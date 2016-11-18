


package busiwork;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

import sun.nio.cs.HistoricallyNamedCharset;

public class TestStreamDecoder extends Writer
{

    private static final int DEFAULT_BYTE_BUFFER_SIZE = 8192;

    private volatile boolean isOpen = true;

    private void ensureOpen() throws IOException {
        if (!isOpen)
            throw new IOException("Stream closed");
    }

    // Factories for java.io.OutputStreamWriter
    public static TestStreamDecoder forOutputStreamWriter(OutputStream out,
                                                      Object lock,
                                                      String charsetName)
        throws UnsupportedEncodingException
    {
        String csn = charsetName;
        if (csn == null)
            csn = Charset.defaultCharset().name();
        try {
            if (Charset.isSupported(csn))
                return new TestStreamDecoder(out, lock, Charset.forName(csn));
        } catch (IllegalCharsetNameException x) { }
        throw new UnsupportedEncodingException (csn);
    }

    public static TestStreamDecoder forOutputStreamWriter(OutputStream out,
                                                      Object lock,
                                                      Charset cs)
    {
        return new TestStreamDecoder(out, lock, cs);
    }

    public static TestStreamDecoder forOutputStreamWriter(OutputStream out,
                                                      Object lock,
                                                      CharsetEncoder enc)
    {
        return new TestStreamDecoder(out, lock, enc);
    }


    // Factory for java.nio.channels.Channels.newWriter

    public static TestStreamDecoder forEncoder(WritableByteChannel ch,
                                           CharsetEncoder enc,
                                           int minBufferCap)
    {
        return new TestStreamDecoder(ch, enc, minBufferCap);
    }


    // -- Public methods corresponding to those in OutputStreamWriter --

    // All synchronization and state/argument checking is done in these public
    // methods; the concrete stream-encoder subclasses defined below need not
    // do any such checking.

    public String getEncoding() {
        if (isOpen())
            return encodingName();
        return null;
    }

    public void flushBuffer() throws IOException {
        synchronized (lock) {
            if (isOpen())
                implFlushBuffer();
            else
                throw new IOException("Stream closed");
        }
    }

    public void write(int c) throws IOException {
        char cbuf[] = new char[1];
        cbuf[0] = (char) c;
        write(cbuf, 0, 1);
    }

    public void write(char cbuf[], int off, int len) throws IOException {
        synchronized (lock) {
            ensureOpen();
            if ((off < 0) || (off > cbuf.length) || (len < 0) ||
                ((off + len) > cbuf.length) || ((off + len) < 0)) {
                throw new IndexOutOfBoundsException();
            } else if (len == 0) {
                return;
            }
            implWrite(cbuf, off, len);
        }
    }

    public void write(String str, int off, int len) throws IOException {
        /* Check the len before creating a char buffer */
        if (len < 0)
            throw new IndexOutOfBoundsException();
        char cbuf[] = new char[len];
        str.getChars(off, off + len, cbuf, 0);
        write(cbuf, 0, len);
    }

    public void flush() throws IOException {
        synchronized (lock) {
            ensureOpen();
            implFlush();
        }
    }

    public void close() throws IOException {
        synchronized (lock) {
            if (!isOpen)
                return;
            implClose();
            isOpen = false;
        }
    }

    private boolean isOpen() {
        return isOpen;
    }


    // -- Charset-based stream encoder impl --

    private Charset cs;
    private CharsetEncoder encoder;
    private ByteBuffer bb;

    // Exactly one of these is non-null
    private final OutputStream out;
    private WritableByteChannel ch;

    // Leftover first char in a surrogate pair
    private boolean haveLeftoverChar = false;
    private char leftoverChar;
    private CharBuffer lcb = null;

    private TestStreamDecoder(OutputStream out, Object lock, Charset cs) {
        this(out, lock,
         cs.newEncoder()
         .onMalformedInput(CodingErrorAction.REPLACE)
         .onUnmappableCharacter(CodingErrorAction.REPLACE));
    }

    private TestStreamDecoder(OutputStream out, Object lock, CharsetEncoder enc) {
        super(lock);
        this.out = out;
        this.ch = null;
        this.cs = enc.charset();
        this.encoder = enc;

        // This path disabled until direct buffers are faster
        if (false && out instanceof FileOutputStream) {
                ch = ((FileOutputStream)out).getChannel();
        if (ch != null)
                    bb = ByteBuffer.allocateDirect(DEFAULT_BYTE_BUFFER_SIZE);
        }
            if (ch == null) {
        bb = ByteBuffer.allocate(DEFAULT_BYTE_BUFFER_SIZE);
        }
    }

    private TestStreamDecoder(WritableByteChannel ch, CharsetEncoder enc, int mbc) {
        this.out = null;
        this.ch = ch;
        this.cs = enc.charset();
        this.encoder = enc;
        this.bb = ByteBuffer.allocate(mbc < 0
                                  ? DEFAULT_BYTE_BUFFER_SIZE
                                  : mbc);
    }

    private void writeBytes() throws IOException {
        bb.flip();
        int lim = bb.limit();
        int pos = bb.position();
        assert (pos <= lim);
        int rem = (pos <= lim ? lim - pos : 0);

            if (rem > 0) {
        if (ch != null) {
            if (ch.write(bb) != rem)
                assert false : rem;
        } else {
            out.write(bb.array(), bb.arrayOffset() + pos, rem);
        }
        }
        bb.clear();
        }

    private void flushLeftoverChar(CharBuffer cb, boolean endOfInput)
        throws IOException
    {
        if (!haveLeftoverChar && !endOfInput)
            return;
        if (lcb == null)
            lcb = CharBuffer.allocate(2);
        else
            lcb.clear();
        if (haveLeftoverChar)
            lcb.put(leftoverChar);
        if ((cb != null) && cb.hasRemaining())
            lcb.put(cb.get());
        lcb.flip();
        while (lcb.hasRemaining() || endOfInput) {
            CoderResult cr = encoder.encode(lcb, bb, endOfInput);
            if (cr.isUnderflow()) {
                if (lcb.hasRemaining()) {
                    leftoverChar = lcb.get();
                    if (cb != null && cb.hasRemaining())
                        flushLeftoverChar(cb, endOfInput);
                    return;
                }
                break;
            }
            if (cr.isOverflow()) {
                assert bb.position() > 0;
                writeBytes();
                continue;
            }
            cr.throwException();
        }
        haveLeftoverChar = false;
    }

    void implWrite(char cbuf[], int off, int len)
        throws IOException
    {
        CharBuffer cb = CharBuffer.wrap(cbuf, off, len);

        if (haveLeftoverChar)
        flushLeftoverChar(cb, false);

        while (cb.hasRemaining()) {
        CoderResult cr = encoder.encode(cb, bb, false);
        if (cr.isUnderflow()) {
           assert (cb.remaining() <= 1) : cb.remaining();
           if (cb.remaining() == 1) {
                haveLeftoverChar = true;
                leftoverChar = cb.get();
            }
            break;
        }
        if (cr.isOverflow()) {
            assert bb.position() > 0;
            writeBytes();
            continue;
        }
        cr.throwException();
        }
    }

    void implFlushBuffer() throws IOException {
        if (bb.position() > 0)
        writeBytes();
    }

    void implFlush() throws IOException {
        implFlushBuffer();
        if (out != null)
        out.flush();
    }

    void implClose() throws IOException {
        flushLeftoverChar(null, true);
        try {
            for (;;) {
                CoderResult cr = encoder.flush(bb);
                if (cr.isUnderflow())
                    break;
                if (cr.isOverflow()) {
                    assert bb.position() > 0;
                    writeBytes();
                    continue;
                }
                cr.throwException();
            }

            if (bb.position() > 0)
                writeBytes();
            if (ch != null)
                ch.close();
            else
                out.close();
        } catch (IOException x) {
            encoder.reset();
            throw x;
        }
    }

    String encodingName() {
        return ((cs instanceof HistoricallyNamedCharset)
            ? ((HistoricallyNamedCharset)cs).historicalName()
            : cs.name());
    }
}

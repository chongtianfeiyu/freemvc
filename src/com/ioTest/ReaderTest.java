package com.ioTest;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PushbackReader;
import java.io.StringReader;

/**
 * reader相关类测试学习 读取字符.字母，数字，汉字都属于字符。比如中字，属于字符，可以读取中字，而不是中字的二进制
 * 
 * @author liaokangli
 * 
 */
public class ReaderTest {

	public static void main(String[] args) {
		// testCharArrayReader();
		// testFileReader();
		// testPipedReader();
		// testBufferedReader();
		// testFilterReader();
//		testPushbackReader();
//		testLineNumberReader();
		testStringReader();
	}

	/**
	 * 1、array 测试CharArrayReader,类似CharArrayReader
	 */
	public static void testCharArrayReader() {
		CharArrayReader charReader = null;
		char[] buff = new char[] { 'a', 'b', 'c' };
		try {
			charReader = new CharArrayReader(buff);
			charReader.skip(2);
			char result = (char) charReader.read();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (charReader != null) {
				charReader.close();
			}
		}
	}

	/**
	 * 2、files 测试FileReader
	 */
	public static void testFileReader() {
		FileReader fileReader = null;
		char[] buff = new char[1024];
		try {
			fileReader = new FileReader("G:\\testOuptStream");
			fileReader.read(buff);
			System.out.println("读完" + buff);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 3、Pipes 测试PipedReader
	 * 
	 */
	public static void testPipedReader() {

		class Writerp implements Runnable {

			private PipedWriter pipedWriter;

			public Writerp(PipedWriter pipedWriter) {
				this.pipedWriter = pipedWriter;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				char[] buff = new char[] { '中', '过' };
				try {
					pipedWriter.write(buff);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		class Readerp implements Runnable {

			private PipedReader pipedReader;

			public Readerp(PipedReader pipedReader) {
				this.pipedReader = pipedReader;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					char[] buff = new char[1024];
					pipedReader.read(buff);
					System.out.println("从管道字符流读取数据：" + new String(buff));
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (pipedReader != null) {
						try {
							pipedReader.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}

		PipedWriter pipedWriter = new PipedWriter();
		PipedReader pipedReader = new PipedReader();
		try {
			pipedWriter.connect(pipedReader);
			new Thread(new Writerp(pipedWriter)).start();
			new Thread(new Readerp(pipedReader)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 4、buffering 将数据读入缓存.
	 * 
	 */
	public static void testBufferedReader() {

		BufferedReader bufferedReader = null;
		char[] buff = new char[1];
		try {
			bufferedReader = new BufferedReader(new FileReader(new File(
					"G:\\testOuptStream")));
			// 返回的是整型，整型跟字符型是对应的，可以强制转换
			int result = 0;
			while ((result = bufferedReader.read()) != -1) {
				System.out.println("读单个字符：" + (char) result);
			}

			// 读取到其他缓存区
			int result1 = bufferedReader.read(buff);
			System.out.println("读取到其他buff:" + new String(buff) + ":" + result1);

			// 读取一行
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println("按行读取:" + line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 5、FilterReader 测试FilterReader，
	 * 
	 */
	public static void testFilterReader() {
		FilterReader filterReader = null;
		try {
			filterReader = new FilterReader(new FileReader(new File(
					"G:\\testOuptStream"))) {

			};

			char result = (char) filterReader.read();

			System.out.println("filter:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (filterReader != null) {
				try {
					filterReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 6.1、parsing 回退流 测试PushbackReader
	 */
	public static void testPushbackReader() {
		PushbackReader pushBackReader = null;
		try {
			pushBackReader = new PushbackReader(new FileReader(new File(
					"G:\\testOuptStream")));
			int result = 0;
			while ((result = pushBackReader.read()) != -1) {
				if ((char) result == '人') {
					pushBackReader.unread(result);
					// 这句话必须
					result = pushBackReader.read();
					System.out.println("(退回" + (char) result + ")");
				} else {
					System.out.println("回退流:" + (char) result);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 6.2 parsing LineNumberReader 测试行号
	 */
	public static void testLineNumberReader() {
		LineNumberReader lineNumberReader = null;
		try {
			lineNumberReader = new LineNumberReader(new FileReader(new File("G:\\testOuptStream")));
			int result = 0;
			while((result = lineNumberReader.read()) != -1){
				System.out.println("lineNumber:"+lineNumberReader.getLineNumber()+":"+(char)result);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lineNumberReader != null) {
				try {
					lineNumberReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 7、Strings 字符串
	 */
	public static void testStringReader(){
		StringReader stringReader = null;
		try{
			stringReader = new StringReader("中国人系统消息");
			int result = 0;
			while((result = stringReader.read()) != -1){
				System.out.println((char)result);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stringReader != null){
				stringReader.close();
			}
		}
		
	}

}

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
 * reader��������ѧϰ ��ȡ�ַ�.��ĸ�����֣����ֶ������ַ����������֣������ַ������Զ�ȡ���֣����������ֵĶ�����
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
	 * 1��array ����CharArrayReader,����CharArrayReader
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
	 * 2��files ����FileReader
	 */
	public static void testFileReader() {
		FileReader fileReader = null;
		char[] buff = new char[1024];
		try {
			fileReader = new FileReader("G:\\testOuptStream");
			fileReader.read(buff);
			System.out.println("����" + buff);

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
	 * 3��Pipes ����PipedReader
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
				char[] buff = new char[] { '��', '��' };
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
					System.out.println("�ӹܵ��ַ�����ȡ���ݣ�" + new String(buff));
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
	 * 4��buffering �����ݶ��뻺��.
	 * 
	 */
	public static void testBufferedReader() {

		BufferedReader bufferedReader = null;
		char[] buff = new char[1];
		try {
			bufferedReader = new BufferedReader(new FileReader(new File(
					"G:\\testOuptStream")));
			// ���ص������ͣ����͸��ַ����Ƕ�Ӧ�ģ�����ǿ��ת��
			int result = 0;
			while ((result = bufferedReader.read()) != -1) {
				System.out.println("�������ַ���" + (char) result);
			}

			// ��ȡ������������
			int result1 = bufferedReader.read(buff);
			System.out.println("��ȡ������buff:" + new String(buff) + ":" + result1);

			// ��ȡһ��
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println("���ж�ȡ:" + line);
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
	 * 5��FilterReader ����FilterReader��
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
	 * 6.1��parsing ������ ����PushbackReader
	 */
	public static void testPushbackReader() {
		PushbackReader pushBackReader = null;
		try {
			pushBackReader = new PushbackReader(new FileReader(new File(
					"G:\\testOuptStream")));
			int result = 0;
			while ((result = pushBackReader.read()) != -1) {
				if ((char) result == '��') {
					pushBackReader.unread(result);
					// ��仰����
					result = pushBackReader.read();
					System.out.println("(�˻�" + (char) result + ")");
				} else {
					System.out.println("������:" + (char) result);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 6.2 parsing LineNumberReader �����к�
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
	 * 7��Strings �ַ���
	 */
	public static void testStringReader(){
		StringReader stringReader = null;
		try{
			stringReader = new StringReader("�й���ϵͳ��Ϣ");
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

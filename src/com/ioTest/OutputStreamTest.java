package com.ioTest;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

/**
 * ���������ѧϰ
 * @author liaokangli
 *
 */
public class OutputStreamTest {

	public static void main(String[] args){
//		testByteArrayOutputStream();
//		testFileOutputStream();
//		testRandomAccessFile();
//		testBufferedOutputStream();
//		testFilterOutputStream();
		testDataOutputStream();
	}
	
	/**
	 * 1��Arrays
	 * �������������.������(����buff)д��ByteArrayOutputStream�ڴ���buff
	 */
	public static void testByteArrayOutputStream(){
		ByteArrayOutputStream byteOutput = null;
		byte[] buff = new byte[]{20,30,40,60};
		try{
			byteOutput = new ByteArrayOutputStream();
			byteOutput.write(30);
			
			//д���Զ���buff����
			byteOutput.write(buff);
			System.out.println("д��");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(byteOutput != null){
				try {
					byteOutput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 2��Files
	 * ����FileOutputStream.���ڴ����������д���ļ�����ȥ
	 */
	public static void testFileOutputStream(){
		FileOutputStream fileOutputStream = null ;
		String str = "����FileOutputStream.���ڴ����������д���ļ�����ȥ";
		try{
			fileOutputStream = new FileOutputStream(new File("G:\\testOuptStream"));
			fileOutputStream.write(str.getBytes());
			System.out.println("д��");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fileOutputStream != null){
				try{
					fileOutputStream.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 3��files
	 * ����RandomAccessFile
	 */
	public static void testRandomAccessFile(){
		RandomAccessFile randomAccessFile = null;
		String str = "����FileOutputStream.���ڴ����������д���ļ�����ȥ";
		try{
			randomAccessFile = new RandomAccessFile("G:\\testOuptStream","rws");
			randomAccessFile.write(str.getBytes());
			System.out.println("д��");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(randomAccessFile != null){
				try{
					randomAccessFile.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 4��Pipes
	 * ����PipedOutputStream.�ܵ�����PipedInputStream���ʹ�á�����ʵ�ֲ���InputStreamTest.testPipedInputStream
	 */
	public static void testPipedOutputStream(){
		
	}
	
	/**
	 * 5��buffering
	 * BufferedOutputStream.������д��buff,Ȼ��д���ļ������д��buff����С��Ĭ�ϵ�������close��ʱ��ֱ��flush���ļ�
	 */
	public static void testBufferedOutputStream(){
		BufferedOutputStream buffere = null;
		String str = "����FileOutputStream.���ڴ����������д���ļ�����ȥ";
		try{
			buffere = new BufferedOutputStream(new FileOutputStream(new File("G:\\testOuptStream")));
			buffere.write(str.getBytes());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(buffere != null){
				try {
					buffere.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 6��Filtering
	 * ����FilterOutputStream.
	 */
	public static void testFilterOutputStream(){
		   FilterOutputStream filterOut = null;
		   String str = "����FileOutputStream.���ڴ����������д���ļ�����ȥ filter";
		   String str1 = "tyui";
		   try{
			   // д�ļ�
			   filterOut = new FilterOutputStream(new FileOutputStream(new File("G:\\testOuptStream")));
			   filterOut.write(str.getBytes());
			   
			   // д����
			   filterOut = new FilterOutputStream(new ByteArrayOutputStream(1024));
			   filterOut.write(str1.getBytes());
			   
			   System.out.println("д��");
		   }catch(Exception e){
			   e.printStackTrace();
		   }finally{
			   if(filterOut != null){
				   try {
					filterOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
		   }
	}
	
	/**
	 * 7��data
	 * ����DataOutputStream.����дԭʼ���ݣ�����Ҫ��ȡ�����Ļ���DataInputStream
	 */
	public static void testDataOutputStream(){
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;
		int aa = 100;
		try{
			dataOutputStream = new DataOutputStream(new FileOutputStream(new File("E:\\19lou���������\\xtx.txt")));
			dataOutputStream.writeLong(100);
			dataOutputStream.writeChars("�й�");
			dataOutputStream.write(100);
			
			// ��ȡ����.���������Ķ�Ӧ������eof����
			dataInputStream = new DataInputStream(new FileInputStream(new File("E:\\19lou���������\\xtx.txt")));
			long result1 = dataInputStream.readLong();
			String result2 = new String(new char[]{dataInputStream.readChar(),dataInputStream.readChar()});
			int result3 = dataInputStream.read();
			System.out.println(result1+":"+result2+":"+result3);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(dataOutputStream != null){
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 8��data-formatted
	 * ����printstream.
	 */
	public static void testPrintStream(){
		PrintStream printStream = null;
		
	}
	
	
	
	
}

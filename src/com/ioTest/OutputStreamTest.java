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
 * 输出流测试学习
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
	 * 1、Arrays
	 * 测试数组输出流.将数据(放在buff)写到ByteArrayOutputStream内带的buff
	 */
	public static void testByteArrayOutputStream(){
		ByteArrayOutputStream byteOutput = null;
		byte[] buff = new byte[]{20,30,40,60};
		try{
			byteOutput = new ByteArrayOutputStream();
			byteOutput.write(30);
			
			//写到自定义buff里面
			byteOutput.write(buff);
			System.out.println("写完");
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
	 * 2、Files
	 * 测试FileOutputStream.将内存里面的数据写到文件里面去
	 */
	public static void testFileOutputStream(){
		FileOutputStream fileOutputStream = null ;
		String str = "测试FileOutputStream.将内存里面的数据写到文件里面去";
		try{
			fileOutputStream = new FileOutputStream(new File("G:\\testOuptStream"));
			fileOutputStream.write(str.getBytes());
			System.out.println("写完");
			
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
	 * 3、files
	 * 测试RandomAccessFile
	 */
	public static void testRandomAccessFile(){
		RandomAccessFile randomAccessFile = null;
		String str = "测试FileOutputStream.将内存里面的数据写到文件里面去";
		try{
			randomAccessFile = new RandomAccessFile("G:\\testOuptStream","rws");
			randomAccessFile.write(str.getBytes());
			System.out.println("写完");
			
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
	 * 4、Pipes
	 * 测试PipedOutputStream.管道流跟PipedInputStream配合使用。具体实现参照InputStreamTest.testPipedInputStream
	 */
	public static void testPipedOutputStream(){
		
	}
	
	/**
	 * 5、buffering
	 * BufferedOutputStream.将数据写到buff,然后写入文件。如果写入buff的量小于默认的量，在close的时候直接flush入文件
	 */
	public static void testBufferedOutputStream(){
		BufferedOutputStream buffere = null;
		String str = "测试FileOutputStream.将内存里面的数据写到文件里面去";
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
	 * 6、Filtering
	 * 测试FilterOutputStream.
	 */
	public static void testFilterOutputStream(){
		   FilterOutputStream filterOut = null;
		   String str = "测试FileOutputStream.将内存里面的数据写到文件里面去 filter";
		   String str1 = "tyui";
		   try{
			   // 写文件
			   filterOut = new FilterOutputStream(new FileOutputStream(new File("G:\\testOuptStream")));
			   filterOut.write(str.getBytes());
			   
			   // 写缓存
			   filterOut = new FilterOutputStream(new ByteArrayOutputStream(1024));
			   filterOut.write(str1.getBytes());
			   
			   System.out.println("写完");
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
	 * 7、data
	 * 测试DataOutputStream.可以写原始数据，但是要读取出来的话用DataInputStream
	 */
	public static void testDataOutputStream(){
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;
		int aa = 100;
		try{
			dataOutputStream = new DataOutputStream(new FileOutputStream(new File("E:\\19lou生活馆数据\\xtx.txt")));
			dataOutputStream.writeLong(100);
			dataOutputStream.writeChars("中国");
			dataOutputStream.write(100);
			
			// 读取出来.必须跟上面的对应，否则报eof错误
			dataInputStream = new DataInputStream(new FileInputStream(new File("E:\\19lou生活馆数据\\xtx.txt")));
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
	 * 8、data-formatted
	 * 测试printstream.
	 */
	public static void testPrintStream(){
		PrintStream printStream = null;
		
	}
	
	
	
	
}

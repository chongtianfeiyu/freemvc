package com.ioTest;

import java.io.BufferedWriter;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * writer测试
 * @author liaokangli
 *
 */
public class WriterTest {

	public static void main(String[] args){
//		testOutputStreamWriter();
//		testCharArrayWriter();
//		testStringWriter();
		testPrintWriter();
	}
	
	
	/**
	 * 1、这个类可以包装字节流
	 * 测试OutputStreamWriter
	 */
	public static void testOutputStreamWriter(){
		OutputStreamWriter outs = null;
		try{
			
			outs = new OutputStreamWriter(new FileOutputStream("G:\\testOuptStream"));
			outs.write("Maven对单字命令不称为goal，而称为phase");
			outs.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(outs != null){
				try {
					outs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 2、测试CharArrayWriter
	 */
	public static void testCharArrayWriter(){
		CharArrayWriter charW = null;
		try{
			charW = new CharArrayWriter();
			charW.write("Maven对单字命令不称为goal，而称为phase");
			System.out.println("写完");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 3、测试FileWriter 雷同OutputStreamWriter
	 */
	public static void testFileWriter(){
		FileWriter fileWriter = null;
	}
	
	/**
	 * 4、测试piped
	 */
	public static void testPipedWriter(){
		PipedWriter pw = null;
		
	}
	
    /**
     * 5、测试bufferedwriter
     */
	public static void testBufferedWriter(){
		BufferedWriter bw = null;
		try{
			
		}catch(Exception e){
			
		}finally{
			
		}
	}
	
	/**
	 * 6、测试FilterWriter
	 */
	public static void testFilterWriter(){
		FilterWriter fw = null;
	}
	
	/**
	 * 7、测试StringWriter
	 * 将数组里面的字符写入到内存中。比方我可以从文件中读取内容到char字符数组中，然后通过某种操作，再写回到文件中
	 */
	public static void testStringWriter(){
		StringWriter sw = null;
		try{
			sw = new StringWriter();
			char[] cbuf = new char[]{'中','国','人'};
			sw.write(cbuf);
			System.out.println("处理完成");
		}catch(Exception e){
			
		}
	}
	
	/**
	 * 8、测试PrintWriter
	 * 
	 */
	public static void testPrintWriter(){
		PrintWriter pw = null;
		try{
			pw = new PrintWriter("G:\\testOuptStream");
			pw.write("比方我可以从文件中读取内容到char字符数组中，然后通过某种操作，再写回到文件中");
		    pw.printf("how %s works \n", "java");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pw != null){
				pw.close();
			}
		}
	}
	
	
	
}

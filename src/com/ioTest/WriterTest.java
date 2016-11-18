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
 * writer����
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
	 * 1���������԰�װ�ֽ���
	 * ����OutputStreamWriter
	 */
	public static void testOutputStreamWriter(){
		OutputStreamWriter outs = null;
		try{
			
			outs = new OutputStreamWriter(new FileOutputStream("G:\\testOuptStream"));
			outs.write("Maven�Ե��������Ϊgoal������Ϊphase");
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
	 * 2������CharArrayWriter
	 */
	public static void testCharArrayWriter(){
		CharArrayWriter charW = null;
		try{
			charW = new CharArrayWriter();
			charW.write("Maven�Ե��������Ϊgoal������Ϊphase");
			System.out.println("д��");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 3������FileWriter ��ͬOutputStreamWriter
	 */
	public static void testFileWriter(){
		FileWriter fileWriter = null;
	}
	
	/**
	 * 4������piped
	 */
	public static void testPipedWriter(){
		PipedWriter pw = null;
		
	}
	
    /**
     * 5������bufferedwriter
     */
	public static void testBufferedWriter(){
		BufferedWriter bw = null;
		try{
			
		}catch(Exception e){
			
		}finally{
			
		}
	}
	
	/**
	 * 6������FilterWriter
	 */
	public static void testFilterWriter(){
		FilterWriter fw = null;
	}
	
	/**
	 * 7������StringWriter
	 * ������������ַ�д�뵽�ڴ��С��ȷ��ҿ��Դ��ļ��ж�ȡ���ݵ�char�ַ������У�Ȼ��ͨ��ĳ�ֲ�������д�ص��ļ���
	 */
	public static void testStringWriter(){
		StringWriter sw = null;
		try{
			sw = new StringWriter();
			char[] cbuf = new char[]{'��','��','��'};
			sw.write(cbuf);
			System.out.println("�������");
		}catch(Exception e){
			
		}
	}
	
	/**
	 * 8������PrintWriter
	 * 
	 */
	public static void testPrintWriter(){
		PrintWriter pw = null;
		try{
			pw = new PrintWriter("G:\\testOuptStream");
			pw.write("�ȷ��ҿ��Դ��ļ��ж�ȡ���ݵ�char�ַ������У�Ȼ��ͨ��ĳ�ֲ�������д�ص��ļ���");
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

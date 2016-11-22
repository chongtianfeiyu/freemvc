package study2016.io.testapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

/**
 * compare all stream
 * @author liaokangli
 *
 */
public class IOInputStreamCompare {
	
	public static void main(String[] args){
//		compareInputStreamReader();
		fileInputStreamReaderMutiple();
	}
	
	/**
	 * 比较inputstream和reader。读两个字节和读一个字符是否一样
	 * 对于中文，utf8情况下，需要读取3个字节才和读取一个字符是一样
	 * 对于英文，读取一个字节才和读取一个字符是一样的
	 */
	public static void compareInputStreamReader(){
		try{
		 
		 // 跟
		 FileInputStream fis = new FileInputStream("F:\\testOut.txt");	 
		 byte[] bytes = new byte[10];
		 fis.read(bytes);
		 System.out.println("==========fis:"+new String(bytes,"GBK"));
		 
		 InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\testOut.txt"),"gbk");
		 
		 char[] chars = new char[1];
		 isr.read(chars);
		 System.out.println("==========fis:"+new String(chars)+";encoding:"+isr.getEncoding());
		 
		 
		 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 比较inputstream reader,一次读取一个
	 */
	public static void fileInputStreamReaderMutiple(){
		
		try{
			 long start1 = new Date().getTime();
			 FileInputStream fis = new FileInputStream("G:\\dd\\recommend_active_uid.sql");	 
			 byte[] bytes = new byte[1];
			 int count1 = 0;
			 while((count1 = fis.read(bytes)) != -1){
//				 System.out.println(new String(bytes));
			 }
			 
			 long end1 = new Date().getTime();
			 
			 FileReader isr = new FileReader(new File("G:\\dd\\recommend_active_uid.sql"));
			 char[] chars = new char[1];
			 int count2 = 0;
			 while((count2 = isr.read(chars)) != -1){
//				 System.out.println(new String(chars));
			 }

			 long end2 = new Date().getTime();
			 
			 System.out.println("======end1:"+(end1-start1)/1000+";end2:"+(end2-end1)/1000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

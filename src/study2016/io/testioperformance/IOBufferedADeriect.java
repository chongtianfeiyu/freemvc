package study2016.io.testioperformance;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * buffered包裹inputstream （如果读取的数据是一样的，其实用buffered包裹inputstream反而是多此一举，因为还要从bufferedReader里面的char[]复制到自己的char[]，这里面有开销）
 * 
 * 
 * 
 * @author liaokangli
 *
 */
public class IOBufferedADeriect {
	
	public static void main(String[] args){
//		testBufferedPerformace();
//		testBufferedPerformanceOne();
		
		testBufferedInputStream();
	}
	
	
	/**
	 * buffered缓存性能.使用buffer包裹inputstreamreader. 读取多个的时候
	 * 直接使用inputStreamReader读取，比较两个之间的性能，发现都是一样的,或者是bufferedReader比InputStreamReader差
	 * 因为多了一部分开销：从bufferedreader内部的char[]复制到自己的char[]。如果相对于系统调用(不是io次数)的开销很小的话，其实这个可以不需要包裹
	 */
	public static void testBufferedPerformace(){
		try{
		  long start1 = new Date().getTime();
		  // buffered wrap inputstream
		  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("G:\\dd\\my_fav_forum.sql"),"gbk"));
		  char[] cbuf = new char[1];
		  int count = 0;
		  while((count = br.read(cbuf)) != -1){
//			  System.out.println(cbuf);
		  }		  
		  long end1 = new Date().getTime();
		  
		  // 直接读取到cbuf
		  InputStreamReader isr = new InputStreamReader(new FileInputStream("G:\\dd\\my_fav_forum.sql"),"gbk");
		  char[] cbuf1 = new char[1];
		  int count1 = 0;
		  while((count1 = isr.read(cbuf1)) != -1){
//			  System.out.println(cbuf1);
		  }
		  
		  long end2 = new Date().getTime();
		  
		  System.out.println("========最终结果 buffered:"+(end1 - start1)/1000+";直接读取到cbuf:"+(end2-end1)/1000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 读取一个的时候两个进行比较
	 */
	public static void testBufferedPerformanceOne(){
		try{
			  long start1 = new Date().getTime();
			  // buffered wrap inputstream
			  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("G:\\dd\\my_fav_forum.sql")));
			  int count = 0;
			  while((count = br.read()) != -1){
//				  System.out.println(cbuf);
			  }		  
			  long end1 = new Date().getTime();
			  
			  // 直接读取到cbuf
			  InputStreamReader isr = new InputStreamReader(new FileInputStream("G:\\dd\\my_fav_forum.sql"));
			  int count1 = 0;
			  while((count1 = isr.read()) != -1){
//				  System.out.println(cbuf1);
			  }
			  
			  long end2 = new Date().getTime();
			  
			  System.out.println("========最终结果 buffered:"+(end1 - start1)/1000+";直接读取到cbuf:"+(end2-end1)/1000);
				
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
    /**
     * 性能测试：bufferdInputStream fileInputStream
     */
	public static void testBufferedInputStream(){
		try{
			  long start1 = new Date().getTime();
			  // buffered wrap inputstream
			  BufferedInputStream br = new BufferedInputStream(new FileInputStream("G:\\dd\\my_fav_forum.sql"));
			  byte[] bytes = new byte[1];
			  int count = 0;
			  while((count = br.read(bytes)) != -1){
//				  System.out.println(new String(bytes));
			  }		  
			  long end1 = new Date().getTime();
			  
			  // 直接读取到cbuf
			  FileInputStream isr = new FileInputStream("G:\\dd\\my_fav_forum.sql");
			  byte[] bytes1 = new byte[1];
			  int count1 = 0;
			  while((count1 = isr.read(bytes1)) != -1){
				  System.out.println(new String(bytes1));
			  }
			   
			  long end2 = new Date().getTime();
			  
			  System.out.println("========最终结果 buffered:"+(end1 - start1)/1000+";直接读取到cbuf:"+(end2-end1)/1000);
				
			}catch(Exception e){
				e.printStackTrace();
			}
	}

}

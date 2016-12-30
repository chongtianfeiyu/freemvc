package study2016.io.streams;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * print writer
 * @author liaokangli
 *
 */
public class IOPrintWriter {
	
	public static void main(String[] args){
		printWriterNormal();
	}
	
	/**
	 * print writer正常。
	 */
	public static void printWriterNormal(){
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("f:\\testOut.txt"),true);
			pw.printf("姓名:%s,年龄:%d,薪资:%f,性别:%c", "tttt",100,15.6781,'女');
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 跟 print stream的区别
	 */
	public static void printWriterStream(){
		try{
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

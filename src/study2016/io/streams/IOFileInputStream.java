package study2016.io.streams;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * io输入流
 * @author liaokangli
 *
 */
public class IOFileInputStream {

	
	public static void main(String[] args){
		inputStreamNormal();
		inputStreamBytes();
	}
	
	/**
	 * 输入流正常使用。单字节
	 */
	public static void inputStreamNormal(){
		try{
			
			FileInputStream fis = new FileInputStream(new File("f:\\testOut.txt"));	
			int count = 0;
			while((count = fis.read()) != -1){
				System.out.println(count);
				System.out.println((char)count);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 输入流多字节读取.
	 */
	public static void inputStreamBytes(){
       try{		
			FileInputStream fis = new FileInputStream(new File("f:\\testOut.txt"));	
			int count = 0;
			byte[] results = new byte[64];
			while((count = fis.read(results)) != -1){
				System.out.println(new String(results,0,count));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}

package study2016.io.streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * buffered reader使用
 * @author liaokangli
 *
 */
public class IOBufferedReader {
	
	public static void main(String[] args){
		
	}
	
	/**
	 * 
	 */
	public static void bufferedReaderNormal(){
		
	}
	
	
	/**
	 * 利用buffered包裹inputStreamReader
	 */
	public static void wrapBuffer(){
		try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\url.txt")));
			char[] cbuf = new char[1024];
			int count = 0;
			while((count = br.read(cbuf)) != -1){
				System.out.println(cbuf);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

package study2016.io.streams;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * 
 * @author liaokangli
 *
 */
public class IODataInputStream {
	
	public static void main(String[] args){
		
	}
	
	/**
	 * DataInputStream正常读取
	 */
	public static void dataInputStreamNormal(){
		try{
			DataInputStream dis = new DataInputStream(new FileInputStream(""));
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

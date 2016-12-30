package study2016.nio;

import java.nio.CharBuffer;

public class NIOCharBuffer {

	public static void main(String[] args){
		charBufferNormal();
	}
	
	/**
	 * char buffer
	 */
	public static void charBufferNormal(){
		try{
			 int c = 100;
			 char cbuf[] = new char[1];
		     cbuf[0] = (char) c;
			CharBuffer cb = CharBuffer.wrap(cbuf, 0, 1);
			
		    byte ts = (byte) cbuf[0];
		    System.out.println("tt");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

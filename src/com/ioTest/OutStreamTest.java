package com.ioTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * outputStream≤‚ ‘
 * @author liaokangli
 *
 */
public class OutStreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testFileOutputStream();
	}
	
	/**
	 * ≤‚ ‘FileOutputStream
	 */
	public static void testFileOutputStream(){
		OutputStream op = null;
		byte[] message = {83, 111, 109, 101, 32,98, 121, 116, 101, 115, 46};
		try {
			 op = new FileOutputStream(new File("D:\\test1.txt"));
			 op.write(message);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(op != null){
				try {
					op.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}

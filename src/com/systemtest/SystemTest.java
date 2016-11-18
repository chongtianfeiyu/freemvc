package com.systemtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * System.out,System.in,System.err使用测试
 * @author liaokangli
 *
 */
public class SystemTest {
	
	public static void main(String[] args) throws FileNotFoundException{
		testFile();
		
	}
	
	public static void testSystem1(){
		try {

		    InputStream input = new FileInputStream("c:\\data\\...");

		    System.out.println("File opened...");

		} catch (IOException e) {

		    System.err.println("File opening failed:");

		    e.printStackTrace();

		}
	}
	
	public static void testFile() throws FileNotFoundException{
		OutputStream output = new FileOutputStream("g:\\system.out.txt");

		PrintStream printOut = new PrintStream(output);

		System.setOut(printOut);
		System.out.println("中国");
	}

}

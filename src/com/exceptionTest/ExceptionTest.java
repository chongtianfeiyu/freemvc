/**
 * 19lou.com
 */
package com.exceptionTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author liaokangli
 *
 */
public class ExceptionTest {
    public static void main(String[] args)  {
    	
//    	if(!getBoolean(111)){
//    		System.out.println("ddd");
//    	}
    	
    	
    	String str = null;
//    	try{
//    		System.out.println("str:"+str.toString());
//    	}finally{
//    		System.out.println("finally:"+str);
//    	}
//		try {
			try {
				getName33("%c%d");
				System.out.println("dddd");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("=====�쳣");
				e.printStackTrace();
			}
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			System.out.println("解析失败:"+e.getMessage());
//		}
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
//    	try {
//			getName1("dd");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println("Enter text to echo:");
//    	InputStreamReader isr = new InputStreamReader(System.in);
//    	BufferedReader inputReader = new BufferedReader(isr);
//    	String inputLine = inputReader.readLine();
//    	System.out.println("Read:" + inputLine);
	}
    
    public static String getName(String name) throws MyException{
    	if(name == null){
    		throw new MyException("aaa", null);
    	}
    	try {
			name = URLDecoder.decode(name,"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new MyException("failed config",e);
		}
    	
    	return name;
    }
    
    public static String getName2(String name) {

    	try {
			name = URLDecoder.decode(name,"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
    	
    	return name;
    }
    
    public static void getName33(String name){
    	try {
			name = URLDecoder.decode(name,"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
    }
    
    public static void getName34(String name) throws UnsupportedEncodingException{
    	
			name = URLDecoder.decode(name,"");
    }
    
    public static String getName1(String name1) throws Exception{

    	FileInputStream aa = new FileInputStream("d://123//11");
    	aa.read();
    	return name1;
    }
    
    public static boolean getBoolean(int aa){
    	throw new MyRuntimException();
    }
}

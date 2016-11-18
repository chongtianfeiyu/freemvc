package com.exceptionTest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 异常机制测试：当调用方法中途throw new exception 或者 throws exception时
 * @author liaokangli
 *
 */
public class ExceptionTest1 {
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		boolean aa = getName1(null);
		System.out.println(aa);
	}
	
	public static void getName(String name) throws UnsupportedEncodingException{
		if(name == null){
			URLDecoder.decode(name,"utf-8");
		}
		System.out.println(name);
	}
	
	public static boolean getName1(String name) throws UnsupportedEncodingException{
		getName(name);
		return true;
	}

	
	public static class MyRuntimeException extends RuntimeException{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}
}

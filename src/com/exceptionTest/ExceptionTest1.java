package com.exceptionTest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * �쳣���Ʋ��ԣ������÷�����;throw new exception ���� throws exceptionʱ
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

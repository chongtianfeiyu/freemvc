package com.commonTest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestDecode {

	public static void main(String[] args){
		String url = "%E5%B0%8F%E6%97%B6%E4%BB%A3";
		try {
			String result = URLDecoder.decode(url, "UTF-8");
			System.out.println("decode:"+result);
			
			String encodeResult = URLEncoder.encode("小时代", "utf-8");
			System.out.println("encode:"+encodeResult);
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testDecode(){
		
	}
}

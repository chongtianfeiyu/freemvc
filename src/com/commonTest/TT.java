package com.commonTest;

import java.io.UnsupportedEncodingException;

public class TT {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String orStr = "《同妻连枝》正剧+古穿今/宠文/婚后/日更";
    	System.out.println("gbk,十六进制:"+Hex.encodeHexStr(orStr.getBytes("gbk")));
    	System.out.println("utf8,十六进制:"+Hex.encodeHexStr(orStr.getBytes("UTF-8")));
	}

}

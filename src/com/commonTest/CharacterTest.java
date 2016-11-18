package com.commonTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 字符转码测试
 * @author liaokangli
 *
 */
public class CharacterTest {

	public static void main(String[] args) throws UnsupportedEncodingException{
		// 编码
		String str = "正";
		byte[] utf8 = str.getBytes("gbk");
		String aa1 = new String(utf8,0,2,"gbk");
		System.out.println(aa1);
		System.out.println("范的utf8,十六进制:"+Hex.encodeHexStr(utf8));
		
		// 解码
		String decodestr = new String(utf8,"utf-8");
		System.out.println("范的utf8,十六进制:"+Hex.encodeHexStr(decodestr.getBytes("utf-8")));
		
		String decodestrdd = new String(utf8,"utf-8");
		
	}
}

package com.commonTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * �ַ�ת�����
 * @author liaokangli
 *
 */
public class CharacterTest {

	public static void main(String[] args) throws UnsupportedEncodingException{
		// ����
		String str = "��";
		byte[] utf8 = str.getBytes("gbk");
		String aa1 = new String(utf8,0,2,"gbk");
		System.out.println(aa1);
		System.out.println("����utf8,ʮ������:"+Hex.encodeHexStr(utf8));
		
		// ����
		String decodestr = new String(utf8,"utf-8");
		System.out.println("����utf8,ʮ������:"+Hex.encodeHexStr(decodestr.getBytes("utf-8")));
		
		String decodestrdd = new String(utf8,"utf-8");
		
	}
}

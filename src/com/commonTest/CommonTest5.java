/**
 * 19lou.com
 */
package com.commonTest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author liaokangli
 *
 */
public class CommonTest5 {
    public static void main(String[] args) throws IOException {
		String str = "马术俱乐部";
		byte[] strb = str.getBytes("utf-8");
		
		System.out.println("的gbk,十六进制:"+Hex.encodeHexStr(strb));
		System.out.println("utf8的gbk结果:"+new String(strb,"gbk"));
		
		// 读取utf-8带bom
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:\\19lou生活馆数据\\dd\\hots_tids_daily2.txt")),"UTF-8"));
        String line = null;
		while((line = reader.readLine()) != null){
			System.out.println(line);
			break;
		}
		
		// 按字节读取
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:\\19lou生活馆数据\\dd\\hots_tids_daily2.txt"));
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		byte[] temp = new byte[1024];        
        int size = 0;        
        while ((size = in.read(temp)) != -1) {        
            out.write(temp, 0, size);        
        }        
        in.close(); 
        String aa = new String(temp,3,temp.length-3,"UTF-8");
        System.out.println(""+aa);
    }
    
    public void getName(){
    	getAA();
    }
    
    public static String getAA(){
    	return "aa";
    }
}

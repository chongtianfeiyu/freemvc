package com.javanet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 测试读url文件，路径问题
 * @author liaokangli
 *
 */
public class UrlTest {
	
	public static void main(String[] args) throws Exception{
		URL url = new URL("file:D:/19louproject/business-tool1/config/config/../system-config/biztool/jdbc.properties");
		URLConnection con = url.openConnection();
		con.getInputStream();
		System.out.println("lkl");
		
		File file = new File("D:/19louproject/business-tool1/config/config/../system-config/biztool/jdbc.properties");
		
		BufferedInputStream bs = new BufferedInputStream(new FileInputStream(file));
		bs.read();
	}

}

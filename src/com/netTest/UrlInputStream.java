package com.netTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * ��ȡurl����/��url����д����
 * ���ύ����������д�ı����ʱ�򣬱ȷ�˵��½��Ϣ�������½��ť�������ͨ�����������д�뵽url���������ͻ���ܵ�����
 * @author liaokangli
 *
 */
public class UrlInputStream {

	public static void main(String[] args){
		testUrlOutput();
	}
	
	/**
	 * ��url��ȡ����
	 */
	public static void testUrlInput(){
		try {
			URL oracle = new URL("http://www.oracle.com/");
			BufferedInputStream buffIn = new BufferedInputStream(oracle.openStream());
			byte[] buff = new byte[1024];
			int result = 0;
			while((result = buffIn.read(buff)) != -1){
				
				System.out.println(new String(buff,"UTF-8"));
				
			}
			buffIn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��url����д����
	 */
	public static void testUrlOutput(){
		try {
			URL url = new URL("http://dw.19lou-inc.com/index.html");
			HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
		    hcon.setDoOutput(true);
		    hcon.connect();
		    // ���ַ�ʽ�û����������޷���֤ͨ��
//		    String userId = URLEncoder.encode("user_id=�ο���&password=607043zlJK","UTF-8");
		     String userId = "user_id="+URLEncoder.encode("�ο���","UTF-8")+"&password="+URLEncoder.encode("607043zlJK","UTF-8");

//		    OutputStreamWriter ow = new OutputStreamWriter(hcon.getOutputStream());
//		    ow.write(userId);
		    OutputStream ow = new BufferedOutputStream(hcon.getOutputStream());
		    ow.write(userId.getBytes());
		    ow.flush();
		    ow.close();
		    
		    BufferedInputStream bufIn = new BufferedInputStream(hcon.getInputStream());
		    byte[] buff = new byte[1024];
		    int result = 0;
		    while((result = bufIn.read(buff)) != -1){
		    	System.out.println(new String(buff,"UTF-8"));
		    }
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

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
 * 读取url内容/往url里面写内容
 * 表单提交：当我们填写文本域的时候，比方说登陆信息，点击登陆按钮，浏览器通过网络把数据写入到url。服务器就会接受到数据
 * @author liaokangli
 *
 */
public class UrlInputStream {

	public static void main(String[] args){
		testUrlOutput();
	}
	
	/**
	 * 从url读取内容
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
	 * 往url里面写内容
	 */
	public static void testUrlOutput(){
		try {
			URL url = new URL("http://dw.19lou-inc.com/index.html");
			HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
		    hcon.setDoOutput(true);
		    hcon.connect();
		    // 这种方式用户名和密码无法验证通过
//		    String userId = URLEncoder.encode("user_id=廖康丽&password=607043zlJK","UTF-8");
		     String userId = "user_id="+URLEncoder.encode("廖康丽","UTF-8")+"&password="+URLEncoder.encode("607043zlJK","UTF-8");

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

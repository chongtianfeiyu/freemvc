package study2016.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.util.Base64;

import sun.net.www.MessageHeader;




/**
 * 网络验证器。http认证
 * http://www.aneasystone.com/archives/2016/03/java-and-http-authentication.html
 * http://blog.csdn.net/wangyangzhizhou/article/details/51336038
 * @author liaokangli
 *
 */
public class NetAuthenticator {
	
	public static void main(String[] args){
		basicHttpAutho();
//		myHttpAutho();
	}
	
	/**
	 * Authenticator 
	 */
	public static void authenticatorNormal(){
		try{
			Authenticator au;
			MessageHeader mh;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 自定义http认证
	 */
	public static void myHttpAutho(){
		String urlStr = "http://172.16.10.99:8081/nexus/content/groups/public";
		// 设置自定义认证器
		Authenticator.setDefault(new CustomAuthenticator());
		try {
			URL url = new URL(urlStr);
			
			// 读取,按行读取
			BufferedReader bis = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = null;
			while((line = bis.readLine()) != null){
				System.out.println(line);
			}
			

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * http基本认证。访问http://172.16.10.99:8081/nexus/content/groups/public是需要认证的。(因为这个连接时受保护的)
	 */
	public static void basicHttpAutho(){
		try {
			
			
			
			String urlStr = "http://172.16.10.99:8081/nexus/content/groups/public";
			URL url = new URL(urlStr);
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			//设置认证头部
			final String username = "developer";
			final String password = "lll123!@#";
			String nameAndPass = username + ":" + password;
			String encoding = new String(Base64.encodeBase64(nameAndPass.getBytes()));
			// 加了下面的代码，通过密码认证.不加将返回401
			huc.setRequestProperty("Authorization", "Basic " + encoding);
			
			huc.setRequestMethod("GET");
			
			// 连接网络
			huc.connect();
			
			String message = huc.getResponseMessage();
			Map<String, List<String>> maps =  huc.getHeaderFields();
			Object content = huc.getContent();
			
			// 读取,按行读取
			BufferedReader bis = new BufferedReader(new InputStreamReader(huc.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while((line = bis.readLine()) != null){
//				sb.append(line);
//				sb.append("\n");
				System.out.println(line);
			}
			
			System.out.println(sb.toString());
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

}

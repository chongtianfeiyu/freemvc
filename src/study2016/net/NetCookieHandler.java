package study2016.net;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * cookie handler.
 * 跟 jetty中实现cookie的还不一样
 * @author liaokangli
 *
 */
public class NetCookieHandler {
	
	public static void main(String[] args){
		
//		getCookieUsingCookieHandler();
		setCookieUsingCookieHandler();
	}

	/**
	 * cookie handler正常
	 */
	public static void cookieHandlerNormal(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 获取cookie
	 */
	public static void getCookieUsingCookieHandler(){
		try{
			CookieManager manager = new CookieManager();
			manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
			CookieHandler.setDefault(manager);
			
			// get content
			URL url = new URL("http://localhost:8182/newall/controller/index1");
			URLConnection connection = url.openConnection();
			connection.getContent();
			
			// get cookies from underlying
			CookieStore cookieJar = manager.getCookieStore();
			List<HttpCookie> cookies = cookieJar.getCookies();
			
			for(HttpCookie cookie:cookies){
				System.out.println("cookie:"+cookie);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置cookie
	 */
	public static void setCookieUsingCookieHandler(){
		try{
			CookieManager manager = new CookieManager();
			manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
			CookieHandler.setDefault(manager);
			
			CookieStore stores = manager.getCookieStore();
			
			//create cookie
			HttpCookie cookie = new HttpCookie("user-name","liaokkk");
			// add Cookie to cookiestore
			URL url = new URL("http://localhost:8182/newall/controller/index1");
			URLConnection connection = url.openConnection();
			connection.connect();
			stores.add(url.toURI(), cookie);
							
			// 查看设置的cookie
			stores.getCookies();
			
			connection.getContent();
			
			System.out.println("add cookie using cookie handler");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 从url里面获取cookie
	 */
	public static  void getCookieFromURLconn(){
		try{
			URL url = new URL("http://localhost:8180/mvcp-dw/newall/controller/index1");
			URLConnection connection = url.openConnection();
			Map<String,List<String>> headers = connection.getHeaderFields();
			List<String> values = headers.get("Set-Cookie");
			if(values != null){
				String cookieValue = null;
				for(Iterator iter = values.iterator();iter.hasNext();) {
					cookieValue = (String) iter.next();
					System.out.println("cookieget:"+cookieValue);
				}
			}else{
				System.out.println("no cookie found");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * set a custom cookie in request header
	 */
	public static void setCookieInURLConn(){
		try{
			URL url = new URL("http://localhost:8180/mvcp-dw/newall/controller/index1");
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("Cookie", "username=John");
			connection.setRequestProperty("ttt", "ppp");
			connection.connect();
			Map<String,List<String>> headers = connection.getHeaderFields();
			System.out.println("setCookieInURLConn");
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}

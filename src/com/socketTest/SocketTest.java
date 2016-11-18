package com.socketTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ContentHandler;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.DatagramPacket;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.MulticastSocket;
import java.net.NetPermission;
import java.net.NetworkInterface;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ResponseCache;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.jar.Manifest;

import sun.net.www.ParseUtil;

/**
 * socket��̲���
 * @author liaokangli
 *
 */
public class SocketTest {
	
	
	public static void main(String[] args) throws Exception{
//		testCookieManager();
//		testAuthenticator();
//		testAuthenticator1();
//		testCacheResponse();
		testCacheRequest();
//		testIDN();
//		testJarURLConnection();
//		testProxy();
//		testURI();
//		testURLClassLoader();
		
		testHttpClient();
	}
	
	/**
	 * ����Authenticator.
	 * ���õ�ַ1��http://172.16.10.99:8081/nexus/content/groups/public(�û���developer ����:lll123!@#��
	 * ���õ�ַ2��http://localhost:8180/mvcp-dw/newall/admin(�û���yjmyzz ����:123456��
	 * ʹ��Authenticator����ʴ���������ӡ��?��֤������
	 */
	public static void testAuthenticator(){
		Authenticator.setDefault(new CustomAuthenticator());
		try {
			URL url = new URL("http://localhost:8180/mvcp-dw/newall/admin");
			BufferedInputStream in = new BufferedInputStream((url.openStream()));
			int len = 0;
			byte[] buffer = new byte[1024];
			while((len = in.read(buffer)) != -1){
				System.out.println(new String(buffer,"UTF-8"));
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void testCacheRequest(){
		CacheRequest cacheRequest;
		
		while(true){
			System.out.println("aa");
			return;
					
		}
		
	}
	
	/**
	 * http://localhost:8180/mvcp-dw/newall/controller/index1
	 * ����cacheRequest
	 * @throws Exception
	 */
	public static void testCacheResponse() throws Exception{
		ResponseCache.setDefault(new MyResponseCache());
		// �����
		String param = String.format("userName=%s&password=%s", URLEncoder.encode("�ο���", "UTF-8"),URLEncoder.encode("222222", "UTF-8"));
		URL url = new URL("http://localhost:8180/mvcp-dw/newall/controller/index1?"+param);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("deviceid", "444_1456708688044");
		connection.setRequestProperty("Accept-Language", "en-US");
		connection.setRequestProperty("Accept-Charset", "gbk");
		connection.setRequestProperty("Connection", "close");
		// ������仰��ִ��MyResponseCache���get��put����
//		Object object = connection.getContent();
		
		connection.getHeaderField("deviceid");
		//��
		BufferedInputStream  in = new BufferedInputStream(connection.getInputStream());
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len = in.read(buffer)) != -1){
			System.out.println(new String(buffer,"UTF-8"));
		}
		in.close();
		
		
		
	}
	
	public static void testHttpClient() throws Exception{
		URL url = new URL("http://oa.19lou-inc.com/user/api/initdwuserinfo");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedInputStream  in = new BufferedInputStream(connection.getInputStream());
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len = in.read(buffer)) != -1){
			System.out.println(new String(buffer,"UTF-8"));
		}
		in.close();
	}
	
	/**
	 * ����manager
	 * @throws Exception
	 */
	public static void testCookieManager() throws Exception{
		String urlString = "http://www.19lou.com/";
		CookieManager cookieManager = new CookieManager();
		CookieHandler.setDefault(cookieManager);
		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		Object object = connection.getContent();
		CookieStore cookiejar = cookieManager.getCookieStore();
		List<HttpCookie> cookies = cookiejar.getCookies();
		for(HttpCookie httpCookie:cookies){
			System.out.println(httpCookie);
		}
	} 
	
	/**
	 * ����DatagramPacket ��ݰ�
	 */
	public static void testDatagramPacket(){
		DatagramPacket datagramPacket;
	}
	
	
	/**
	 * ����ContentHandler
	 */
	public static void testContentHandler(){
		ContentHandler contentHandler;
		
	}
	
	/**
	 * �μ�testCookieManager
	 * ����CookieHandler
	 */
	public static void testCookieHandler(){
		CookieHandler cookieHandler;
	}
	
	/**
	 * ����HttpURLConnection
	 */
	public static void testHttpURLConnection(){
		HttpURLConnection httpURLConnection;
	}
	
	/**
	 * ����IDN��
	 * �ṩ����ͨ Unicode ��ʾ��ʽ�� ASCII �����Ա��� (ACE) ��ʾ��ʽ֮����й�ʻ����� (IDN) ת���ķ���
	 */
	public static void testIDN(){
		String str = IDN.toASCII("www.yourName.com");
		String u = IDN.toUnicode("www.yourName.com");
		System.out.println(str+":"+u);
	}
	
	
	
	/**
	 * ����Inet4Address
	 */
	public static void testInet4Address(){
		Inet4Address inet4Address;
	}
	
	/**
	 * InetAddress
	 */
	public static void testInetAddress(){
		InetAddress inetAddress;
	}
	
	/**
	 * ����InetSocketAddress
	 */
	public static void testInetSocketAddress(){
		InetSocketAddress inetSocketAddress;
	}
	
	
	/**
	 * ��ȡjar�ļ�����
	 * @throws MalformedURLException 
	 */
	public static void testJarURLConnection() throws Exception{
            URL url = new URL("jar:file:D:\\repo\\com\\github\\fommil\\netlib\\core\\1.1.2\\core-1.1.2.jar!/");
            JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
            Manifest manifest = jarURLConnection.getManifest();
            System.out.println("====");
	}
	
	/**
	 * �ಥ�׽���.
	 */
	public static void testMulticastSocket(){
		MulticastSocket multicastSocket;
	}
	
	/**
	 * ����Ȩ��NetPermission
	 */
	public static void testNetPermission(){
		NetPermission netPermission = new NetPermission("getCookieHandler");
		SecurityManager sm = System.getSecurityManager();
		if (sm != null) {
		    NetPermission setDefaultPermission
			= new NetPermission("setDefaultAuthenticator");
		    sm.checkPermission(setDefaultPermission);
		}
		
	}
	
	/**
	 * ����NetworkInterface
	 */
	public static void testNetworkInterface(){
		NetworkInterface networkInterface;
		
	}
	
	/**
	 * ����Proxy.3����ʽ�Ĵ���
	 */
	public static void testProxy(){
		String proxyIp = "172.16.15.28";
		// 1.�����ڸ߲�:��Ӧ�ò�Ĵ��?����HTTP��ftp
		Proxy.Type typeHttp = Proxy.Type.HTTP;
		// 2.�����ڵͲ㣺�������Ĵ���
		Proxy.Type typeSockets = Proxy.Type.SOCKS;
		// 3.ֱ������ ����ͨ�����
		Proxy.Type typeNone = Proxy.Type.DIRECT;
		
		try{
			 // ************************ ȫ�ִ��� *****************************// 
			// 1.1.����httpȫ�ִ��?ͬһ��JVM��������Ӷ�Ĭ��ʹ�øô���
			System.setProperty("http.proxyHost", proxyIp);
			System.setProperty("http.proxyPort", "80");
			
			// �����Щ���Ӳ�ͨ�����,��ͨ��http.nonProxyHosts����
			System.setProperty("http.nonProxyHosts", "www.baidu.com");
			
			// 1.2 ����socksȫ�ִ���:ע�����ַ�ʽ����ȫ��ʹ�ô��?Ҫôȫ����ʹ��
			System.setProperty("socks.proxyHost", proxyIp);
			System.setProperty("socks.proxyPort", "80");
			
			 // ************************ ����ǰָ������ *****************************//  
			// 2.1 Ӧ�ò��̣�����http/ftp�ȣ�ʹ�ô��? ����ͨ��������ӵ��ٶ� 
			SocketAddress sa = new InetSocketAddress(proxyIp,80);
			Proxy httpProxy = new Proxy(typeHttp,sa);
			
			URL url = new URL("http://www.baidu.com");
			URLConnection connection = url.openConnection(httpProxy);
			
			byte[] buff = new byte[1024];
			int len = 0;
			BufferedInputStream bos = new BufferedInputStream(connection.getInputStream());
			while((len = bos.read(buff))!=-1){
				String str = new String(buff,"utf-8");
				System.out.println(str);
			}
			
			//2.2 ֱ���ڵͲ㼴�����ʹ��socket���,������ǰʹ�ô���
			Proxy socksProxy = new Proxy(typeSockets,sa);
			Socket client = new Socket(socksProxy);
			SocketAddress remote = new InetSocketAddress("www.baidu.com",80);
			client.connect(remote,3000);
			client.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ����SocketImpl
	 */
	public static void testSocketImpl(){
		SocketImpl socketImpl;
	}
	

	/**
	 * ����URI��URL
	 * @throws URISyntaxException 
	 */
	public static void testURI() throws Exception{
//		URI uri = new URI("http://localhost:8180/mvcp-dw/newall/controller/index1 index1/aa");
		URL url = new URL("http://localhost:8180/mvcp-dw/newall/controller/index1");
		URLConnection connection = url.openConnection();
		connection.setRequestProperty("Accept-Language", "en-US");
		connection.setRequestProperty("Accept-Charset", "gbk");
		connection.getContent();
		
		System.out.println("====");
	}
	
	/**
	 * ����URLClassLoader
	 */
	public static void testURLClassLoader(){
		URL url = null;
		try {
			url = new URL("file:///D:\\repo\\com\\mycompany\\app\\my-testA\\1.0-SNAPSHOT\\my-testA-1.0-SNAPSHOT.jar");
	
			URLClassLoader uRLClassLoader = new URLClassLoader(new URL[]{url});
			Class myClass = uRLClassLoader.loadClass("com.mycompany.app.Persontt");
			myClass.newInstance();
			System.out.println("end.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����ResponseCache
	 * @author liaokangli
	 *
	 */
	public static class MyResponseCache extends ResponseCache{

		@Override
		public CacheResponse get(URI uri, String rqstMethod,
				Map<String, List<String>> rqstHeaders) throws IOException {
			// TODO Auto-generated method stub
			if(uri.equals(ParseUtil.toURI(new URL("http://localhost:8180/mvcp-dw/newall/controller/index11")))){
				  return new MyCacheResponse("G:\\dd\\t\\file2.cache");
			} 
			return null;
		}

		/**
		 * https://bugs.openjdk.java.net/browse/JDK-6460811
		 * @see java.net.ResponseCache#put(java.net.URI, java.net.URLConnection)
		 */
		@Override
		public CacheRequest put(URI uri, URLConnection conn) throws IOException {
			// TODO Auto-generated method stub
			if(uri.equals(ParseUtil.toURI(new URL("http://localhost:8180/mvcp-dw/newall/controller/index11")))){
				return new MyCacheRequest("G:\\dd\\t\\file2.cache",conn.getHeaderFields());
			}
			return null;
		}
		
	}
	
	static class MyCacheResponse extends CacheResponse {
		FileInputStream fis;
		Map<String, List<String>> headers;
		public MyCacheResponse(String filename) {
		        try {
		         fis = new FileInputStream(new File(filename));
		         ObjectInputStream ois = new ObjectInputStream (fis);
		         headers = (Map<String, List<String>>)  ois.readObject();
		   } catch (Exception ex) {
		        // handle exception
		   }
		}

		public InputStream getBody() throws IOException {
		   return fis;
		}

		 public Map getHeaders() throws IOException {
		   return headers;
		 }
	}
	
	static class MyCacheRequest extends CacheRequest {
		FileOutputStream fos;
		File file = null;
		public MyCacheRequest(String filename,
		   Map<String, List<String>> rspHeaders) {
		   try {
		        file = new File(filename);
		        fos = new FileOutputStream(file);
		        ObjectOutputStream oos = new ObjectOutputStream(fos);
		        oos.writeObject(rspHeaders);
		   } catch (Exception ex) {
		        throw new RuntimeException(ex.getMessage());
		   }
		}
		public OutputStream getBody() throws IOException {
		   return fos;
		}

		public void abort() {
		   // we abandon the cache by close the stream,
		   // and delete the file
		   try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		   file.delete();
		 }
		}
	
	
	
	
	/**
	 * Authenticator������
	 * @author liaokangli
	 *
	 */
	public static class CustomAuthenticator extends Authenticator{
		
		protected PasswordAuthentication getPasswordAuthentication() {
			String prompt = getRequestingPrompt();
			String hostname = getRequestingHost();
			InetAddress ipaddr = getRequestingSite();
			int port = getRequestingPort();
			String username = "yjmyzz";
			String password = "123456";
			PasswordAuthentication pa = new PasswordAuthentication(username,password.toCharArray());
			return pa;
		}
	}


}

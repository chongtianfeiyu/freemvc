package study2016.securitymanager;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * java 安全模型
 * @author liaokangli
 *
 */
public class SecuritySecurityManger {
	
	public static void main(String[] args){
		securityMangerNormal();
	}
	
	/**
	 * 默认情况下是不能使用安全管理器，必须通过-Djava.security.manager
	 * http://m.blog.csdn.net/article/details?id=49204237
	 */
	public static void securityMangerNormal(){
		System.out.println(System.getSecurityManager());
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("f:\\testOut.txt"));
			bw.write("hello world");
			bw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

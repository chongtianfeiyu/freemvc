package com.jvmTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 * ����Ϊʲô��Ҫ�����ļ�����
 * ����������getCallerClass�������
 * callerC = Class.forName(driverClassName, true, callerClassLoader);
 * 
 * ��������:
 * Class.forName("com.mysql.jdbc.Driver",true, DriverManager.class.getClassLoader()) ����׳��쳣
 * 
 * �����������:
 * Class.forName("com.mysql.jdbc.Driver",true, Thread.currentThread().getContextClassLoader())
 * ����
 * @author liaokangli
 *
 */
public class ThreadContexCloaderTest {

	
	public static void main(String[] args){
		String url = "jdbc:mysql://127.0.0.1:3306/home_userinfo";
		String username = "root";
		String password = "";
		System.out.println("dd");
		try{
			System.out.println(DriverManager.class.getClassLoader());
			Connection con = DriverManager.getConnection(url, username, password);
			
		}catch(Exception e){
			System.out.println("");
		}
	}
}

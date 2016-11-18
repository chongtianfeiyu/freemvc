package com.jvmTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.commons.logging.impl.NoOpLog;
import org.apache.log4j.Logger;


/**
 * 主线程和子线程类加载器
 * @author liaokangli
 *
 */
public class ClassLoaderTest2 {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		ClassLoader classLoader = NoOpLog.class.getClassLoader();
		
		NoOpLog logger = (NoOpLog) Class.forName("org.apache.commons.logging.impl.NoOpLog", true, classLoader).newInstance();
		System.out.println(logger);
		
		Thread myThread = new Thread(new MyThread());
		myThread.start();
		
		System.out.println("完成");
	}
	
	public static class MyThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			URL[] urls = new URL[1];
			try {
				urls[0] = new URL("file:/G:/study/my-testB/target/my-testB-1.0-SNAPSHOT.jar");
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			URLClassLoader urlLoader = new URLClassLoader(urls);
			Thread.currentThread().setContextClassLoader(urlLoader);
			System.out.println(Thread.currentThread().getContextClassLoader());
			ClassLoader classLoader = NoOpLog.class.getClassLoader();
//			Thread.currentThread().setContextClassLoader(classLoader);
			try {
				// 子线程继承父线程的类加载器
			   
				NoOpLog log = (NoOpLog) Class.forName("org.apache.commons.logging.impl.NoOpLog",true,urlLoader).newInstance();
			    System.out.println(log.getClass().getClassLoader());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


}

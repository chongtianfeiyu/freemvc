/**
 * 19lou.com
 */
package com.jvmTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author liaokangli
 *
 */
public class ClassLoaderTest {
     
	public static void main(String[] args) {
	  System.out.println(Thread.currentThread().getName()+":"+ClassLoaderTest.class.getClassLoader());
	  System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getContextClassLoader());
      Thread t1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Thread t2 = new MyThread("ThreadMy");
			t2.start();
		}
	  });
      
      Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getContextClassLoader());				
			}
	  });
      
      t1.start();
      t3.start();
      
	}
	
	public static class MyThread extends Thread{
		
		public MyThread(String name){
			super(name);
		}
		public void run() {
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getContextClassLoader());
			URL[] urls = new URL[1];
			String jarPath = "file:/D:/repo/com/google/code/gson/gson/1.4";
			try {
				urls[0] = new URL(jarPath);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			URLClassLoader urlLoader = new URLClassLoader(urls);
			try {
				urlLoader.loadClass("com.google.gson.JsonArray");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	   }
	}
}

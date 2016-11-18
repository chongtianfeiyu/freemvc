/**
 * 19lou.com
 */
package com.commonTest;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author liaokangli
 *
 */
public class CommonTest {
	
	private static void getName(){
		
	}
	
     public static void main(String[] args) throws SQLException {
    	 DriverManager.getConnection("jdbc:mysql://172.16.10.203:3307/dw_stat","dw","PjNQzLGRNQHUSMl7BaAx");
    	 System.out.println("tt");
    	 final SubClass s1 = new SubClass();
    	 HashMap<String,Object> aa;
    	 final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			  for(int i =0;i<2;i++){
//				SubClass sb1 = threadLocal.get();
				System.out.println(Thread.currentThread().getName());
				if(threadLocal.get() == null){
//					sb1 = new SubClass();
					threadLocal.set(new SubClass());
					threadLocal.set(new String("wo"));
				}
				((FatherClass) threadLocal.get()).ref();
			  }
			}
		});
		
	   Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
//			SubClass s2 = new SubClass();
		  
		  for(int i = 0;i<2;i++){
//			SubClass sb1 = threadLocal.get();
			System.out.println(Thread.currentThread().getName());
			if(threadLocal.get() == null){
//				sb1 = new SubClass();
				threadLocal.set(new SubClass());
			}
			((FatherClass) threadLocal.get()).ref();
		  }	
		}
	});
	   t1.start();
	   t2.start();
	   
	   StringBuilder sb;
	   getName();
	}
}

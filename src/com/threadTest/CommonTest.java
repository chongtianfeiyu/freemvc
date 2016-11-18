package com.threadTest;

/**
 * 通用测试,测试synchronized(this)的指向
 * @author liaokangli
 *
 */
public class CommonTest {
	
	public static void main(String[] args){
		CommonTest t = new CommonTest();
		t.testThread();
	}
	
	public void testThread(){
		
		MyThread myThread1 = new MyThread("tt");
		System.out.println(myThread1);
//		MyThread myThread2 = new MyThread();
		myThread1.start();
//		myThread2.start();
		
		System.out.println("tt");
	}
	
	public  synchronized void getName1(){
		System.out.println(this);
	}
	
	
	public  class MyThread extends Thread{
		public MyThread(String name){
			super(name);
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
//			synchronized(this){
			System.out.println(":::"+this);
			 getName2();
//			}
		}
		
		public  synchronized void getName2(){
			System.out.println(";;;;"+this);
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}

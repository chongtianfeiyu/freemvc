package com.threadTest;

/**
 * 测试wait时间<=10000.当有notify的时候，wait时间等于t2的时间
 * @author liaokangli
 *
 */
public class SynchronizedWaitTest {
   
	public static void main(String[] args){
		final Object object = new Object();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					System.out.println("t1获取锁并等待");
					try {
						object.wait(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					System.out.println("t2获取锁并等待");
					try {
						object.notify();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		t1.start();
		t2.start();
	}
}

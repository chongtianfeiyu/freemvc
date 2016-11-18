package com.threadTest;

/**
 * 测试synchronized，如果未获取到锁，将会一直被阻塞
 * @author liaokangli
 *
 */
public class SynchronizedTest {
	public static void main(String[] args) {
		final Object object = new Object();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					System.out.println("ddd");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println("aaa");
			}
			
		});
		
		final Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					System.out.println("bbb");
				}
				System.out.println("hjk");
			}
			
		});
		
		t1.start();
		t2.start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("t3执行开始.....");
				t2.interrupt();
				System.out.println("t3执行结束.....");
			}
			
		}).start();
		
	}
	
	
}

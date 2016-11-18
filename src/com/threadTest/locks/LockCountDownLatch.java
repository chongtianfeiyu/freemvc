package com.threadTest.locks;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * @author liaokangli
 *
 */
public class LockCountDownLatch {
	
	public static void main(String[] args){
		countDownLatch();
	}
	
	public static void countDownLatch(){
		final CountDownLatch countDownLatch = new CountDownLatch(10);
		
		for(int i = 0;i < 10;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"开始执行");
					try{
					    Thread.sleep(10000);
					    countDownLatch.countDown();
					    System.out.println(Thread.currentThread().getName()+"执行完成");
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			}).start();
		}
		
		try {
			System.out.println("主线程等待其他线程执行");
			countDownLatch.await();
			System.out.println("主线程等待完成");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

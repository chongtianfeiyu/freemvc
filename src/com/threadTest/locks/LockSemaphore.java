package com.threadTest.locks;

import java.util.concurrent.Semaphore;

/**
 * 信号量使用
 * @author liaokangli
 *
 */
public class LockSemaphore {
	
	public static void main(String[] args){
//		lockSemaphoreNormal();
		lockSemaphoreReleaseTwo();
//		lockSemaphoreTryAcquire();
	}
	
	/**
	 * 信号量正常使用,阻塞
	 */
	public static void lockSemaphoreNormal(){
	
		final Semaphore semaphore = new Semaphore(2);
		
		for(int i = 0;i < 4;i++){
			final int count = i;
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						System.out.println(Thread.currentThread().getName()+"获得许可");
						// 获得许可
						semaphore.acquire();
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName()+"开始");
						Thread.sleep(count*2000);
						System.out.println(Thread.currentThread().getName()+"结束");
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						// 释放许可
						semaphore.release();
						semaphore.release();
					}
				}
				
			}).start();
		}
		
		
	}
	
	/**
	 * 信号量正常使用,阻塞。获取一次许可，释放多次
	 * 
	 */
	public static void lockSemaphoreReleaseTwo(){
	
		final Semaphore semaphore = new Semaphore(1);
		
		for(int i = 0;i < 4;i++){
			final int count = i+1;
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						System.out.println(Thread.currentThread().getName()+"获得许可");
						// 获得许可
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName()+"开始");
						Thread.sleep(count*2000);
						System.out.println(Thread.currentThread().getName()+"结束");
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						// 释放许可
						semaphore.release();
						semaphore.release();
					}
				}
				
			}).start();
		}
		
		
	}
	
	/**
	 * 尝试获取，不阻塞
	 */
	public static void lockSemaphoreTryAcquire(){
		final Semaphore semaphore = new Semaphore(1);
		for(int i = 0;i < 4;i++){
			final int count = i;
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						System.out.println(Thread.currentThread().getName()+"获得许可");
						// 尝试获得许可，有，返回true
						if(semaphore.tryAcquire()){
							System.out.println(Thread.currentThread().getName()+"开始");
							Thread.sleep(count * 20000);
							System.out.println(Thread.currentThread().getName()+"结束");
					     }else{
					    	 System.out.println(Thread.currentThread().getName()+"未获得许可");
					     }
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						semaphore.release();
					}
				}
				
			}).start();
		}
	}

}

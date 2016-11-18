package com.threadTest.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 1、自旋锁:不停的检测是否获得锁，直到获得锁。但是在它等待的过程中，并不释放cpu时间片，相比synchronized和wait操作，减少了释放，重新获取锁的开销
 * 
 * 适应于竞争不激烈的场景使用
 * @author liaokangli
 *
 */
public class LockSpinLock {
	
	public static void main(String[] args){
		spinLock();
	}
	
	/**
	 * 自旋锁实现
	 */
	public static void spinLock(){
		
		final SpinLock spinLock = new SpinLock();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName());
				spinLock.lock();
			    long start = System.currentTimeMillis();
				System.out.println(Thread.currentThread().getName());
			    try {
//					Thread.sleep(100000);
			    	long current = System.currentTimeMillis();
			    	while((current - start) < 100000){
			    		current = System.currentTimeMillis();
			    	}
			    	
			    	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				spinLock.unlock();
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName());
				spinLock.lock();
				System.out.println(Thread.currentThread().getName());
				spinLock.unlock();
			}
			
		});
		
		t1.start();
		t2.start();
		
		
	}
	
	/**
	 * 自旋锁实现
	 * 
	 * @author liaokangli
	 *
	 */
	public static class SpinLock{
		AtomicReference<Thread> sign = new AtomicReference<Thread>();
		public void lock(){
			Thread currentThread = Thread.currentThread();
			while(!sign.compareAndSet(null, currentThread)){
				
			}
		}
		
		public void unlock(){
			Thread currentThread = Thread.currentThread();
			sign.compareAndSet(currentThread, null);
		}
	}

}

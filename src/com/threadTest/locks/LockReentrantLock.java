package com.threadTest.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

import com.threadTest.Counter;

/**
 * 
 * @author liaokangli
 *
 */
public class LockReentrantLock {
	
	private static int aa = 100;
	static ReentrantLock lock = new ReentrantLock();
	static Condition condition = lock.newCondition();
	
	public static void main(String[] args){
//		reentrantLockNormal();
//		reentrantLockReentry();
//		reentrantTryLock();
//		reentrantTryLockTime();
		reentrantInterruptibly();
		
	}
	
	public static  void reentrantLockNormal(){
		
		final Counter counter = new Counter();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					lock.lock();
					  for(int i = 0; i<1000000000000l;i++){
						  int count = counter.getCount();
						  counter.setCount(count++);
						  System.out.println(Thread.currentThread().getName()+":"+counter.getCount());
					  }
					  
					  
					    
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					lock.lock();
					  for(int i = 0; i<1000000000000l;i++){
						  int count = counter.getCount();
						  counter.setCount(count++);
						  System.out.println(Thread.currentThread().getName()+":"+counter.getCount());
					  }
					    
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 重入特性。获得几次锁，相应的需要释放几次锁
	 */
	public static void reentrantLockReentry(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					lock.lock();
					System.out.println(Thread.currentThread().getName()+":第一次获得锁");
					lock.lock();
					System.out.println(Thread.currentThread().getName()+":第二次获得锁");
				
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					// 释放一次
					lock.unlock();
					System.out.println(Thread.currentThread().getName()+":第一次释放锁");
					lock.unlock();
					System.out.println(Thread.currentThread().getName()+":第二次释放锁");
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					lock.lock();
					System.out.println(Thread.currentThread().getName()+":第一次获得锁");
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					// 释放一次
					lock.unlock();
				}
			}
			
		});
		
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
	}
	
	/**
	 * 尝试获得锁，没有获取，立马返回。
	 * 这个可以解决一直阻塞获取锁，而不能释放,可以避免死锁
	 * 非阻塞等待
	 */
	public static void reentrantTryLock(){
		
		for(int i = 0;i < 10;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						if(lock.tryLock()){					
							try{
								System.out.println(Thread.currentThread().getName()+"获得锁");
								Thread.sleep(10000);
							}finally{
								lock.unlock();
							}
						}else{
							System.out.println(Thread.currentThread().getName()+"未获得锁");
						}
						
					}catch(Exception e){
						
					}
				}
				
			}).start();
		}
		
	}
	
	/**
	 * 尝试等待一段时间获得锁
	 */
	public static void reentrantTryLockTime(){
		for(int i = 0;i < 10;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						if(lock.tryLock(1000,TimeUnit.SECONDS)){					
							try{
								System.out.println(Thread.currentThread().getName()+"获得锁");
								Thread.sleep(10000);
							}finally{
								lock.unlock();
							}
						}else{
							System.out.println(Thread.currentThread().getName()+"未获得锁");
						}
						
					}catch(Exception e){
						
					}
				}
				
			}).start();
		}
		
	}
	
	
	/**
	 * 在获取锁的过程中，允许中断
	 */
	public static void reentrantInterruptibly(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					lock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName()+"获得锁");
					Thread.sleep(1000000);
									
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					lock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName()+"获得锁");
					Thread.sleep(10000);
									
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					// 不是自己拥有锁,调用这个方法会抛异常
					if(lock.isHeldByCurrentThread()){
					   lock.unlock();
					}else{
						System.out.println(Thread.currentThread().getName()+"不拥有锁");
					}
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					lock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName()+"获得锁");
					Thread.sleep(10000);
									
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			
		});
		
		
		
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t2.interrupt();
		t3.start();
		System.out.println("结束");
		
		
		
		
	}
	
	
	
	

}

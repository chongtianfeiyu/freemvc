package com.threadTest.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁测试
 * @author liaokangli
 *
 */
public class LockTest {
	
	public static void main(String[] args){
//		testSemaphore();
//		testReetrantLockLockInter();
//		testLockSupport();
		testReetrantLockSample();
	
	}
	
	/**
	 * 测试信号量
	 */
	public static void testSemaphore(){
		
		ExecutorService exec = Executors.newFixedThreadPool(100);
		final Semaphore semp = new Semaphore(2);
		for(int index = 0;index < 5;index++){
			final int NO = index;
			exec.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						
						semp.acquire();
						System.out.println("accessing:"+NO);
						Thread.sleep(100);
						semp.release();
						System.out.println("-------------"+semp.availablePermits());
						
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			});
		}
		exec.shutdown();
		
	}
	
	/**
	 * 测试LockSupport.park是否会释放锁
	 */
	public static void testLockSupport(){
		final Object object = new Object();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					System.out.println("ttt1");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("ttt2");
					LockSupport.park();
					System.out.println("ttt3");
					
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ttt锁");
				synchronized(object){
					System.out.println("ttt");
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 测试锁ReetrantLock,中断。在阻塞阶段可以被中断。如果线程在运行的话是不能中断的
	 */
	public static void testReetrantLockLockInter(){
		
		final ReentrantLock lock = new ReentrantLock();
		
		final Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  try{
				    System.out.println("t1未获得锁");
					lock.lockInterruptibly();
					System.out.println("t1获得锁了");
			  }catch(Exception e){
				  System.out.println("t1中断");
				  e.printStackTrace();
			  }finally{
				  System.out.println("t1中断完成");
//				  lock.unlock();
			  }
			}
			
		});
		
		final Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
			  try{
				while(true){
					
				}
			  }finally{
				  System.out.print("tt");
				  lock.unlock();
			  }
				
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean flag = true;
				while(flag){
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(!t1.isInterrupted()){
						t1.interrupt();
						System.out.println("t3中断t1"+":"+t1.isAlive());
					}
					if(!t2.isInterrupted()){
						t2.interrupt();
						System.out.println("t3中断t2"+":"+t2.isAlive());
						flag = false;
					}
				}
				
				System.out.println("t3退出");
				
				
			}
			
		});
		t1.start();
		t2.start();
		t3.start();
	}
	
	/**
	 * 中断锁和锁是同一个锁吗？由同一个ReentrantLock是同一把锁。
	 * 同一个对象
	 */
	public static void testReetrantLockSample(){
		
		final ReentrantLock rtl = new ReentrantLock();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				rtl.lock();
				System.out.println("tt");
				rtl.unlock();
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  try{
				  System.out.println("cc");
				rtl.lockInterruptibly();
				System.out.println("bb");
				rtl.unlock();
			  }catch(Exception e){
				  e.printStackTrace();
			  }
				
			}
			
		});
		t1.start();
		t2.start();
		
	}
	
	 

}

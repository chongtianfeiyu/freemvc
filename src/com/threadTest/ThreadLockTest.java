/**
 * 19lou.com
 */
package com.threadTest;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁
 * @author liaokangli
 *
 */
public class ThreadLockTest {
   public static void main(String[] args) {
	    final Counter counter = new Counter();
	    // 设置true公平锁
	    final ReentrantLock2 lock = new ReentrantLock2();
	    // 类似wait
	    final Condition condition = lock.newCondition();
	    Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try{
//					System.out.println(Thread.currentThread().getName()+"获得锁");
//					condition.await(10,TimeUnit.SECONDS);
				try{
					lock.lock();
				  for(int i = 0;i < 10;i++){
				   
						
						counter.increment();
						System.out.println(Thread.currentThread().getName()+":"+counter.value()+":等待队列:"+lock.getQueuedThreads());
				   
				   System.out.println(Thread.currentThread().getName()+"dddd");
				 }
				}finally{
						lock.unlock();
				   }
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	    	
	    });
	    Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				lock.lock();
				try{
//					System.out.println(Thread.currentThread().getName()+"获得锁");
//					condition.await(10,TimeUnit.SECONDS);
					if(lock.tryLock(1,TimeUnit.MILLISECONDS)){
				     try{
							for(int i = 0;i < 10;i++){
								System.out.println(Thread.currentThread().getName()+"开始");
							  
								 							    
											counter.decrement();
											System.out.println(Thread.currentThread().getName()+":"+counter.value()+":等待队列11:"+lock.getQueuedThreads());
									    
								  
								
							
							}
					  }finally{
							lock.unlock();
			          }
					}else{
						System.out.println(Thread.currentThread().getName()+"锁不可用.....");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	    	
	    });
	    Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
                  try{
                	  lock.lock();
                  
					for(int i = 0;i < 10;i++){
						
							
							counter.increment();
							System.out.println(Thread.currentThread().getName()+":"+counter.value()+":等待队列:"+lock.getQueuedThreads());
						   
					}
                  }finally{
                	  lock.unlock();
                  }
			}
	    	
	    });
	    t1.start();
	    
	    t3.start();
	    t2.start();
   }
   
   class MyThread implements Runnable{
    private Counter counter;
	   
	public MyThread(Counter counter){
		this.counter = counter;
	}

	/** 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	   
   }
   
   static class Counter{
	   private int c = 0;
	   public void increment(){
		   c++;
	   }
	   public void decrement(){
		   c--;
	   }
	   public int value(){
		   return c;
	   }
   }
   static class ReentrantLock2 extends ReentrantLock{
	   public Collection<Thread> getQueuedThreads() {
	        return super.getQueuedThreads();
	    }
   }
}

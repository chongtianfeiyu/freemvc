package com.threadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock中实现wait,notify,notifyall测试
 * @author liaokangli
 *
 */
public class ReentrantLockConditionTest {
      public static void main(String[] args){
    	  final ReentrantLock lock = new ReentrantLock();
    	  final ReentrantLock lock1 = new ReentrantLock();
    	  final Condition condition = lock.newCondition();
    	  
    	  Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				try{
				  for(int i = 0;i<10;i++){
					System.out.println(Thread.currentThread().getName()+"获取锁"+i);
					if(i == 3){
						System.out.println(Thread.currentThread().getName()+"==========等待"+i);
						condition.await(10000,TimeUnit.MILLISECONDS);
					}
				  }
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
    		  
    	  },"t1");
    	  
    	  Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				try{
				  for(int i = 0;i<10;i++){
					System.out.println(Thread.currentThread().getName()+"获取锁"+i);
					if(i == 3){
						System.out.println(Thread.currentThread().getName()+"===========通知"+i);
//						condition.signal();
						condition.await(10000,TimeUnit.MILLISECONDS);
					}
				  }
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
    		  
    	  },"t2");
    	  
    	  
    	  Thread t3 = new Thread(new Runnable(){

  			@Override
  			public void run() {
  				// TODO Auto-generated method stub
  				lock.lock();
  				try{
  				  for(int i = 0;i<10;i++){
  					System.out.println(Thread.currentThread().getName()+"获取锁"+i);
  					if(i == 3){
  						System.out.println(Thread.currentThread().getName()+"===========等待"+i);
  						condition.await(1000,TimeUnit.MILLISECONDS);
  					}
  				  }
  					
  				} catch (Exception e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}finally{
  					lock.unlock();
  				}
  				
  				System.out.println("t3上半部分执行完");
  				
  				lock.lock();
  				try{  					
  					condition.signalAll();
  				}finally{
  					lock.unlock();
  				}
  			}
      		  
      	  },"t3");
    	  
    	  t1.start();
    	  t2.start();
    	  t3.start();
      }

}

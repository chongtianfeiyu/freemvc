package com.threadTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁公平性测试，
 * @author liaokangli
 *
 */
public class ReentrankLockFairyTest {
	public static void main(String[] args) {
		// 公平锁
		final ReentrantLock lock = new ReentrantLock(true);
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			 for(int i=0;i<5;i++){
				lock.lock();
				try{
					System.out.println("t1获得锁");
				}finally{
					System.out.println("t1释放锁");
					lock.unlock();
				}
			 }
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  for(int i=0;i<5;i++){
				lock.lock();
				try{
					System.out.println("t2获得锁");
				}finally{
					System.out.println("t2释放锁");
					lock.unlock();
				}
			  }
			}
			
		});
		t1.start();
		t2.start();
		
	}
	
	
}

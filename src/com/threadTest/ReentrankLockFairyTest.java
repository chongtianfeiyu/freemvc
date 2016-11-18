package com.threadTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ����ƽ�Բ��ԣ�
 * @author liaokangli
 *
 */
public class ReentrankLockFairyTest {
	public static void main(String[] args) {
		// ��ƽ��
		final ReentrantLock lock = new ReentrantLock(true);
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			 for(int i=0;i<5;i++){
				lock.lock();
				try{
					System.out.println("t1�����");
				}finally{
					System.out.println("t1�ͷ���");
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
					System.out.println("t2�����");
				}finally{
					System.out.println("t2�ͷ���");
					lock.unlock();
				}
			  }
			}
			
		});
		t1.start();
		t2.start();
		
	}
	
	
}

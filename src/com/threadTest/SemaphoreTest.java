package com.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * �ź�������(�ɿ��Ʒ��ʵ��̸߳�������Ϊÿ���߳�ִ�б�������ɣ�.
 * ��ʵ������5����5������û��������̱߳�����������һ���߳�ִ���꣬�ͷ����
 * @author liaokangli
 *
 */
public class SemaphoreTest {

	public static void main(String[] args){
//		testAccquire();
		testTryAccquire();
	}
	
	/**
	 * ����accquire û�л�ȡ����ɣ�����
	 */
	public static void testAccquire(){
        ExecutorService pool = Executors.newFixedThreadPool(100);
		
		// �ź���
		final Semaphore semph = new Semaphore(5);
		
		// 20���߳�
		for(int i = 1;i<20;i++){
			pool.execute(new Thread(new Runnable(){

				@Override
				public void run() {
					try {
						semph.acquire();
						// TODO Auto-generated method stub
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(100000);
						semph.release();
						System.out.println("-------------"+semph.availablePermits());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}));
		}
		pool.shutdown();
		
	}
	
	// ����tryacquire,û�л�ȡ����ɣ�ִ�к���Ĵ��룬
	public static void testTryAccquire(){
		ExecutorService pool = Executors.newCachedThreadPool();
		final Semaphore semph = new Semaphore(5);
		// 20���߳�
		for(int i = 1;i<10;i++){
			pool.execute(new Thread(new Runnable(){

				@Override
				public void run() {
					try {
						if(semph.tryAcquire()){
						// TODO Auto-generated method stub
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(10000);
						
						}else{
							System.out.println(Thread.currentThread().getName()+"û�������"+semph.availablePermits());
						}
						semph.release();
						System.out.println("-------------"+semph.availablePermits());
					   
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}));
		}
		pool.shutdown();
	}
}

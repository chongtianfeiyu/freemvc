package com.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * �̳߳ز���
 * @author liaokangli
 *
 */
public class ExecutorTest {

	public static void main(String[] args){
		
//		singleThreadExecutorTest();
		
//		newScheduledThreadPoolTest();
		newFixedThreadPoolTest();
//		newCachedThreadPoolTest();
		
		
		
	}
	
	
	public static void newSchedule(){
		
	}
	
	/**
	 * newFixedThreadPool����
	 */
	public static void newFixedThreadPoolTest(){
		// �����̶���С���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for(int i=0;i<10;i++){
			pool.execute(new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true){
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					System.out.println(Thread.currentThread().getName()+"����");
					}
				}
				
			},"t"+i));
		}
		
		System.out.println("aa");
		pool.shutdown();
		System.out.println("bb");
	}
	
	/**
	 * newCachedThreadPool����
	 */
	public static void newCachedThreadPoolTest(){
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			pool.execute(new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"����");
				}
				
			}));
		}
		pool.shutdown();
	}
	
	/**
	 * singleThreadExecutor����
	 */
	public static void singleThreadExecutorTest(){
		// ����һ�������ù̶��߳������̳߳�(�̳߳�ֻ��һ���߳�)
		ExecutorService pool = Executors.newSingleThreadExecutor();
				
		for(int i=0;i<10;i++){
		
			// ���̷߳�����н���ִ��
			pool.execute(new Thread(new Runnable(){
	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"����");
				}
				
			},"t"+i));
		}
		
		try{
		 Thread.sleep(10000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		pool.shutdown();
	}
	
	/**
	 * newScheduledThreadPool����
	 */
	public static void newScheduledThreadPoolTest(){
		ScheduledExecutorService  pool = Executors.newScheduledThreadPool(10);
		for(int i=0;i<1;i++){
			pool.scheduleAtFixedRate(new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"����");
					System.out.println("=====================================");
				}
				
			},"t"+i),3,10,TimeUnit.SECONDS);
		}
	}
	
	
}

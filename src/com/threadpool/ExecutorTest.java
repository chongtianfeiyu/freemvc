package com.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
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
	 * newFixedThreadPool测试
	 */
	public static void newFixedThreadPoolTest(){
		// 创建固定大小的线程池
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
					System.out.println(Thread.currentThread().getName()+"运行");
					}
				}
				
			},"t"+i));
		}
		
		System.out.println("aa");
		pool.shutdown();
		System.out.println("bb");
	}
	
	/**
	 * newCachedThreadPool测试
	 */
	public static void newCachedThreadPoolTest(){
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			pool.execute(new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"运行");
				}
				
			}));
		}
		pool.shutdown();
	}
	
	/**
	 * singleThreadExecutor测试
	 */
	public static void singleThreadExecutorTest(){
		// 创建一个可重用固定线程数的线程池(线程池只有一个线程)
		ExecutorService pool = Executors.newSingleThreadExecutor();
				
		for(int i=0;i<10;i++){
		
			// 将线程放入池中进行执行
			pool.execute(new Thread(new Runnable(){
	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"运行");
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
	 * newScheduledThreadPool测试
	 */
	public static void newScheduledThreadPoolTest(){
		ScheduledExecutorService  pool = Executors.newScheduledThreadPool(10);
		for(int i=0;i<1;i++){
			pool.scheduleAtFixedRate(new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"运行");
					System.out.println("=====================================");
				}
				
			},"t"+i),3,10,TimeUnit.SECONDS);
		}
	}
	
	
}

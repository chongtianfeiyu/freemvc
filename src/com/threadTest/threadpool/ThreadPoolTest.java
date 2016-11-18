package com.threadTest.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试。
 * corepoolsize大小设置
 * maximumPoolSize大小设置
 * workQueue队列类型的选择
 * @author liaokangli
 *
 */
public class ThreadPoolTest {
	
	public static void main(String[] args){
//		testExecutors();
		long heapSize = Runtime.getRuntime().totalMemory();
		long heapMaxSize = Runtime.getRuntime().maxMemory();
		long heapFreeSize = Runtime.getRuntime().freeMemory();
		long availableProcessors = Runtime.getRuntime().availableProcessors();
//		testThreadPoolExecutor();
		testExecutors();
		new Date().getTime();
	}
	
	/**
	 * 线程池测试.
	 */
	public static void testThreadPoolExecutor(){
		ThreadPoolExecutor te = new ThreadPoolExecutor(2,10000,0,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1));
		for(int i = 0;i<1000;i++){
		    te.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					// 1m size 	
					byte[] bytes = new byte[1024*1024*2];
					long heapSize = Runtime.getRuntime().totalMemory()/(1024*1024);
					long heapMaxSize = Runtime.getRuntime().maxMemory()/(1024*1024);
					long heapFreeSize = Runtime.getRuntime().freeMemory()/(1024*1024);
					long availableProcessors = Runtime.getRuntime().availableProcessors();
					System.out.println(Thread.currentThread().getName()+":heapSize-"+heapSize+"mb"+":heapFreeSize-"+heapFreeSize+"mb"+":availableProcessors"+availableProcessors);
				    long nowtime1 = System.currentTimeMillis();
				    long nowtime2 = System.currentTimeMillis();
					while(nowtime2 - nowtime1 < 4*60*1000){
						nowtime2 = System.currentTimeMillis();
					}
					System.out.println(Thread.currentThread().getName());

					}
		    	
		    });
		}
	}
	
	/**
	 * 线程池
	 */
	public static void testExecutors(){
		ExecutorService pool = Executors.newFixedThreadPool(10);
		for(int i = 0;i<50;i++){
			pool.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+":");
				}
				
			});
		}
	}
	
	

}

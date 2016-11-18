package com.threadTest.locks;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 周期性栅栏
 * @author liaokangli
 *
 */
public class LockCyclicBarrier {
	
	public static void main(String[] args){
//		cyclicBarrierNormal();
//		cyclicBarrierException();
		cyclicBarrierMutip();
	}
	
	
	/**
	 * 周期性栅栏
	 */
	public static void cyclicBarrierNormal(){
		int N = 5;
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(N,new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("所有线程执行完成");
				
			}
			
		});
		for(int i = 0;i < N;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据");
					long startTime = System.currentTimeMillis();
					try {
//						Thread.sleep(50000);
						long currentTime = System.currentTimeMillis();
						while(currentTime - startTime < 10000){
							currentTime = System.currentTimeMillis();
						}
						System.out.println("空执行");
						Thread.sleep(50000);
						System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕,等待其他线程写入完毕");
						cyclicBarrier.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"等待结束完成");
				}
				
			}).start();
		}
		
		
	}
	
	/**
	 * 停止一个阻塞的线程,查看barrier情况.其他线程阻塞在barrier的也会提前离开,并抛出异常
	 */
	public static void cyclicBarrierException(){
		
		int N = 4;
		final CyclicBarrier cylicBarrier = new CyclicBarrier(N);
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("t1开始");
//				long startTime = System.currentTimeMillis();
//				long currentTime = System.currentTimeMillis();
//				while(currentTime - startTime < 100000){
//					
//				}
				try {
					cylicBarrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t1结束");
			}
			
		});
		
		final Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("t2开始");
				
				try {
					cylicBarrier.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				System.out.println("t2结束");
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("t3开始");
				long startTime = System.currentTimeMillis();
				long currentTime = System.currentTimeMillis();
				while(currentTime - startTime < 1000){
					currentTime = System.currentTimeMillis();
				}
				try {
//					cylicBarrier.await();
					t2.interrupt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t3结束");
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	
	/**
	 * barrier.await()多次。
	 */
	public static void cyclicBarrierMutip(){
		
		final int N = 5;
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(N+2);
		for(int i = 0;i <= N;i++){
			final int count = i;
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(count >=5){
						int aa = 1;
					}
					try {
						cyclicBarrier.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}).start();
		}
		
	   try{
		cyclicBarrier.await();
		System.out.println("主线程完成1");
		cyclicBarrier.await();
		System.out.println("主线程完成2");
	   }catch(Exception e){
		   e.printStackTrace();
	   }
		
	}
	
	
	

}

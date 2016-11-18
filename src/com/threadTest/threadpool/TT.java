package com.threadTest.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testExecutors();
	}

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

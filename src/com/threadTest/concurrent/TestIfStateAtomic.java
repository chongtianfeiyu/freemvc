package com.threadTest.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试if语句是否是原子性
 * @author liaokangli
 *
 */
public class TestIfStateAtomic {
	
	
	public static void main(String[] args){
		testAtomic();
	}
	
	public static void testAtomic(){
		final AtomicInteger ai = new AtomicInteger(0);
		final int count = 100;
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean flag = true;
				while(flag){
					if(ai.get() == count){
						flag = false;
						System.out.println("tt");
					}
					
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					ai.getAndIncrement();
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}

}

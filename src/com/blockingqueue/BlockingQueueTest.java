package com.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列测试
 * @author liaokangli
 *
 */
public class BlockingQueueTest {

	
	public static void main(String[] args) throws InterruptedException{
		testLinkedBlockingQueue();
		
	}
	
	public static void testLinkedBlockingQueue(){
		final BlockingQueue blockQueue = new LinkedBlockingQueue(1);
		final Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
//				  while(true){
					
					System.out.println("查如");
					blockQueue.offer("bb");
//				  }
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("中断rd");
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				System.out.println("取出");
                while(true){
                	try {
						System.out.println("取出"+blockQueue.poll(10000, TimeUnit.MILLISECONDS));
						System.out.println("后续");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	public static void testSynchronousQueue(){
		final BlockingQueue block = new SynchronousQueue();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  while(true){
				System.out.println("t1:"+block.offer("dd"));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("dd");
			  }
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  while(true){
				try {
					System.out.println(block.poll(6000000,TimeUnit.NANOSECONDS));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			}
			
		});
		t1.start();
		t2.start();
	}
}

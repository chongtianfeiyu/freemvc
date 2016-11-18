/**
 * 19lou.com
 */
package com.threadTest;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.DelayQueue;

/**
 * @author liaokangli
 *
 */
public class CopyOfThreadTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		DelayQueue dq = new DelayQueue();
		
		// TODO Auto-generated method stub
//		final ThreadLocal<ThreadTest.Counter> counter = new ThreadLocal<ThreadTest.Counter>();
		final CopyOfThreadTest.Counter counter1 = new CopyOfThreadTest().new Counter();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			synchronized(counter1){	
			  for(int i=0;i<10;i++){
//				if(counter.get() == null){
//				  counter.set(new ThreadTest().new Counter());
//				}
//				ThreadTest.Counter counter1 = counter.get();
//			    synchronized(counter1){	
//				  counter1.increment();
//				  System.out.println(Thread.currentThread().getName()+"dddd");
//			    }
			    
				  counter1.increment();
				try {
					System.out.println(Thread.currentThread().getName()+"aa寮�");
				   while(counter1.c < 3){
					System.out.println(Thread.currentThread().getName()+"绛夊緟");
					counter1.wait(1000);
				   }
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				counter1.notifyAll();
//				Thread.yield();
//				
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				System.out.println(Thread.currentThread().getName()+":"+counter1.value());
			  }
			  }
			}
//			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public  void run() {
//				ThreadTest.Counter counter = new ThreadTest().new Counter();
				// TODO Auto-generated method stub
				synchronized(counter1){	
					  for(int i=0;i<10;i++){
//						if(counter.get() == null){
//						  counter.set(new ThreadTest().new Counter());
//						}
//						ThreadTest.Counter counter1 = counter.get();
//					    synchronized(counter1){	
//						  counter1.increment();
//						  System.out.println(Thread.currentThread().getName()+"dddd");
//					    }
					    
						  counter1.increment();
						try {
							System.out.println(Thread.currentThread().getName()+"aa寮�");
						   while(counter1.c < 3){
							   System.out.println(Thread.currentThread().getName()+"绛夊緟");
							counter1.wait(1000);
						   }
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//						counter1.notifyAll();
//						Thread.yield();
//						
//						try {
//							Thread.sleep(100);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						System.out.println(Thread.currentThread().getName()+":"+counter1.value());
					  }
					  }
					}
//					}
		});

		t1.start();
		t2.start();
//		t2.join();
//		t1.join();
		System.out.println(Thread.currentThread().getName()+"缁撴潫");
		
	}

	 class Counter{
		private    int c = 0;
	    
		public   void increment(){
//			Thread.yield();
			System.out.println(Thread.currentThread().getName()+"c++鑾峰緱閿�");
			c++;

//				try {
//					Counter.class.wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			System.out.println(Thread.currentThread().getName()+"c++鎵ц:"+c);
		   
		}
		
		public   void decrement(){
			System.out.println(Thread.currentThread().getName()+"c--鑾峰緱閿�");
			c--;
//			Counter.class.notifyAll();
			System.out.println(Thread.currentThread().getName()+"c--鎵ц:"+c);
		  
		}
		
		public  int value(){
//			System.out.println(Thread.currentThread().getName()+"value鑾峰緱閿�锛�+this+":"+c);
			return c;
		}
		
		public void setValue(int c){
			this.c = c;
//		    System.out.println(Thread.currentThread().getName()+"set鑾峰緱閿�锛�+this+":"+c);
		}
	}

}

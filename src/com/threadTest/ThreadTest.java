/**
 * 19lou.com
 */
package com.threadTest;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author liaokangli
 *
 */
public class ThreadTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		testThreadBasi();
//		testThreadState();
//		testSleep();
//		testWait();
//		testYieldLock();
//		testYield();
//		testJoin();
//		testJoinItSelf();
		testNotify();
//		testJoininterrupt();
		
	}
	

	
	
	/**
	 * 测试thread基本知识.优先级测试
	 * @throws FileNotFoundException 
	 */
	public static void testThreadBasi() throws Exception{
		final ThreadTest.Counter counter1 = new ThreadTest().new Counter();
		
		
		for(int i=0;i<100;i++){
			final BufferedWriter bos = new BufferedWriter(new FileWriter("g:\\testlog\\log"+i+".log"));
			Thread t1 = new Thread(new Runnable() {
				
					@Override
					public void run() {
						// TODO Auto-generated method stub
					  while(true){			    
//						counter1.increment();
		            	try {
							bos.write(Thread.currentThread().getName()+":"+counter1.value()+":"+Thread.currentThread().getPriority());
						    bos.newLine();
		            	} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  }
					  
				   }
				  
	
			},"t"+i);
			if(i==10||i==50||i==25){
			 t1.setPriority(Thread.MAX_PRIORITY);
			}
			t1.start();
		}
		

		
		System.out.println(Thread.currentThread().getName()+"结束");
	}
	
	/**
	 * 测试thread状态
	 */
	public static void testThreadState(){
		
		final Object object = new Object();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					
				}
			}
			
		});
		
		// new state
		System.out.println("new state:"+t1.getState());
		
		t1.start();
		
		// runnable state
	    System.out.println("new state:"+t1.getState());
		
	    // time_waiting
	    Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	    	
	    });
	    
	    // waiting state
	    Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					try {
						object.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	    	
	    });
	    
	    Thread t4 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					while(true){
//						System.out.println("tt");
					}
				}
			}
	    	
	    });
	    
	    t2.start();
	    t3.start();
	    t4.start();
	    System.out.println("new state:"+t3.getState());
	    System.out.println("new state:"+t2.getState());
	    System.out.println("new state:"+t4.getState());
	    
	}
	
	/**
	 * 不释放锁
	 */
	public static void testSleep(){
		
		final Object object = new Object();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			 synchronized(object){
				while(true){
					try {
						System.out.println(Thread.currentThread().getName()+":tt");
						Thread.sleep(10000);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			 }
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					while(true){
						try {
							System.out.println(Thread.currentThread().getName()+":tt1");
							Thread.sleep(10000);
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				 }
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 释放锁
	 */
	public static void testWait(){
        final Object object = new Object();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			 synchronized(object){
				while(true){
					try {
						System.out.println("tt");
						object.wait(1000000);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			 }
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  synchronized(object){ 
				while(true){
					try {
						System.out.println("tt1");
						object.notify();
						Thread.sleep(10000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			  }
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 测试yield,不释放锁
	 */
	public static void testYieldLock(){
		final Object object = new Object();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					System.out.println("tt");
					Thread.yield();
					while(true){
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
				  while(true){
					System.out.println("tt2");
				  }
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		
		
	}
	
	/**
	 * 测试yield使用,cpu还可能会选择刚刚那个线程
	 */
	public static void testYield(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("tt");
				Thread.yield();
				System.out.println("tt1");
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("tt2");
				System.out.println("tt21");
			}
			
		});
		
		t1.start();
		t2.start();
		
	}
	
	/**
	 * 测试join。主线程等待其他线程执行完后，主线程再执行
	 */
	public static void testJoin(){
		
		final Counter counter = new ThreadTest().new Counter();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(counter){
					counter.increment();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(counter){
					counter.increment();
				}
			}
			
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		counter.increment();
		System.out.println("result:"+counter.value());
		
	}
	
	/**
	 * 测试join。自己join自己.因为join里面是wait,导致当前线程会无限制的等待下去，死锁一样
	 */
	public static void testJoinItSelf(){
		
		final Counter counter = new ThreadTest().new Counter();
		
		 Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					counter.increment();
					Thread.currentThread().join();
					System.out.println("tt");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    counter.increment();
				
			}
			
		});
		
		t1.start();
		System.out.println("result:"+counter.value());
		
	}
	
	/**
	 * join的线程被中断
	 */
	public static void testJoininterrupt(){
        final Counter counter = new ThreadTest().new Counter();
		
		final Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(counter){
					counter.increment();
					try {
						counter.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			}
			
		});
		
		final Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(counter){
					counter.increment();
					try {
						Thread.sleep(100000);
						counter.increment();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		// 中断t2线程，t4执行
		final Thread t4 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(counter){
					counter.increment();
					try {
						t2.join();
						System.out.println("tt");
						counter.increment();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		/**
		 * 中断线程
		 */
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					t1.interrupt();
					t2.interrupt();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		t1.start();
		t2.start();
		t4.start();
		t3.start();
		
		
		
		counter.increment();
		System.out.println("result:"+counter.value());
	}
	
	
	
	/**
	 * 测试notify。对哪种线程notify是有效的,对sleep是无效的，因为sleep是占用锁的,而notify要获得锁，两者矛盾
	 * 
	 */
	public static void testNotify(){
		
		final Object object = new Object();
		
//		// sleep线程
//		Thread t1 = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//
//				System.out.println("t11");
//				try {
//					Thread.sleep(100000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					System.out.println("t1:"+e.getMessage());
//				}
//				
//				System.out.println("t12");
//			  
//			}
//			
//		},"t1");
//		
//		
//		
//		// join线程	
//		final Thread t4 = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
////				synchronized(object){
//					System.out.println("t41");
//					while(true){
//						
//					}
////					System.out.println("t42");
////				}
//			}
//			
//		},"t4");
//		
//		final Thread t3 = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					System.out.println("30");
//					t4.join();
//					
//					System.out.println("31");
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		},"t3");
//		
		// wait线程
		Thread t2 = new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
					synchronized(object){
						System.out.println("t21");
						
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println("t22");
					 }
					}
					
				},"t2");
		
		// notifyall线程
		Thread t5 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("");
			  synchronized(object){
				try {
					System.out.println("t51");

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t52");
				object.notifyAll();
			  }
			}
			
		},"t5");
			
		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		t5.start();
		
		
		
		
	}
	
	
	
	
	/**
	 * 测试Runtime
	 */
	public static void testRuntime(){
		Runtime current = Runtime.getRuntime();
		current.exit(0);
		System.out.println("end.");
	}

	  class Counter{
		private    int c = 0;
	    
		public   void increment(){
			System.out.println(Thread.currentThread().getName()+"c++获得锁:");
			c++;


			System.out.println(Thread.currentThread().getName()+"c++执行:"+c);
		   
		}
		
		public   void decrement(){
			System.out.println(Thread.currentThread().getName()+"c--获得锁:");
			c--;
			System.out.println(Thread.currentThread().getName()+"c--执行:"+c);
		  
		}
		
		public  int value(){
			return c;
		}
		
		public void setValue(int c){
			this.c = c;
		}
	}

}

/**
 * 19lou.com
 */
package com.threadTest;

/**
 * @author liaokangli
 *
 */
public class ThreadBaseTest {
        public static void main(String[] args) throws InterruptedException {
        	System.out.println("ddddd");
			final Object object = new Object();
			Thread t1 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
//					 synchronized (object) {
						   try {
							System.out.println(Thread.currentThread().getName()+":"+Thread.holdsLock(object)+":"+Thread.currentThread().getState());
							Thread.sleep(10000);
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						   System.out.println("lkl");
//					 }
				}
			});
			Thread t2 = new Thread(new Runnable() {
			  
				@Override
				public void run() {
					// TODO Auto-generated method stub
//				   synchronized (object) {
					   System.out.println("aaa");
//				   }
					
				}
			});
//			t1.setPriority(10);
//			t2.setPriority(1);
			System.out.println(t1.getPriority()+":"+t2.getPriority()+":"+Thread.currentThread().getPriority());
			t1.start();
//			t1.join(100000);
			t2.start();
//			t1.interrupt();
			System.out.println("ddddd3445");
		}
}

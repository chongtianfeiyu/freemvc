package com.threadTest.locks;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 * @author liaokangli
 *
 */
public class LockLockSupport {

	public static void main(String[] args){
//		lockSupportNormal();
		lockSupportOrder();
	}
	
	public static void lockSupportNormal(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				LockSupport.park();
				System.out.println(Thread.currentThread().getName());
				LockSupport.park();
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}
			
		});
		
//		Thread t2 = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				LockSupport.park();
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName());
//			}
//			
//		});
		
		try {
			t1.start();
//			t2.start();
			Thread.sleep(1000);
			LockSupport.unpark(t1);
			LockSupport.unpark(t1);
			System.out.println(Thread.currentThread().getName());
//			LockSupport.unpark(t2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	/**
	 * 先unpark。再park。线程不阻塞。一个unpark等待一个park之后，可以重新给线程分配unpark
	 * 可以理解为unpark其实是构建一个map,key为线程，value为许可。当park后，消耗这个key,变成，value为null
	 * 所以unpark多次也是一个许可
	 */
	public static void lockSupportOrder(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+"开始");
				// 执行两次unpark也是获取一个许可。最终还是阻塞。
				LockSupport.unpark(Thread.currentThread());
				LockSupport.unpark(Thread.currentThread());
				System.out.println(Thread.currentThread().getName()+"结束");
				LockSupport.park();
				System.out.println(Thread.currentThread().getName()+"结束2");
				LockSupport.park();
				System.out.println(Thread.currentThread().getName()+"结束3");
			}
			
		});
		t1.start();
	}
}

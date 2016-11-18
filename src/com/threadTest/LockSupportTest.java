package com.threadTest;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * locksupport����.���н�����Կ�����LockSupport�ǿ����������ض��̣߳������ض��̣߳���wait()��notify�����ѡ���߳�;
 * ����Ӧ�жϣ����׳��ж��쳣
 * @author liaokangli
 *
 */
public class LockSupportTest {

	private final AtomicBoolean locked = new AtomicBoolean();
	private Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();
	
	public static void main(String[] args){
		  final Thread main = Thread.currentThread();
		  		  
		  Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("t1 run");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LockSupport.unpark(main);
			}
			  
		  });
		  
		  Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("t2 run");
				LockSupport.park();
				
				System.out.println("t2 run end");
			}
			  
		  });
		  t1.start();
		  t2.start();
		
		  LockSupport.park();
		  System.out.println(".block and sleep 10s");
		  
		  try {
			Thread.sleep(10000);
			t2.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	
	public void lock(){
		boolean wasInterrupted = false;
		Thread current = Thread.currentThread();
		waiters.add(current);
		
		while(waiters.peek() != current || !locked.compareAndSet(false, true)){
			LockSupport.park(this);
			if(Thread.interrupted()){
				wasInterrupted = true;
			}
			
			waiters.remove();
			if(wasInterrupted)
				current.interrupt();
		}
	}
	
	public void unlock(){
		locked.set(false);
		LockSupport.unpark(waiters.peek());
	}
}

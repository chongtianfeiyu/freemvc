package com.threadTest;

/**
 * ∂ÓÕ‚≤‚ ‘notifyall,wait()
 * @author liaokangli
 *
 */
public class ThreadTestOther {

	public static void main(String[] args){
	    final Object object = new Object();
	    
	    new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					
					try {
						System.out.println(Thread.currentThread().getName()+":1");
						object.notifyAll();
						System.out.println(Thread.currentThread().getName()+":2");
						object.wait();
						System.out.println(Thread.currentThread().getName()+":3");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	    	
	    }).start();
	    
	    new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					
					try {
						System.out.println(Thread.currentThread().getName()+":1");
						object.notifyAll();
						System.out.println(Thread.currentThread().getName()+":2");
						object.wait();
						System.out.println(Thread.currentThread().getName()+":3");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	    	
	    }).start();
	    
	}
	
}

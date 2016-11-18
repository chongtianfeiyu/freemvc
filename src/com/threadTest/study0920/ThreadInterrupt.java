package com.threadTest.study0920;

/**
 * study thread interrupt
 * @author liaokangli
 *
 */
public class ThreadInterrupt {
	
	public static void main(String[] args){
//		interruptRunningThread();
		interruptBlockThread();
	}
	
	/**
	 * 中断运行的线程，这个线程不是处于阻塞状态
	 */
	public static void interruptRunningThread(){
		
		
		
	    Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("tt1");
				long startTime = System.currentTimeMillis();
				long currentTime = System.currentTimeMillis();
				while(currentTime - startTime < 100000){
					currentTime = System.currentTimeMillis();
				}
				System.out.println("tt2");
			}
	    	
	    });
	    
	    t2.start();
		
	    System.out.println("tt01");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tt02");
		
		t2.interrupt();
		
		System.out.println("tt03");
		
	}
	
	/**
	 * 中断运行的线程，这个线程是处于阻塞状态
	 */
	public static void interruptBlockThread(){
		
		
		
	    Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("tt1");
//				long startTime = System.currentTimeMillis();
//				long currentTime = System.currentTimeMillis();
//				while(currentTime - startTime < 100000){
//					currentTime = System.currentTimeMillis();
//				}
				try {
					Thread.sleep(100000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("tt2");
			}
	    	
	    });
	    
	    t2.start();
		
	    System.out.println("tt01");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tt02");
		
		t2.interrupt();
		
		System.out.println("tt03");
		
	}

}

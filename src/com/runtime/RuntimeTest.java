package com.runtime;

/**
 * 学习Runtime
 * @author liaokangli
 *
 */
public class RuntimeTest {
	
	public static void main(String[] args){
		testaddShutdownHook();
	}
	
	/**
	 * 测试addShutdownHook
	 * 例子:jvm在只有守护线程存在的时候，将退出
	 */
	public static void testaddShutdownHook(){
		Thread t1 = new Thread(){
			public void run(){
				try {
					Thread.sleep(10000);
					System.out.println("t1");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		t1.setDaemon(true);
		
		Thread t2 = new Thread(){
			public void run(){
				try {
					Thread.sleep(100);
					System.out.println("t2");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
		Runtime.getRuntime().addShutdownHook(new Thread(){
		     public void run(){
		    	 System.out.println("退出jvm");
		     }
		});
	}

}

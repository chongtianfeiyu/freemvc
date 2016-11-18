package com.jvmTest;

/**
 * jvm简单测试
 * @author liaokangli
 *
 */
public class JvmTest {
	
	public static void main(String[] args) throws InterruptedException{
		testReference();
	}
	
	/**
	 * 测试引用.虽然设置为null,还是没有被回收，因为被Threadgroup强引用
	 * @throws InterruptedException 
	 */
	public static void testReference() throws InterruptedException{

//		for(int i = 0;i<1000;i++){
			Thread t = new Thread(Thread.currentThread().getThreadGroup(),new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};
			
			});
			Thread t1 = new Thread(Thread.currentThread().getThreadGroup(),new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			t.start();
			t1.start();
			
			
//		}
		t=null;
		System.gc();
		Thread.sleep(5000);
		ThreadGroup tg = Thread.currentThread().getThreadGroup();
        tg.list();
		System.out.println("tt");
		
	}

}

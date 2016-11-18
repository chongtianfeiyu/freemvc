package com.threadTest;

/**
 * ����waitʱ��<=10000.����notify��ʱ��waitʱ�����t2��ʱ��
 * @author liaokangli
 *
 */
public class SynchronizedWaitTest {
   
	public static void main(String[] args){
		final Object object = new Object();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					System.out.println("t1��ȡ�����ȴ�");
					try {
						object.wait(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(object){
					System.out.println("t2��ȡ�����ȴ�");
					try {
						object.notify();
					} catch (Exception e) {
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

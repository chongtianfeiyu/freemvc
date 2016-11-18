package com.threadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ��������
 * 1���������������̵߳ȴ�һ���ⲿ�¼��������ӵȴ����̣߳��ķ���
 * һ��ͬ�������������ӳ��̵߳Ľ���ֱ���̵߳���ĳ���յ�״̬��ͨ�׵Ľ����ǣ�һ�������൱��һ�ȴ��ţ�
 * �ڴ��Ŵ�֮ǰ�����̶߳�����ϣ�һ�����Ŵ������̶߳���ͨ��������һ�����Ŵ򿪣������̶߳�ͨ���ˣ���ô���������״̬��ʧЧ�ˣ��ŵ�״̬Ҳ�Ͳ��ܱ��ˣ�
 * ֻ���Ǵ�״̬��Ҳ����˵������״̬��һ���Եģ���ȷ���ڱ�����֮ǰ�����ض��Ļ����Ҫ�ڱ�����֮�������ɡ�
 * 
 * 2��ԭ��ά��һ��count.��count>0ʱ������await()�������߳̽���������count=0ʱ���������򿪣������������߳̽�ͨ��������ʼִ��
 *          ����countDown()ʱ��count��һ
 * 
 * 3�����ܱ����̼߳䷢�������ݹ������⡣���ݿ��ܻ᲻һ��
 * @author liaokangli
 *
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException{
		
		testSimpleUsage();
//		testTypicalUsage();
		
	}
	
	/**
	 * Ӧ�ó���һ����
	 * һ�鹤���߳�ʹ������������
	 * startSignal������10���߳�ͬʱ��ʼִ��
	 * douneSignal�������ȴ�10���߳����
	 * 
	 * @throws InterruptedException
	 */
	public static void testSimpleUsage() throws InterruptedException{
		// ��10���߳�ͬʱ��ʼִ��
		CountDownLatch startSignal = new CountDownLatch(1);
		// �ȴ�10���߳�ִ�����
		CountDownLatch douneSignal = new CountDownLatch(10);
		
		for(int i=0;i<10;i++){
			new Thread(new Worker(startSignal,douneSignal)).start();
		}
		
		Thread.sleep(1000);

		System.out.println("main1");
		// ���̸߳���10���߳�׼�����ˣ����Կ�ʼִ�С�
		// ע�⣺�����������̵߳�����run����������������await()������
		startSignal.countDown();
		System.out.println("main2");
		//���߳� �ȴ�10���߳�ִ�����,��ִ�к�������System.out.println("main3")
		// ע��:����������run����ִ����ɣ����ǵȴ�count==0;���£���run�����е�3�������뵽doneSignal.countDown();���棬
		// ִ�н������main3�Ѿ���ӡ��ϣ���3���ִ�к�ִ��
		douneSignal.await();
		System.out.println("main3");
	}
	
	/**
	 * Ӧ�ó�����:��һ������ֳ�N����,ÿһ���ֶ������У�û��Ҫ��ͬʱִ��)��������������һ.
	 * �������Ӳ���ִ����ɺ�,���߳�ͨ���ȴ�
	 * 
	 * ����ˣ��������������..�������û���С�
	 * �涨�����ֻҪ���ܵ��յ��ˣ���ҿ��Ժ�ơ�ơ�
	 * ���ǣ�ֻҪ��һ����û���յ㣬�Ͳ��ܺȡ� ����Ҳû��Ҫ����Ҫͬʱ����(��ȻҲ���ԣ���latch)��
	 * Ҳ����ʹ��դ��ʵ��
	 * @throws InterruptedException 
	 * 
	 */
	public static void testTypicalUsage() throws InterruptedException{
		
		CountDownLatch doneSignal = new CountDownLatch(10);
		ExecutorService e = Executors.newFixedThreadPool(5);
		
		for(int i=0;i<10;i++){
			e.execute(new Worker1(doneSignal,i));
			
		}
		
		doneSignal.await();
		
		System.out.println("���߳�ͨ���ȴ�");
		
	}
	
	public static class Worker1 implements Runnable{
        
		private final CountDownLatch doneSignal;
		private final int i;
		
		public Worker1(CountDownLatch doneSignal,int i){
			this.doneSignal = doneSignal;
			this.i = i;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+":"+i);
			doneSignal.countDown();
			System.out.println(Thread.currentThread().getName()+"����");
		}
		
	}
	
	public static class Worker implements Runnable{
		
		private final CountDownLatch startSignal;
		
		private final CountDownLatch doneSignal;
		
		public Worker(CountDownLatch startSignal,CountDownLatch doneSignal){
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				// 1
				System.out.println(Thread.currentThread().getName());
				startSignal.await();
				Thread.currentThread().join();
				// 2
				System.out.println(Thread.currentThread().getName()+"��ʼ");
				doneSignal.countDown();
				// 3
				System.out.println(Thread.currentThread().getName()+"����");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}

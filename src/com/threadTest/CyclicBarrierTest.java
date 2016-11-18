package com.threadTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * դ������
 * ����N���߳��໥�ȴ�,һ���̵߳ȴ���ĳ��״̬֮����ȫ��ͬʱִ��
 * դ������ʹһ��ִ����һ���㼯��Ҳ����˵���ǿ�����դ����һ������ֽ�ɶ�������������⣬����ִ�н�������ͬһ�����л㼯��
���̵߳���㼯�غ����await��await�������������ֱ�������߳�Ҳ����㼯�ء�
������е��̶߳�����Ϳ���ͨ��դ����Ҳ�������е��̵߳õ��ͷţ�����դ��Ҳ���Ա���������
3�����ܱ����̼߳䷢�������ݹ������⡣���ݿ��ܻ᲻һ��
 * @author liaokangli
 *
 */
public class CyclicBarrierTest {
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException{
		testUsage1();
	}
	
	/**
	 * ���ɸ��̶߳�Ҫ����д���ݲ�����
	 * ����ֻ�������̶߳����д���ݲ���֮����Щ�̲߳��ܼ�������������飬��ʱ�Ϳ�������CyclicBarrier��
	 * @throws BrokenBarrierException 
	 * @throws InterruptedException 
	 */
	public static void testUsage1() throws InterruptedException, BrokenBarrierException{
		int N = 4;
		CyclicBarrier barrier = new CyclicBarrier(N);
		for(int i =0;i<N;i++){
			new Write(barrier).start();
		}
		
//		barrier.await();
//		System.out.println("���߳�ִ��");
	}
	
	public static class Write extends Thread{
		private CyclicBarrier cyclicBarrier;
		public Write(CyclicBarrier cyclicBarrier){
			this.cyclicBarrier = cyclicBarrier;
		}
		
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName()+"����д������");
			try{
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName()+"д���������,�ȴ������߳�д�����");
				cyclicBarrier.await();
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"�����߳�д��������ϣ�ִ������������....");
			System.out.println(Thread.currentThread().getName()+"�����߳�д��������ϣ�ִ������������11....");
		}
	}

}

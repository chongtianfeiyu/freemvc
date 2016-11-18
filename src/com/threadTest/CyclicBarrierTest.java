package com.threadTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 栅栏测试
 * 允许N个线程相互等待,一组线程等待至某个状态之后再全部同时执行
 * 栅栏可以使一组执行在一处汇集，也就是说我们可以用栅栏将一个问题分解成多个独立的子问题，并在执行结束后在同一处进行汇集。
当线程到达汇集地后调用await，await方法会出现阻塞直至其他线程也到达汇集地。
如果所有的线程都到达就可以通过栅栏，也就是所有的线程得到释放，而且栅栏也可以被重新利用
3、不能避免线程间发生的数据共享问题。数据可能会不一致
 * @author liaokangli
 *
 */
public class CyclicBarrierTest {
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException{
		testUsage1();
	}
	
	/**
	 * 若干个线程都要进行写数据操作，
	 * 并且只有所有线程都完成写数据操作之后，这些线程才能继续做后面的事情，此时就可以利用CyclicBarrier了
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
//		System.out.println("主线程执行");
	}
	
	public static class Write extends Thread{
		private CyclicBarrier cyclicBarrier;
		public Write(CyclicBarrier cyclicBarrier){
			this.cyclicBarrier = cyclicBarrier;
		}
		
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName()+"正在写入数据");
			try{
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName()+"写入数据完毕,等待其他线程写入完毕");
				cyclicBarrier.await();
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"所有线程写入数据完毕，执行其他的任务....");
			System.out.println(Thread.currentThread().getName()+"所有线程写入数据完毕，执行其他的任务11....");
		}
	}

}

package com.threadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 闭锁测试
 * 1、闭锁用于所有线程等待一个外部事件（此例子等待主线程）的发生
 * 一种同步方法，可以延迟线程的进度直到线程到达某个终点状态。通俗的讲就是，一个闭锁相当于一扇大门，
 * 在大门打开之前所有线程都被阻断，一旦大门打开所有线程都将通过，但是一旦大门打开，所有线程都通过了，那么这个闭锁的状态就失效了，门的状态也就不能变了，
 * 只能是打开状态。也就是说闭锁的状态是一次性的，它确保在闭锁打开之前所有特定的活动都需要在闭锁打开之后才能完成。
 * 
 * 2、原理：维持一个count.当count>0时，调用await()方法的线程将阻塞，当count=0时，闭锁将打开，所有阻塞的线程将通过闭锁开始执行
 *          调用countDown()时，count减一
 * 
 * 3、不能避免线程间发生的数据共享问题。数据可能会不一致
 * @author liaokangli
 *
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException{
		
		testSimpleUsage();
//		testTypicalUsage();
		
	}
	
	/**
	 * 应用场景一测试
	 * 一组工作线程使用两个闭锁。
	 * startSignal闭锁：10个线程同时开始执行
	 * douneSignal闭锁：等待10个线程完成
	 * 
	 * @throws InterruptedException
	 */
	public static void testSimpleUsage() throws InterruptedException{
		// 让10个线程同时开始执行
		CountDownLatch startSignal = new CountDownLatch(1);
		// 等待10个线程执行完成
		CountDownLatch douneSignal = new CountDownLatch(10);
		
		for(int i=0;i<10;i++){
			new Thread(new Worker(startSignal,douneSignal)).start();
		}
		
		Thread.sleep(1000);

		System.out.println("main1");
		// 主线程告诉10个线程准备好了，可以开始执行。
		// 注意：并不是阻塞线程的整个run方法，而是阻塞到await()方法处
		startSignal.countDown();
		System.out.println("main2");
		//主线程 等待10个线程执行完成,再执行后面的语句System.out.println("main3")
		// 注意:并不是整个run方法执行完成，而是等待count==0;如下：将run方法中的3处语句加入到doneSignal.countDown();后面，
		// 执行结果将是main3已经打印完毕，而3语句执行后执行
		douneSignal.await();
		System.out.println("main3");
	}
	
	/**
	 * 应用场景二:将一个问题分成N部分,每一部分都可运行（没有要求同时执行)及闭锁计数器减一.
	 * 当所有子部分执行完成后,主线程通过等待
	 * 
	 * 五个人（这五个人真无聊..），这次没裁判。
	 * 规定五个人只要都跑到终点了，大家可以喝啤酒。
	 * 但是，只要有一个人没到终点，就不能喝。 这里也没有要求大家要同时起跑(当然也可以，加latch)。
	 * 也可以使用栅栏实现
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
		
		System.out.println("主线程通过等待");
		
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
			System.out.println(Thread.currentThread().getName()+"结束");
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
				System.out.println(Thread.currentThread().getName()+"开始");
				doneSignal.countDown();
				// 3
				System.out.println(Thread.currentThread().getName()+"结束");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}

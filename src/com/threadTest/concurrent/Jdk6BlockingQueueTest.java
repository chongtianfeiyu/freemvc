package com.threadTest.concurrent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * jdk6 队列
 * @author liaokangli
 *
 */
public class Jdk6BlockingQueueTest {
	
	public static void main(String[] args) throws Exception{

		long heapSize = Runtime.getRuntime().totalMemory();
		long heapMaxSize = Runtime.getRuntime().maxMemory();
		long heapFreeSize = Runtime.getRuntime().freeMemory();
		long availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(heapSize+":"+heapMaxSize+":"+heapFreeSize);
//		testArrayBlockingQueue();
//		testArrayBlockingQueueNo();
//		testBlockQueuePerformance();
//		testSynchronousQueue();
//		testPriorityBlockingQueue();
		
//		testLinkedBlockingQueue();
//		testConcurrentLinkedQueue();
		
//		testPriorityQueue();
		
		testDelayQueue();
		
		
	}
	
	/**
	 * 测试队列性能，此处对比ArrayBlockingQueue和LinkedBlockingQueue
	 * @throws Exception 
	 */
	public static void testBlockQueuePerformance() throws Exception{
		int qsize = 100;
		BlockQueueTest bqt1 = new BlockQueueTest(new ArrayBlockingQueue<String>(qsize),qsize);
		BlockQueueTest bqt2 = new BlockQueueTest(new LinkedBlockingQueue<String>(qsize),qsize);
		bqt1.test();
		bqt2.test();
	}
	
	
	/**
	 * 测试阻塞队列1
	 */
	public static void testArrayBlockingQueueNo(){
		final ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(Integer.MAX_VALUE);
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						abq.put("tt");
//						Thread.sleep(10000000);
					  
					} catch (Exception e) {
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
				while(true){
					try {
						abq.take();
						System.out.println("tt");
						Thread.sleep(100000);
					  
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
	
	/**
	 * 测试数组阻塞队列2
	 */
	public static void testArrayBlockingQueue(){
		final ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10);
		List<Thread> threadList = new ArrayList<Thread>();
		// 生产者
		for(int i = 0;i < 10;i++){
			final int count = i;
			Thread t1 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					abq.offer("tt"+count);
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			threadList.add(t1);
		}
		
		// 消费者
		for(int i = 0;i < 10;i++){
			Thread t1 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					String result = abq.poll();
					System.out.println(Thread.currentThread().getName()+":"+result);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			threadList.add(t1);
		}
		for(int i = 0; i < threadList.size();i++){
			threadList.get(i).start();
		}
	}
	
	/**
	 * 测试链表阻塞队列LinkedBlockingQueue
	 */
	public static void testLinkedBlockingQueue(){
		final LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>(1);
			Thread t1 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					int count = 0;
					while(true){
						try {
							lbq.put("tt"+count);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			});
			
			Thread t3 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					int count = 0;
					while(true){
						try {
							lbq.put("tt"+count);
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
					try {
						lbq.take();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			
			t1.start();
			t2.start();
			t3.start();
		
		
	}
	
	
	/**
	 * 测试SynchronousQueue.一个线程往队列里面放数据；另两个线程从队列里面取数据
	 * 高并发情况下
	 */
	public static void testSynchronousQueue(){
		final SynchronousQueue<String> sq = new SynchronousQueue<String>();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					try {
						sq.offer("tt"+count,2000,TimeUnit.SECONDS);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count++;
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String result="";
					try {
						result = sq.poll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+":"+result);
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
//						Thread.sleep(1000);
						sq.offer("bb", 2000, TimeUnit.SECONDS);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//					System.out.println(Thread.currentThread().getName()+":"+result);
				}
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	/**
	 * 测试PriorityBlockingQueue
	 */
	public static void testPriorityBlockingQueue(){
		final PriorityBlockingQueue<String> pbq = new PriorityBlockingQueue<String>();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					pbq.offer("tt"+count);
					count++;
				}
			}
			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					String result="";
					try {
						result = pbq.take();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+":"+result);
				}
			}
			
		});
		t1.start();
//		t2.start();
	}
	
	
	public static void testConcurrentLinkedQueue(){
		final ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					clq.offer("tt");
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					clq.poll();
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					clq.poll();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
	
	/**
	 * 测试延迟队列
	 */
	public static void testDelayQueue(){
		final DelayQueue<MyDelayed> dq = new DelayQueue<MyDelayed>();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					
					MyDelayed myDelayed = new MyDelayed();
					myDelayed.setItem("tt"+count);
					dq.offer(myDelayed);
					count++;
					try {
						Thread.sleep(1000);
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
				int count = 0;
				while(true){
					MyDelayed myDelayed = new MyDelayed();
					myDelayed.setItem("tt"+count);
					dq.offer(myDelayed);
					count++;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
	}
	
	
	public static void testPriorityQueue(){
		 
	}

	
	
	public static class MyDelayed implements Delayed{
		
		private static final long current_time = System.nanoTime();
		
		private String item;	

		/**
		 * @return the item
		 */
		public String getItem() {
			return item;
		}

		/**
		 * @param item the item to set
		 */
		public void setItem(String item) {
			this.item = item;
		}

		/**
		 * @return the currentTime
		 */
		public static long getCurrentTime() {
			return current_time;
		}

		@Override
		public int compareTo(Delayed o) {
			// TODO Auto-generated method stub
			int result = 0;
			long duration = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
			if(duration > 0){
				result = 1;
			}else{
				result = -1;
			}
			return result;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			// TODO Auto-generated method stub
			long time = System.nanoTime();
			return unit.convert(time-current_time, TimeUnit.NANOSECONDS);
		}
		
	}
	
	
	public static class BlockQueueTest{
		
		
		public BlockingQueue<String> queue;
		
		public int qsize ;
		
				
		public BlockQueueTest(BlockingQueue<String> queue ,int qsize){
			this.queue = queue;
			this.qsize= qsize;
			
		}
		
	    
		public  void test() throws Exception{
			
			int produceSize = qsize * 4;
			int consumeSize = qsize * 8;
			final CountDownLatch cdl = new CountDownLatch(produceSize+consumeSize);
			
			long stime1 = new Date().getTime();
			
			for(int i = 0;i < produceSize;i++){
				new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							queue.put("tt");
							cdl.countDown();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}).start();
			}
			
			for(int i = 0;i < consumeSize;i++){
				new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							String result = queue.take();
							System.out.println(Thread.currentThread().getName()+":"+result);
							cdl.countDown();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}).start();
			}
			cdl.await();
			long etime1 = new Date().getTime();
			
			long diff = (etime1 - stime1);
			System.out.println("======time:"+diff);
		}
		
		
		
		
	}
	
	
	
	

}

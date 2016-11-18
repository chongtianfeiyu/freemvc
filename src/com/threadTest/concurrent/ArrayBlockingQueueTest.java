package com.threadTest.concurrent;

import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Array Blocing queue测试
 * @author liaokangli
 *
 */
public class ArrayBlockingQueueTest {
	
	public static String tt = "";
	public ArrayBlockingQueueTest(String tt1){
		tt = tt1;
	}
	
	public static void main(String[] args){
//		testArrayBlockingQueue();
//		testLinkedBlockingQueue();
//		testLinkedTransferQueue();
//		testPriorityBlockingQueue();
		
//		testConcurrentLinkedQueue();
//		testConcurrentHashMap();
		testCopyOnWriteArrayList();
//		testDelayQueue();

		
		
		
		
	}
	
	
	/**
	 * 测试ArrayBlockingQueue
	 */
	public static void testArrayBlockingQueue(){
		final ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10);
		
		// 生产者线程
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				while(true){
				 try{
					 boolean flag = abq.offer(i+"");
					 System.out.println("========put:"+flag);
				 }catch(Exception e){
					 System.out.println("queue full");
				 }				 
				 i++;
				}
			}
			
		});
		
		// 消费者线程
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						String re = abq.poll();
						System.out.println("==========result:"+re);
					} catch (Exception e) {
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
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				abq.add("tt");
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	/**
	 * 测试LinkedBlockingDeque
	 */
	public static void testLinkedBlockingQueue(){
		final LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>();
		// 生产者线程
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				while(true){
				 try{
					 Thread.sleep(10000);
					 boolean flag = lbq.offer(i+"");
					 
					 System.out.println("========put:"+flag);
				 }catch(Exception e){
					 System.out.println("queue full");
				 }				 
				 i++;
				}
			}
			
		});
		
		// 消费者线程
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String result = lbq.poll();
					System.out.println("t2========take:"+result);
				}
			}
			
		});
		// 消费者线程
		Thread t3 = new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						while(true){
							try {
								Thread.sleep(15000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String result = lbq.poll();
							System.out.println("t3========take:"+result);
						}
					}
					
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	
//	/**
//	 * 测试LinkedTransferQueue
//	 */
//	public static void testLinkedTransferQueue(){
//		final LinkedTransferQueue<String> ltq = new LinkedTransferQueue<String>();
//		
//		Thread t1 = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				int count = 0;
//				while(true){
//					
//					try {
////						Thread.sleep(1000);
//						System.out.println("=====bb start");
//						ltq.transfer(""+count);
//						count++;
//						System.out.println("=====bb:"+count);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}
//			
//		});
//		
//		Thread t2 = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				while(true){
////					String result = ltq.poll();
//					String result="";
//					try {
//						Thread.sleep(10000);
//						result = ltq.take();
//						
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("======result:"+result);
//				}
//			}
//			
//		});
//		t1.start();
//		t2.start();
//	}
//	
	
	/**
	 * 测试PriorityBlockingQueue.优先级队列
	 */
	public static void testPriorityBlockingQueue(){
		final PriorityBlockingQueue<FIFOEntry<String>> tt = new PriorityBlockingQueue<FIFOEntry<String>>(100,new EntryComparator());
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					tt.offer(new FIFOEntry<String>("tt"+count));
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
				while(true){
					try {
						FIFOEntry<String> result = tt.take();
						System.out.println("==========:"+result.getEntry());
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		t1.start();
//		t2.start();
	    
	}
	
	/**
	 * 测试LinkedBlockingDeque。双向链表
	 */
	public static void testLinkedBlockingDeque(){
		final LinkedBlockingDeque<String> lbd = new LinkedBlockingDeque<String>();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub\
			    int count = 0;
				while(true){
					lbd.offer("tt"+count);
					count++;
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					try {
						String result = lbd.take();
						System.out.println("================"+result);
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
	
	
	/**
	 * 测试ConcurrentLinkedQueue.
	 */
	public static void testConcurrentLinkedQueue(){
		final ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
				
					clq.offer("tt"+count);
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
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String result = clq.poll(); 
					System.out.println("============result:"+result);
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					try{
						clq.offer("s3"+count);
						count++;
						
						
					}catch(Exception e){
						
					}
				}
			}
			
		});
		
		t1.start();
		t3.start();
//		t2.start();
		
	}
	
	/**
	 * 并发hashmap
	 */
	public static void testConcurrentHashMap(){
		final ConcurrentHashMap<String,String> chm = new ConcurrentHashMap<String,String>();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					chm.put("tt-"+count, count+"");
					count++;
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					chm.put("bb-"+count, count+"");
					count++;
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					String result = chm.get("tt-"+count);
					System.out.println("result:"+result);
					count++;
				}
			}
			
		});
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	/**
	 * 测试CopyOnWriteArrayList
	 */
	public static void testCopyOnWriteArrayList(){
		
		final CopyOnWriteArrayList cowal = new CopyOnWriteArrayList();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					cowal.add("tt"+count);
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					cowal.add("tt"+count);
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 测试CopyOnWriteArraySet
	 */
	public static void testCopyOnWriteArraySet(){
		final CopyOnWriteArraySet cows = new CopyOnWriteArraySet();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					cows.add("tt"+count);
					count++;
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
//					cows.
				}
			}
			
		});
	}
	
	/**
	 * 延时队列
	 */
	public static void testDelayQueue(){
		final DelayQueue dq = new DelayQueue();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int key = 0;
//				while(true){
					dq.offer(new MyDelay(1464340200000l,"tt-"+key));
					key++;
//					dq.offer(new MyDelay(1464339720000l,"tt-"+key));
//					key++;
//					dq.offer(new MyDelay(1464336120017l,"tt-"+key));
//					key++;
//					dq.offer(new MyDelay(1464336120000l,"tt-"+key));
//					try {
//						Thread.sleep(100000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
//				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						MyDelay delay = (MyDelay) dq.poll();
						if(delay != null){
							System.out.println("-------到期时间："+delay.time+";缓存键值:"+delay.getName());
						}else{
							System.out.println("缓存已失效");
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						Thread.sleep(1000);
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
	
	public 
	
	
	static class MyDelay implements Delayed{
		
		public long time;
		
		public String name;		
		
		public MyDelay(long time,String name){
			this.time = time;
			this.name = name;
		}

		/**
		 * @return the time
		 */
		public long getTime() {
			return time;
		}

		/**
		 * @param time the time to set
		 */
		public void setTime(long time) {
			this.time = time;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Delayed o) {
			// TODO Auto-generated method stub
			if(this.time < ((MyDelay)o).time) return -1;
			else if(this.time > ((MyDelay)o).time ) return 1;
			else return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			// TODO Auto-generated method stub
			long delay = unit.convert(time - System.currentTimeMillis() , TimeUnit.MINUTES);
			return delay;
		}
		
	}
	
	
	static class FIFOEntry<E extends Comparable<? super E>> implements Comparable<FIFOEntry<E>>{
           static String tt = "";
		   static final AtomicLong seq = new AtomicLong(0);
		   final long seqNum;
		   final E entry;
		   public FIFOEntry(E entry) {
		     seqNum = seq.getAndIncrement();
		     this.entry = entry;
		   }
		   public E getEntry() { return entry; }
		   public int compareTo(FIFOEntry<E> other) {
		     
		       int res = (seqNum < other.seqNum ? -1 : 1);
		     return res;
		   }
		
	}
	
	static class EntryComparator implements Comparator<FIFOEntry<String>>{

		@Override
		public int compare(FIFOEntry<String> o1, FIFOEntry<String> o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
		
	}
	
	

}

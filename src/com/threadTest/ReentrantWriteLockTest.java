package com.threadTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写锁
 * @author liaokangli
 *
 */
public class ReentrantWriteLockTest {
	
	 ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock();
	 Lock read = writeLock.readLock();
	 Lock write = writeLock.writeLock();
	
	Map<String,Person> cacheMap = new HashMap<String,Person>();

	public static void main(String[] args){
		
		final ReentrantWriteLockTest.MyWriteRead wr = new ReentrantWriteLockTest().new MyWriteRead();
         
	    for(int i=0;i<10;i++){
			new Thread(new Runnable(){
	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					 wr.writeValue(Thread.currentThread().getName(), new Person("aa","bb"));
//					
				}
				
			},"wt"+i).start();
	    }
		
	   for(int i=0;i<10;i++){
		 new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				for(int i = 0; i < 10;i++){
					
					wr.readValue("wt0");
//				}
			}
			
		},"wr"+i).start();
	   }
		
		
	}
	
	public  class MyWriteRead{
		
	
		public  void writeValue(String key,Person person){
			write.lock();
			try{
				try {
					System.out.println(Thread.currentThread().getName()+"写锁获取");
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				cacheMap.put(key, person);
				
			}finally{
				write.unlock();
			}
		}
		
		public Person readValue(String key){
			read.lock();
			try{
				try {
					System.out.println(Thread.currentThread().getName()+"读锁获取");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return cacheMap.get(key);
			
			}finally{
				read.unlock();
			}
		}
	}
	
	public static  class Person{
		private String name;
		private String age;
		public Person(String name,String age){
			this.name = name;
			this.age = age;
		}
	}
}

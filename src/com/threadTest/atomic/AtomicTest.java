package com.threadTest.atomic;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * atomic test
 * @author liaokangli
 *
 */
public class AtomicTest {

	public static void main(String[] args){
//		testNoAtomicBoolean();
//		testAtomicBoolean();
//		testAtomicInteger();
//		testAtomicIntegerPro();
//		testAtomicIntegerA();
		
		testAtomicStampedReference();
	}
	
	/**
	 * test atomic boolean
	 */
	public static void testNoAtomicBoolean(){
		final Person person = new Person();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			
			  while(true){
				  Date da = new Date();

				 if(!person.isFlag()){
				  System.out.println(da+":tt:"+Thread.currentThread().getName()+":"+person.isFlag());
				  person.setFlag(true);
				 }
			  }
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  while(true){
				  Date da = new Date();

				 if(person.isFlag()){
				  System.out.println(da+":tt:"+Thread.currentThread().getName()+":"+person.isFlag());
				  person.setFlag(false);
				 }
			  }
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  while(true){
				  Date da = new Date();

				 if(person.isFlag()){
				  System.out.println(da+":tt:"+Thread.currentThread().getName()+":"+person.isFlag());
				  person.setFlag(false);
				 }
			  }
			}
			
		}).start();
		

	}
	
	/**
	 * test atomic boolean
	 */
	public static void testAtomicBoolean(){
		final Person person = new Person();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			
			  while(true){
//				  Date da = new Date();

//				 if(!person.getAtomicBoolean().getAndSet(true)){
//				  System.out.println(da+":tt:"+Thread.currentThread().getName()+":"+person.isFlag());
//				 }
				 if(person.getAtomicBoolean().compareAndSet(false, true)){
					 System.out.println(Thread.currentThread().getName()+":"+person.getAtomicBoolean().get());
				 }
			  }
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  while(true){
//				  Date da = new Date();

//				 if(person.getAtomicBoolean().getAndSet(false)){
//				  System.out.println(da+":tt:"+Thread.currentThread().getName()+":"+person.isFlag());
//				 }
				 if(person.getAtomicBoolean().compareAndSet(true, false)){
					 System.out.println(Thread.currentThread().getName()+":"+person.getAtomicBoolean().get());
				 }
			  }
			}
			
		}).start();
		
	}
	
	
	/**
	 * test atomic integer.
	 */
	public static void testAtomicInteger(){
		
		final Person person = new Person();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  while(true){
				System.out.println(new Date()+":"+Thread.currentThread().getName()+":"+person.getAtomicInteger().getAndIncrement());
			  }
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			   while(true){
				System.out.println(new Date()+":"+Thread.currentThread().getName()+":"+person.getAtomicInteger().getAndIncrement());
			   }
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 原子操作问题 模拟aba问题
	 */
	public static void testAtomicIntegerPro(){
        final Person person = new Person();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				boolean flag = person.getAtomicInteger().compareAndSet(0, 1);		
				
				System.out.println(Thread.currentThread().getName()+":"+ person.getAtomicInteger().get());
			  
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				boolean flag = person.getAtomicInteger().compareAndSet(0, 1);
				System.out.println(Thread.currentThread().getName()+":"+ person.getAtomicInteger().get());
				flag = person.getAtomicInteger().compareAndSet(1, 2);
				System.out.println(Thread.currentThread().getName()+":"+ person.getAtomicInteger().get());
				flag = person.getAtomicInteger().compareAndSet(2, 0);
				System.out.println(Thread.currentThread().getName()+":"+ person.getAtomicInteger().get());
			   
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 增1操作原子性，不能保证数据按顺序，但是是唯一的
	 */
	public static void testAtomicIntegerA(){
       final Person person = new Person();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int re = person.getAtomicInteger().incrementAndGet();	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":"+ re);
				System.out.println(Thread.currentThread().getName()+":"+person.getAtomicInteger().get());
			  
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int re = person.getAtomicInteger().incrementAndGet();
				System.out.println(Thread.currentThread().getName()+":"+ person.getAtomicInteger().get());
				re = person.getAtomicInteger().incrementAndGet();
				System.out.println(Thread.currentThread().getName()+":"+ person.getAtomicInteger().get());
				re = person.getAtomicInteger().incrementAndGet();
				System.out.println(Thread.currentThread().getName()+":"+ person.getAtomicInteger().get());
			   
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	
	/**
	 * 测试AtomicIntegerArray
	 */
	public static void testAtomicIntegerArray(){
		
		final Person person = new Person();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++){
					person.getAtomicIntegerArray().getAndIncrement(i);
				}
			}
			
		});
		
		
		
	}
	
	/**
	 * 测试AtomicStampedReference解决aba问题
	 */
	public static void testAtomicStampedReference(){
		
		final Person person = new Person();
		
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AtomicStampedReference asr = person.getAtomicStampedReference();
				// 预期引用 更新后的引用 预期标志 更新后标志
				// 这个更新是没有问题
				asr.compareAndSet(100, 101, asr.getStamp(), asr.getStamp()+1);
				asr.compareAndSet(101, 100, asr.getStamp(), asr.getStamp()+1);
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				AtomicStampedReference asr = person.getAtomicStampedReference();
				// 存储的是老版本
				int stamp = asr.getStamp();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				boolean flag = asr.compareAndSet(100, 101, stamp, stamp+1);
				System.out.println(flag);
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	
	
	
	
	public static class Person{
		private boolean flag = false;
		
		private volatile boolean vflag = false;
		
		private AtomicBoolean atomicBoolean = new AtomicBoolean();
		
		private AtomicInteger atomicInteger = new AtomicInteger(100);
		
		private AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
		
		private AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,0);

		/**
		 * @return the flag
		 */
		public boolean isFlag() {
			return flag;
		}

		/**
		 * @param flag the flag to set
		 */
		public void setFlag(boolean flag) {
			this.flag = flag;
		}

		/**
		 * @return the atomicBoolean
		 */
		public AtomicBoolean getAtomicBoolean() {
			return atomicBoolean;
		}

		/**
		 * @param atomicBoolean the atomicBoolean to set
		 */
		public void setAtomicBoolean(AtomicBoolean atomicBoolean) {
			this.atomicBoolean = atomicBoolean;
		}

		/**
		 * @return the vflag
		 */
		public boolean isVflag() {
			return vflag;
		}

		/**
		 * @param vflag the vflag to set
		 */
		public void setVflag(boolean vflag) {
			this.vflag = vflag;
		}

		/**
		 * @return the atomicInteger
		 */
		public AtomicInteger getAtomicInteger() {
			return atomicInteger;
		}

		/**
		 * @param atomicInteger the atomicInteger to set
		 */
		public void setAtomicInteger(AtomicInteger atomicInteger) {
			this.atomicInteger = atomicInteger;
		}

		/**
		 * @return the atomicIntegerArray
		 */
		public AtomicIntegerArray getAtomicIntegerArray() {
			return atomicIntegerArray;
		}

		/**
		 * @param atomicIntegerArray the atomicIntegerArray to set
		 */
		public void setAtomicIntegerArray(AtomicIntegerArray atomicIntegerArray) {
			this.atomicIntegerArray = atomicIntegerArray;
		}

		/**
		 * @return the atomicStampedReference
		 */
		public AtomicStampedReference getAtomicStampedReference() {
			return atomicStampedReference;
		}

		/**
		 * @param atomicStampedReference the atomicStampedReference to set
		 */
		public void setAtomicStampedReference(
				AtomicStampedReference atomicStampedReference) {
			this.atomicStampedReference = atomicStampedReference;
		}
		
		
		
		
		
	}
}

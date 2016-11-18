package com.threadTest.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 学习读锁。
 * 读读不互斥
 * 读写互斥
 * 写写互斥
 * @author liaokangli
 *
 */
public class LockReadWriteLock {
	
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	// 读锁
	private static ReadLock readLock = readWriteLock.readLock();
	// 写锁
	private static WriteLock writeLock = readWriteLock.writeLock();
	
	
	public static void main(String[] args){
//		readLockNormal();
//		readWriteLockNormal();
//		writeLockNormal();
//		writeLockRetry();
//		writeLockDowngrading();
//		readLockUpgrading();
//		writeReadLockInteruppt();
//		readWriteLockInteruppt();
//		readLockInteruppt();
//		writeLockCondition();
	}
	
	/**
	 * 读读锁。允许多个线程可以获得读锁。不互斥
	 */
	public static void readLockNormal(){
		
		
		
		Thread t1 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						readLock.lock();
						System.out.println(Thread.currentThread().getName()+":获得锁");
						Thread.sleep(10000);
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						System.out.println(Thread.currentThread().getName()+":释放锁");
						readLock.unlock();
					}
				}
				
			});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					readLock.lock();
					System.out.println(Thread.currentThread().getName()+":获得锁");
					Thread.sleep(1000);
					readLock.lock();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println(Thread.currentThread().getName()+":释放锁");
					readLock.unlock();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		
	}
	
	/**
	 * 读写锁。互斥。线程t2需要获得读锁，等t1把写锁释放完了才能获取读锁。对同一线程(先获得写锁，再获得读锁）是不互斥的
	 */
	public static void readWriteLockNormal(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+":获得锁");
					Thread.sleep(100000);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println(Thread.currentThread().getName()+":释放锁");
					writeLock.unlock();
				}
			}
			
		});
	
	Thread t2 = new Thread(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				readLock.lock();
				System.out.println(Thread.currentThread().getName()+":获得锁");
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				System.out.println(Thread.currentThread().getName()+":释放锁");
				readLock.unlock();
			}
		}
		
	});
	
	t1.start();
	t2.start();
		
	}
	
	
	/**
	 * 写写互斥。线程t1获取了写锁,另一线程无法获取写锁
	 */
	public static void writeLockNormal(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+"获得锁");
					Thread.sleep(10000);
					
				}catch(Exception e){
					
					e.printStackTrace();
					
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放锁");
					writeLock.unlock();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+"获得锁");
					Thread.sleep(1000);
					
				}catch(Exception e){
					
					e.printStackTrace();
					
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放锁");
					writeLock.unlock();
				}
			}
			
		});
		t1.start();
		t2.start();
		
	}
	
	
	/**
	 * 写锁重入性。同一线程获得了写锁，可以再次获得写锁。不过释放需要相应的多次释放
	 */
	public static void writeLockRetry(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+"第一次获得锁");
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+"第二次获得锁");
					writeLock.lock();
				}catch(Exception e){
					
					e.printStackTrace();
					
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放第一次锁");
					writeLock.unlock();
					System.out.println(Thread.currentThread().getName()+"释放第二次锁");
					writeLock.unlock();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+"获得锁");
					Thread.sleep(1000);
					
				}catch(Exception e){
					
					e.printStackTrace();
					
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放锁");
					writeLock.unlock();
				}
			}
			
		});
		t1.start();
		t2.start();
		
	}
	
	/**
	 * 锁降级(从写锁变成读锁，同一线程)。线程t1获得了写锁，可以获得读锁，然后释放写锁，此时锁降级
	 * 线程t2需要获得写锁，需要等线程t1释放了写锁或者读锁，才能获得，不同线程读写互斥
	 */
	public static void writeLockDowngrading(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+"获得写锁");
					Thread.sleep(1000);
					readLock.lock();
					System.out.println(Thread.currentThread().getName()+"释放写锁");				
					writeLock.unlock();
					Thread.sleep(10000);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放读锁");
					readLock.unlock();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					
					Thread.sleep(1000);
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+"获得写锁");
					readLock.lock();
					System.out.println(Thread.currentThread().getName()+"释放写锁");
					writeLock.lock();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放读锁");
					readLock.unlock();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		
	}
	
	/**
	 * 锁升级(读锁升级，不可能)。线程t1获得读锁，然后获得写锁,会阻塞
	 */
	public static void readLockUpgrading(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					readLock.lock();
					System.out.println(Thread.currentThread().getName()+"获得读锁");				
					System.out.println(Thread.currentThread().getName()+"获得写锁");
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+"释放写锁");				
					readLock.unlock();
					Thread.sleep(10000);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放读锁");
					writeLock.unlock();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					Thread.sleep(1000000);
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+"获得写锁");
					readLock.lock();
					System.out.println(Thread.currentThread().getName()+"释放写锁");
					writeLock.lock();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放读锁");
					readLock.unlock();
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	/**
	 * 支持中断锁(写锁和读锁支持),如果线程t1获取了写锁，线程t2需要获取写锁，则t2需要等待,此时可以中断线程t1
	 */
	public static void writeReadLockInteruppt(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					writeLock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName()+"获得写锁");
					Thread.sleep(100000);
					System.out.println(Thread.currentThread().getName()+"执行完成");
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					writeLock.unlock();
				}
			}
			
		});
		
		final Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				try{
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+"尝试获得写锁");
					writeLock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName()+"获得写锁");
					Thread.sleep(100000);
					System.out.println(Thread.currentThread().getName()+"执行完成");
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放锁");
					if(writeLock.isHeldByCurrentThread())
					    writeLock.unlock();
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  try{
				System.out.println(Thread.currentThread().getName()+"停顿");
				Thread.sleep(10000);
				System.out.println(Thread.currentThread().getName()+"执行中断t2");
				t2.interrupt();
			  }catch(Exception e){
				  e.printStackTrace();
			  }
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	/**
	 * 支持中断锁(写锁和读锁支持),如果线程t1获取了写锁，线程t2需要获取读锁，则t2需要等待,此时可以中断线程t1
	 */
	public static void readWriteLockInteruppt(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					writeLock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName()+"获得读锁");
					Thread.sleep(100000);
					System.out.println(Thread.currentThread().getName()+"执行完成");
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					writeLock.unlock();
				}
			}
			
		});
		
		final Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				try{
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+"尝试获得读锁");
					readLock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName()+"获得读锁");
					Thread.sleep(100000);
					System.out.println(Thread.currentThread().getName()+"执行完成");
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放锁");
					try{
				     readLock.unlock();
					}catch(Exception e){
						System.out.println(Thread.currentThread().getName()+"未拥有锁");
					}
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  try{
				System.out.println(Thread.currentThread().getName()+"停顿");
				Thread.sleep(10000);
				System.out.println(Thread.currentThread().getName()+"执行中断t2");
				t2.interrupt();
			  }catch(Exception e){
				  e.printStackTrace();
			  }
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	/**
	 * 支持中断锁(写锁和读锁支持),如果线程t1获取了读锁，线程t2需要获取读锁，则t2需要等待,此时可以中断线程t1。不过读读不互斥，所以这种情况是无法测试到
	 */
	public static void readLockInteruppt(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					readLock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName()+"获得读锁");
					Thread.sleep(100000);
					System.out.println(Thread.currentThread().getName()+"执行完成");
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					readLock.unlock();
				}
			}
			
		});
		
		final Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				try{
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+"尝试获得读锁");
					readLock.lockInterruptibly();
					System.out.println(Thread.currentThread().getName()+"获得读锁");
					Thread.sleep(100000);
					System.out.println(Thread.currentThread().getName()+"执行完成");
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println(Thread.currentThread().getName()+"释放锁");
					try{
				     readLock.unlock();
					}catch(Exception e){
						System.out.println(Thread.currentThread().getName()+"未拥有锁");
					}
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  try{
				System.out.println(Thread.currentThread().getName()+"停顿");
				Thread.sleep(10000);
				System.out.println(Thread.currentThread().getName()+"执行中断t2");
				t2.interrupt();
			  }catch(Exception e){
				  e.printStackTrace();
			  }
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	/**
	 * 写锁支持condition,读锁不支持。类似于wait,和signal
	 */
	public static void writeLockCondition(){
		
		final Condition condition = writeLock.newCondition();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					writeLock.lock();
					System.out.println(Thread.currentThread().getName()+"获得读锁");
					Thread.sleep(1000);
					condition.await();
					System.out.println(Thread.currentThread().getName()+"执行完成");
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(writeLock.isHeldByCurrentThread())
					   writeLock.unlock();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					// 尝试等待30秒
					if(writeLock.tryLock(30,TimeUnit.SECONDS)){
						System.out.println(Thread.currentThread().getName()+"获得读锁");
						condition.signalAll();
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+"执行完成");
					}else{
						System.out.println(Thread.currentThread().getName()+"未获得读锁");
					}
								
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(writeLock.isHeldByCurrentThread())
					   writeLock.unlock();
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{					
					System.out.println(Thread.currentThread().getName()+"开始获得锁");
					// 尝试等待30秒
					if(writeLock.tryLock(30,TimeUnit.SECONDS)){					
						System.out.println(Thread.currentThread().getName()+"获得读锁");
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+"执行完成");
					}else{
						System.out.println(Thread.currentThread().getName()+"未获得读锁");
					}
								
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(writeLock.isHeldByCurrentThread())
						   writeLock.unlock();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	

}

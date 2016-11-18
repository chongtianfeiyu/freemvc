package com.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量测试(可控制访问的线程个数，因为每个线程执行必须获得许可）.
 * 此实例中是5个，5个许可用户，其他线程被阻塞，当有一个线程执行完，释放许可
 * @author liaokangli
 *
 */
public class SemaphoreTest {

	public static void main(String[] args){
//		testAccquire();
		testTryAccquire();
	}
	
	/**
	 * 测试accquire 没有获取到许可，阻塞
	 */
	public static void testAccquire(){
        ExecutorService pool = Executors.newFixedThreadPool(100);
		
		// 信号量
		final Semaphore semph = new Semaphore(5);
		
		// 20个线程
		for(int i = 1;i<20;i++){
			pool.execute(new Thread(new Runnable(){

				@Override
				public void run() {
					try {
						semph.acquire();
						// TODO Auto-generated method stub
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(100000);
						semph.release();
						System.out.println("-------------"+semph.availablePermits());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}));
		}
		pool.shutdown();
		
	}
	
	// 测试tryacquire,没有获取到许可，执行后面的代码，
	public static void testTryAccquire(){
		ExecutorService pool = Executors.newCachedThreadPool();
		final Semaphore semph = new Semaphore(5);
		// 20个线程
		for(int i = 1;i<10;i++){
			pool.execute(new Thread(new Runnable(){

				@Override
				public void run() {
					try {
						if(semph.tryAcquire()){
						// TODO Auto-generated method stub
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(10000);
						
						}else{
							System.out.println(Thread.currentThread().getName()+"没有许可了"+semph.availablePermits());
						}
						semph.release();
						System.out.println("-------------"+semph.availablePermits());
					   
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}));
		}
		pool.shutdown();
	}
}

/**
 * 19lou.com
 */
package com.threadTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这种Threadlocal变量还是存在并发访问的问题，因为他们的value还是在堆里面的
 * @author liaokangli
 *
 */
public class ThreadLocalTest {
    static final Car car1 = new Car("aa");
    static final Car car2 = new Car("lkl");
    private static final ThreadLocal<Car> threadLocal = new ThreadLocal<Car>();
   
    public static Car get(){  	
    	return threadLocal.get();
    }
    public static void set(Car car){  	
    	threadLocal.set(car);;
    }
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				set(car1);
			   for(int i=0;i<10;i++){
				int value = get().addValue();
				
				System.out.println(Thread.currentThread().getName()+"get:"+value);
			   }
			}
			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				set(car2);
				for(int i=0;i<10;i++){
					int value = get().addValue();
					System.out.println(Thread.currentThread().getName()+"get:"+value);
				}
				
			}
			
		});		
		t1.start();
		t2.start();
//		t2.join();
//		System.gc();
		System.out.print("aa:"+threadLocal.get());
	}
	public static class Car {
		public String name;
		private  int c=0;
		public Car(String name){
			this.name = name;
		}
		public int addValue(){
			c++; 
			return c;
		}
		
	}

}

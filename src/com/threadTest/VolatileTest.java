/**
 * 19lou.com
 */
package com.threadTest;

import com.threadTest.atomic.AtomicTest.Person;

/**
 * @author liaokangli
 *
 */
public class VolatileTest {
     public static void main(String[] args) {
//		 final VolatileExample vo = new VolatileExample();
//		 Thread t1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//			    vo.writer();	
//			}
//		});
//		 
//		 Thread t2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				vo.reader();
//			}
//		});
//		 t1.start();
//		 t2.start();
    	 testVolatileLoop();
	}
     
     /**
 	 * 测试取出volatile变量放入线程的工作内存中。
 	 * 如果另一个线程修改了主内存里面的值话，该线程里面的值如何变化.
 	 */
 	public static void testVolatile(){
        final Person person = new Person();
 		
 		new Thread(new Runnable(){

 			@Override
 			public void run() {
 				// TODO Auto-generated method stub
 			
 			  while(true){
 				boolean flag =  person.isVflag();
 				System.out.println(Thread.currentThread().getName()+":"+flag);
 				try {
 					Thread.sleep(10000);
 					System.out.println(Thread.currentThread().getName()+"-1:"+flag);
 					System.out.println(Thread.currentThread().getName()+"-2:"+person.isVflag());
 				} catch (InterruptedException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 			  }
 			}
 			
 		}).start();
 		
 		new Thread(new Runnable(){

 			@Override
 			public void run() {
 				// TODO Auto-generated method stub
 			  try {
 				boolean flag = person.isVflag();
 				System.out.println(Thread.currentThread().getName()+":"+flag);
 				Thread.sleep(1000);
 				person.setVflag(true);
 				boolean newF = person.isVflag();
 				System.out.println(Thread.currentThread().getName()+":"+newF);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			  
 			}
 			
 		}).start();
 	}
     
    static class VolatileExample{
    	int a = 0;
    	volatile boolean flag = false;
    	
    	public void writer(){
    		a = 1;
    		flag = true;
    	}
    	public void reader(){
    		if(flag){
    			int i = a;
    		}
    	}
    }
    
    public static void testVolatileLoop(){    	
    	final VolatileExample ve = new VolatileExample();
    	new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(!ve.flag){
//					System.out.println(Thread.currentThread().getName());
				}
			}
    		
    	}).start();
    	
    	new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("tt");
				ve.flag=true;
			}
    		
    	}).start();
    }
}

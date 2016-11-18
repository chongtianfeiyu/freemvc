/**
 * 19lou.com
 */
package com.threadTest;

/**
 * 测试ThreadLocal共享变量的问题
 * @author liaokangli
 *
 */
public class ThreadLocalTest2 {
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		@Override
    	protected Integer initialValue() {
            return 0;
        }
	};
	
	public int getNextNum(){
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
    public static void main(String[] args) {
    	ThreadLocalTest2 sn = new ThreadLocalTest2();  
         
         //③ 3个线程共享sn，各自产生序列号  
         TestClient t1 = new TestClient(sn);    
         TestClient t2 = new TestClient(sn);  
         TestClient t3 = new TestClient(sn);  
         Thread t11 = new Thread(t1);
         Thread t21 = new Thread(t1);
         Thread t31 = new Thread(t1);
         t11.start();  
         t21.start();  
         t31.start(); 
	}
    
    public static class TestClient implements Runnable{

    	private ThreadLocalTest2 sn;  
        public TestClient(ThreadLocalTest2 sn) {  
            this.sn = sn;  
        }  
        public void run()  
        {  
                        //④每个线程打出3个序列值  
            for (int i = 0; i < 3; i++) {  
            System.out.println("thread["+Thread.currentThread().getName()+  
"] sn["+sn.getNextNum()+"]");  
            }  
        }  
    	
    }
    
    public static class MyThreadLocal<T> extends ThreadLocal{

		/**
		 * @return
		 */
    	@Override
    	protected T initialValue() {
            return null;
        }
    	
    }
}

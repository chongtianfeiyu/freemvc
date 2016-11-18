package com.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * futureTask����
 * @author liaokangli
 *
 */
public class FutureTaskTest {
    
	public static void main(String[] args) throws InterruptedException, ExecutionException{
//		testCallableNoValue();
//		testCallableWithValue();
		testCallableWithValue1();
//		testCallableExecutorCompletionService();
	}
	
	/**
	 * ʹ��thread������callable,��ʹ��FutureTask��ȡ����ֵ
	 */
	public static void testCallableNoValue(){
		FutureTask<String> future = new FutureTask<String>(new Callable<String>(){
			public String call() throws Exception {  
				System.out.println("ִ��callable");
                return Thread.currentThread().getName();
            }  
		});
		new Thread(future).start();
		
		try {
			Thread.sleep(10000);
			System.out.println("����:"+future.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ʹ��FutureTask��ȡ����ֵ,ʹ��excutors�����߳�(Ϊʲô������future��ȡ����ֵ��
	 * ��Ϊ���յ���submit(Runnable task)������submit(Callable<T> task)
	 * ����AbstractExecutorService�е�submit(Runnable task)Դ��,
	 * newTaskFor(task, null)valueֵ��Ϊnull.
	 */
	public static void testCallableWithValue(){
		FutureTask<String> future = new FutureTask<String>(new Callable<String>(){
			public String call() throws Exception {  
				System.out.println("ִ��callable");
                return Thread.currentThread().getName();
            }  
		});
		ExecutorService excutor = Executors.newSingleThreadExecutor();
		Future result = excutor.submit(future);
		
		try {
			Thread.sleep(10000);
			System.out.println("����1:"+future.get());
			System.out.println("����:"+result.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ʹ��Future��ȡ����ֵ,ʹ��excutors�����߳�
	 */
	public static void testCallableWithValue1(){
		
		ExecutorService excutor = Executors.newSingleThreadExecutor();
		Future result = excutor.submit(new Task());
//		new Thread(future).start();
		
		try {
//			Thread.sleep(10000);
//			System.out.println("����1:"+future.get());
			System.out.println("tt");
			System.out.println("����:"+result.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ���Զ��ִ������
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void testCallableExecutorCompletionService() throws InterruptedException, ExecutionException{
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CompletionService<String> cs = new ExecutorCompletionService<String>(executor);
		for(int i=0;i<=10;i++){
			final int taskId = i;
			cs.submit(new Callable<String>(){

				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					return taskId+":"+Thread.currentThread().getName();
				}
				
			});
			
		}
		for(int i=0;i<=10;i++){
			System.out.println(cs.take().get());
		}
	}
	
	public static class Task implements Callable<String>{

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			Thread.sleep(10000);
			System.out.println("ִ��callable");
			Thread.sleep(10000);
            return Thread.currentThread().getName();
		}
		
	}
}

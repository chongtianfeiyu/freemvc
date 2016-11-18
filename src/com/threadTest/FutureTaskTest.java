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
 * futureTask测试
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
	 * 使用thread来启动callable,并使用FutureTask获取返回值
	 */
	public static void testCallableNoValue(){
		FutureTask<String> future = new FutureTask<String>(new Callable<String>(){
			public String call() throws Exception {  
				System.out.println("执行callable");
                return Thread.currentThread().getName();
            }  
		});
		new Thread(future).start();
		
		try {
			Thread.sleep(10000);
			System.out.println("结束:"+future.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用FutureTask获取返回值,使用excutors启动线程(为什么不能用future获取返回值，
	 * 因为最终调用submit(Runnable task)而不是submit(Callable<T> task)
	 * 根据AbstractExecutorService中的submit(Runnable task)源码,
	 * newTaskFor(task, null)value值是为null.
	 */
	public static void testCallableWithValue(){
		FutureTask<String> future = new FutureTask<String>(new Callable<String>(){
			public String call() throws Exception {  
				System.out.println("执行callable");
                return Thread.currentThread().getName();
            }  
		});
		ExecutorService excutor = Executors.newSingleThreadExecutor();
		Future result = excutor.submit(future);
		
		try {
			Thread.sleep(10000);
			System.out.println("结束1:"+future.get());
			System.out.println("结束:"+result.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用Future获取返回值,使用excutors启动线程
	 */
	public static void testCallableWithValue1(){
		
		ExecutorService excutor = Executors.newSingleThreadExecutor();
		Future result = excutor.submit(new Task());
//		new Thread(future).start();
		
		try {
//			Thread.sleep(10000);
//			System.out.println("结束1:"+future.get());
			System.out.println("tt");
			System.out.println("结束:"+result.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试多个执行任务
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
			System.out.println("执行callable");
			Thread.sleep(10000);
            return Thread.currentThread().getName();
		}
		
	}
}

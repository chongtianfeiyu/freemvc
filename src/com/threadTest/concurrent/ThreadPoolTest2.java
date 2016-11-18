//package com.threadTest.concurrent;
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorCompletionService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.Future;
//import java.util.concurrent.RecursiveTask;
//
///**
// * 线程池.ExecutorCompletionService不是多线程
// * @author liaokangli
// *
// */
//public class ThreadPoolTest2 {
//	
//	public static void main(String[] args){
////		testExecutorCompletionService();
//		testForkJoinPool();
//	
//	}
//
//	
//	/**
//	 * 测试executor
//	 */
//	public static void testExecutorCompletionService(){
//		
//		Executors.newFixedThreadPool(4);
//		
//		ExecutorCompletionService<String> ecs = new ExecutorCompletionService<String>(new Executor (){
//
//			@Override
//			public void execute(Runnable command) {
//				// TODO Auto-generated method stub
//				System.out.println("ss2"+Thread.currentThread().getName());
//				command.run();
//			}
//			
//		});
//		
//		ecs.submit(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("ss1"+Thread.currentThread().getName());
//				while(true){
//					
//				}
//				
//			}
//			
//		},"tt");
//		
//		ecs.submit(new Callable(){
//
//			@Override
//			public Object call() throws Exception {
//				// TODO Auto-generated method stub
//				System.out.println(Thread.currentThread().getName());
//				return "tt";
//			}
//
//			
//			
//		});
//		
//	}
//	
//	/**
//	 * 测试Executors
//	 */
//	public static void testExecutors(){
//		Executors executors;
//	}
//	
//	/**
//	 * 测试ForkJoinPool.类似mapreduce
//	 */
//	public static void testForkJoinPool(){
//		
//		ForkJoinPool forkJoinPool = new ForkJoinPool();
//		
//		
//		CountTask task = new CountTask(1,50);
// 		Future<Integer> result = forkJoinPool.submit(task);
//		
//		try {
//			System.out.println(result.get());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//	}
//	
//	/**
//	 * 继承forkjointask
//	 * @author liaokangli
//	 *
//	 */
//	public static class CountTask extends RecursiveTask<Integer>{
//		
//		private static final int THRESHOLD = 2;
//		
//		private int start;
//		
//		private int end;
//		
//		public CountTask(int start,int end){
//			this.start = start;
//			this.end = end;
//		}
//
//		@Override
//		protected Integer compute() {
//			// TODO Auto-generated method stub
//			int sum = 0;
//			
//			boolean canCompute = (end - start) <= THRESHOLD;
//			if(canCompute){
//				for(int i = start;i<=end;i++){
//					sum += i;
//				}
//			}else{
//				int mid = (start + end) / 2;
//				CountTask leftTask = new CountTask(start,mid);
//				
//				CountTask rightTask = new CountTask(mid+1,end);
//				
//				//执行任务
//				leftTask.fork();
//				rightTask.fork();
//				
//				// 等待子任务执行完，并得到结果
//				int leftResult = (int) leftTask.join();
//				int rightResult = (int) rightTask.join();
//				
//				sum = leftResult + rightResult;
//			}
//			
//			return sum;
//		}
//		
//	}
//}

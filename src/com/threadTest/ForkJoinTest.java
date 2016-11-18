//package com.threadTest;
//
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.Future;
//import java.util.concurrent.RecursiveTask;
//
///**
// * fork/join���ʹ�ò���
// * @author liaokangli
// *
// */
//public class ForkJoinTest {
//
//	public static void main(String[] args){
//		ForkJoinPool forkJoinPool = new ForkJoinPool();
//		// ����һ���������񣬸������1+2+3+4
//		CalculateTask task = new CalculateTask(1,4);
//		// ִ��һ������
//		Future<Long> result = forkJoinPool.submit(task);
//	    
//		try {
//			System.out.println(result.get());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public static class CalculateTask extends RecursiveTask<Long>{
//		private static final int THRESHOLD = 2;
//		private int start;
//		private int end;
//		
//		public CalculateTask(int start,int end){
//			 this.start = start;
//			 this.end = end;
//		}
//
//		@Override
//		protected Long compute() {
//			// TODO Auto-generated method stub
//			Long sum = 0l;
//			boolean canCompute = (end - start)<=THRESHOLD;
//			if(canCompute){
//				for(int i = start;i<=end;i++){
//					sum +=1;
//				}
//			}else{
//				int middle = (start + end)/2;
//				CalculateTask leftTask = new CalculateTask(start,middle);
//				CalculateTask rightTask = new CalculateTask(middle + 1,end);
//				
//				// ִ������
//				leftTask.fork();
//				rightTask.fork();
//				
//				//�ȴ�������ִ���꣬���õ�������
//				Long leftResult = leftTask.join();
//				Long rightResult = rightTask.join();
//				
//				// �ϲ�������
//				sum = leftResult + rightResult;
//			}
//			return sum;
//		}
//		
//	}
//}

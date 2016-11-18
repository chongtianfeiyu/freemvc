//package com.threadTest.concurrent;
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.concurrent.AbstractExecutorService;
//import java.util.concurrent.BlockingDeque;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.Callable;
//import java.util.concurrent.CompletionService;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.ConcurrentNavigableMap;
//import java.util.concurrent.Delayed;
//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.Future;
//import java.util.concurrent.RunnableFuture;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.TransferQueue;
//
//import com.sun.jmx.remote.internal.ArrayQueue;
//
///**
// *并发包接口学习
// * @author liaokangli
// *
// */
//public class InterfaceTest {
//	
//	// 双端队列
//	BlockingDeque bd;
//	
//	// 队列。先进先出
//	BlockingQueue bq;
//	
//	Callable callable;
//	
//	Runnable runnable;
//	
//	CompletionService cs;
//	
//	ConcurrentMap cm;
//	
//	ConcurrentNavigableMap cnm;
//	
//	Delayed delayed;
//	
//	Executor executor;
//	
//	ExecutorService es;
//	
//	ForkJoinPool fjp;
//	
//	Future future;
//	
//	RunnableFuture rf;
//	
//	ScheduledExecutorService ses;
//	
//	ThreadFactory tf;
//	
//	TransferQueue tq;
//	
//	AbstractExecutorService aes;
//	
//	class DirectExecutor implements Executor{
//
//		@Override
//		public void execute(Runnable command) {
//			// TODO Auto-generated method stub
//			command.run();
//		}
//		
//	}
//	
//	class ThreadPerTaskExecutor implements Executor{
//
//		@Override
//		public void execute(Runnable command) {
//			// TODO Auto-generated method stub
//			new Thread(command).start();
//		}
//		
//	}
//	
//	class SerialExecutor implements Executor{
//		
//		final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
//
//		@Override
//		public void execute(Runnable command) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
//	
//	
//
//}

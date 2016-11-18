package com.threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrankLockInterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBuffer buffer = new MyBuffer();
		   final WriteThread write = new WriteThread(buffer);
		   write.start();
		   
		   final ReadThread read = new ReadThread(buffer);
		   read.start();
		   
		   new Thread(new Runnable(){
			  public void run(){
				  long readThreadMaxWaitTime = 5000;
				  long startTime = System.currentTimeMillis();
				  System.out.println("读线程等待时间已超过"+readThreadMaxWaitTime/1000+"秒,请求中断....");
				  read.interrupt();
			  }
		   }).start();
	}
 
 static class WriteThread extends Thread{
 	private MyBuffer buffer;
 	public WriteThread(MyBuffer buffer){
 		this.buffer = buffer;
 	}
 	public void run(){
 		buffer.write();
 	}
 }
 
 static class ReadThread extends Thread{
 	private MyBuffer buffer;
 	public ReadThread(MyBuffer buffer){
 		this.buffer = buffer;
 	}
 	public void run(){
 		try{
 			buffer.read();
 		}catch(InterruptedException e){
 			System.out.println("读线程已经被中断...."+e);
 		}
 	}
 }
 
 static class MyBuffer{
 	private ReentrantLock lock = new ReentrantLock();
 	
 	Condition condition = lock.newCondition();
 	
 	/**
 	 * 写操作
 	 */
 	public void write(){
 		lock.lock();
 		try{
 		
             while(true){
            		try {
        				Thread.sleep(10000);
        			} catch (InterruptedException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
            	 System.out.println("写操作完成.....");
             }
             
 		}finally{
 			System.out.println("write 释放锁");
 			lock.unlock();
 		}
 	}
 	
 	/**
 	 * 读操作
 	 * @throws InterruptedException
 	 */
 	public void read() throws InterruptedException{
 		System.out.println("读操作开始....");
 		lock.lockInterruptibly();
 		try{
 			while(true){
 			  System.out.println("读操作完成.....");
 			}
 		}finally{
 			System.out.println("读 释放锁");
 			lock.unlock();
 		}

 	}
 }
	
	

}

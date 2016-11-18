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
				  System.out.println("���̵߳ȴ�ʱ���ѳ���"+readThreadMaxWaitTime/1000+"��,�����ж�....");
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
 			System.out.println("���߳��Ѿ����ж�...."+e);
 		}
 	}
 }
 
 static class MyBuffer{
 	private ReentrantLock lock = new ReentrantLock();
 	
 	Condition condition = lock.newCondition();
 	
 	/**
 	 * д����
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
            	 System.out.println("д�������.....");
             }
             
 		}finally{
 			System.out.println("write �ͷ���");
 			lock.unlock();
 		}
 	}
 	
 	/**
 	 * ������
 	 * @throws InterruptedException
 	 */
 	public void read() throws InterruptedException{
 		System.out.println("��������ʼ....");
 		lock.lockInterruptibly();
 		try{
 			while(true){
 			  System.out.println("���������.....");
 			}
 		}finally{
 			System.out.println("�� �ͷ���");
 			lock.unlock();
 		}

 	}
 }
	
	

}

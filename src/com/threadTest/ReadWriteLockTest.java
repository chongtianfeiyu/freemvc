package com.threadTest;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        final Queue3 q3 = new Queue3();
//        for(int i=0;i<3;i++)
//        {
//            new Thread(){
//                public void run(){
//                    while(true){
//                        q3.get();                        
//                    }
//                }
//                
//            }.start();
//        }
        for(int i=0;i<3;i++)
        {        
            new Thread(){
                public void run(){
                    while(true){
                        q3.put(new Random().nextInt(10000));
                    }
                }            
                
            }.start();    
        }
    }
}

class Queue3{
    private Object data = null;//�������ݣ�ֻ����һ���߳���д�����ݣ��������ж���߳�ͬʱ�������ݡ�
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public void get(){
        rwl.readLock().lock();//�϶����������߳�ֻ�ܶ�����д
        System.out.println(Thread.currentThread().getName() + "׼��������!");
        try {
            Thread.sleep((long)(Math.random()*10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "have read data :" + data);        
        rwl.readLock().unlock(); //�ͷŶ�������÷���finnaly����
    }
    
    public void put(Object data){

        rwl.writeLock().lock();//��д���������������̶߳�Ҳ������д
        
        System.out.println(Thread.currentThread().getName() + " ׼��д����!");                    
        try {
            Thread.sleep((long)(Math.random()*10000));
       
        this.data = data;        
        System.out.println(Thread.currentThread().getName() + " have write data: " + data);                    
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
         System.out.println(Thread.currentThread().getName()+"�ͷ���");
         rwl.writeLock().unlock();//�ͷ�д��   
        }
    }
}
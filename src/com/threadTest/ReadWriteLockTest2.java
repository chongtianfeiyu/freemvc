package com.threadTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest2 {
    private Map<String, Object> map = new HashMap<String, Object>();//������
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public static void main(String[] args) {
    	final Queue3 q3 = new Queue3();
    	final ReadWriteLockTest2 aa = new ReadWriteLockTest2();
        for(int i=0;i<3;i++)
        {
            new Thread(){
                public void run(){
                    while(true){
//                        q3.put(new Random().nextInt(10000));     
                    	// ��������
                    	aa.get("0");
                    }
                }
                
            }.start();
        }
    }
    public Object get(String id){
        rwl.readLock().lock();//���ȿ����������ӻ�����ȥȡ
        try{
            System.out.println(Thread.currentThread().getName()+"��һ�ζ�");
                rwl.writeLock().lock();
                try{
                        System.out.println("================"+Thread.currentThread().getName());
                    
                }finally{
                    rwl.writeLock().unlock(); //�ͷ�д��
                }
            
            System.out.println(Thread.currentThread().getName());   

        }finally{
            rwl.readLock().unlock(); //����ͷŶ���
        }
        
        return null;
    }
    
    public Object get1(String id){
        rwl.writeLock().lock();//���ȿ����������ӻ�����ȥȡ
        try{
            System.out.println(Thread.currentThread().getName()+"��һ�ζ�");
                rwl.readLock().lock();
                try{
                        System.out.println("================"+Thread.currentThread().getName());
                    
                }finally{
                    rwl.readLock().unlock(); //�ͷ�д��
                }
            
            System.out.println(Thread.currentThread().getName());   

        }finally{
            rwl.writeLock().unlock(); //����ͷŶ���
        }
        
        return null;
    }

    public static class Queue3{
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;        
            System.out.println(Thread.currentThread().getName() + " have write data: " + data);     
            
            rwl.readLock().lock();//�϶����������߳�ֻ�ܶ�����д
            System.out.println(Thread.currentThread().getName()+"�ͷ�д��");
            rwl.writeLock().unlock();//�ͷ�д�� 
            System.out.println(Thread.currentThread().getName()+"׼��������");
            System.out.println(Thread.currentThread().getName() + "have read data :" + data);   
            
            rwl.readLock().unlock(); //�ͷŶ�������÷���finnaly����
               
        }
    }
}


package com.threadTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest2 {
    private Map<String, Object> map = new HashMap<String, Object>();//缓存器
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
                    	// 死锁测试
                    	aa.get("0");
                    }
                }
                
            }.start();
        }
    }
    public Object get(String id){
        rwl.readLock().lock();//首先开启读锁，从缓存中去取
        try{
            System.out.println(Thread.currentThread().getName()+"第一次读");
                rwl.writeLock().lock();
                try{
                        System.out.println("================"+Thread.currentThread().getName());
                    
                }finally{
                    rwl.writeLock().unlock(); //释放写锁
                }
            
            System.out.println(Thread.currentThread().getName());   

        }finally{
            rwl.readLock().unlock(); //最后释放读锁
        }
        
        return null;
    }
    
    public Object get1(String id){
        rwl.writeLock().lock();//首先开启读锁，从缓存中去取
        try{
            System.out.println(Thread.currentThread().getName()+"第一次读");
                rwl.readLock().lock();
                try{
                        System.out.println("================"+Thread.currentThread().getName());
                    
                }finally{
                    rwl.readLock().unlock(); //释放写锁
                }
            
            System.out.println(Thread.currentThread().getName());   

        }finally{
            rwl.writeLock().unlock(); //最后释放读锁
        }
        
        return null;
    }

    public static class Queue3{
        private Object data = null;//共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。
        private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        public void get(){
            rwl.readLock().lock();//上读锁，其他线程只能读不能写
            System.out.println(Thread.currentThread().getName() + "准备读数据!");
            try {
                Thread.sleep((long)(Math.random()*10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "have read data :" + data);        
            rwl.readLock().unlock(); //释放读锁，最好放在finnaly里面
        }
        
        public void put(Object data){

            rwl.writeLock().lock();//上写锁，不允许其他线程读也不允许写
            System.out.println(Thread.currentThread().getName() + " 准备写数据!");                    
            try {
                Thread.sleep((long)(Math.random()*10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;        
            System.out.println(Thread.currentThread().getName() + " have write data: " + data);     
            
            rwl.readLock().lock();//上读锁，其他线程只能读不能写
            System.out.println(Thread.currentThread().getName()+"释放写锁");
            rwl.writeLock().unlock();//释放写锁 
            System.out.println(Thread.currentThread().getName()+"准备读数据");
            System.out.println(Thread.currentThread().getName() + "have read data :" + data);   
            
            rwl.readLock().unlock(); //释放读锁，最好放在finnaly里面
               
        }
    }
}


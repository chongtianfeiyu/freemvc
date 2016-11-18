package com.threadTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest1 {
    private Map<String, Object> map = new HashMap<String, Object>();//缓存器
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    Object value = null;
    public static void main(String[] args) {
    	final ReadWriteLockTest1 aa = new ReadWriteLockTest1();
        for(int i=0;i<3;i++)
        {
            new Thread(){
                public void run(){
                    while(true){
                        aa.get("0");
                        try {
							Thread.sleep(100000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                }
                
            }.start();
        }
    }
    public Object get(String id){
//        Object value = null;写在这里的话，是每个线程一个副本，体现不出并发性
        rwl.readLock().lock();//首先开启读锁，从缓存中去取
        try{
            value = map.get(id); 
            System.out.println(Thread.currentThread().getName()+"第一次读"+value);
            if(value == null){  //如果缓存中没有释放读锁，上写锁
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    if(value == null){
                        value = Thread.currentThread().getName();  //此时可以去数据库中查找，这里简单的模拟一下
                        System.out.println("写数据================"+value);
                        map.put("0", value);
                    }
                }finally{
                	System.out.println(Thread.currentThread().getName()+"释放写锁");
                    rwl.writeLock().unlock(); //释放写锁
                }
                rwl.readLock().lock(); //然后再上读锁
            }
            System.out.println(Thread.currentThread().getName()+"读取:"+value);   

        }finally{
            rwl.readLock().unlock(); //最后释放读锁
        }
        
        return value;
    }

}
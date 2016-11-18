package com.threadTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest1 {
    private Map<String, Object> map = new HashMap<String, Object>();//������
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
//        Object value = null;д������Ļ�����ÿ���߳�һ�����������ֲ���������
        rwl.readLock().lock();//���ȿ����������ӻ�����ȥȡ
        try{
            value = map.get(id); 
            System.out.println(Thread.currentThread().getName()+"��һ�ζ�"+value);
            if(value == null){  //���������û���ͷŶ�������д��
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    if(value == null){
                        value = Thread.currentThread().getName();  //��ʱ����ȥ���ݿ��в��ң�����򵥵�ģ��һ��
                        System.out.println("д����================"+value);
                        map.put("0", value);
                    }
                }finally{
                	System.out.println(Thread.currentThread().getName()+"�ͷ�д��");
                    rwl.writeLock().unlock(); //�ͷ�д��
                }
                rwl.readLock().lock(); //Ȼ�����϶���
            }
            System.out.println(Thread.currentThread().getName()+"��ȡ:"+value);   

        }finally{
            rwl.readLock().unlock(); //����ͷŶ���
        }
        
        return value;
    }

}
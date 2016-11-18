package com.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * �������Ͳ���
 * @author liaokangli
 *
 */
public class ReferenceTest {
	
	public static void main(String[] args){
		testPhantomReference();
//		testSoftReference();
//		testWeakReference();
	}

	/**
	 * ����������
	 * ��������Ҫ�������ٶ����������������յĻ���������������ú������õ�һ���������ڣ������ñ�������ö��� ��ReferenceQueue������ʹ�á�
	 * ������������׼������һ������ʱ��������������������ã��ͻ��ڻ��ն�����ڴ�֮ǰ������������ü��뵽��֮���������ö����С�
	 * �������ͨ���ж����ö������Ƿ��Ѿ������������ã�
	 * ���˽ⱻ���õĶ����Ƿ�Ҫ���������ա����������ĳ���������Ѿ������뵽���ö��У���ô�Ϳ����������õĶ�����ڴ汻����֮ǰ��ȡ��Ҫ���ж�
	 *�ڴ�����������PhantomReference��ʱ�����Ҫָ��һ�����ö��С���һ�������finalize�����Ѿ���������֮�����������������ûᱻ���뵽�����С�
	 *ͨ�����ö�����������ݾ�֪��һ�������ǲ����Ѿ�׼��Ҫ��������
	 *http://www.bkjia.com/Javabc/883033.html
	 */
	public static void testPhantomReference(){
	    Person person = new Person();
	    ReferenceQueue rq = new ReferenceQueue();
		PhantomReference<Person> pR = new PhantomReference<Person>(person,rq); 	
		
		
		System.out.println(rq.poll());
		
		person = null;
		
		// ִ�����person������������
		System.gc();
		
		try {
			// ��һ��ʱ�䣬��gc�̹߳������
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("dd"+rq.poll());
        
	}
	
	/**
	 * ����������
	 */
	public static void testSoftReference(){
		Person person = new Person();
		SoftReference<Person> srf = new SoftReference<Person>(person);
		
		person = null;
		System.gc();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("dd");
	}
	
	/**
	 * ������
	 */
	public static void testWeakReference(){
		Person person = new Person();
		WeakReference<Person> wrf = new WeakReference<Person>(person);
		person = null;
		System.gc();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dd");
	}
	
	public static class Cleaner extends PhantomReference{

		public Cleaner(Object referent, ReferenceQueue q) {
			super(referent, q);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public static class Person {

	}
	
	public static class SuperPerson{
		
		public SuperPerson(String tt){
			
		}
	}
}

package com.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 引用类型测试
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
	 * 测试虚引用
	 * 虚引用主要用来跟踪对象被垃圾回收器回收的活动。虚引用与软引用和弱引用的一个区别在于：虚引用必须和引用队列 （ReferenceQueue）联合使用。
	 * 当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之关联的引用队列中。
	 * 程序可以通过判断引用队列中是否已经加入了虚引用，
	 * 来了解被引用的对象是否将要被垃圾回收。如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动
	 *在创建幽灵引用PhantomReference的时候必须要指定一个引用队列。当一个对象的finalize方法已经被调用了之后，这个对象的幽灵引用会被加入到队列中。
	 *通过检查该队列里面的内容就知道一个对象是不是已经准备要被回收了
	 *http://www.bkjia.com/Javabc/883033.html
	 */
	public static void testPhantomReference(){
	    Person person = new Person();
	    ReferenceQueue rq = new ReferenceQueue();
		PhantomReference<Person> pR = new PhantomReference<Person>(person,rq); 	
		
		
		System.out.println(rq.poll());
		
		person = null;
		
		// 执行完后，person对象加入队列中
		System.gc();
		
		try {
			// 等一段时间，让gc线程工作完成
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("dd"+rq.poll());
        
	}
	
	/**
	 * 测试软引用
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
	 * 弱引用
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

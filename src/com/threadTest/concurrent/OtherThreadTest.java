//package com.threadTest.concurrent;
//
//import java.awt.image.DataBuffer;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//import java.util.concurrent.Exchanger;
//import java.util.concurrent.Phaser;
//
///**
// * 其他类测试
// * @author liaokangli
// *
// */
//public class OtherThreadTest {
//	
//	volatile static Person[] personss = new Person[10];
//	
//	public static void main(String[] args){
////		testVolatile();
////		testExchanger();
//		testPhaser();
//		
//	}
//
//	
//	/**
//	 * 测试Exchanger
//	 */
//	public static void testExchanger(){
//		FillAndEmpty fillAndEmpty = new FillAndEmpty();
//		Runnable t1 =  fillAndEmpty.new FillingLoop();
//		Runnable t2 = fillAndEmpty.new EmptyLoop();
//		new Thread(t1).start();
//		new Thread(t2).start();
//		System.out.println("tt");
//		
//	}
//	
//	/**
//	 * 测试Phaser.类似countlantch
//	 */
//	public static void testPhaser(){
//		int count = 5;
//		Phaser phaser = new Phaser(count);
//		
//		for(int i = 0;i < count;i++){
//			System.out.println("start thread,id:"+i);
//			final Thread thread = new Thread(new Task(i,phaser));
//			thread.start();
//		}
//		
//		
//	}
//	
//	public static class Task implements Runnable{
//		
//		private final int id;
//		private final Phaser phaser;
//		
//		public Task(int id,Phaser phaser){
//			this.id = id;
//			this.phaser = phaser;
//		}
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			phaser.arriveAndAwaitAdvance();  
//            System.out.println("in Task.run(), phase: " + phaser.getPhase() + ", id: " + this.id);  
//		}
//		
//	}
//	
//	public static class FillAndEmpty{
//		Exchanger<Set<String>> exchanger = new Exchanger<Set<String>>();
//		
//		
//		class FillingLoop implements Runnable{
//			
//			Set<String> fillset = new HashSet<String>();
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				for(int i = 0;i < 10;i++){
//					fillset.add("tt"+i);
//				}
//				
//				try {
//					fillset = exchanger.exchange(fillset);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//			
//		}
//		
//		class EmptyLoop implements Runnable{
//
//			Set<String> emptyset = new HashSet<String>();
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				for(int i = 0;i < 10;i++){
//					emptyset.add("bb"+i);
//				}
//				
//				try {
//					// 一定要赋值
//					emptyset = exchanger.exchange(emptyset);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				Iterator<String> iterator = emptyset.iterator();
//				while(iterator.hasNext()){
//					System.out.println(iterator.next());
//				}
//			}
//			
//		}
//		
//	}
//	
//	
//	
//	public static void testVolatile(){
//		
//		Thread t1 = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				tt("lkl");
//			}
//			
//		});
//		
//		Thread t2 = new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				tt("bb");
//			}
//			
//		});
//		t1.start();
//		t2.start();
//	}
//	
//	public static void tt(String name){
//		Person person = new Person();
//		person.setName(name);
//		Person[] ts = personss;
//		Person t = ts[0];
//		synchronized(ts){
//			if(ts[0] == null){
//				Person person1 = new Person();
//				person1.setName("mn");
//				ts[0] = person1;
//			}
//				
//			     
//				
//		}
//	}
//	
//	public static class Person{
//		
//		private String name;
//
//		/**
//		 * @return the name
//		 */
//		public String getName() {
//			return name;
//		}
//
//		/**
//		 * @param name the name to set
//		 */
//		public void setName(String name) {
//			this.name = name;
//		}
//		
//		
//		
//	}
//}

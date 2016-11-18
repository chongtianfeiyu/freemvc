package com.jvmTest;

/**
 * slot复用特性
 * @author liaokangli
 *
 */
public class SlotTest {

	public static void main(String[] args){
		// 代码块，如果不加int a=0,slot不能得到复用，gc无法回收
//		{
//		  byte[] b = new byte[64*1024*1024];
//		  
//		}
//		int a= 0;
//		System.gc();
		
//		
//		// b在循环中经历创建和销毁，退出for循环，java自动销毁，无需考虑slot复用
//		for(int i=0;i<10;i++){
//			byte[] b = new byte[64*1024*1024];
//		}
//		System.gc();
		
		
		// 方法级别,方法退出，栈枕退出，栈里面的变量销毁，也就可以回收对象
//		test();
//		System.gc();
		
		
		//if语句,为什么if里面改成true的时候，不能回收，改成i==0可以回收？
		int i=0;       
		if(true){
			byte[] b = new byte[64*1024*1024];
		}
		
		System.gc();
	}
	
	public static void test(){
		 byte[] b = new byte[64*1024*1024];
		 System.gc();
	}
}

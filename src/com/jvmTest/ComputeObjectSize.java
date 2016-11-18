package com.jvmTest;

import java.lang.instrument.Instrumentation;

/**
 * 计算对象大小
 * @author liaokangli
 *
 */
public class ComputeObjectSize {
	
	public static void main(String[] args){
		System.out.println("main is over");
	}
	
	public static void premain(String args, Instrumentation inst) {
	    Object obj = new Object();
	    System.out.println("Bytes used by Object:"+ inst.getObjectSize(obj));
	    System.out.println("Bytes used by MyObject:"+ inst.getObjectSize(new Person()));
	  }
	
	
	public static class Person{
		int a;
		String[] as;
	}

}

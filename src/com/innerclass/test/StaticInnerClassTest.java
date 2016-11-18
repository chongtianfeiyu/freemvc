package com.innerclass.test;

/**
 * 静态内部类
 * 除了外围类的其他类访问该内部类时使用new StaticInnerClassTest.StaticInnerClass
 * 外围类访问该内部类可以省略StaticInnerClassTest
 * @author liaokangli
 *
 */
public class StaticInnerClassTest {
    
	public static void main(String[] args){
		new StaticInnerClassTest();
	}
	
	public static class StaticInnerClass{
		
	}
}

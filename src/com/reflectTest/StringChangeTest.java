package com.reflectTest;

import java.lang.reflect.Field;

/**
 * 用反射验证String是可变的类
 * @author liaokangli
 *
 */
public class StringChangeTest {
	
	public static void main(String[] args){
		testStringChange();
	}
	
	/**
	 * 测试String类里面的值可以改变：用反射
	 */
	public static void testStringChange(){
	   try{
		String str = "abcd";
		Field field = str.getClass().getDeclaredField("value");
		field.setAccessible(true);
		char[] tt =  (char[]) field.get(str);
		tt[2]='_';
		System.out.println(str);
	   }catch(Exception e){
		   e.printStackTrace();
	   }
		
	}

}

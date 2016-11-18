package com.reflectTest;

import java.lang.reflect.Field;

/**
 * �÷�����֤String�ǿɱ����
 * @author liaokangli
 *
 */
public class StringChangeTest {
	
	public static void main(String[] args){
		testStringChange();
	}
	
	/**
	 * ����String�������ֵ���Ըı䣺�÷���
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

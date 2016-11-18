package com.reflectTest;

import java.lang.reflect.Array;

/**
 * ����Ӧ��֪ʶѧϰ
 * Class.forName;o.getClass();A.class����
 * @author liaokangli
 *
 */
public class ReflectTest1 {

	
	public static void main(String[] args){
//		testArray();
		testThree();
	}
	
	/**
	 * Array��
	 */
	public static void testArray(){
		try {
			Class stringArrayClass = Class.forName("[Ljava.lang.String;");
			Class stringArrayClass1 = Array.newInstance(String.class, 0).getClass();
			System.out.println("����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testThree(){
		
		try {
			Class c1 = SubPerson.class;
			Person o1 = new SubPerson();
			Class c2 = o1.getClass();
			Class c3 = Class.forName("com.reflectTest.ReflectTest1$SubPerson");
			System.out.println("dd");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static class Person{
		
	}
	
	public static class SubPerson extends Person{
		
	}
}

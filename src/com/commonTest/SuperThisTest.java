/**
 * 19lou.com
 */
package com.commonTest;

/**
 * ���������е���super.method������thisָ���������ʵ��
 * �����б����صĳ�Ա�����ͱ����ǵĳ�Ա����
 * �������е���super.method ��ʵ����������õ�
 * 
 * @author liaokangli
 *
 */
public class SuperThisTest {
   
	public static void main(String[] args){
		SubPerson sp = new SubPerson("");
		System.out.println(sp);
		sp.getName();
	}
	
	public static abstract class Person{
		public Person(String name){
			System.out.println(name);
		}
		public void getName(){
			System.out.println("super:"+this);
		}
	}
	
	public static  class SubPerson extends Person{
		public SubPerson(String name){
			super("dd");
		}
		public void getName(){
			super.getName();
		}
	}
}

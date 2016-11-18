/**
 * 19lou.com
 */
package com.commonTest;

/**
 * 测试子类中调用super.method方法，this指向的是子类实例
 * 父类中被隐藏的成员变量和被覆盖的成员方法
 * 在子类中调用super.method 其实还是子类调用的
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

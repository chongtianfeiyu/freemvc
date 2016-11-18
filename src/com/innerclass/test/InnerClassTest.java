package com.innerclass.test;

import com.exceptionTest.ExceptionTest;
import com.exceptionTest.ExceptionTest1;



/**
 * 继承的时候，内部类中的this指向的是哪个方法。
 * @author liaokangli
 *
 */
public class InnerClassTest {
	SubPerson tt = new SubPerson();
	
	public static void main(String[] args){
		
		SubPerson sp = new SubPerson();
		sp.getInstance().getNamett();
	}
	
	public static  abstract class Person{
		public abstract void getName(String name);
		
		public void getName1(){
			System.out.println("tt");
		}
		
		public t getInstance(){
			return new X();
		}
		class X implements t{
			
			public void getName(String name){
				System.out.println("tt");
			}

			@Override
			public void getNamett() {
				// TODO Auto-generated method stub
				Person.this.getName("tt1");
				getName1();
			}
			
		}
	}
	
	public static class SubPerson extends Person{

		@Override
		public void getName(String name) {
			// TODO Auto-generated method stub
			System.out.println("tt1");
		}
		
		public void getName1(){
			System.out.println("tt2");
		}
		
	}
	
	public interface t{
		public void getNamett();
	}

}

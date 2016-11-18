package com.innerclass.test;

/**
 * 内部类同名字段名称访问方式
 * @author liaokangli
 *
 */
public class ShadowingTest {
  
	public int x = 0;
	
	class FirstLevel{
		public int x = 1;
		
		void method(int x){
			System.out.println("method args x="+x);
			System.out.println("class FirstLever x="+this.x);
			System.out.println("class ShadowingTest x="+ShadowingTest.this.x);
		}
	}
	
	public static void main(String[] args){
		ShadowingTest test = new ShadowingTest();
		ShadowingTest.FirstLevel firstLevel = test.new FirstLevel();
		firstLevel.method(10);
	}
}

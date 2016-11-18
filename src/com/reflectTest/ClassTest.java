package com.reflectTest;

/**
 * class类测试
 * @author liaokangli
 *
 */
public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException{
		
//		testIsAssignableFrom();
//		testGetClass();
		testGetInterfaces();
	}
	
	public static void testIsAssignableFrom(){
		TestClImp1 tc = new TestClImp1();
		Class classz = tc.getClass();
		
		TestClImp tc1 = new TestClImp();
		Class classz1 = tc1.getClass();
		// 判断classz1是否是TestClImp1的子类，为false
		boolean result1 = TestClImp1.class.isAssignableFrom(classz1);
		// 判断classz是否是TestClImp的子类，为true
		boolean result = TestClImp.class.isAssignableFrom(classz);
		System.out.println(result);
		
		//判断上面的classz,classz1及TestClImp1.class是否同一个
		TestClImp tc2 = new TestClImp();
		Class classz2 = tc2.getClass();
		System.out.println("classz1==classz2:"+(classz1==classz2)+";classz1==TestClImp.class:"+(classz1==TestClImp.class));
		
		
		
	}
	
	/**
	 * 测试.class和getClass区别
	 * @throws ClassNotFoundException 
	 */
	public static void testGetClass() throws ClassNotFoundException{
		// TestClImp1继承了TestClImp
		TestClImp tc = new TestClImp1();
		Class classz1 = tc.getClass();
        Class classz2 = TestClImp1.class;
        
        Class classz3 = Class.forName("com.reflectTest.ClassTest$TestClImp1");
        System.out.println("classz1==classz2:"+(classz1==classz2)+"classz1==classz2:"+(classz1==classz3));
	}
	
	
	/**
	 * 测试getInterfaces方法
	 */
	public static void testGetInterfaces(){
		TestClImp1 tc = new TestClImp1();
		Class classz = tc.getClass();
		// 获取implements的接口，继承父类的接口,但是不获取
		Class[] cs = classz.getInterfaces();
		
		TestClImp tc1 = new TestClImp();
		Class classz1 = tc1.getClass();
		Class[] cs1 = classz1.getInterfaces();
		System.out.println("测试完");
	}
	
	public static interface TestCl extends TestC2{
		public void getName();
	}
	
	public static interface TestC2{
		
	}
	
	public static class TestClImp implements TestCl{

		
		public void getName() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public static class TestClImp1 extends TestClImp{
		
		public static String tt = "tt";
		
	}
}

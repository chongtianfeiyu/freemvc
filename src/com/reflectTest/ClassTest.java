package com.reflectTest;

/**
 * class�����
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
		// �ж�classz1�Ƿ���TestClImp1�����࣬Ϊfalse
		boolean result1 = TestClImp1.class.isAssignableFrom(classz1);
		// �ж�classz�Ƿ���TestClImp�����࣬Ϊtrue
		boolean result = TestClImp.class.isAssignableFrom(classz);
		System.out.println(result);
		
		//�ж������classz,classz1��TestClImp1.class�Ƿ�ͬһ��
		TestClImp tc2 = new TestClImp();
		Class classz2 = tc2.getClass();
		System.out.println("classz1==classz2:"+(classz1==classz2)+";classz1==TestClImp.class:"+(classz1==TestClImp.class));
		
		
		
	}
	
	/**
	 * ����.class��getClass����
	 * @throws ClassNotFoundException 
	 */
	public static void testGetClass() throws ClassNotFoundException{
		// TestClImp1�̳���TestClImp
		TestClImp tc = new TestClImp1();
		Class classz1 = tc.getClass();
        Class classz2 = TestClImp1.class;
        
        Class classz3 = Class.forName("com.reflectTest.ClassTest$TestClImp1");
        System.out.println("classz1==classz2:"+(classz1==classz2)+"classz1==classz2:"+(classz1==classz3));
	}
	
	
	/**
	 * ����getInterfaces����
	 */
	public static void testGetInterfaces(){
		TestClImp1 tc = new TestClImp1();
		Class classz = tc.getClass();
		// ��ȡimplements�Ľӿڣ��̳и���Ľӿ�,���ǲ���ȡ
		Class[] cs = classz.getInterfaces();
		
		TestClImp tc1 = new TestClImp();
		Class classz1 = tc1.getClass();
		Class[] cs1 = classz1.getInterfaces();
		System.out.println("������");
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

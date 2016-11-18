package com.javalangreflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * ���Է���
 * @author liaokangli
 *
 */
public class ReflectTest {
	
	public static void main(String[] args) throws Exception{
//		testArray();
//		testProxy();
		testReflectTest();
	}
	
	public static void testAccessibleObject(){
		AccessibleObject ao;
		
		Array a ;
	}
	
	/**
	 * ͨ��Array��������
	 */
	public static void testArray(){
		// ����������ʽ
		int[] intArray = {1,2,3};
		
		// ͨ��Array����
		Object array = Array.newInstance(int.class, 3);
		Array.set(array, 0, 1);
		Array.set(array, 1, 2);
		Array.set(array, 2, 3);
		
		System.out.println("lk");
		
	}
	
	/**
	 * ���Թ�����
	 */
	public static void testConstructor(){
		Constructor constructor;
		
	}
	
	/**
	 * �����ֶ�
	 */
	public static void testField(){
		Field field;
	}
	
	/**
	 * ���Է���
	 */
	public static void testMethod(){
		Method m;
	}
	
	/**
	 * �������η�
	 */
	public static void testModifier(){
		Modifier m;
	}
	
	/**
	 * ���Է���
	 */
	public static void testReflectTest(){
	  try{
		
		Object person = new Person();
		
		Class classz = person.getClass();
		
		Field field = classz.getDeclaredField("tt");
		field.setAccessible(true);
		field.set(person, "dd");
		
		Method method = classz.getMethod("getName", null);
		method.invoke(person, null);
		
		System.out.println("lk");
	  }catch(Exception e){
		  e.printStackTrace();
	  }
		
	}
	
	/**
	 * ���Զ�̬�����ࡣʹ�ýӿڣ�����̬�����ýӿڵ�ʵ����
	 */
	public static void testProxy() throws Exception{
		SubFoo subFoo = new SubFoo();
		InvocationHandler ph = new ProxyHandler(subFoo);
		Class proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(), new Class[]{Foo.class});
		Foo f = (Foo) proxyClass.getConstructor(new Class[]{InvocationHandler.class}).newInstance(new Object[]{ph});
		f.getName("bb");
	}
	
	
	
	
	public interface Foo{
		public void getName(String name);
	}
	
	public static class SubFoo implements Foo {

		
		public void getName(String name) {
			// TODO Auto-generated method stub
			System.out.println(name);
		}
		
	}
	
	/**
     * ��̬����
     * @author liaokangli
     *
     */
    static class ProxyHandler implements InvocationHandler{
    	private Object tar;
    	
    	public ProxyHandler(Object tar){
    		this.tar = tar;
    	}

		/** 
		 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
		 */
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			// TODO Auto-generated method stub
			System.out.println("��ʼ��̬����");
			Object result = method.invoke(tar, args);
			System.out.println("������̬����");
			return result;
		}
   	 
    }


}

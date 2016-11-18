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
 * 测试反射
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
	 * 通过Array操作数组
	 */
	public static void testArray(){
		// 基本创建方式
		int[] intArray = {1,2,3};
		
		// 通过Array创建
		Object array = Array.newInstance(int.class, 3);
		Array.set(array, 0, 1);
		Array.set(array, 1, 2);
		Array.set(array, 2, 3);
		
		System.out.println("lk");
		
	}
	
	/**
	 * 测试构造器
	 */
	public static void testConstructor(){
		Constructor constructor;
		
	}
	
	/**
	 * 测试字段
	 */
	public static void testField(){
		Field field;
	}
	
	/**
	 * 测试方法
	 */
	public static void testMethod(){
		Method m;
	}
	
	/**
	 * 测试修饰符
	 */
	public static void testModifier(){
		Modifier m;
	}
	
	/**
	 * 测试反射
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
	 * 测试动态代理类。使用接口，将动态产生该接口的实现类
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
     * 动态代理
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
			System.out.println("开始动态代理");
			Object result = method.invoke(tar, args);
			System.out.println("结束动态代理");
			return result;
		}
   	 
    }


}

/**
 * 19lou.com
 */
package com.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * jdk动态代理测试
 * 动态产生类，并对每个接口内的代码用invoke包括。
 * @author liaokangli
 *
 */
public class JdkProxyTest {
     public static void main(String[] args) {
		Person per1 = new Student();
		System.out.println(per1.getName("lkll"));
		
		Person per2 = new StaticProxy();
		System.out.println(per2.getName("lkll"));
		
		// 动态代理
		ProxyHandler proxyHandler = new ProxyHandler();
		Person per3 =(Person) proxyHandler.bind(new Student());
		System.out.println(per3.getName("dd"));
		
		System.out.println("==========");
		per3.tt();
	}
     
    
     
    interface Person extends SubPerson{
    	public String getName(String name);
    	
    	
    }
    
    interface SubPerson{
    	public void tt();
    }
    
    static class Student implements Person{
        
		/** 
		 * @see com.jdkproxy.JdkProxyTest.Person#getName()
		 */
		@Override
		public String getName(String name) {
			// TODO Auto-generated method stub
			System.out.println("中间");
			return name;
		}
		
		
		@Override
		public void tt(){
			System.out.println("tt");
		}
    	
    }
    /**
     * 静态代理
     * @author liaokangli
     *
     */
     static class StaticProxy implements Person{
    	Person person = new Student();

		/** 
		 * @see com.jdkproxy.JdkProxyTest.Person#getName(java.lang.String)
		 */
		@Override
		public String getName(String name) {
			// TODO Auto-generated method stub
			return person.getName(name);
		}

		
		@Override
		public void tt(){
			System.out.println("tt");
		}
    }
     
     /**
      * 动态代理
      * @author liaokangli
      *
      */
     static class ProxyHandler implements InvocationHandler{
         private Object tar;
         
         public Object bind(Object tar){
        	 this.tar = tar;
        	 Object result = Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{ Person.class}, this);
        	 return result;
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

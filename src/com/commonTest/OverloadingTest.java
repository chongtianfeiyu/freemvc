/**
 * 19lou.com
 */
package com.commonTest;

import java.io.IOException;

/**
 * 重载测试
 * @author liaokangli
 *
 */
public class OverloadingTest {
    public static void main(String[] args) throws IOException {
    	
		SubPerson per = new SubPerson();
		per.bark(10);
		
		per.bark();
	}
    
    public static class Person{
    	public void bark(){
    		System.out.println("Person bark");
    	}
    }
    
    public static class SubPerson extends Person{
    	public void bark(int a){
    		System.out.println("SubPerson bark:"+a);
    	}
    	public void bark(){
    		System.out.println("Person SubPerson bark:");
    	}
    	
    	// 方法名不变，参数个数变化，返回类型变化
    	public String bark(int a,int b){
    		return "aa"+a+":"+b;
    	}
    	
    	// 方法名不变，参数类型变化，返回类型不变
    	public void bark(String name){
    		System.out.println("overload bark:"+name);
    	}
    	
    	/**
    	 * 跟上面的方法，参数个数必须不一样。若把int b去掉，编译错误
    	 * @param name
    	 * @param b
    	 * @return
    	 */
    	public String bark(String name,int b){
    		return name+":"+b;
    	}
    }
}

/**
 * 19lou.com
 */
package com.commonTest;

import java.io.IOException;
import java.sql.SQLException;


/**
 * 重载测试
 * @author liaokangli
 *
 */
public class OverridingTest {
    public static void main(String[] args) throws Exception {
    	
    	SubPerson per = new SubPerson();		
		per.bark();
	}
    
    public static class Person{
    	  void bark()throws IOException{
    		System.out.println("Person bark");
    	}
    }
    
    public static class SubPerson extends Person{
    	public void bark(int a)throws IOException {
    		System.out.println("SubPerson bark:");
    	}
    	
    }
}

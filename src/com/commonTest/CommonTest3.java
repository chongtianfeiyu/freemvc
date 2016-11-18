/**
 * 19lou.com
 */
package com.commonTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.reflectTest.Student;

/**
 * @author liaokangli
 *
 */
public class CommonTest3 {
     public static void main(String[] args) {
    	String aa = "";
		new CommonTest3().getName();
		Map<String,String> d = new HashMap<String,String>();
		d.put("dd", "dd");
		
		String bb = d.get("dd");
		bb="cc";
		System.out.println();
		
		Map<String,Person> d1 = new HashMap<String,Person>();
		Person person = new Person();
		person.setName("cc");
		d1.put("dd", person);
		Person p1 = d1.get("dd");
		p1.setName("gh");
		System.out.println();
		
		int type =2;
		
		switch(type){
		case 1:
			type = 1;
			System.out.println("tt");
			break;
		case 2:
			type = 2;
			System.out.println("tt2");
	     default:
	    	 type = 4;
		}
		System.out.println(type);
	}
     
     public void getName(){
    	 SubClass sub = new SubClass();
    	 sub.ref2();
     }
     
     public static class Person{
    	 private String name;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
    	 
     }
}

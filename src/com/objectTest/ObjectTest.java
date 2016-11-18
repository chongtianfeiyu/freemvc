/**
 * 19lou.com
 */
package com.objectTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 面向对象引用测试
 * @author liaokangli
 *
 */
public class ObjectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String,Person> aa = new HashMap<String,Person>();
		
		aa.put("dd", new Person());
		
		Person person = aa.get("dd");
		
		person.setName("ttt");
		
		System.out.println("oooo");
		
		List<Person> tt = new ArrayList<Person>();
		
		tt.add(person);
		person.setName("mn");

		System.out.println("oooo");
	}
	
	public static class Person{
		private String name = "lkl";

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

/**
 * 19lou.com
 */
package com.listtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * list閫氱敤娴嬭瘯
 * @author liaokangli
 *
 */
public class CommonTest {
    public static void main(String[] args) {
    	// 娴嬭瘯indexof鐨勯噷闈㈢殑equals鏄垽鏂湴鍧�繕鏄�
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person();
		
		System.out.println("p1:"+p1);
		persons.add(p1);
		Person p2 = new Person();
		System.out.println("p2:"+p2);
		persons.add(p2);
		System.out.println("class equals:"+persons.indexOf(new Person()));
		
		List<String> strings = new ArrayList<String>();
		String str1 = new String("dddd");
		String str2 = new String("mndj");
		System.out.println("str1:"+str1);
		System.out.println("str2:"+str2);
		strings.add(str2);
		strings.add(str1);
		System.out.println("String:"+strings.indexOf(new String("aaa")));
		
		ConcurrentLinkedQueue clq;
	}
    
    public static class Person{
    	private int a = 0;
    	
    	private String str = new String("bnh");

		/**
		 * @return the a
		 */
		public int getA() {
			return a;
		}

		/**
		 * @param a the a to set
		 */
		public void setA(int a) {
			this.a = a;
		}
		
		
		
		/**
		 * @return the str
		 */
		public String getStr() {
			return str;
		}

		/**
		 * @param str the str to set
		 */
		public void setStr(String str) {
			this.str = str;
		}

		@Override
		public boolean equals(Object obj1) {
			if(this == obj1){
				return true;
			}
			if(this.a == ((Person) obj1).getA() && this.str.equals(((Person) obj1).getStr())){
				return true;
			}
			
			return false;
		}
    	
    }
}

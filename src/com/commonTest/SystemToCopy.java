/**
 * 19lou.com
 */
package com.commonTest;

/**
 * system copy is 深拷贝还是浅拷贝测试，运行结果知道是浅拷贝
 * @author liaokangli
 *
 */
public class SystemToCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Person[] persons = new Person[3];
        persons[0] = new Person();
        persons[1] = new Person();
        persons[2] = new Person();
        System.arraycopy(persons, 2, persons, 1, 1);
        persons[2] = null;
        System.out.println("ddd");
	}
	
	public static class Person{
		private String name = "ddd";
	}

}

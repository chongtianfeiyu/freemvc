/**
 * 19lou.com
 */
package com.reflectTest;

/**
 * @author liaokangli
 *
 */
public class ReflectTest {
	  private Class <? extends Person> personClass = Student.class;
	  
	  private int i = 1;
	  
      public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ReflectTest test = new ReflectTest();
		Person per = test.personClass.newInstance();
	 
	}
}

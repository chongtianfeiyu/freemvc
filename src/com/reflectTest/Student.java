/**
 * 19lou.com
 */
package com.reflectTest;

/**
 * @author liaokangli
 *
 */
public class Student implements Person{
     
	private String name;
	
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/** 
	 * @see com.reflectTest.Person#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}



}

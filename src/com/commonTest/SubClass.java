/**
 * 19lou.com
 */
package com.commonTest;

/**
 * @author liaokangli
 *
 */
public class SubClass extends FatherClass {

	/** 
	 * @see com.commonTest.FatherClass#ref1()
	 */
	@Override
	public void ref1() {
		// TODO Auto-generated method stub
		
	}
	
	public void ref2(){
		System.out.println("sub"+this);
		super.ref2();
	}
   
}

/**
 * 19lou.com
 */
package com.commonTest;

/**
 * @author liaokangli
 *
 */
public abstract  class FatherClass {

	private final Object obj = new Object();
	
	public  void ref(){
		synchronized(this.obj){
			System.out.println("obj");
		}
	}
	
	public abstract void ref1();
	
	public  void ref2(){
		System.out.println("super"+this);
	}
}

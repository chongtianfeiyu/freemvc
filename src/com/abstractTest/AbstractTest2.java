/**
 * 19lou.com
 */
package com.abstractTest;

/**
 * @author liaokangli
 *
 */
public class AbstractTest2 extends AbstractTest1{
	   public AbstractTest2(String name){
		    
		   	this(name,null);
		   }
		   public AbstractTest2(String name,String age){
		   	System.out.println(name+age);
		   }
}

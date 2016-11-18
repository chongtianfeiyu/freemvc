/**
 * 19lou.com
 */
package com.innerclass.test;

import com.innerclass.test.OuterClass.InnerClass1;
import com.innerclass.test.OuterClass.InnerClass2;

/**
 * @author liaokangli
 *
 */
public class OuterClass3 {
    
	public String age = "20岁";
	public InnerClass1 a = new InnerClass1();
	public InnerClass2 b = new OuterClass().new InnerClass2();
	public String getAge1(){
		return "";
	}
	
}

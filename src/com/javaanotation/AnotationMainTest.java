/**
 * 19lou.com
 */
package com.javaanotation;

/**
 * @author liaokangli
 *
 */

public class AnotationMainTest {
    public static void main(String[] args) {
		Class<AnotationTest> classz = AnotationTest.class;
		if(classz.getAnnotation(MyTable.class) != null){
			MyTable ann = classz.getAnnotation(MyTable.class);
			System.out.println("获取到:"+ann.value());
		}else{
			
			System.out.println("未获取到:"+classz.getAnnotation(MyTable.class));
		}
	}
}

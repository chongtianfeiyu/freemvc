/**
 * 19lou.com
 */
package com.commonTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  arraysList源码中
 * @author liaokangli
 *
 */
public class ArrayToArrayTest {
    public static void main(String[] args) {
		List<Object> l1 = new ArrayList<Object>(Arrays.asList(new Object(),new Object()));
		Object[] l1Array = l1.toArray();
		l1Array[0] = new Object();
		System.out.println(l1.get(0));
		
		List<String> aa = new ArrayList<String>(Arrays.asList("ddd","cccc"));
		Object[] aaAray = aa.toArray();
		aaAray[0] = new Object();
		System.out.println("true:"+aa.toArray().getClass());
		
	
		
		List l = Arrays.asList(new String[]{"aa","bb"});
        Object[] dd = l.toArray();
        dd[0] = new Object();
        System.out.println(l.toArray());
        System.out.println(l.toArray(new Object[0]));
        
        
	}
}

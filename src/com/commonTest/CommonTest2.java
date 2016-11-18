/**
 * 19lou.com
 */
package com.commonTest;

import java.io.UnsupportedEncodingException;

/**
 * @author liaokangli
 *
 */
public class CommonTest2 {
       public static void main(String[] args) throws UnsupportedEncodingException {
		AA a1 = new AA();
		AA a2 = new AA();
		a1.ref1();
		a2.ref1();
		String orStr = "马术俱乐部";
    	System.out.println("范的gbk,十六进制:"+Hex.encodeHexStr(orStr.getBytes("gbk")));
	}
       
    static class AA extends FatherClass{
    	private final FatherClass aa = new SubClass();
    	
    	public void getObject(){
    		System.out.println(aa);
    	}

		/** 
		 * @see com.commonTest.FatherClass#ref1()
		 */
		@Override
		public void ref1() {
			// TODO Auto-generated method stub
			
		}

    }
}

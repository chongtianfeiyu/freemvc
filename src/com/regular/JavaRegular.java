package com.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java正则
 * @author liaokangli
 *
 */
public class JavaRegular {
	
	public static void main(String[] args){
		
	}
	
	/**
	 * 正常使用
	 */
	public static void patternNormal(){
		
		Pattern pattern = Pattern.compile("a*b");
		Matcher m = pattern.matcher("aaaab");
		boolean b = m.matches();
		
		boolean flag = Pattern.matches("a*b", "aaaab");
		
	}

}

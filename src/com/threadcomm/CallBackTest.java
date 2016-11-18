package com.threadcomm;

/**
 * 回调接口
 * @author liaokangli
 *
 */
public class CallBackTest {
	
	public static void main(String[] args){
		Wang wang = new Wang(new Li());
		wang.askQuestion("中国");
		
	}

}

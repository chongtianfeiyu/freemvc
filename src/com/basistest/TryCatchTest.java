package com.basistest;

/**
 * 测试try...catch
 * @author liaokangli
 *
 */
public class TryCatchTest {
	
	public static void main(String[] args){
//		testTryFinally();
//		Person person = testTryFinally2();
//		System.out.println(testTryFinally4());
//		testTryFinally5();
//		System.out.println(testTryFinally3());
		System.out.println(testTryCatchFinally());
	}
	
	/**
	 * 
	 */
	public static void testTryFinally(){
		

		
		String str = null;
		try{
			str.trim();
		}finally{
			System.out.println("tt");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static Person testTryFinally2(){
		Person person = new Person();
		person.str = "1";
		try{
			return person;
		}finally{
			person.str = "3";
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static String testTryFinally4(){
		try{
			
			System.out.println("tt");
			return "a";
			
		}finally{
			return "b";
		}
	}
	
	/**
	 * return语句是值拷贝，不是引用拷贝，输出为1；
	 * @return
	 */
	public static String testTryFinally3(){
		String str = "1";
		try{
//			System.out.println("tt");
			return str;
		}finally{
			str = "3";
//			return str;
            
		}

	}
	
	/**
	 * 嵌套try finally
	 * @return
	 */
	public static String testTryFinally5(){
		try{
		
			System.out.println("tt");
			try{
				System.out.println("yy");
			 return "bb";
			}finally{
				System.out.println("nn");
			}
		}finally{
			System.out.println("cc");
		}
	}
	
	/**
	 * try catch finally
	 * 
	 * @return
	 */
	public static String testTryCatchFinally(){
		String str = null;
		try{
			str.trim();
			return str;
		}catch(Exception e){
			return str;
		}finally{
			str = "3";
			
		}
	}
	
	public static class Person{
		public String str = "";
	}

}

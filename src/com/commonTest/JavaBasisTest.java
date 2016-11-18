package com.commonTest;

public class JavaBasisTest {


	public static void main(String[] args){
		SubPerson.getName();
	}
	
	
	public static class SubPerson extends Person{
//        public static void getName(){
//			System.out.println("sub");
//		}
	}
	
	
	public static class Person{
		public static void getName(){
			System.out.println("per");
		}
	}
	
	
}

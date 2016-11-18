package com.javatype;

public class TypeTest {
	
	
	public enum TypeKind{
		 COUS_1("1",2);
		
		private String name;
		private int age;
		
		private TypeKind(String name,int age){
			this.name = name;
			this.age = age;
		}
	}

	
	public static void main(String[] args){
		
	}

}

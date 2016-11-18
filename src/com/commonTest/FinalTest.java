package com.commonTest;

/**
 * final测试 只初始化一次
 * @author liaokangli
 *
 */
public class FinalTest {
	public static String hhh = "";
	
	public String aa = "";
   
	public static void main(String[] args){
		FinalAA aa = new FinalAA(new Person());
//		aa.per = new Person();
		
		System.out.println("jieshu:"+Person.name3);
		
		SubPerson aa1 = new SubPerson();
		aa1.setName();
		
		SubPerson1 aa2 = new SubPerson1();
		aa2.setName();
		
		System.out.println("jieshu:"+Person.name3);
		
		
		
	}
	
	public static class FinalAA{
		private final Person per;
		private int dd;
		public FinalAA(Person person){
			per = person;
		}
		
	}
	
	public static class Person implements DD,CC{
		private String name1;
		private String name2;
		public static String name3;
		public Person(){
			this.name1 = DD.name;
			this.name2 =CC.name;
		}

	}
	
	public static class SubPerson extends Person{
		public void setName(){
			name3="dd";
		}
	}
	
	public static class SubPerson1 extends Person{
		public void setName(){
			name3="cc";
		}
	}
	
	static interface DD{
		String name = "aa";
//		public void setName();
	}
	static interface CC{
		String name = "bb";
	}
}

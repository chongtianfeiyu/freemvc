package com.commonTest;

/**
 * 构造器知识
 * 1、对于继承来说，
 * --前提：在父类和子类中分别含有无参构造函数和有参构造函数
1.在主函数中定义一个子类变量（无参），执行子类中的无参构造函数之前先执行父类的构造函数
a.子类中没有写调用父类的构造函数，则默认调用父类中的无参构造函数。
b.子类中调用父类的无参构造函数，则执行父类中的无参构造函数。
c.子类中调用父类的有参构造函数，则执行父类中的有参构造函数。

2.在主函数中定义一个子类变量（有参），执行子类中的有参构造函数之前先执行父类的构造函数
a.子类中没有写调用父类的构造函数，则默认调用父类中的无参构造函数。
b.子类中调用父类的无参构造函数，则执行父类中的无参构造函数。
c.子类中调用父类的有参构造函数，则执行父类中的有参构造函数。
 * @author liaokangli
 *
 */
public class ConstrustorTest {
	
	public static void main(String[] args){
		SubPerson subperson = new SubPerson("dd");
	}
	
	public static class Person{
		public Person(){
			System.out.println("ty");
		}
		public String name;
		public Person(String name){
			this.name = name;
		}
		
		
	}
	
	public static class SubPerson extends Person{
		
		public String name;
		
		public SubPerson(){
//			super();
			System.out.println("uy");
		}
		
		public SubPerson(String name) {
			super(name);
			// TODO Auto-generated constructor stub
			this.name = name;
		}
		
	}

}

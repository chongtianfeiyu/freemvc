package com.commonTest;

/**
 * ������֪ʶ
 * 1�����ڼ̳���˵��
 * --ǰ�᣺�ڸ���������зֱ����޲ι��캯�����вι��캯��
1.���������ж���һ������������޲Σ���ִ�������е��޲ι��캯��֮ǰ��ִ�и���Ĺ��캯��
a.������û��д���ø���Ĺ��캯������Ĭ�ϵ��ø����е��޲ι��캯����
b.�����е��ø�����޲ι��캯������ִ�и����е��޲ι��캯����
c.�����е��ø�����вι��캯������ִ�и����е��вι��캯����

2.���������ж���һ������������вΣ���ִ�������е��вι��캯��֮ǰ��ִ�и���Ĺ��캯��
a.������û��д���ø���Ĺ��캯������Ĭ�ϵ��ø����е��޲ι��캯����
b.�����е��ø�����޲ι��캯������ִ�и����е��޲ι��캯����
c.�����е��ø�����вι��캯������ִ�и����е��вι��캯����
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

package com.classtest;

/**
 * class ¿‡≤‚ ‘
 * @author liaokangli
 *
 */
public class ClassTest {
	
	public static void main(String[] args){
		ClassImpl aa = new ClassImpl();
		String name = aa.getClass().getInterfaces()[0].getName();
		String name1 = ClassService.class.getInterfaces()[0].getName();
		System.out.println(name+":"+name1);
	}
	
	interface ClassService extends Simple{
		
		public void getName();
	}
	
	interface Simple{
		public void tt();
	}
	
	interface normal{
		public void tt1();
	}
	static class ClassImpl implements ClassService,normal{

		@Override
		public void getName() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void tt() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void tt1() {
			// TODO Auto-generated method stub
			
		}
		
	}

}

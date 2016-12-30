package study2016.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口可以new
 * @author liaokangli
 *
 */
public class NewInterface {
	
	public static void main(String[] args){
		newInterface();
	}
	
	/**
	 * 
	 */
	public static void newInterface(){
		List<TestInter> testInters = new ArrayList<TestInter>();
		testInters.add(new SubTest1());
		testInters.add(new SubTest2());
		testInters.add(new SubTest3());
		
		testInters.toArray(new TestInter[0]);
		
		System.out.println("tt");
		
		// 还可以这么使用。接口不是不能被实例化的吗？
		TestInter[] tests = new TestInter[100];
		
		// complier error
//		TestInter test = new TestInter();
	}
	
	/**
	 * 接口
	 * @author liaokangli
	 *
	 */
	public static interface TestInter{
		public void getName();
	}
	
	public static class SubTest1 implements TestInter{

		@Override
		public void getName() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static class SubTest2 implements TestInter{

		@Override
		public void getName() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static class SubTest3 implements TestInter{

		@Override
		public void getName() {
			// TODO Auto-generated method stub
			
		}
		
	}

}

package com.commonTest;

/**
 * ≥ÈœÛ¿‡≤‚ ‘
 * @author liaokangli
 *
 */
public  class AbstractClassTest {
	
	public  class DD implements SubPer{

		@Override
		public void getName() {
			// TODO Auto-generated method stub
			
		}


		
	}
    
	
	public interface SubPer extends Person{
//		void getName();
	}
	
	public static interface Person{
		
		public abstract  void getName();
	}
	
}

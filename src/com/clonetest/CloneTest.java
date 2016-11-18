/**
 * 19lou.com
 */
package com.clonetest;

/**
 * 娴呭鍒跺拰娣卞鍒舵祴璇�
 * @author liaokangli
 *
 */
public class CloneTest {
     public static void main(String[] args) throws CloneNotSupportedException {
    	 Employer employer = new Employer();
    	 employer.clone();
	}
	
     
     /**
      * 瀹炵幇娴呭鍒�
      * @author liaokangli
      *
      */
	public static class Employer implements Cloneable{
		private String name;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public Object clone()throws CloneNotSupportedException{
			return super.clone();
		}
	}
	
	public static class Employee implements Cloneable{
		
	}
}

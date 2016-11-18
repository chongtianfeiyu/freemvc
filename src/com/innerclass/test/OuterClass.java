/**
 * 19lou.com
 */
package com.innerclass.test;

/**
 * 外部类测试
 * @author liaokangli
 *
 */
public class OuterClass {
    private String sex;
    private static String name = "chenssy";
    
    public InnerClass2 d = new InnerClass2();
    
   
   
    /**
     * 静态内部类
     * @author liaokangli
     *
     */
    public static class InnerClass1 extends OuterClass1{
    	public static String name1 = "chenssy_static";

    	public void display(){
    		System.out.println("Outter Class:"+name);
    	}
		/** 
		 * @see com.innerclass.test.OuterClass1#geName1()
		 */
		@Override
		public void geName1() {
			// TODO Auto-generated method stub
			System.out.println("innerClass1");
		}
    	
    }
    
    /**
     * 非静态内部类
     * @author liaokangli
     *
     */
    public class InnerClass2 extends OuterClass2{
    	public String name2 = "chenssy_no_static";
    	public void display(){
    		System.out.println("Outer Class:"+name+":"+sex);
    	}
    	public OuterClass getOuterClass(){
    		return OuterClass.this;
    	}
		/** 
		 * @see com.innerclass.test.OuterClass2#getName2()
		 */
		@Override
		public void getName2() {
			// TODO Auto-generated method stub
			System.out.println("innerClass2");
		}
    }
    
    /**
     * 外围类方法
     */
    public void display(){
    	/** 静态内部类相关信息的访问*/
    	System.out.println(InnerClass1.name1+":");
    	new InnerClass1().display();
    	
    	OuterClass.InnerClass2 inner = new OuterClass().new InnerClass2();
    	
    	System.out.println(inner.name2);
    	inner.display();
    }
    
    /**
     * 局部内部类
     * @return
     */
    public OuterClass3  display1(String age){
    	class PdDestionation extends OuterClass3{
    		private String age1;
    		
    		public PdDestionation(String age1){
    			this.age1 = age1;
    		}
    		
    		public String getAge1(){
    			return age1;
    		}
    	}
    	return new PdDestionation(age);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         OuterClass outer = new OuterClass();
         outer.display();
         System.out.println(outer.display1("40").getAge1());
         
         OuterClass1 outer1 = new OuterClass1() {
			
			@Override
			public void geName1() {
				// TODO Auto-generated method stub
				System.out.println("匿名内部类");
			}
		};
		outer1.geName1();
		
	}

}

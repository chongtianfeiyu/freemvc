/**
 * 19lou.com
 */
package com.abstractTest;

/**
 * 类初始化顺序测试
 * @author liaokangli
 *
 */
public class ClassInitOrderTest {
    public static void main(String[] args) {
		Children d = new Children("wer");
		System.out.println(d.age+":"+d.dfg);
		
		AbstractTest1 test = new AbstractTest2("wo");
	    System.out.println(test);
	}
    
    public static abstract class Parent{
    	public static final String ALERT_NAME="LKL";
    
    	static{
    		System.out.println(ALERT_NAME);
    	}
    	
    	private String ert = "ert";
    	
    	public String dfg = "dfg";
    }
    
    public static class Children extends Parent{
        private String age = "18岁以上";
        
        public static String ddd = "ddd";
        
        static{
        	System.out.println(ddd);
        }
        
        public Children(String name){
        	this(name,null);
        }
        public Children(String name,String age){
        	System.out.println(name+age);
        }
    }
}

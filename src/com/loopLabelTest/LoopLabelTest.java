/**
 * 19lou.com
 */
package com.loopLabelTest;

/**
 * @author liaokangli
 *
 */
public class LoopLabelTest {
    public static void main(String[] args) {
    	test1();
    	System.out.println("===========测试2=======");
    	test2();
	}
    
    public static void test1(){
    	outer: 
            for(int i=0; i<3; i++) { 
                System.out.print("Pass " + i + ": "); 
                inner:
                for(int j=0; j<100; j++) { 
                    if(j == 10) 
                        break inner; // exit both loops 
                    System.out.print(j + " "); 
                } 
                System.out.println("This will not print"); 
            } 
            System.out.println("Loops complete."); 
    }
    
    public static void test2(){
    	outer: 
            for(int i=0; i<3; i++) { 
                System.out.print("Pass " + i + ": "); 
                for(int j=0; j<100; j++) { 
                    if(j == 10) 
                        break outer; // exit both loops 
                    System.out.print(j + " "); 
                } 
                System.out.println("This will not print"); 
            } 
            System.out.println("Loops complete."); 
    }
}

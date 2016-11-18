/**
 * 19lou.com
 */
package com.threadTest;

/**
 * @author liaokangli
 *
 */
public class GuardedTest {
	 boolean joy = false;
    public static void main(String[] args) {
    	final GuardedTest guard = new GuardedTest();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				guard.guardJoy();			
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				guard.setJoy(true);
				notifyAll();
			}
		});
		t2.start();
	}
    
     public  void guardJoy(){
    	 while(!joy){
    		 try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 System.out.println("joy sucess has been set");
     }
     
     public  void setJoy(boolean joy){
    	 this.joy = joy;
    	 System.out.println("joy的值："+this.joy);
     }
}

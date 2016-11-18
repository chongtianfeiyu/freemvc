/**
 * 19lou.com
 */
package com.threadTest;

/**
 * @author liaokangli
 *
 */
public class ThreadDeadLockTest {
     public static void main(String[] args) {
		final Friend gs = new ThreadDeadLockTest(). new Friend("aa");
		final Friend df = new ThreadDeadLockTest().new Friend("bb");
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				gs.bow(df);
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				df.bow(gs);
				
			}
			
		}).start();
	}
     
     class Friend{
    	private String name = "";
    	public Friend(String name){
    		this.name = name;
    	}
    	public String getName(){
    		return name;
    	}
    	public synchronized void bow(Friend friend){
    		System.out.format("%s:%s" + " has bowed to me!%n", this.name,friend.getName());
    		friend.bowback(this);		
    	}
    	public synchronized void bowback(Friend friend){
    		System.out.format("%s:%s" + " has bowed back to me!%n", this.name,friend.getName());
    	}
    }
}

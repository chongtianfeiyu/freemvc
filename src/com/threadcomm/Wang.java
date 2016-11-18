package com.threadcomm;

public class Wang implements CallBack{
	
	private Li li;
	
	public Wang(Li li){
		this.li = li;
	}
	
	public void askQuestion(final String question){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				li.executeMessage(Wang.this, question);
			}
			
		}).start();
		
		play();
	}
	

	@Override
	public void solve(String result) {
		// TODO Auto-generated method stub
		System.out.println("=================="+result);
	}
	
	public void play(){  
        System.out.println("我要逛街去了");  
    }  

}

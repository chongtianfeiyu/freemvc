package com.threadTest.locks;

import java.util.concurrent.atomic.AtomicInteger;

public class TT {
   public AtomicInteger at = new AtomicInteger();
   
   public int c = 10;
	
	public static void main(String[] args){
		TT tt = new TT();
		if(tt.at.get() == tt.c){
			System.out.println("tt");
		}
		
	}
	
	
	
}

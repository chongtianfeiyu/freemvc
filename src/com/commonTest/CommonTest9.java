package com.commonTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CommonTest9 {

	
	public static void main(String[] args) throws ParseException{
//		getName();
//		
//		System.out.println("bb");
//		
//		printlnName();
		
		String regixStr = "00f0#1#10001394709831569#20140313";
		String regixStr1 = "0000#1#1";
		System.out.println(regixStr.matches("\\w{4}(#)\\d+(#)\\d+(#)\\d+"));
		System.out.println(regixStr1.matches("\\w{4}(#)\\d+(#)\\d+(#)\\d+"));
		
		String tt = "d0xxxdxxxd";
		System.out.println(tt.matches("(d)(\\w+)"));
		
		String tt1 = "00091";
		System.out.println(tt1.matches("\\w{4}"));
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(1449108404153L);
		System.out.println(sf.parse("2016-01-18 12:00:00").getTime());
		System.out.println(sf.parse("2016-01-18 12:00:05").getTime());
		System.out.println(date.getTime());
		
		System.out.println(":"+UUID.randomUUID());
		
	    boolean flag = getflag();
	    System.out.println(flag);
	    
	    System.out.println("=============");
	    String st = "2b2b#32657567#18041461484698160#hangzhou#app#20160425^-1";
	    System.out.println(st.matches("\\w{4}(#)\\d+(#)\\d+(#)\\w+(#)\\w+(#)\\d{8}(\\^-)\\w+"));
		
	}
	
	public static boolean getflag(){
	   
	   for(int i = 1;i<10;i++){
			if(i==5){
				return false;
			}
		}
	   System.out.println("tt");
	return false;
	}
	
	public static void getName(){
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			  try{
				  
				Thread.sleep(10000);
				System.out.println("tt");
			  }catch(Exception e){
				  e.printStackTrace();
			  }
			}
			
		}).start();
	}
	
	public static void printlnName(){
		System.out.println(Thread.currentThread().getName());
	}
}

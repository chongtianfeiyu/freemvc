package com.commonTest;

/**
 * ��ʼ������.
 * ����static�������ᴥ����ʼ���ࣨ��̬�ֶΣ�
 * @author liaokangli
 *
 */
public class InitialTest {
	
     public static void main(String[] args){
    	 InitialTest1.getName();
    	 
    	 float i=2f*0.1f;
 		System.out.println(i);
 		System.out.println(i == 0.5);
     }
     
     public static class InitialTest1{
    	 public static String aa = "dd";
    	 
    	 static{
    		 hj = "bb";
    	 }
    	 public static String hj = "lk";
    	 private String dd = "ttt";
    	 
    	 public static void getName(){
    		 System.out.println("dd");
    	 }
     }

}

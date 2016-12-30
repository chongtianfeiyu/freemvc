package com.commonTest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liaokangli
 *
 */
public class CommonTest10 {
	
	public static void main(String[] args){
		SubPerson subPerson = new SubPerson("ttt");	
		System.out.println("ttts:"+subPerson.getName());
		System.out.println("parent object from child object:"+subPerson.getParentObject());
//		String tt = "wap_bbs_gbt_160703_24xsgdxw_125_53971467529316305%2Cwap_ent_gbt_160703_24xsgdxw_125_5397146752931630";
		String tt = "2wap_pagelist_pagedown";
		int value = tt.hashCode();
		
		System.out.println("hashcode:"+value);
//	    char val[] = tt.toCharArray();
//	    for (int i=0;i<val.length;i++){
//	    	int acc = val[i];
//	    	System.out.println(val[i]+":"+acc);
//	    }
	    
	    int tt1 = 1122145114;
	    tt1 = tt1 *31;
	    System.out.println(tt1);
	    System.out.println(~(1122145114*31)+1);
	    System.out.println(Integer.toHexString(~(1122145114*31)+1));
	    
	    // 11010000100110111111001111010111 低32位的高位为1,是负数
		int tts = 112899401*31;
		System.out.println("tts:"+tts+";"+(~(112899401*31)+1));
		
		// 11111111111111111111111111111010 01000010111000101001001011100111 低32位的高位为0,是正数
		int tts1 = -795085767*31;
		System.out.println("tts1:"+tts1);
		
		//1000 00011001011011111101011111100110 低32位的高位为0,是正数
		int tts2 = 1122145114*31;
		System.out.println("tts2:"+tts2+";"+(~(1122145114*31)+1));
		
		//11111111111111111111111111110111 11100110100100000010100000011010 低32位的高位为1,是负数
		int tts3 = -1122145114*31;
		System.out.println("tts3:"+tts3+";"+(~(-1122145114*31)+1));
		
		
		List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
		List<String> stringList = new ArrayList<String>();
		Class<? extends List> classz = stringList.getClass();
		ParameterizedType actualType = (ParameterizedType)classz.getGenericSuperclass();
		Class<?> classz1 = (Class<?>) actualType.getActualTypeArguments()[0];
		System.out.println("tt"+classz1);
	}
	
	public static class Person{
		private String name;
		
		public Person(String name){
			this.name = "tttt";
			System.out.println("parent object:"+this);
		}

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
		
		public Person getPerson(){
			return this;
		}
		
	}
	
	public static class SubPerson extends Person{

		public SubPerson(String name) {
			super(name);
			
			System.out.println("============");
			// TODO Auto-generated constructor stub
		}
		
		public Person getParentObject(){
			return getPerson();
		}
		
	}

}

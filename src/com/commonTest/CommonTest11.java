package com.commonTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CommonTest11 {

	public static void main(String[] args) throws ParseException{
		boolean error = false;
		boolean isOpen = false;
		assert isOpen = true;
//		assert error;
//		System.out.println(isOpen);
//		assert error;
		
		
		Map<String,Map<String,String>> ruleMap = new HashMap<String,Map<String,String>>();
		Map<String,String> items = new HashMap<String,String>();
		items.put("主题内容", "2,100");
		items.put("uv", "30");
		items.put("发帖人", "1111,22222");
		ruleMap.put("hangzhou_美食", items);
		
//		if(isTest()){
//			System.out.println("tt");
//		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time1 = sdf.parse("2017-12-19 15:12:00").getTime();
		long time2 = sdf.parse("2016-12-19 15:32:00").getTime();
		System.out.println(time1+":"+time2);
		
		Random random = new Random();
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i < 100;i++){
			Integer number = 7000+random.nextInt(100);
			set.add(number);
		}
		
		int port = 7000 +  random.nextInt(1000);
		
		List<String> aa = new ArrayList<String>();
		aa.add("tt");
		aa.add("bb");
		aa.add("cc");
		List<String> as = aa.subList(0, 2);
		System.out.println("ts");
		
		
		//
		List<String> bb = new ArrayList<String>();
		bb.add("tt1");
		bb.add("bb");
		bb.add("cc");
		
		Date now = new Date();
		System.out.println(sdf.format(now));
		Date now_10 = new Date(now.getTime() - 600000); //10分钟前的时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		String nowTime_10 = dateFormat.format(now_10);
		System.out.println(nowTime_10);
		
		
		Person person = new SubPerson();
		try {
			person.bark();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str1 = "《同妻连枝》正剧+古穿今/宠文/婚后/日更";
		try {
			// 编码
			byte[] bytes = str1.getBytes("UTF-8");
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SubPerson1 s1 = new SubPerson1();
		SubPerson1 s2 = s1.clone();
		
		System.out.println("tt");
		
		
		testFinally();
		
		Class classz = HashMap.class;
		
		double aa1 = Math.log10(0.0);
		System.out.println("tt");
		
		int a = -1;
		
		Date date = sdf.parse("0000-00-00 00:00:00");
		
		System.out.println("tt");
		
		String a2 = "1,2,3";
		
		new ArrayList(Arrays.asList(new String[]{}));
		Collections.addAll(bb, a2.split(","));
		TopK ad;
		
        String[] two = null;
		
		String[][] astwo = {{"A","B","C"}};
		
		String[] aone = {"A","B"};
		
		two = aone;
		
		String aert = "hj,hn,hu,ho";
		List<String> ls = Arrays.asList(aert.split(","));
		List<String> ls1 = ls.subList(0, 3);
		List<String> ls2 = ls.subList(0, 5);
		System.out.println("ls1");
		
		System.out.println("object size:");
		
		System.currentTimeMillis();
		
		
	}
	
	public static int testFinally(){
		try{
			System.out.println("ttrt");
			isTest();
			return 0;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
			System.out.println("sssert");
		}
		return 0;
	}
	
	
	public static boolean isTest(){
		throw new RuntimeException();
	}
	
	public static class Person{
		
		
		public void bark() throws Exception{
			
			System.out.println("tt");
		}
	}
	
	
	public static class SubPerson extends Person{
		// 重写父类方法，抛出子异常
		@Ano(required = true)
		public void bark() throws IOException{
			System.out.println("bb");
		}
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
	public static @interface Ano{
		boolean required() default false;
	}
	
	public static class SubPerson1 implements Cloneable{
		
		public String name = "aa";
		
		public Long age = 100l;
		
		public Date date = new Date();
		
		public Integer i = 0;
		
		public SubPerson1 clone(){
			SubPerson1 result = null;
			try {
				 result = (SubPerson1) super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		
		
		
	}
}

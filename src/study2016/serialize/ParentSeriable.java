package study2016.serialize;

import java.io.Serializable;

/**
 * 实现了序列化类
 * 1、这个类包含了四种修饰符的字段，查看序列化对作用域的字段序列化情况
 * 2、里面包含了两种修饰符的方法，查看序列化后方法是否序列化
 * @author liaokangli
 *
 */
public class ParentSeriable implements Serializable{
	
	public String name = "tt";
	
	protected int age = 100;
	
	private String rt = "rt";
	
	String wq = "wq";
	
	/** 静态成员变量不会被序列化**/
	public static String uo = "uo";
	
	/** 静态成员变量不会被序列化**/
	public static final String op = "op";
	
	public SubParentSeriable sps = new SubParentSeriable();
	
	public String getName(String name){
		return name;
	}
	
	private int getAge(int age){
		return age;
	}
	
	public static void getUo(){
		System.out.println("uo:"+uo);
	}

}

/**
 * 19lou.com
 */
package com.seriases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.reflectTest.Student;

/**
 * 对象序列化
 * @author liaokangli
 *
 */
public class SerializTest {
    public static void main(String[] args) {
    	
          Employee em = new Employee();
          em.name="lkl";
          em.adress="dd";
          em.SSN=12345;
          em.number=4567;
          FileOutputStream f1 = null;
          ObjectOutputStream out = null;
         
          // 序列化
          try {
			f1 = new FileOutputStream("e:\\employee.ser1");
			out = new ObjectOutputStream(f1);
			out.writeObject(em);
			System.out.print("seri");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(f1 != null){
				try {
					f1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
          
        // 反序列化
        Employee em1 = null;
        FileInputStream in = null;
        ObjectInputStream obIn = null;
        try{
        	in = new FileInputStream("e:\\employee.ser");
        	obIn = new ObjectInputStream(in);
        	em1 = (Employee)obIn.readObject();
        	em1.mailCheck();
        	System.out.println("成功");
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(in != null){
        		try{
        			in.close();
        		}catch(Exception e){
        			e.printStackTrace();
        		}
        	}
        	if(obIn != null){
        		try{
        			obIn.close();
        		}catch(Exception e){
        			e.printStackTrace();
        		}
        	}
        }
	}
       
    static class Employee implements Serializable{
    	static final  long serialVersionUID = -6412357711185893769l;
    	private String name;
    	public String adress;
    	public transient int SSN;
    	public int number;
    	public transient Person per = new Person();
    	public static String nameS = "dd";
//    	//序列化后新增加字段：
//    	public int aa = 90;
    	public void mailCheck(){
    		System.out.println("jiaanc");
    	}
    }
    
    static class Person implements Serializable{
    	private int age = 200;
    }

}

package study2016.io.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;

/**
 * 对象输出流,常常使用在对象序列化中
 * @author liaokangli
 *
 */
public class IOObjectOutputStream {
	
	public static void main(String[] args){
//		objectOutputStreamNormal();
		ObjectOutputStreamInt();
//		ObjectOutputStreamByte();
		
//		ObjectOutputStreamPut();
	}
	
	/**
	 * 对象输出流。非transient和非static可以序列化
	 */
	public static void objectOutputStreamNormal(){
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f:\\oos.txt"));
			oos.writeObject(AT.CODE1);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 对象输出流。整型
	 */
	public static void ObjectOutputStreamInt(){
		try{
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f:\\oos1.txt"));
			oos.writeInt(64);
			oos.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 对象输出流。字节
	 */
	public static void ObjectOutputStreamByte(){
		try{
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f:\\oos1.txt"));
			oos.write(new byte[]{10,5,8});
			oos.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * put类
	 */
	public static void ObjectOutputStreamPut(){
       try{
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f:\\oos1.txt"));
			oos.writeObject(new OOS());
			PutField putFields = oos.putFields();
			oos.flush();
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public static class OOS implements Serializable{
		private String name = "tt";
		
		public static int fg = 100;
		
		
		public transient String fn = "sh";
		
		private OOSsub oosSub = new OOSsub();
		
		public AT at = AT.CODE1;
		
		// 一定要这个方法，否则ObjectOutputStreamPut方法里面使用oos.putFields抛异常
		private void writeObject(ObjectOutputStream out)
	              throws IOException {

	         // write into the ObjectStreamField array the variable string
	         ObjectOutputStream.PutField fields = out.putFields();
	         fields.put("name", name);
	         out.writeFields();
	         System.out.println("tt");

	      }
	}
	
	public static class OOSsub implements Serializable{
		private int age = 100;
	}
	
	public enum AT{
		CODE1("tt",10);
		
		private String name;
		private int age;
		
		
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


		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}


		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}


		private AT(String name,int age){
			this.name = name;
			this.age = age;
		}
		
		
		
		
		
	}

}

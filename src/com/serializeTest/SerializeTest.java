package com.serializeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import org.objenesis.strategy.StdInstantiatorStrategy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

/**
 * 序列化测试。
 * 1、对象中含有未序列化的对象，不可序列化,抛异常
 * 2、A继承了可序列化的类B，A也是可序列化的
 * @author liaokangli
 *
 */
public class SerializeTest {

	
	public static void main(String[] args) throws Exception{
	
//		ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream("G:\\testOuptStream"));
//		obos.writeObject(new Person(""));
//		
//		// 反序列化
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:\\testOuptStream"));
//		Object object = ois.readObject();
//		System.out.println("dd");
		long time1 = new Date().getTime();
		testKryo();
		long time2 = new Date().getTime();
		testObjectOutputStream();
		long time3 = new Date().getTime();
		
		System.out.println("----time1:"+(time2-time1));
		
		System.out.println("----time2:"+(time3-time2));
	}
	
	/**
	 * 测试kryo序列化方式 序列化后的大小是比java小多了。而且速度比java快
	 * @throws FileNotFoundException 
	 */
	public static void testKryo() throws FileNotFoundException{
		
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		kryo.setRegistrationRequired(false);
		kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		Output output = new Output(new FileOutputStream("G:\\dd\\kryo.bin"));
		kryo.writeClassAndObject(output, Simple.getSimple());
		output.flush();
	}
	
	/**
	 * 测试java序列化方式
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void testObjectOutputStream() throws FileNotFoundException, IOException{
		ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream("G:\\dd\\java.bin"));
		obos.writeObject(new Simple());
	}
	
	
	public static class Simple implements Serializable{
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
		
		static Simple getSimple(){
			    Simple simple = new Simple();  
			    simple.setAge(10);  
			    simple.setName("XiaoMing");  
			    return simple; 
		}
	}
	
	public static class Person extends Info implements Serializable{
		public Person(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}

		public static final  long serialVersionUID = 495610423144760435L;
		private String age = "dd";
		
//		private static Info ttt = new Info();
		
		private Class classz = Info.class;
	}
	
	public static class Info {
		private String name ="lkl";
		
		public Info(String name){
			
		}
	}
}

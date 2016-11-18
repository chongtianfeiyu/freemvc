package com.javalang;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.commonTest.CharacterTest;

/**
 * java.lang������
 * @author liaokangli
 *
 */
public class JavaLangTest {
	
	public static void main(String[] args) throws IOException{
//		testCharacter();
//		testClass();
//		testClassLoader();
//		testInheritableThreadLocal();
		testStrings();
//		testSystem("tt");
	}
	
	public static void testCharacter(){
		Character ct = new Character('c');
		
	
	}
	
	public static void testClass(){
	   try{
		Class ctt = CharacterTest.class;
		CharacterTest ct = (CharacterTest) ctt.newInstance();
		System.out.println(ct);
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	    
	}
	
	/**
	 * �����Զ����������
	 */
	public static void testClassLoader(){
		
		// name ����Ϊbinary name.���磺ThreadΪjava.lang.Thread
		NetworkClassLoader loader = new NetworkClassLoader("tt.Test","D:\\19lou\\workspace\\Test\\bin\\");
		
		Class clz = loader.findClass("tt.Test");
		try {
			Object object = clz.newInstance();
			Class[] params = new Class[1];
			params[0] = String[].class;
			// ����main����
			Method method = clz.getMethod("main", params);
			method.invoke(object, new Object[]{new String[]{"bb","cc"}});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * �ɼ̳�ʽThreadLocal,���̵߳ı���ֵ���Դ��͸����̡߳�
     */
    public static void testInheritableThreadLocal(){
    	final InheritableThreadLocal<String> tl = new InheritableThreadLocal<String>();
    	
    	tl.set("tt");
    	Thread tg = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+":"+tl.get());
			}
    		
    	},"tt-ui");
    	tg.start();
    	System.out.println("bb");
    	
    }
    
    public static void testMath(){
    	BigInteger bi = new BigInteger("0");
    	BigInteger bi1 = new BigInteger("0");
    	bi.add(bi1);
    	
    	BigDecimal bd = new BigDecimal(0);
    
    }
    
    /**
     * ���manifest�ļ�����
     */
    public static void testPackage(){
    	Package pk ;
    }
    
    public static void testProcess(){
    	Process pp;
    	ProcessBuilder pb;
    	Runtime rt = Runtime.getRuntime();
    	String[] bb = new String[100];
    }
    
    public static void testStrings(){
    	String a = "a";
    	String b = "b";
    	a = "a" + "b";
    	
    	
    	StringBuffer sb = new StringBuffer();
    	sb.append(a);
    	
    	StringBuilder sb1 = new StringBuilder();
    	sb1.append(a);
    	System.out.println("tt");
    	
    	Error er;
    	Throwable tw;
    	System.out.println(Void.TYPE);
    }
    
    
    /**
     * ���Է���ֵ��throw
     * @param ttt
     * @return
     * @throws IOException
     */
    public static Person testSystem(String ttt) throws IOException{
    	if(ttt == null){
    		return null;
    	}
    	
    	throw new IOException();

    	
    }
    
    public static class Person{
    	
    }
	
	
	public static class NetworkClassLoader extends ClassLoader{
		private String name;
		
		private String path="";
		
		private final String fileType = ".class";
		
		public NetworkClassLoader(String name,String path){
			super();
			this.path = path;
			this.name = name;
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



		/**
		 * @return the path
		 */
		public String getPath() {
			return path;
		}



		/**
		 * @param path the path to set
		 */
		public void setPath(String path) {
			this.path = path;
		}



		/**
		 * @return the fileType
		 */
		public String getFileType() {
			return fileType;
		}



		public Class findClass(String name){
			byte[] b = loadClassData1(name);
			return defineClass(name,b,0,b.length);
		}
		
		public byte[] loadClassData(String name){
		  byte[] result = new byte[2048];
		  try{
//			name = name.replace(".", "\\");
			path = path + name.replace(".", "\\") + fileType;
			FileInputStream fis = new FileInputStream(path);
			int count = 0;
			while((count = fis.read(result)) != -1){
				System.out.print(count);
			}
		  }catch(Exception e){
			  e.printStackTrace();
		  }
			
			return result;
		}
		
		public byte[] loadClassData1(String name){
			byte[] result = null;
			try{
//				name = name.replace(".", "\\");
				String path1 = path + name.replace(".", "\\") + fileType;
				FileInputStream fis = new FileInputStream(path1);
				ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
				int ch = 0;
				while((ch = fis.read()) !=-1){
					baos.write(ch);
				}
				result = baos.toByteArray();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
		}
	}


}

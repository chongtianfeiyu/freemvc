package study2016.io.streams;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import study2016.io.streams.IOObjectOutputStream.AT;
import study2016.io.streams.IOObjectOutputStream.OOS;

/**
 * 对象输入流
 * @author liaokangli
 *
 */
public class IOObjectInputStream {
	
	public static void main(String[] args){
//		objectInputStreamNormal();
//		objectInputStreamInt();
		objectInputStreamByte();
	}
	
	/**
	 * 对象输入流正常
	 */
	public static void objectInputStreamNormal(){
		try{
			
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:\\oos.txt"));
//			OOS oos = (OOS) ois.readObject();
//			
//			AT at = oos.at;
//			AT[] as = at.values();
//			int fg = oos.fg;
			
			AT at = (AT) ois.readObject();
			System.out.println("tt");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void objectInputStreamInt(){
       try{
			
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:\\oos1.txt"));
			int fg = ois.readInt();
			System.out.println("tt");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 读字节
	 */
	public static void objectInputStreamByte(){
        try{
			
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:\\oos1.txt"));
			byte[] bytes = new byte[4];
			ois.read(bytes);
			System.out.println("tt");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

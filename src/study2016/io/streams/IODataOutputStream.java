package study2016.io.streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IODataOutputStream {

	public static void main(String[] args){
		dataOutputStreamNormal();
	}
	
	/**
	 * 数据输出流。可以写入原始java类型
	 */
	public static void dataOutputStreamNormal(){
		try{
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("f:\\testOut.txt"));
			dos.writeInt(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

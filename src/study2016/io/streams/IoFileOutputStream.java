package study2016.io.streams;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * io output stream
 * @author liaokangli
 *
 */
public class IoFileOutputStream {
	
	public static void main(String[] args){
		fileOutputStreamNormal();
	}
	
	/**
	 * 文件输出流。
	 */
	public static void fileOutputStreamNormal(){
		try {
			// 1000的字节
//			byte[] bytes = {3,-24};
			byte[] bytes = {64,64};
			FileOutputStream fos = new FileOutputStream("f:\\testOut.txt");
			fos.write(bytes);
			
			FileDescriptor fd = fos.getFD();
			
			System.out.println("文件描述符");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("没找到文件");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("io异常:"+e.fillInStackTrace());
		}
	}
	
	/**
	 * 文件输出流。
	 */
	public static void fileOutputStreamBoolean(){
		try {
			// 1000的字节
//			byte[] bytes = {3,-24};
			FileOutputStream fos = new FileOutputStream("f:\\testOut.txt");
			
			
			FileDescriptor fd = fos.getFD();
			
			System.out.println("文件描述符");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("没找到文件");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("io异常:"+e.fillInStackTrace());
		}
	}
	
	
	
	
	
   
	

}

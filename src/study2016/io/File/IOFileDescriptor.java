package study2016.io.File;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 文件描述符
 * http://www.cnblogs.com/skywang12345/p/io_09.html
 * http://hugozhu.myalert.info/2013/03/01/resource-management-in-java.html
 * 
 * 标准输出，标准输入，标准错误输出
 * @author liaokangli
 *
 */
public class IOFileDescriptor {
	
	public static void main(String[] args){
//		fileDescriptorNormal();
		fileDescriptorFos();
	}
	
	/**
	 * 文件描述符。表示打开的文件，打开的套接字或者其他源。不能直接操作文件，必须创建相应的FileInputStream or FileOutputStream
	 */
	public static void fileDescriptorNormal(){
		
		PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.in));
		ps.println("tt====");
		
	    System.out.println("tt");
		
	}
	
	/**
	 * 文件描述符,与fieoutputstream对应。标准输出(输出到屏幕），输出到屏幕
	 * 
	 */
	public static void fileDescriptorFos(){
		
		FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
		try {
			fos.write(100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

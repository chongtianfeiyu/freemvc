package study2016.io.streams;

import java.io.File;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 打印输出流
 * @author liaokangli
 *
 */
public class IOPrintStream {
	
	public static void main(String[] args){
//		printStreamNormal();
//		printStreamPrint();
		printStreamPrintf();
	}
	
	/**
	 * 正常流。输出到文件
	 */
	public static void printStreamNormal(){
		try{
			byte[] bytes = {3,-24};
			PrintStream ps = new PrintStream(new File("F:\\testOut.txt"));
			ps.write(bytes);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * print api。都转换为String
	 */
	public static void printStreamPrint(){
		try{
			byte[] bytes = {3,-24};
			PrintStream ps = new PrintStream(new File("F:\\testOut.txt"));
			ps.print(100);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * printf 格式化输出
	 */
	public static void printStreamPrintf(){
		try{
			
			PrintStream ps = new PrintStream(new File("F:\\testOut.txt"));
			ps.printf("姓名:%s,年龄:%d,薪资:%f,性别:%c", "tttt",100,15.6781,'女');
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 打印网络流
	 */
	public static void printStreamSocket(){
		try{
			Socket socket = new Socket("",9999);
			PrintStream ps = new PrintStream(socket.getOutputStream());
			// ......
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}

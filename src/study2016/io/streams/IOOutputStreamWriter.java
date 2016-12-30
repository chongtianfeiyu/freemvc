package study2016.io.streams;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 
 * 写出writer
 * outputstream writer
 * @author liaokangli
 *
 */
public class IOOutputStreamWriter {
	
	public static void main(String[] args){
		outputStreamWriterNormal();
//		outputStreamWriterInt();
//		outputStreamWriterChar();
	}
	
	/**
	 * 从字符流到字节流的转换
	 * gbk是对"中国"使用gbk编码转换为二进制后的值存储到文件中
	 */
	public static void outputStreamWriterNormal(){
		try{
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("f:\\oos3.txt"),"gbk");
			osw.write("中国");
			osw.close();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 写入int
	 */
	public static void outputStreamWriterInt(){
		try{
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("f:\\oos1.txt"));
			osw.write(64);
			osw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 写入字符
	 */
	public static void outputStreamWriterChar(){
		try{
			char[] cbuf = {'@'};
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("f:\\oos2.txt"));
			osw.write(cbuf);
			osw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}

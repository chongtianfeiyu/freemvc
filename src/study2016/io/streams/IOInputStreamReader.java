package study2016.io.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * 
 * @author liaokangli
 *
 */
public class IOInputStreamReader {
	
	public static void main(String[] args){
		inputStreamReaderNormal();
	}
	
	/**
	 * 正常读取。
	 */
	public static void inputStreamReaderNormal(){
		try {
			// 这个跟文件编码也有关系，如果文件编码为gbk,这里设置gbk.原因：文件编码为gbk,其实内容已经是gbk(两字节)编码了，
			// 这个时候如果按照utf8(三字节)解码
			InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\testOut.txt"),"gbk");
			System.out.println("==========isready:"+isr.ready());
			char[] cbuf = new char[1024];
			int count = 0;
			while((count = isr.read(cbuf) )!= -1){
				System.out.println(cbuf);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

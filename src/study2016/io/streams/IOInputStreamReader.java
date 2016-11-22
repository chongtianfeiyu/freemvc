package study2016.io.streams;

import java.io.BufferedReader;
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
//		inputStreamReaderNormal();
		wrapBuffer();
	}
	
	/**
	 * 正常读取。跟FileReader的区别:构造函数
	 */
	public static void inputStreamReaderNormal(){
		try {
			// 这个跟文件编码也有关系，如果文件编码为gbk,这里设置gbk.原因：文件编码为gbk,其实内容已经是gbk(两字节)编码了，
			// 这个时候如果按照utf8(三字节)解码
			InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\url.txt"),"gbk");
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
	
	/**
	 * 利用buffered包裹inputStreamReader。为什么要包裹，我直接使用上面那个方法也是可以的，中间还要经过一次缓存？
	 */
	public static void wrapBuffer(){
		try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\url.txt")));
			char[] cbuf = new char[1024];
			int count = 0;
			while((count = br.read(cbuf)) != -1){
				System.out.println(cbuf);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

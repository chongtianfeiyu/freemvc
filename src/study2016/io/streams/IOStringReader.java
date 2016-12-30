package study2016.io.streams;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * StringReader。用于读取字符
 * @author liaokangli
 *
 */
public class IOStringReader {
	
	public static void main(String[] args){
//		stringReaderNormal();
		stringWriterNormal();
	}
	
	/**
	 * StringReader 正常。读取字符
	 */
	public static void stringReaderNormal(){
		try{
			char[] chars = new char[64];
			StringReader sr = new StringReader("中国人");
			int count = sr.read(chars);
			System.out.println(new String(chars));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * StringWriter 正常。
	 */
	public static void stringWriterNormal(){
		try{
			
			Writer sw = new StringWriter();
			sw.write("中国人");
			System.out.println("tt:"+sw.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

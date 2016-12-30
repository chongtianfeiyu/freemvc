package study2016.io.streams;

import java.io.FileReader;
import java.io.LineNumberReader;

/**
 * 字符流行号
 * @author liaokangli
 *
 */
public class IOLineNumberReader {
	
	public static void main(String[] args){
//		lineNumberReaderNormal();
		lineNumberReaderReadLine();
	}
	
	/**
	 * 正常字符行号流
	 */
	public static void lineNumberReaderNormal(){
		try{
			
			LineNumberReader lnr = new LineNumberReader(new FileReader("f:\\testOut.txt"));
			char[] chars = new char[6];
			int count = 0;
			while((count = lnr.read(chars)) != -1){
				System.out.println("========line:"+lnr.getLineNumber()+";"+new String(chars));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 按行读取
	 */
	public static void lineNumberReaderReadLine(){
		
		try{
			LineNumberReader lnr = new LineNumberReader(new FileReader("f:\\testOut.txt"));
			String line = "";
			while((line = lnr.readLine()) != null){
				System.out.println("========line:"+lnr.getLineNumber()+";"+line);
			}	
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

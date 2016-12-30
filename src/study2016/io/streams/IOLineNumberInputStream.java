package study2016.io.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.LineNumberInputStream;

/**
 * 行号输入流
 * @author liaokangli
 *
 */
public class IOLineNumberInputStream {
	
	public static void main(String[] args){
		lineNumberInputStreamNormal();
	}
	
	/**
	 * 记录行号输入流
	 */
	public static void lineNumberInputStreamNormal(){
		try {
			LineNumberInputStream lnis = new LineNumberInputStream(new FileInputStream("F:\\testOut.txt"));
			byte[] bytes = new byte[6];
			int count = 0;
			while((count = lnis.read(bytes)) != -1){
				System.out.println("======line number:" + lnis.getLineNumber()+";" + new String(bytes));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

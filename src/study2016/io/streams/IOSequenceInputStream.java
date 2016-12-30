package study2016.io.streams;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 合并流，一般合并文件使用
 * @author liaokangli
 *
 */
public class IOSequenceInputStream {
	
	public static void main(String[] args){
		sequenceInputStreamNormal();
	}
	
	/**
	 * 序列文件流正常
	 */
	public static void sequenceInputStreamNormal(){
		try{
			Vector<InputStream> isList = new Vector<InputStream>();
			isList.add(new FileInputStream("f:\\oos1.txt"));
			isList.add(new FileInputStream("f:\\oos2.txt"));
			isList.add(new FileInputStream("f:\\oos3.txt"));
			
			SequenceInputStream sis = new SequenceInputStream(isList.elements());
			int count = 0;
			byte[] bytes = new byte[64];
			while((count = sis.read(bytes)) != -1){
				System.out.println("--------content:"+new String(bytes,0,count,"gbk"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

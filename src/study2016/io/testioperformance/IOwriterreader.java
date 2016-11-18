package study2016.io.testioperformance;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 测试writer写入数据（但是没有写入到磁盘，数据在内核缓存区）
 * reader从文件读数据，读取的是什么(没有读取到内容，网上有人说是从内核缓存区直接读取）
 * @author liaokangli
 *
 */
public class IOwriterreader {
	
	public static void main(String[] args){
		testWriterReader();
	}
	
	/**
	 * 
	 */
	public static void testWriterReader(){
		try{
			
		 FileWriter fw = new FileWriter(new File("F:\\testOut.txt"));
		 char[] buf = {'写','到'};
		 fw.write(buf);
		 fw.flush();
		 
		 FileReader fr = new FileReader(new File("F:\\testOut.txt"));
		 int count = 0;
		 char[] butt = new char[1];
		 while((count = fr.read(butt)) != -1){
			System.out.println(new String(butt));
		 }
			
		}catch(Exception e){
			
		}
		
	}

}

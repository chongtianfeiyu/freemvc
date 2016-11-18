package study2016.io.streams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * file writer
 * @author liaokangli
 *
 */
public class IOFileWriter {

	
	public static void main(String[] args){
		fileWriterNormal();
	}
	
	/**
	 * file writer正常写。
	 * (1)一定要flush,否则文件看不到内容，根据io原理，数据先写入内核缓存区，内核缓存区满了以后，才会写入到磁盘
	 * (2)写中文字符数组，为什么文件中只有一个。而写英文却是多个。重启电脑就好了（奇怪)。
	 */
	public static void fileWriterNormal(){
		
		try{
		 
		 FileWriter fw = new FileWriter(new File("F:\\testOut.txt"));
//		 char[] cbuf = {'中','看','的','我','是'};
		 char[] cbuf = {'a','中','w'};
		 fw.write(cbuf);
         fw.flush();		 
			
         
//         BufferedWriter bw = new BufferedWriter(fw);
//         bw.write(cbuf);
//         bw.flush();
         
         
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	public  void test(){
		System.out.println(name);
	}
	
	private  String name;
}

package study2016.io.streams;

import java.io.File;
import java.io.FileReader;

/**
 * file reader
 * @author liaokangli
 *
 */
public class IOFileReader {
	
	
	public static void main(String[] args){
		fileReaderNormal();
	}
	
	/**
	 * file reader正常。
	 * 
	 */
	public static void fileReaderNormal(){
		try{
			// 必须是utf8编码，否则会乱码
			FileReader fileReader = new FileReader(new File("f:\\testOut.txt"));
			char ts = '中';
			char[] charbuf = new char[1];
			int count = 0;
			while((count = fileReader.read(charbuf)) != -1){
				System.out.println(new String(charbuf));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}

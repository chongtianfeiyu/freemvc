package study2016.io.streams;

import java.io.RandomAccessFile;

/**
 * 随机读文件
 * @author liaokangli
 *
 */
public class IORandomAccessFile {
	
	public static void main(String[] args){
//		randomAccessFileNormal();
		randomAccessFileChars();
	}
	
	/**
	 * 随机读写文件。先读后写。
	 */
	public static void randomAccessFileNormal(){
		try{
			
			RandomAccessFile raf = new RandomAccessFile("f:\\testOut.txt","rw");
			// 写文件
			raf.write("中国".getBytes("utf-8"));
			System.out.println(raf.getFilePointer());
			
			// 转化为读
			raf.seek(0);
			System.out.println(raf.getFilePointer());
			byte[] bytes = new byte[3];
			raf.read(bytes);
			System.out.println("----字符:"+new String(bytes,"utf-8"));
			
			// 转化为写
			raf.writeInt(100);
			System.out.println(raf.getFilePointer());

			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 写字符。这个写字符跟原来的fileoutputstream不一样，这是写字符,java存字符存的是unicode编码
	 * 存到文件是unicode。中的unicode是(4e2d)。所以存到文件里面的二进制是4e2d
	 */
	public static void randomAccessFileChars(){
		try{
			RandomAccessFile raf = new RandomAccessFile("f:\\testOut.txt","rw");
			// 写文件
			raf.writeChars("中");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

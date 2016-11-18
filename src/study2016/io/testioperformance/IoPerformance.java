package study2016.io.testioperformance;

import java.io.File;
import java.io.FileOutputStream;

/**
 * io性能
 * @author liaokangli
 *
 */
public class IoPerformance {
	
	
	public static void main(String[] args){
//		openFileHandlerClose();
//		openFileHandlerNoClose();
		bufferSizeOneByte();
	}
	
	/**
	 * 打开的文件句柄产生性能问题。close掉，文件句柄维持在一个水平。磁盘读写比较频繁
	 * 产生磁盘io性能.
	 * 文件句柄的打开可以通过FileOutputStream来打开。new file并不会打开文件句柄
	 */
	public static void openFileHandlerClose(){
		try{
			
			File file = new File("log.log");
			FileOutputStream fos = null;
			while(true){
			   fos = new FileOutputStream(file);
			   //close
			   fos.close();
			}
//			Thread.sleep(100000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 打开的文件句柄产生性能问题。没有close掉，文件句柄数飙升。磁盘读写也比较频繁
	 */
	public static void openFileHandlerNoClose(){
		try{
				
			File file = new File("log.log");
			FileOutputStream fos = null;
			while(true){
			   fos = new FileOutputStream(file);
			   System.out.println("mn");
			}
//			Thread.sleep(100000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 缓存区大小影响到系统调用,用户态到内核态的转换
	 * 每次写入一个字节。多次系统调用
	 */
	public static void bufferSizeOneByte(){
		try{
			
			File file = new File("f:\\log.log");
			FileOutputStream fos = new FileOutputStream(file);
			byte[] bytes = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
			while(true){
				fos.write(bytes);
			   System.out.println("mn");
			   
			}
//			Thread.sleep(100000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}

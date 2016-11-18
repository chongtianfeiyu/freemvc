package study2016.io.streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * bufferedInputStream api
 * @author liaokangli
 *
 */
public class IOBufferedInputStream {
	
	public static void main(String[] args){
//		bufferedInputStreamNormal();
//		bufferedInputStreamMark();
		bufferedInputStreamSkip();
	}
	
	/**
	 * 正常使用.从io中读取数据。
	 * 原理.1、系统调用fileInputStream的read方法，其实会从用户态转化为内核态，这个时候，会从disk通过dma写入到内核的缓存区(这个时候会预读更多的数据到内核缓存区，减少io次数）
	 * 2、然后再从内核缓存区将数据写到用户态的缓存区，就是BufferedInputStream里面的buf.下次读的时候如果有数据的时候直接从buf里面读，减少用户态到内核态的转换
	 * 如果buf里面的数据不够的话，会先从重复上面的1。
	 */
	public static void bufferedInputStreamNormal(){
		
		try{
			
	     BufferedInputStream bis = new BufferedInputStream(new FileInputStream("G:\\log.log"));     
	     int count = 0;
	     byte[] buffer = new byte[7192];
	     int cnt = 7192;
	     while((count = bis.read(buffer,0,cnt)) != -1){
	    	
	    	 String result = new String(buffer,"utf-8");
	    	 System.out.println(result);
	     }
	     
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * mark
	 */
	public static void bufferedInputStreamMark(){
		try{
			
		     BufferedInputStream bis = new BufferedInputStream(new FileInputStream("G:\\log.log"));     
		     int count = 0;
		     byte[] buffer = new byte[4];
		     int cnt = 4;
		     bis.mark(Integer.MAX_VALUE);
		     while((count = bis.read(buffer,0,cnt)) != -1){
		    	 String result = new String(buffer,"utf-8");
		    	 System.out.println(result);
		    	 bis.reset();
		     }
		     
				
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	/**
	 * skip
	 */
	public static void bufferedInputStreamSkip(){
		try{
			 BufferedInputStream bis = new BufferedInputStream(new FileInputStream("G:\\log.log"));     
		     int count = 0;
		     int cnt = 4;
		     byte[] buffer = new byte[cnt];
		     
		     while((count = bis.read(buffer,0,cnt)) != -1){
		    	 bis.skip(2);
		    	 String result = new String(buffer,"utf-8");
		    	 System.out.println(result);
		     }
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	
	

}

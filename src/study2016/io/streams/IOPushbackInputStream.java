package study2016.io.streams;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.PushbackReader;

/**
 * 回退流。理解: 不要理解为是不读某个字符。而是在读某个字符的时候插入特定字符。比如这个时候你读取','字符，而你想插入+,可以使用unread('+')
 * 将一个字节或字节数组插入流缓存的最前面，下次读取将读取这次插入的数据。字符为{'a','b','t',','}。因此unread('+'),变成{'a','b','t','+',','}
 * 
 * @author liaokangli
 *
 */
public class IOPushbackInputStream {
	
	public static void main(String[] args){
//		pushbackInputStreamNormal();
//		pushbackReaderNormal();
		pushbackInputStreamSeparator();
//		pushBackReaderChars();
//		pushBackInputStream();
	}
	
	/**
	 * 回退流。可以用于读取不需要的字符
	 */
	public static void pushbackInputStreamNormal(){
		try{
			
			PushbackInputStream pis = new PushbackInputStream(new FileInputStream("f:\\testOut.txt"));
			int count = 0;
			while((count = pis.read()) != -1){
				System.out.println("------:"+(char)count);
			  if('u' == count){
				  // 不需要的字符
				  pis.unread('u');
				  char backChar = (char)pis.read();
				  System.out.println("----------回退:"+backChar);
			  }
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 回退分隔符
	 */
	public static void pushbackInputStreamSeparator(){
        try{
			
			PushbackInputStream pis = new PushbackInputStream(new FileInputStream("f:\\testOut.txt"));
			int count = 0;
			while((count = pis.read()) != -1){
				System.out.println("------:"+(char)count);
			  if(',' == count){
				  // 不需要的字符
				  pis.unread('+');
//				  char backChar = (char)pis.read();
//				  System.out.println("----------回退:"+backChar);
			  }
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 回退reader. 可以用于读取不需要的字符。下面的代码感觉有问题，比如说我已经读取出count,我直接
	 */
	public static void pushbackReaderNormal(){
		try{
			PushbackReader pr = new PushbackReader(new FileReader("f:\\testOut.txt"));
			int count = 0;
			while((count = pr.read()) != -1){
				
				if('u' == count){
					// 不需要读的字符
					pr.unread('u');
					char backChar = (char)pr.read();
					System.out.println("-----------回退:"+backChar);
				}else{
					System.out.println("--------:"+(char)count);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 回退一组char
	 */
	public static void pushBackReaderChars(){
		try{
			//
//			byte[] byteArray = new byte[]{'j','a','v'};
			char[] pushBackChars = new char[]{'w','m'};
			
			PushbackReader pr = new PushbackReader(new FileReader("f:\\testOut.txt"),100);
			pr.unread(pushBackChars);
			int count = 0;
			while((count = pr.read()) != -1){			
			   System.out.println("--------:"+(char)count);			
			}
			System.out.println("--------:");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 回退流
	 */
	public static void pushBackInputStream(){
		  byte[] arrByte = new byte[1024];
	      byte[] byteArray = new byte[]{'j', 'a', 'v', 'a', '2','s','.','c','o','m'};

	      InputStream is = new ByteArrayInputStream(byteArray);
	      PushbackInputStream pis = new PushbackInputStream(is, 10);

	      try {
	         for (int i = 0; i < byteArray.length; i++) {
	            arrByte[i] = (byte) pis.read();
	            System.out.println((char) arrByte[i]);
	         }
	         byte[] b = {'W', 'o', 'r', 'l', 'd'};
	         pis.unread(b);
	         for (int i = 0; i < byteArray.length; i++) {
	            arrByte[i] = (byte) pis.read();
	            System.out.println((char) arrByte[i]);
	         }
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	}
	
	
	
	
	
   

}

package study2016.io.streams;

import java.io.StringBufferInputStream;

/**
 * 此类被废弃，因为只有低8位被读取，读中文就会乱码
 * @author liaokangli
 *
 */
public class IOStringBufferInputStream {
	
	public static void main(String[] args){
		stringBufferInputStreamNormal();
	}
	
	/**
	 * string buffer input stream 正常流
	 */
	public static void stringBufferInputStreamNormal(){
		try{
			byte[] bytes = new byte[64];
			StringBufferInputStream sbis = new StringBufferInputStream("中");
			int count = 0;
			while((count = sbis.read(bytes)) != -1){
				System.out.println("------:"+new String(bytes,0,count,"gbk"));
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

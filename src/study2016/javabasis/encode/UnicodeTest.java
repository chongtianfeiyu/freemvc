package study2016.javabasis.encode;

import java.io.UnsupportedEncodingException;

import com.commonTest.Hex;

/**
 * unicode编码
 * @author liaokangli
 *
 */
public class UnicodeTest {
	
	public static void main(String[] args){
		strToUnicode();
	}
	
	/**
	 * string to unicode
	 */
	public static void strToUnicode(){
		String str = "中";
		try {
			// 大端序：高字节在低地址
			byte[] bytes = str.getBytes("UnicodeBigUnmarked");	
			System.out.println("大端序:"+Hex.encodeHexStr(bytes));
			// 小端序：低字节在低地址
			byte[] byteslittle = str.getBytes("UnicodeLittleUnmarked");
			System.out.println("小端序:"+Hex.encodeHexStr(byteslittle));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 支持的编码方式
	 */
	public static void supportCode(){
		
	}

}

package commonapi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Arrays.
 * @author liaokangli
 *
 */
public class ArraysTest {
	
	public static void main(String[] args){
		testArrays();
	}
	
	public static void testArrays(){
		
		Object[] objects = new Object[10];
		
		System.out.println("=========objects");
		
		String str = "中国";
		try {
			System.out.println(URLEncoder.encode(str, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package study2016.javabasis.datatype;

/**
 * 类型变窄
 * @author liaokangli
 *
 */
public class NarrowType {
	
	public static void main(String[] args){
		charToByteNarrow();
	}
	
	/**
	 * char转byte类型变窄.char可以转换为int,
	 */
	public static void charToByteNarrow(){
	    char chars = '中';
	    int ints = (int)chars;
	    byte bytes = (byte)chars;
	    System.out.println("tt");
	    
		
	}
	
	public static void intNarrow(){
		int tt1 = 1122145114;
	    tt1 = tt1 *31;
	    System.out.println(tt1);
	    System.out.println(~(1122145114*31)+1);
	    System.out.println(Integer.toHexString(~(1122145114*31)+1));
	    
	    // 11010000100110111111001111010111 低32位的高位为1,是负数
		int tts = 112899401*31;
		System.out.println("tts:"+tts+";"+(~(112899401*31)+1));
		
		// 11111111111111111111111111111010 01000010111000101001001011100111 低32位的高位为0,是正数
		int tts1 = -795085767*31;
		System.out.println("tts1:"+tts1);
		
		//1000 00011001011011111101011111100110 低32位的高位为0,是正数
		int tts2 = 1122145114*31;
		System.out.println("tts2:"+tts2+";"+(~(1122145114*31)+1));
		
		//11111111111111111111111111110111 11100110100100000010100000011010 低32位的高位为1,是负数
		int tts3 = -1122145114*31;
		System.out.println("tts3:"+tts3+";"+(~(-1122145114*31)+1));
	}

}

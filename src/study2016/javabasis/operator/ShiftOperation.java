package study2016.javabasis.operator;

/**
 * 位移操作
 * @author liaokangli
 *
 */
public class ShiftOperation {
	
	public static void main(String[] args){
		shiftOperationUnsign();
		shiftOperationToBin();
//		shiftOperationToDigit();
	}
	
	/**
	 * 无符号右移。相当于除以2^位数得到的商
	 */
	public static void shiftOperationUnsign(){
		int ag = 319;
		
		System.out.println((byte)(ag >>> 0));
		
		// 除法
		System.out.println(Math.pow(2,8));
		System.out.println(ag/Math.pow(2,8));
		
	}
	
	/**
	 * 右移操作可以用于十进制转二进制。可以这么理解，十进制转化为进制，int是4个字节
	 * 下面的操作其实是把不同的位数放入byte数组中
	 */
	public static void shiftOperationToBin(){
		int val = 319;
		byte[] b = new byte[4];
		// 发生类型变窄，取低8位
		b[3] = (byte) (val >>> 0);
		// 移除低8位，再取8位
		b[2] = (byte) (val >>> 8);
		b[1] = (byte) (val >>> 16);
		b[0] = (byte) (val >>> 24);
		
		System.out.println("tt");
	}
	
	/**
	 * 左移操作转化为十进制
	 */
	public static void shiftOperationToDigit(){
		byte[] b = new byte[]{0,0,0,-1};
		int aa = ((b[3] & 0xFF) << 0) +
	       ((b[2] & 0xFF) << 8) +
	       ((b[1] & 0xFF) << 16) +
	       ((b[0]) << 24);
		
		System.out.println("tt");
	}

}

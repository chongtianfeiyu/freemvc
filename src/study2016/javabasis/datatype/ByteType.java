package study2016.javabasis.datatype;

/**
 * 字节类型
 */
public class ByteType {
	
	
	public static void main(String[] args){
		byteNormal();
	}
	
	public static void byteNormal(){
		
		Byte b1 = 1;
		System.out.println(b1);
		
		
		System.out.println((char)(int)b1);
		
		double d1 = 5.6;
		float as = 5.60f;
		
		int i1 = 0xff;
		long i2 = 100l;
		
		byte b2 = 0x11;
		
		long i3 = 0xff;
		
		int eightInt = 011;
		System.out.println(eightInt);
		
	}

}

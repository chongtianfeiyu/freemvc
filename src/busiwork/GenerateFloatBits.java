package busiwork;

/**
 * 循环产生小数位数
 * @author liaokangli
 *
 */
public class GenerateFloatBits {
	
	public static void main(String[] args){
		generateMethod();
//		repairFloat();
//		floatToBits();
	}
	
	/**
	 * 必须用字符串。因为double有精度问题。
	 */
	public static void generateMethod(){
		String fstr = "0.9999999";
//		String fstr = "0.025675";
//		String fstr = "0.33333333";
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<50;i++){
			Double f = Double.valueOf(fstr);
			System.out.println("======:"+i+";"+f);
			f = f * 2;
			
			String[] strs = String.valueOf(f).split("\\.");
	        fstr = "0."+strs[1];
			sb.append(Integer.parseInt(strs[0]));
		}
		System.out.println(sb.toString());
	}
	
	/**
	 * 小数二进制转换为十进制
	 */
	public static void repairFloat(){
		String binStr = "11111111111111111111111";
		double result = 0;
		for(int i = 0;i < 23;i++){
			char chars = binStr.charAt(i);
			String subs = String.valueOf(chars);
			result = result + (Double.parseDouble(subs) * (Math.pow(2, -1*(++i))));
		}
		
		System.out.println(result);
	}
	
	
	public static void floatToBits(){
		float f = 0.99999999f;
		float f1 = 1f;
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(f1)));
	}
	
	

}

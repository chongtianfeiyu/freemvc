package study2016.javabasis.datatype;

import java.math.BigDecimal;

/**
 * 浮点类型
 * @author liaokangli
 *http://blog.csdn.net/zq602316498/article/details/41148063
 */
public class FloatType {
	
	
   public static void main(String[] args){
	   
	   // 精度相等问题1
	   float f1 = 2.2f;
	   double d1 = (double)f1;
	   
	   double d2 = 2.2;
	   System.out.println(f1==2.2);
	   System.out.println(d1==2.2);
	   System.out.println(d2==2.2);
	   
	   // 精度相等问题2
	   float f2 = 0.99999998f;
	   float f3 = 1.0f;
	   float f4 = 0.9f;
	   double d3 = 0.99999999;
	   System.out.println("f2 == f1:"+(f2 == 1f));
	   
	   System.out.println("f4 == f1:"+(f4 == 1f));
	   
	   System.out.println("f4 == f1:"+(d3 == 1d));
	   
	   
	   double d4 = 2.4;
	   String d4bits = Long.toBinaryString(Double.doubleToRawLongBits(d4));
	   System.out.println(d4bits);
	   
	   float s=0f;
	   for (int i=0; i<26; i++)
	     s += 0.1;
	   System.out.println(s);
	   
	   // float相等比较实用Math而不是==,尽量使用
	   float a=10.222222222f;
	   float b = 10.222222229f;
	   System.out.println(Float.compare(a, b));
	   System.out.println(Math.abs(a-b));
	   
	   //金钱表示
	   BigDecimal bd1 = new BigDecimal(10.56).setScale(8,BigDecimal.ROUND_HALF_DOWN);
	   BigDecimal bd2 = new BigDecimal(b).setScale(8,BigDecimal.ROUND_HALF_DOWN);
	   
	   System.out.println(bd1.compareTo(bd2));
	   
	   
   }
   
   
   

}

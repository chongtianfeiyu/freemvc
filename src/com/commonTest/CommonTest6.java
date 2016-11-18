/**
 * 19lou.com
 */
package com.commonTest;

/**
 * @author liaokangli
 *
 */
public class CommonTest6 {
   public static void main(String[] args) {
	  String aa = "Returns a new string that is a substring of this string. The substring begins at the specified 免费的在线翻译服务可即时翻译文本和网页。 该翻译器支持： 中文(简体), 阿尔巴";
	  String dd = aa.substring(0, 20);
	  System.out.println(dd);
	  
	  FinalTest tt = new FinalTest();
	  String nn = tt.hhh;
	  System.out.println(tt.getClass().getSimpleName());
	  System.out.println(tt.getClass().getDeclaredFields()[0].getName());
   }
}

package study2016.formater;

import java.util.Formatter;
import java.util.Locale;

/**
 * formatter
 * @author liaokangli
 *
 */
public class ApiFormatter {
	
	public static void main(String[] args){
		formatterNormal();
	}
	
	/**
	 * string formatter normal
	 * %4$3d 其中4表示从第4个也就是10开始打印,$分隔符，3表示是中间3个空格(也就是说10和3之间用3个空格表示),d表示数字（若改为s表示字符串)
	 */
	public static void formatterNormal(){
		try{
			StringBuilder sb = new StringBuilder();
			Formatter formatter = new Formatter(sb,Locale.US);
			//Explicit argument indices may be used to re-order output
			formatter.format("%4$3d %3$3d %2$3d %1$3d", 100, 2, 3, 10);
			System.out.println("tt:"+sb.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

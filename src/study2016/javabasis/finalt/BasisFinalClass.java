package study2016.javabasis.finalt;

/**
 * final 修饰class
 * 不能被继承。final是不能修饰接口的
 * @author liaokangli
 *
 */
public class BasisFinalClass {
	
	public static void main(String[] args){
		
	}
	
	public static void finalClassNormal(){
		MyFinal myFinal = new MyFinal(new Object());

	}
	
	
	public static final class MyFinal{
		
		private final Object object ;

		public MyFinal(Object object){
			this.object = object;
		}
		
	}
	


}

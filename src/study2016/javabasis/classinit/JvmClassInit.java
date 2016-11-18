package study2016.javabasis.classinit;

/**
 * 类和接口初始化（分静态域和非静态域,子类和父类）
 * @author liaokangli
 *
 */
public class JvmClassInit {
	
	public static void main(String[] args){
		classInitNormal();
//		classInitByChild();
//		classInitConstant();
	}
	
	/**
	 * 会触发staticclass初始化
	 */
	public static void classInitNormal(){
		String name = StaticClass.name;
		System.out.println("tt");
	}

	
	/**
	 * 通过子类引用父类，只会触发父类的初始化
	 */
	public static void classInitByChild(){
		String name = SubStaticClass.name;
		System.out.println("tt");
		
	}
	
	/**
	 * 访问常量的初始化。不会引起类的初始化。
	 */
	public static void classInitConstant(){
		String name = StaticClass.aa;
		System.out.println("tt");
	}
	
	
}

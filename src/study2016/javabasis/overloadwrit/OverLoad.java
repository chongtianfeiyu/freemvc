package study2016.javabasis.overloadwrit;

/**
 * 重载
 * 重载和重写的关键点

private： 一个私有的java方法是不能被重写的，因为它对子类压根就不可见
final：重载一个final的方法是可以的，但是不能重写它，因此父类如果将方法声明为final的就可保证所有子类的调用此方法时调用的都是父类的方法。
final：如果两个方法有同样的参数列表，而其中一个的参数被声明为final的这种情况下这两个方法完全一样，因此不可重载。编译都通不过，因为这两个方法被视为完全一样。
static：可以重载一个静态的Java方法但是不能重写静态的Java方法，因为静态方法在方法区中只有一个。
static：重载是关于对象(实例）和继承而言的。一个声明为静态的方法属于整个类(对于这个的所有对象都是一样的)。因此重写它没有任何意义。
static：对于重载，两个静态方法的重载没有什么特别的，只不过是修饰符多了个static修饰符。参数列表依然必须不同。
 * @author liaokangli
 *
 */
public class OverLoad {
	
	public static void main(String[] args){
		
	}
	
	public final void test(String name){
		
	}
	
    public final String test(String name,int age){
		
    	return "";
	}
    
    public  void test(Object object){
		
	}
    
    public static void test(int object){
    	
    }
    
    public static void test(int object,int age){
    	
    }

}

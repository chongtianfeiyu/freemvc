package study2016.javabasis.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * @author liaokangli
 *
 */
public class Fanxing {
	
	public static void main(String[] args){
		
	}
	
	/**
	 * 不能插入任何类型（除null外)，因为fruits可能指向其他的子类型比如ArrayList<Banna>
	 * 
	 * 但是可以获取元素，因为子类型可以转换为父类型
	 */
	public static void fxExtends(){
		List<? extends Fruit> fruits = new ArrayList<Apple>();
		
		Fruit aa = fruits.get(0);
		
	}
	
	/**
	 * 只能插入Fruit的子类型，包括Fruit(因为确定子类型可以向上转为fruit)
	 * ,如果插入Fruit的父类型,fruits可能指向ArrayList<SuperFruit1>
	 * 
	 * 但是不能取出任何元素,除object
	 */
	public static void fxSuper(){
		List<? super Fruit> fruits = new ArrayList<SuperFruit>();
		
		List<? super Fruit> fruits1 = new ArrayList<SuperFruit1>();
		
		fruits.add(new Fruit());
		
		Object object = fruits.get(0);
		
	}
	
	
    public static class SuperFruit1{
		
	}
	
	public static class SuperFruit extends SuperFruit1{
		
	}
	
	public static class Fruit extends SuperFruit{
		
	}
	
	public static class Apple extends Fruit{
		
	}
	
    public static class Banna extends Fruit{
		
	}

}

package com.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * java泛型测试
 * @author liaokangli
 *
 */
public class FanxingTest {
	
	public static void main(String[] args){
		// ? 是Fruit的父类,表示list接受是Fruit父类的类型。可以添加Fruit的子类，不能添加Fruit的父类
		// ArrayList里面如果要带参数，至少是Fruit类型或者是Fruit的父类型
		// 由于添加Fruit的子类，可以转换为父类，所以是可以添加类型的
		List<? super Fruit> list = new ArrayList<SuperFruit>();
		list.add(new Fruit());
		list.add(new Apple());
		
		// ? 是Fruit的子类,表示list1接受是Fruit子类的类型。不可以添加任何元素
		List<? extends Fruit> list1 = new ArrayList<Fruit>();
		
	}
	
	public static class Fruit extends SuperFruit{
		
	}
	
	public static class SuperFruit{
		
	}
	
	public static class NoFruit{
		
	}
	
	public static class Apple extends Fruit{
		
	}
	
	public static class Apple1 extends Fruit{
		
	}

}

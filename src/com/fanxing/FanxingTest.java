package com.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * java���Ͳ���
 * @author liaokangli
 *
 */
public class FanxingTest {
	
	public static void main(String[] args){
		// ? ��Fruit�ĸ���,��ʾlist������Fruit��������͡��������Fruit�����࣬�������Fruit�ĸ���
		// ArrayList�������Ҫ��������������Fruit���ͻ�����Fruit�ĸ�����
		// �������Fruit�����࣬����ת��Ϊ���࣬�����ǿ���������͵�
		List<? super Fruit> list = new ArrayList<SuperFruit>();
		list.add(new Fruit());
		list.add(new Apple());
		
		// ? ��Fruit������,��ʾlist1������Fruit��������͡�����������κ�Ԫ��
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

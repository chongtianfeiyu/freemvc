package com.commonTest;

import java.util.List;

import com.commonTest1.FriendTest2;
import com.commonTest1.Person3;

/**
 * –ﬁ Œ∑˚≤‚ ‘£∫private,public,protected,friendly
 * @author liaokangli
 *
 */
public class ModifieTest {
	
	public static void main(String[] args){
		Person3 person = new Person3();
		person.getName();
		
		System.out.println(new TT1().name);
		
	}
	
	
	public static class FriendTotal<E> implements FriendTest2<E>{

		@Override
		public List<E> getName() {
			// TODO Auto-generated method stub
			
			return null;
		}
		
	}
	
	public static class TT{
		public static  String name = "tt";
	}
	
	public static class TT1 extends TT{
		public static String name = "tt1";
	}


}

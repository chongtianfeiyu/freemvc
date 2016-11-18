package com.mapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * map²âÊÔ
 * @author liaokangli
 *
 */
public class MapTest {

	public static void main(String[] args){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("dd", "dd");
		Set<Entry<String,String>> sets = map.entrySet();
		sets.iterator();
//		for(Entry<String, String> set:map.entrySet()){
//			System.out.println(set.getKey());
//		}
	
		System.out.println("dd");
		
		MapTest1 mapTest1 = new MapTest1();
		
		System.out.println("ccc");
	}
	
	
}

/**
 * 19lou.com
 */
package com.mapTest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liaokangli
 *
 */
public class MapListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
        // hashmap 无序 支持插入null has表和数组
		Map<String,String> hasMap = new HashMap<String,String>();
		hasMap.put("lkl", "lkl1");
		hasMap.put("aaa", "aaa1");
		for(Entry<String,String> entry:hasMap.entrySet()){
			System.out.println(entry.getKey());
		}
		System.out.println("=====linkedHashMap");
		// linkedhashmap has表和双链表 支持按插入顺序访问，和按访问顺序访问 插入使用hashmap里面的，只不过在addentry使用自己的
		Map<String,String> linkedHashMap = new LinkedHashMap<String,String>(16,.75f,true);
		linkedHashMap.put("lkl", "lkl1");
		linkedHashMap.put("aaa", "aaa1");
		linkedHashMap.put("bbb", "bbb1");
		linkedHashMap.put("ccc", "ccc1");
		
		for(Entry<String,String> entry:linkedHashMap.entrySet()){
			System.out.println(entry.getKey());
		}
		System.out.println("****最近最少使用的项被先打印出,类似LRU的缓存调度算法");
		linkedHashMap.get("aaa");
		linkedHashMap.get("lkl");
		for(Entry<String,String> entry:linkedHashMap.entrySet()){
			System.out.println(entry.getKey());
		}
		
		// hashtable
		
		// IdentityHashMap
		System.out.println("IdentityHashMap");
		Map<String,String> identityHashMap = new IdentityHashMap<String,String>();
		identityHashMap.put("lkl", "lkl1");
		identityHashMap.put("lkl", "aaa1");
		for(Entry<String,String> entry:identityHashMap.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		//treemap
		Map<String,String> treeMap = new TreeMap<String,String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		treeMap.put("lkl", "lkl1");
		treeMap.put("lkl", "aaa1");
		System.out.println("成功");
		
		//ConcurrentHashMap
		Map<String,String> conMap = new ConcurrentHashMap<String,String>();
		
	}

}

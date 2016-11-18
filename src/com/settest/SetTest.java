/**
 * 19lou.com
 */
package com.settest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * sortedset,hashset,TreeSet
 * @author liaokangli
 *
 */
public class SetTest {
    public static void main(String[] args) {
    	// hashset
		HashSet<String> set1 = new HashSet<String>();
		set1.add("lkl");
		set1.add("lkl");
		set1.add("dfg");
		
		for(String str:set1){
			System.out.println(str);
		}
		System.out.println("======");
		// SortedSet
		Set<String> treeSet = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int result = 0;
				if(o1.compareTo(o2) < 0){
					result = 1;
				}
				return result;
			}
		});
		treeSet.add("lkl");
		treeSet.add("dfg");
		treeSet.add(null);
		for(String str:treeSet){
			System.out.println(str);
		}
		
		// linkedHashSet
		Set<String> linkSet = new LinkedHashSet<String>();
		linkSet.add("");
		System.out.println("测试成功");
	}
}

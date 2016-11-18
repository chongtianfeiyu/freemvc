/**
 * 19lou.com
 */
package com.listtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * ArrayList LinkedList Vector
 * 
 * @author liaokangli
 * 
 */
public class ListTest {
	public static void main(String[] args) {
		String[] aa = new String[] { "lkl", "dd", "gh", "" };
		System.arraycopy(aa, 1, aa, 2, 2);
		aa[1] = "gh";
		// 扩容分析
		// capAutoSize(100000,10);
		// ArrayList 数组实现。适合随机访问，随机插入比linkedlist慢
		List<String> list1 = new ArrayList<String>(5);
		list1.add("uio");
		list1.add("lkl");
		list1.add("rty");
		System.out.println(list1.size());
		Iterator<String> it1 = list1.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		list1.remove(1);
		
		// LinkedList 双链表实现 适合随机插入，随机访问要移动多个指针，比较慢
		List<String> list2 = new LinkedList<String>();
		list2.add("lkl");
		list2.add("uio");
		Iterator<String> it2 = list2.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

		Collections.sort(list1, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});

		// Vector 也是用数组实现和arraylist一样，只不过vector是同步，扩容方式：若未指定扩容大小，使用当前数组大小*2。指定扩容大小，当前数组大小+扩容大小
		List<String> vector = new Vector<String>();
		vector.add("lkl");
		vector.add("uio");

		System.out.println("成功");

		int inc = abc(1, 2, 2);
		String dd;
	
        Arrays dfd;
	}

	/**
	 * arraylist的扩容分析
	 * 
	 * @param counts
	 *            要增加给list的个数
	 * @param oriSize
	 *            原始大小
	 */
	public static void capAutoSize(int counts, int oriSize) {
		int size = 0;
		Set c = new HashSet();
		for (int i = 0; i < counts; i++) {
			oriSize = abc(size + 1, counts, oriSize);
			size++;
			c.add(oriSize);
		}
		System.out.println(c.size());
	}

	public static int abc(int size, int counts, int oriSize) {
		int newSize = 0;
		if (size > oriSize) {
			newSize = (oriSize * 3) / 2 + 1;
		}
		return newSize;
	}
}

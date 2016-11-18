package com.collectiontest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;

/**
 * ���ϲ��� ���м�����ؽӿ�
 * @author liaokangli
 *
 */
public class CollectionTest {
	
	public static void main(String[] args){
		ArrayList a;
	}
	
	/**
	 * ����Collection�ӿ�
	 */
	public static void testCollection(){
		
		// ʹ�������ڲ��࣬����̳�һ�����ʵ��һ����Ľӿڣ�����಻һ���ǳ�����
		Collection aa = new Collection(){

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray(Object[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(Object e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
	/**
	 * �Ƚ���
	 */
	public static void testComparator(){
		Comparator aa;
	}
	
	/**
	 * ˫�˶���
	 */
	public static void testDeque(){
		Deque d1;
	}
	
	/**
	 * ö��
	 */
	public static void testEnumeration(){
		Enumeration aa;
	}
	
	/**
	 * ��ʽ��
	 */
	public static void testFormattable(){
		Formattable aa;
		Formatter ab;
	}
	
	/**
	 * �����
	 */
	public static void testIterator(){
		Iterator i1;
	}
	
	/**
	 * ����list
	 */
	public static void testListIterator(){
		ListIterator aa;
	}
	
	/**
	 * map
	 */
	public static void testMap(){
		Map aa;
	}
	
	/**
	 * �ɵ�����map
	 */
	public static void testNavigableMap(){
		NavigableMap aa;
	}
	
	/**
	 * �۲��߽ӿ�
	 */
	public static void testObserver(){
		
	}
	
	/**
	 * ������� fifo(�Ƚ��ȳ�,�Ƚ���
	 */
	public static void testQueue(){
		Queue aa;
	}
	
	/**
	 * ����
	 */
	public static void testSet(){
		Set set;
	}

}

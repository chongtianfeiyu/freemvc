package com.collectiontest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;

/**
 * ArrayDequeѧϰ
 * @author liaokangli
 *
 */
public class ArrayDequeTest {
	
	public static void main(String[] args) throws Exception{
		
		
//		testArrayDeque();
//		testArrayList();
//		testLinkedList();
//		testArrays();
//		testBitSet();
//		testCollections();
//		testEnumMap();
		testHashMap();
//		testHashTable();		
//		testIdentityHashMap();
//		testLinkedHashMap();
//		testTreeMap();
//		testWeakHashMap();
		
//		testHashSet();
//		testLinkedHashSet();
//		testEnumSet();
		
//		testStack();
		
		// object��Ϊkey
		testHashMapObject();
		
	}
	
	
	public static void testHashMapObject(){
		Map<Class<? extends Person>,String> map = new HashMap<Class<? extends Person>,String>();
		Person per1 = new Person();
		Person per2 = new Person();
		Class<? extends Person> classz1 = per1.getClass();
		Class classz2 = per2.getClass();
		Class classz3 = Person.class;
		map.put(classz1, "tt");
		map.put(per2.getClass(), "aa");
		map.put(classz3, "dd");
		System.out.println("dd");
	}
	
	/**
	 * ����ArrayDeque ˫�˶��С��ڲ�ʵ������.�ɵ����С�Ķ���
	 * ����������.δ�̳�RandomAccess
	 */
	public static void testArrayDeque(){
		ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
//		arrayDeque.addFirst("lkl");
		
		
		arrayDeque.addLast("dd");
		arrayDeque.addLast("dd1");
		
		String tt1 = arrayDeque.poll();
		
		String tt2 = arrayDeque.poll();
		
		String tt3 = arrayDeque.pollLast();
		
		String tt4 = arrayDeque.pollLast();
		
		System.out.println("���");
	}
	
	
	/**
	 * ����ArrayList��
	 * 1������ʵ��,�ɵ����С�����顣
	 * 2���̳�RandomAccess,��������
	 * 3���̲߳���ȫ
	 */
	public static void testArrayList() throws Exception{
	
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("cc");
		arrayList.add("dd");
		arrayList.add("bb");
		
		// arraylist�����л����ԣ���ΪelementData������transient
//		ObjectOutputStream tt = new ObjectOutputStream(new FileOutputStream("G:\\tt.txt"));
//		tt.writeObject(arrayList);
		// �����л�����
//		ObjectInputStream tt1 = new ObjectInputStream(new FileInputStream("G:\\tt.txt"));
//		ArrayList<String> ob = (ArrayList<String>) tt1.readObject();
		
		// ����ʹ�õ����
		Iterator<String> it = arrayList.iterator();
		while(it.hasNext()){
			String str = it.next();
			if(str.equals("bb")){
				// ���ַ�ʽ���׳��쳣ConcurrentModificationException
				// 
				arrayList.remove(str);
				
				// ���ַ�ʽ����
//				it.remove();
			}else{
				System.out.println(str);
			}
		}
		
		System.out.println("arraylist ���:"+arrayList.size());
		
	}
	
	/**
	 * ����LinkedList
	 */
	public static void testLinkedList(){
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("dd");
		ll.add("tt");
		ll.add("bb");
		Iterator<String> it = ll.iterator();
		while(it.hasNext()){
			String str = it.next();
			if(str.equals("tt")){
				ll.remove();
				it.remove();
			}else{
				System.out.println(str);
			}
		}
		System.out.println("���");
	}
	
	/**
	 * ����Arrays
	 * ����������࣬�ṩ�˸��ֲ�������ķ���
	 */
	public static void testArrays(){
		long[] val = new long[10];
		Arrays.fill(val, 3, 5, 20);
		System.out.println("���");
		
	}
	
	/**
	 * ����BitSet
	 * �Զ���������
	 */
	public static void testBitSet(){
		BitSet bs1 = new BitSet(2);
		System.out.println(bs1.size());
//		bs1.set(0);
//		bs1.set(3);
//		bs1.set(8);
		// ����2147483647,��������Խ��
		bs1.set(2147483646);
		
//		bs1.set(100);
		System.out.println(bs1.toString());
		
		
	}
	
	/**
	 * ����Collections��
	 * ����list����
	 */
	public static void testCollections(){
		List<Long> list = new ArrayList<Long>();
		list.add(100l);
		list.add(50l);
		Collections.sort(list);
		
		// ͬ��list ��list�����ͬ��
		List safeList = Collections.synchronizedList(new ArrayList());
		
		
        System.out.println("���");
		
	}
	
	/**
	 * ����EnumMap
	 */
	public static void testEnumMap(){
		
		//�������еĲ���һ����ö������
		EnumMap em = new EnumMap(Type.class);
		em.put(Type.OFF, "tt");
		em.put(Type.ON, "dd");
		
		Iterator it = em.entrySet().iterator();
		while(it.hasNext()){
			Entry entry = (Entry) it.next();
			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
		}
		System.out.println("���");

	}
	
	/**
	 * ����HashMap
	 * 1��key����Ϊnull��valueҲ����Ϊnull
	 * 2��DEFAULT_INITIAL_CAPACITY��loadFactor����Ҫ����������ʱ����DEFAULT_INITIAL_CAPACITY��������̫�ߣ�loadFactor��������̫��
	 */
	public static void testHashMap(){
		Map<String,String> map = new HashMap<String,String>();
		map.put(new String("tt"), "tt1");
		map.put("dd", null);
		map.put(null, "bb");
		map.put("vv", "vv1");
		
		// ��Ȼnew String,���String��hashcode��������ͬһ��ֵ
		String res = map.get(new String("tt"));
		
		// ��ʽһ����
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,String> entry = (Entry<String, String>) it.next();
			System.out.println("key:"+entry.getKey());
			System.out.println("value:"+entry.getValue());
			if("dd".equals(entry.getKey())){
			   // �˷������쳣
			   map.remove("dd");
			   
			   // �˷������׳��쳣
//			   it.remove();
			}
		}
		
		// ��ʽ������,���ܲ��緽ʽһ���ܺã���Ϊ��ʽ����map.get(keyset)����Ҫ�ٱ���һ�α�
		Iterator it1 = map.keySet().iterator();
		while(it1.hasNext()){
			String keyset = (String) it1.next();
			String value = map.get(keyset);
		}
		System.out.println("���"+map.size()+":"+map.containsKey("dd"));
		
		
	}
	
	/**
	 * ����hashtable
	 * 1��Ĭ������11����������0.75
	 * 2����hashmap���ƣ���ͬ��
	 * ��1����֧��null key,��֧��null value
	 * ��1���̰߳�ȫ�ġ�
	 */
	public static void testHashTable(){
		Hashtable<String,String> table = new Hashtable<String,String>();
		table.put("tt", "tt1");
		table.put("bb", "bb1");
		table.put("cc", "cc1");
		
//		Iterator it = table.entrySet().iterator();
//		while(it.hasNext()){
//			Entry<String,String> entry = (Entry<String, String>) it.next();
//			System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
//			if("bb".equals(entry.getKey())){
//				// �׳��쳣
//				table.remove("bb");
//			}
//		}
		
		// ���ַ�ʽ�������쳣
		Enumeration era = table.keys();
		while(era.hasMoreElements()){
			String key = (String) era.nextElement();
			System.out.println("key:"+key);
			if("bb".equals(key)){
				table.remove("bb");
			}
	
		}
	
		System.out.println("���");
		
	}
	
	/**
	 * ����IdentityHashMap
	 * �����ظ���key(��ַ��ͬ),�����ݲ��Ḳ�ǵ�
	 */
	public static void testIdentityHashMap(){
		IdentityHashMap ihm = new IdentityHashMap();
		String str1 = new String("tt");
		String str2 = new String("tt");
		ihm.put(str1, "tt1");
		ihm.put(str2, "tt2");
		
		System.out.println("���"+ihm.get(str1));
		
	}
	
	/**
	 * ����LinkedHashMap
	 * ˫������
	 */
	public static void testLinkedHashMap(){
		
		// �����˳��
		LinkedHashMap lhm = new LinkedHashMap();
		lhm.put("tt1", "bb1");
		lhm.put("tt2", "bb2");
		lhm.put("tt3", "bb3");
		
		Iterator it = lhm.entrySet().iterator();
		
		System.out.println("���"+lhm.get("tt2"));
		
	}
	
	/**
	 * ����TreeMap
	 */
	public static void testTreeMap(){
		// �Զ�������
		TreeMap<SubPerson,String> tm = new TreeMap<SubPerson,String>(new MyComparator2());
		SubPerson p1 = new SubPerson();
		p1.setAge(10);
		
		SubPerson p2 = new SubPerson();
		p2.setAge(30);
		
		SubPerson p3 = new SubPerson();
		p3.setAge(20);
		
		tm.put(p1, "bb1");
		tm.put(p2, "bb2");
		tm.put(p3, "bb3");
		
		// descendingMap
		NavigableMap nm = tm.descendingMap();
		
		System.out.println("���");
	}
	
	/**
	 * ������WeakHashMap
	 */
	public static void testWeakHashMap(){
		String key = new String("dd");
		String key1 = new String("dd1");
		String value1 = new String("tt");
		WeakHashMap whm = new WeakHashMap();
		whm.put(key1, value1);
		whm.put(key1, "tt1");
		key = null;
		// ֪ͨgc�ռ�,
		System.gc();
		// ��ʱwhmΪ{}
		System.out.println("de:"+whm.containsKey("dd"));
	}
	
	/**
	 * ����hashset
	 */
	public static void testHashSet(){
		HashSet hs = new HashSet();
		hs.add("tt");
		hs.add("bb");
		hs.add(null);
		
		Iterator it = hs.iterator();
		while(it.hasNext()){
			String ele = (String) it.next();
			if("tt".equals(ele)){
				hs.remove(ele);
			}
		}
		System.out.println("���"+hs.size());
	}
	
	
	/**
	 * ����LinkedHashSet
	 */
	public static void testLinkedHashSet(){
		LinkedHashSet lhs = new LinkedHashSet();
		lhs.add("tt");
		lhs.add("bb");
		lhs.add("cc");
		System.out.println("���");
	}
	
	/**
	 * ����TreeSet
	 */
	public static void testTreeSet(){
		TreeSet ts = new TreeSet();
		ts.add("tt");
		
	}
	
	/**
	 * ����Enumset
	 */
	public static void testEnumSet(){
		EnumSet es = EnumSet.noneOf(Type.class);
		es.add(Type.OFF);
		es.add(Type.ON);
		Iterator it = es.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("���");
	}
	
	/**
	 * ����Dictionary ������
	 */
	public static void testDictionary(){
		Dictionary aa;
	}
	
	
	/**
	 * ����Stack������ȳ���"cc"�ȴ�ӡ����
	 */
	public static void testStack(){
		Stack sk = new Stack();
		sk.push("tt");
		sk.push("dd");
		sk.push("cc");
		
		System.out.println("���:"+sk.peek());
	}
	
	/**
	 * ����Vector��
	 */
	public static void testVector(){
		Vector vt = new Vector();
		vt.add("tt");
		vt.add("hj");
		vt.add("dd");
		System.out.println("���:"+vt.get(0));
	}
	
	
	
	public static class MyComparator2 implements Comparator<Person>{

		@Override
		public int compare(Person o1, Person o2) {
			// TODO Auto-generated method stub

			if(o1 == null || o2 == null){
				return 0;
			}
			return o1.getAge()-o2.getAge();
		}


		
	}
	
	public static class Person{
		
		private int age;

		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}

		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}
		
		
		
	}
	
	public static class SubPerson extends Person{
		private int age;

		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}

		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}
		
	}
	
	
	public enum Type{
		ON,OFF
	}
	

}

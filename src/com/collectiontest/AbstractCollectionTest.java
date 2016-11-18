package com.collectiontest;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AbstractCollection
 * AbstractList
 * AbstractMap
 * @author liaokangli
 *
 */
public class AbstractCollectionTest {

	public static void main(String[] args){
		String str = "aa,bb,cc";
		List<String> as = Arrays.asList(str.split(","));
		List<String> ab = new ArrayList<String>();
		ab.add("aa");
		as.removeAll(ab);
		System.out.println("tt");
	}
	
	public void testAbstractCollection(){
		AbstractCollection ac;
	}
	
	public void testAbstractList(){
		AbstractList al;
	}
	
	public void testAbstractMap(){
		AbstractMap am;
	}
	
	public void testAbstractQueue(){
		AbstractQueue aq;
	}
	
	public void testAbstractSequentialList(){
		AbstractSequentialList asl;
	}
}

package com.collectiontest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * top k问题
 * 比如求10亿个数中的最大的前10个数，时时构建只有10个元素的小顶堆，如果比堆顶小，则不处理；如果比堆顶大，则替换堆顶，然后依次下沉到适当的位置。

比如求10亿个数中的最小的前10个数，时时构建只有10个元素的大顶堆，如果比堆顶大，则不处理；如果比堆顶小，则替换堆顶，然后依次下沉到适当的位置。
 * 
 * 1w个里面取前300个
 * @author liaokangli
 *
 */
public class TopkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		List<Integer> sortList = new ArrayList<Integer>();
		for(int i=0;i<10000;i++){
			int value = rand.nextInt();
			sortList.add(value);
			
		}
		List<Integer> priorityList = new ArrayList<Integer>(sortList);
		System.out.println("=============testSort");
		long start = System.currentTimeMillis();
		testSort(sortList);
		long end = System.currentTimeMillis();
		System.out.println("======testSort:"+(end-start));
		System.out.println("=============testPriorityQueue");
		 start = System.currentTimeMillis();
		testPriorityQueue(priorityList);
		 end = System.currentTimeMillis();
		System.out.println("======testPriorityQueue cost:"+(end-start));
	}
	
	/**
	 * 全部排序再取top k
	 */
	public static void testSort(List<Integer> sortList){
		Collections.sort(sortList,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
		List<Integer> subresult = sortList.subList(0, 10);
		
		for(int i = 0;i<10;i++){
			System.out.print(subresult.get(i)+",");
		}
	}
	
	/**
	 * 优先队列排序，小顶堆
	 */
	public static void testPriorityQueue(List<Integer> sortList){
		
		
		TopK.getTopK(10000, 10, sortList);
		
		
		
	}
	
	
	
	public static class TopK {

	    private static Queue<Integer> queue;

	    /**
	     * 从n个整数中查找最大的k个
	     *
	     * @param n
	     * @param k
	     * @return
	     */
	    public static boolean getTopK(int n, int k,List<Integer> sortList) {
	        queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
	        	// 若改成o1.compareTo(o2)是顺序排列,最小堆
	            @Override
	            public int compare(Integer o1, Integer o2) {
	                return o1.compareTo(o2);
	            }
	        });

	        //先加入k个再说
	        for (int i = 0; i < k; i++) {
	            queue.offer(sortList.get(i));
	        }
	        //这个时候，队列已满，若再想加入，那么必须是比队列中最大的元素大的才可以加入
	        for (int i = k; i < n; i++) {
	            int i1 = sortList.get(i);
	            if (queue.peek() < i1) {
	                queue.poll();
	                queue.offer(i1);
	            }

	        }
	        
//	        List<Integer> result = new ArrayList<Integer>();
	        int queueSize = 0;
	        LinkedList<Integer> result = new LinkedList<Integer>();
	        
	        while (!queue.isEmpty()) {
//				System.out.print(queue.poll() + ",");
	        	result.addFirst(queue.poll());
			}
	        
//	        Arrays.sort(result, new Comparator<Integer>() {
//	        	// 若改成o1.compareTo(o2)是顺序排列,最小堆
//	            @Override
//	            public int compare(Integer o1, Integer o2) {
//	                return o2.compareTo(o1);
//	        }});
	        
	        for(int i = 0;i<10;i++){
				System.out.print(result.get(i)+",");
			}
	        
	        return true;
	    }
	    
	    

	}

}

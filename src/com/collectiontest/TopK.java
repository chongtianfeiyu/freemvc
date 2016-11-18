package com.collectiontest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {
	public static double[] topKLargest(double[] input, int k) {
		PriorityQueue<Double> minheap = new PriorityQueue<Double>(k,new Comparator<Double>(){

			// 小顶堆
			@Override
			public int compare(Double o1, Double o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
		
		//先加入k个再说
        for (int i = 0; i < k; i++) {
        	minheap.offer(input[i]);
        }
        
        for (int i = k; i < input.length; i++) {
            double i1 = input[i];
            if (minheap.peek() < i1) {
            	minheap.poll();
            	minheap.offer(i1);
            }

        }
        
        System.out.println("-----------------------"+minheap.size()); 
//        while(minheap.size() > 0) { 
//        	System.out.println(minheap.poll()); 
//        } 

		double[] out = new double[k];
		for (int i = 0; i < out.length; i++) {
			out[i] = minheap.poll();
		}
		return out;
	}

	
	public static void main(String[] args) {
		
		
		double[] out = topKLargest(new double[] { 10.40, 23.0, 5.12, 1.1, 7.9, 8.7, 4.3, 5.1, 7.3, 12.5,
				523.4 }, 3);
		System.out.print("Largest: ");
		for (double o : out) {
			System.out.print(o + " ");
		}
		
		
	}
}

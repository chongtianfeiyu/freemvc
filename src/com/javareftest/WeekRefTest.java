/**
 * 19lou.com
 */
package com.javareftest;

import java.lang.ref.WeakReference;

/**
 * 弱引用测试.car为强引用，
 * @author liaokangli
 *
 */
public class WeekRefTest {
    public static void main(String[] args) throws InterruptedException {
		Car car = new Car(300, 123);
		String str = new String("abc");//必须用new，若直接str="abc",不会回收"abc"对象，因为这个是常量池里面的
		int i=0;
		WeakReference<Car> weakCar = new WeakReference<Car>(car);
	    car = null;
	    System.out.println(weakCar.get());
	    
	    WeakReference<String> weakCar1 = new WeakReference<String>(str);
	    str = null;
	    System.out.println(weakCar1.get());
	    System.gc();
	    Thread.sleep(10000);
	    System.out.println(weakCar1.get());
	    System.out.println(weakCar.get());
//	    while(true){
//	    	if(weakCar.get()!=null){
//	    		i++;
//	    		System.out.println("object is alive for "+i+" loops-"+weakCar.get());	 
//	    		if(i==30){
//	    			car = null;
//	    		}
//	    	}else{
//	    		System.out.println("Object has been collected. "+weakCar.get());
//	    		break;
//	    	}
//	    }
    }
    public static class Car{
		private double price;  
	    private int colour;  
	      
	    public Car(double price, int colour){  
	        this.price = price;  
	        this.colour = colour;  
	    }  
	      
	    public double getPrice() {  
	        return price;  
	    }  
	    public void setPrice(double price) {  
	        this.price = price;  
	    }  
	    public int getColour() {  
	        return colour;  
	    }  
	    public void setColour(int colour) {  
	        this.colour = colour;  
	    }  
	      
	    public String toString(){  
	        return colour +"car costs $"+price;  
	    }  
	}
}

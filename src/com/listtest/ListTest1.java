/**
 * 19lou.com
 */
package com.listtest;

import java.util.ArrayList;
import java.util.List;

/**
 * ²âÊÔlistÌí¼Ó¿Õ×Ö·û´®
 * @author liaokangli
 *
 */
public class ListTest1 {
   public static void main(String[] args) {
	   List<Object> cityList = new ArrayList<Object>();
//	   aa.add("");
//	   aa.add(null);
	   System.out.println("");
	   String[] nodes = {"dd","null"};
	   if(nodes.length == 1){
			cityList.add("");
		}else if(nodes[1].equals( "shn")){
			cityList.add("shh");
		}else if(!nodes[1].equals( "null")){
			cityList.add(nodes[1]);
		}
	   System.out.println("");
   }
}

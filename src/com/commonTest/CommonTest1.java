/**
 * 19lou.com
 */
package com.commonTest;

import java.io.UnsupportedEncodingException;
import java.lang.instrument.ClassDefinition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author liaokangli
 *
 */
public class CommonTest1 {
//	 private static final long   MULTMIN_RADIX_TEN =  Long.MIN_VALUE / 10;
//	 private static final long N_MULTMAX_RADIX_TEN = -Long.MAX_VALUE / 10;
	/**
	 * @param args
	 * @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
		ClassDefinition cd;
		// TODO Auto-generated method stub
//        String str = "12";
//        
//        long aa = parseLong(str, 10);
//        int length = str.length();
//        Long dig = Long.parseLong(str);
//        System.out.println(String.format("%02d", Long.parseLong(str)));
		double time2 = 365 * 24 * 60 * 60 * 1000.0;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
		Long time1 = new Date().getTime() - sf.parse("2012-02").getTime();
		double time = time1/(365 * 24 * 60 * 60 * 1000.0);
		
		System.out.println( time);
		
		String name = "ÖÐ¹ú";
		String name1 = java.net.URLDecoder.decode(java.net.URLDecoder.decode(name, "utf-8"));
		System.out.println(name1);
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("tt", "tt");
		for(Entry<String,Object> entry:param.entrySet()){
			String key = entry.getKey();
			Object value = entry.getValue();
			entry.setValue("dd");
		}
		
		System.out.println("tt");
		
		long tt = 1445914592542L;
		Date date = new Date(tt);
		System.out.println("bb");
		
		String stt = "2015-10-12 09:48:15";
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sf1.parse(stt).getTime());
		
		String longstr = "100,0";
		long longres = Long.parseLong(longstr);
		System.out.println(longres);
        
	}
	
//	public static Long parseLong(String s, int radix)
//            throws NumberFormatException
//  {
//      if (s == null) {
//          throw new NumberFormatException("null");
//      }
//
//	if (radix < Character.MIN_RADIX) {
//	    throw new NumberFormatException("radix " + radix +
//					    " less than Character.MIN_RADIX");
//	}
//	if (radix > Character.MAX_RADIX) {
//	    throw new NumberFormatException("radix " + radix +
//					    " greater than Character.MAX_RADIX");
//	}
//
//	long result = 0;
//	boolean negative = false;
//	int i = 0, max = s.length();
//	long limit;
//	long multmin;
//	int digit;
//
//	if (max > 0) {
//	    if (s.charAt(0) == '-') {
//		negative = true;
//		limit = Long.MIN_VALUE;
//		i++;
//	    } else {
//		limit = -Long.MAX_VALUE;
//	    }
//          if (radix == 10) {
//              multmin = negative ? MULTMIN_RADIX_TEN : N_MULTMAX_RADIX_TEN;
//          } else {
//              multmin = limit / radix;
//          }
//          if (i < max) {
//              digit = Character.digit(s.charAt(i++),radix);
//		if (digit < 0) {
//		    
//		} else {
//		    result = -digit;
//		}
//	    }
//	    while (i < max) {
//		// Accumulating negatively avoids surprises near MAX_VALUE
//		 digit = Character.digit(s.charAt(i++),radix);
//		 result *= radix;
//		 result -= digit;
//	    }
//	   
//  }
//	 return -result;
//  }

}

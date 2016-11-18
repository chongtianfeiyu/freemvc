package com.localeTest;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * ���ʻ�����
 * @author liaokangli
 *
 */
public class LocaleTest {

	public static void main(String[] args){
		Locale locale = new Locale("en", "EN");  
		NumberFormat currFmt = NumberFormat.getCurrencyInstance(locale);  
		double amt = 123456.78;  
		System.out.println(currFmt.format(amt));
	}
}

package com.javaanotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解继承
 * @author liaokangli
 *
 */
public class AnotationExtendsTest {
	
	public static void main(String[] args){
		Class<Person> classz = Person.class;
		if(classz.getAnnotation(SubAnoExtend.class) != null){
			SubAnoExtend ann = classz.getAnnotation(SubAnoExtend.class);
			System.out.println("获取到:"+ann.subValue()+";"+ann.anoExtend().value());
		}else{
			
			System.out.println("未获取到:"+classz.getAnnotation(MyTable.class));
		}
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
	public static @interface AnoExtend{
		String value() default "";
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
	public static @interface SubAnoExtend{
		AnoExtend anoExtend();
		String subValue() default "";
	}
	
	
	@SubAnoExtend(subValue="aa",anoExtend=@AnoExtend(value="tt"))
	public static class Person{
		
	}

}

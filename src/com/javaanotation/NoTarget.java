package com.javaanotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Target为空的话，不能放到任何地方
 * @author liaokangli
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface NoTarget {

	String value() default "";
}

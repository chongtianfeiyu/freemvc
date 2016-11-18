package com.javaanotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TargetΪ�յĻ������ܷŵ��κεط�
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

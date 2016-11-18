/**
 * 19lou.com
 */
package com.exceptionTest;

/**
 * @author liaokangli
 *
 */
public class MyException extends Exception {
	public MyException(String msg, Throwable cause) {
		super(msg);
		initCause(cause);
	}
}

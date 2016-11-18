package com.threadTest;

import java.util.concurrent.locks.LockSupport;

/**
 * LOck原理。只能unpark一次行程，多次执行不累加。park会消耗一个许可
 * @author liaokangli
 *
 */
public class LockSupportPermitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LockSupport.park();
		LockSupport.unpark(Thread.currentThread());
		LockSupport.unpark(Thread.currentThread());
		System.out.println("当前线程开始");
		LockSupport.park();
		System.out.println("当前线程未阻塞");
		LockSupport.park();
		System.out.println("结束");
	}

}

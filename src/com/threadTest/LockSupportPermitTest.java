package com.threadTest;

import java.util.concurrent.locks.LockSupport;

/**
 * LOckԭ��ֻ��unparkһ���г̣����ִ�в��ۼӡ�park������һ�����
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
		System.out.println("��ǰ�߳̿�ʼ");
		LockSupport.park();
		System.out.println("��ǰ�߳�δ����");
		LockSupport.park();
		System.out.println("����");
	}

}

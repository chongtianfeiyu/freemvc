package com.jvmTest;

/**
 * slot��������
 * @author liaokangli
 *
 */
public class SlotTest {

	public static void main(String[] args){
		// ����飬�������int a=0,slot���ܵõ����ã�gc�޷�����
//		{
//		  byte[] b = new byte[64*1024*1024];
//		  
//		}
//		int a= 0;
//		System.gc();
		
//		
//		// b��ѭ���о������������٣��˳�forѭ����java�Զ����٣����迼��slot����
//		for(int i=0;i<10;i++){
//			byte[] b = new byte[64*1024*1024];
//		}
//		System.gc();
		
		
		// ��������,�����˳���ջ���˳���ջ����ı������٣�Ҳ�Ϳ��Ի��ն���
//		test();
//		System.gc();
		
		
		//if���,Ϊʲôif����ĳ�true��ʱ�򣬲��ܻ��գ��ĳ�i==0���Ի��գ�
		int i=0;       
		if(true){
			byte[] b = new byte[64*1024*1024];
		}
		
		System.gc();
	}
	
	public static void test(){
		 byte[] b = new byte[64*1024*1024];
		 System.gc();
	}
}

package com.nioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;


/**
 * nio����
 * @author liaokangli
 *
 */
public class NioTest {

	public static void main(String[] args){
//		testIoThread();
		testNioChannelRead();
//		testNioChannelWrite();
//		testTransferFrom();
		
	}
	
	/**
	 * ������channelʾ��:�����ݣ�flip()���л�����ģʽ��channel���뵽buffer
	 * 
	 * ͨ��˫��ġ�������ģ�ͬһ��ͨ���ȿ���д�룬Ҳ���Զ�����������io��˵����Ҫ����Ϊfileoutputstream,������д��
	 */
	public static void testNioChannelRead(){
		RandomAccessFile afile = null;
		byte[] message = {83, 111, 109, 101, 32,98, 121, 116, 101, 115, 46};
	  try{
		afile = new RandomAccessFile("E:\\19lou���������\\uid����","rw");
		FileChannel inChannel = afile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = inChannel.read(buf);
		while(bytesRead != -1){
			System.out.println("Read " + bytesRead);
			buf.flip();
			while(buf.hasRemaining()){
				System.out.println((char)buf.get());
				System.out.println("--------");
			}
			// ������������������Ա��ٴ�д��
//			buf.clear();
			// ��ն����Ļ�����
			buf.compact();
			bytesRead = inChannel.read(buf);
			
			
		}
		
		// д
        buf.reset();
		for(int i=0;i<message.length;i++){
			buf.put(message[i]);
		}
		buf.rewind();
		int writeBytes = 0;
	    while((writeBytes = inChannel.write(buf)) != 0){
	    	System.out.println("д��");
	    }
		inChannel.write(buf);
		
		
	  }catch(Exception e){
		e.printStackTrace();
		
	  }finally{
		if(afile != null){
			  try {
				afile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	  }
	}
	
	/**
	 * ����д,flip()�л���дģʽ��bufferд��ͨ��;��ͨ��ֻ��д,���ܶ�
	 */
	public static void testNioChannelWrite(){
		byte[] message = {83, 111, 109, 101, 32,98, 121, 116, 101, 115, 46};
		try {
			FileOutputStream fout = new FileOutputStream("d:\\test.txt");
			FileChannel fc = fout.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			for(int i=0;i<message.length;i++){
				buffer.put(message[i]);
			}
			buffer.flip();
			try {
				fc.write(buffer);
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ���̲߳��Զ�дio:����
	 */
	public static void testIoThread(){
	  try{
		final FileInputStream fileInput = new FileInputStream(new File("E:\\19lou���������\\trade-temai-12-16.txt"));
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
		     
			  try{
				int readbytes = 0;
				while((readbytes = fileInput.read()) != -1){
					synchronized(fileInput){
					    System.out.println(Thread.currentThread().getName()+":"+readbytes);
					 }
					System.out.println(Thread.currentThread().getName()+":t1");
				}
			  }catch(Exception e){
				  e.printStackTrace();
			  }
		   
				
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
			 
			  try{
				int readbytes = 0;
				while((readbytes = fileInput.read()) != -1){
					synchronized(fileInput){
					    System.out.println(Thread.currentThread().getName()+":"+readbytes);
					 }
					System.out.println(Thread.currentThread().getName()+":t1");
				}
			  }catch(Exception e){
				  e.printStackTrace();
			  }
				
			}
			
		}).start();
		
		
		System.out.println("dd");
		
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	}
	
	/**
	 * ���Դ�һ��ͨ��������һ��ͨ��
	 */
	public static void testTransferFrom(){
		
		try {
			RandomAccessFile raf = new RandomAccessFile("G:\\testOuptStream","rw");
			FileChannel fch1 = raf.getChannel();
			
			RandomAccessFile rafTo = new RandomAccessFile("G:\\testOuptStream1","rw");
			FileChannel fch2 = rafTo.getChannel();
			fch2.transferFrom(fch1, 0, fch1.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ����selector ��channelʹ�ã�����ʹ�÷�����ģʽ����filechannel������selectorһ��ʹ�ã���Ϊ��������ģʽ
	 * �����ⲿ�ֲ��ԣ���Ϊ�漰���������Ϳͻ��ˣ��ο�rpc-app����
	 */
	public static void testSelector(){
		ServerSocket dd ;
		Selector selector = null;
		try{
			// ����selector����
			selector = Selector.open();
			
			// ������ѡ��ͨ��,������Ϊ������ģʽ����ͨ����ָ���˿�
			SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("172.16.15.28", 8099));
			socketChannel.configureBlocking(false);
			
			// ��selectorע�����Ȥ���¼�
			SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(selector != null){
				try {
					selector.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
}

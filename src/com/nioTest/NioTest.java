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
 * nio测试
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
	 * 基本的channel示例:读数据；flip()会切换到读模式：channel读入到buffer
	 * 
	 * 通道双向的。看下面的，同一个通道既可以写入，也可以读出。而对于io来说是需要更换为fileoutputstream,才能再写入
	 */
	public static void testNioChannelRead(){
		RandomAccessFile afile = null;
		byte[] message = {83, 111, 109, 101, 32,98, 121, 116, 101, 115, 46};
	  try{
		afile = new RandomAccessFile("E:\\19lou生活馆数据\\uid个数","rw");
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
			// 清空整个缓存区，可以被再次写入
//			buf.clear();
			// 清空读过的缓存区
			buf.compact();
			bytesRead = inChannel.read(buf);
			
			
		}
		
		// 写
        buf.reset();
		for(int i=0;i<message.length;i++){
			buf.put(message[i]);
		}
		buf.rewind();
		int writeBytes = 0;
	    while((writeBytes = inChannel.write(buf)) != 0){
	    	System.out.println("写入");
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
	 * 测试写,flip()切换到写模式：buffer写入通道;此通道只能写,不能读
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
	 * 多线程测试读写io:阻塞
	 */
	public static void testIoThread(){
	  try{
		final FileInputStream fileInput = new FileInputStream(new File("E:\\19lou生活馆数据\\trade-temai-12-16.txt"));
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
	 * 测试从一个通道传入另一个通道
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
	 * 测试selector 与channel使用，必须使用非阻塞模式，像filechannel不能与selector一起使用，因为它是阻塞模式
	 * 关于这部分测试（因为涉及到服务器和客户端）参考rpc-app里面
	 */
	public static void testSelector(){
		ServerSocket dd ;
		Selector selector = null;
		try{
			// 创建selector对象
			selector = Selector.open();
			
			// 创建可选择通道,并配置为非阻塞模式，绑定通道到指定端口
			SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("172.16.15.28", 8099));
			socketChannel.configureBlocking(false);
			
			// 向selector注册感兴趣的事件
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

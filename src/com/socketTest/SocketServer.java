package com.socketTest;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket编程server端
 * @author liaokangli
 *
 */
public class SocketServer {
	
	public static void main(String[] args){
	  try{
		int port = 6014;
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("127.0.0.1",port));
		Socket socket = serverSocket.accept();	
		
		BufferedInputStream buff = new BufferedInputStream(socket.getInputStream());
		byte[] byteb = new byte[1024];
		int len = 0;
		while((len = buff.read(byteb))!=-1){
			String str = new String(byteb);
			System.out.println("结果："+str);
		}
		
//		Reader reader = new InputStreamReader(socket.getInputStream());
//		char[] buffer = new char[1024];
//		int len = 0;
////		while((len = reader.read(buffer))!=-1){
//	    reader.read(buffer);
//		String str = new String(buffer);
//		System.out.println("结果:"+str);
//		}
		
		Writer writer = new OutputStreamWriter(socket.getOutputStream());
		writer.write("已经接受了");
		writer.flush();
		writer.close();
		socket.close();
//		reader.close();
		
	  }catch(Exception e){
		  e.fillInStackTrace();
	  }
	}

}

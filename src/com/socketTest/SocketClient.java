package com.socketTest;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

/**
 * socket±à³Ìclient¶Ë
 * @author liaokangli
 *
 */
public class SocketClient {
	
	public static void main(String[] args){
		int port = 6014;
		String host = "127.0.0.1";
		try{
		  Socket socket = new Socket(host,port);
		  Writer writer = new OutputStreamWriter(socket.getOutputStream());
		  writer.write("java.io.OutputStreamWriter");
		  writer.flush();
		  
		 
		  
		  Reader reader = new InputStreamReader(socket.getInputStream());
		  int len = 0;
		  char[] readValue = new char[1024];
//		  while((len = reader.read(readValue))!=-1){
		      reader.read(readValue);
			  String str = new String(readValue);
			  System.out.println("====:"+str);
//		  }
		  reader.close();
		  writer.close();
		  socket.close();
		}catch(Exception e){
			e.fillInStackTrace();
		}
	}

}

package com.javanet;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * ¿Í»§¶Ë
 * @author liaokangli
 *
 */
public class Client {
	
	public static void main(String[] args){
	  try{
		String host = "127.0.0.1";
		
		int port = 8899;
		
		Socket client = new Socket(host,port);
		Writer writer = new OutputStreamWriter(client.getOutputStream());
		
		writer.write("Hello server");
		writer.flush();
		writer.close();
		client.close();
	  }catch(Exception e){
		  e.printStackTrace();
	  }
		
	}

}

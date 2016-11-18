package com.socketTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class QuoteServerThread extends Thread{
	private DatagramSocket socket;
	
	private BufferedReader in;
	
	public QuoteServerThread(){
		this("QuoteServer");
	}
	
	public QuoteServerThread(String name){
		super(name);
		
		try{
		   this.socket = new DatagramSocket(4445);
		   
		   this.in = new BufferedReader(new FileReader("G:\\dd\\t\\tt.txt"));
		   
		}catch(Exception e){
		   System.out.println("Couldn't open quote file.  Serving time instead.");
		}
	}
	
	@Override
	 public void run() {
		String line = null;
		try {
			while((line = in.readLine()) != null){
				// 接受客户端的请求
				byte[] buf = new byte[256];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String clientSendStr = new String(buf,"utf-8");
				System.out.println("client data:"+clientSendStr);
				
				// 发送数据包给客户端
				System.out.println("send client data:"+line);
				buf = line.getBytes();
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buf,buf.length,address,port);
				socket.send(packet);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	
	
	public static void main(String[] args){
		QuoteServerThread server = new QuoteServerThread();
		server.start();
	}
}

package com.socketTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * ���ݰ����� �ͻ���
 * https://docs.oracle.com/javase/tutorial/networking/datagrams/clientServer.html
 * @author liaokangli
 *
 */
public class DatagramPacketTest {
	
	public static void main(String[] args) throws Exception{
		
		int port=4445;
		// ���͸�������
		byte[] sends = "hello server !".getBytes();
		byte[] sendBuf = new byte[256];
		InetAddress address = InetAddress.getByName("127.0.0.1");
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket packet = new DatagramPacket(sends,sends.length,address,port);		
		socket.send(packet);
		
		//���ܷ��������͹�������Ϣ
		packet = new DatagramPacket(sendBuf,sendBuf.length);
		socket.receive(packet);
		String received = new String(packet.getData(), 0, packet.getLength());
		System.out.println("Quote of the Moment: " + received);
		
	}
	
	
	

}

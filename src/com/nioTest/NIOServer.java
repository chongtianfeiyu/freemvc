package com.nioTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * socketchannel����
 * 
 * NIO����� 
 * @author liaokangli
 *
 */
public class NIOServer {
	// ͨ��������
	private Selector selector;
	
	public void initServer(int port) throws IOException{
		
		// ���һ��ServerSocketͨ��
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		
		serverChannel.configureBlocking(false);
		
		serverChannel.socket().bind(new InetSocketAddress(port));
		this.selector = Selector.open();
		serverChannel.register(selector,SelectionKey.OP_ACCEPT);
	}
	

	public static void main(String[] args){
		
	}
	
	
	
}

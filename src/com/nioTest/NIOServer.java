package com.nioTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * socketchannel测试
 * 
 * NIO服务端 
 * @author liaokangli
 *
 */
public class NIOServer {
	// 通道管理器
	private Selector selector;
	
	public void initServer(int port) throws IOException{
		
		// 获得一个ServerSocket通道
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		
		serverChannel.configureBlocking(false);
		
		serverChannel.socket().bind(new InetSocketAddress(port));
		this.selector = Selector.open();
		serverChannel.register(selector,SelectionKey.OP_ACCEPT);
	}
	

	public static void main(String[] args){
		
	}
	
	
	
}

package com.javaapitest;

import java.net.URI;

/**
 * uri
 * @author liaokangli
 *
 */
public class URITest {
	public static void main(String[] args) throws InterruptedException {
		URI nnuri = URI.create("hdfs://hzmobile-bigdata-110d11:9000");
		System.out.println(nnuri.getHost()+":"+nnuri.getPort());
		
		URITest aa = new URITest();
		aa.join(nnuri);
		
	}
	
	public synchronized void join(URI nnuri) throws InterruptedException{
		while(true){
			wait();
		}
	}
}

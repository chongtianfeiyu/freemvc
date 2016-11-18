package com.jmstest.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Session;

/**
 * 点对点jms模型
 * @author liaokangli
 *
 */
public class Consumer {
	
	private static String brokerUrl = "http://localhost:61616";
	
	private static transient ConnectionFactory factory;
	
	private transient Connection connection;
	
	private transient Session session;
	
	private String jobs[] = new String[]{"suspend","delete"};
	
	public Consumer(){
//		factory = new ActiveMQConnectionFactory(brokerURL);
	}

}

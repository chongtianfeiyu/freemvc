package com.webservices;

import javax.xml.ws.Endpoint;

/**
 * webservice∑¢≤º≤‚ ‘
 * @author liaokangli
 *
 */
public class WebServiceTest {

	public static void main(String[] args){
		Endpoint.publish("http://localhost:8080/service/helloJaxWs", new HelloJaxwsImpl()); 
	}
	
	
}

package com.webservices;

import javax.jws.WebService;

@WebService(endpointInterface = "com.webservices.HelloJaxws")
public class HelloJaxwsImpl implements HelloJaxws {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello, JAX-WS"; 
	}

}

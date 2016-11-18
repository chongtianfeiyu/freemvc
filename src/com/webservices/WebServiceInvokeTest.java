package com.webservices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * webservice调用测试
 * @author liaokangli
 *
 */
public class WebServiceInvokeTest {

	public static void main(String[] args) throws MalformedURLException{
		//创建访问wsdl服务地址的URL

        URL url = new URL("http://localhost:8080/service/helloJaxWs?wsdl");

        //通过QName指明服务的具体信息

        QName sName = new QName("http://webservices.com/", "HelloJaxwsImplService");

        //创建服务

        Service service = Service.create(url, sName);

        //实现接口

        HelloJaxws ms = service.getPort(HelloJaxws.class);

        System.out.println(ms.sayHello());

	}
}

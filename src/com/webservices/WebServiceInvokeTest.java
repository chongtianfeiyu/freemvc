package com.webservices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * webservice���ò���
 * @author liaokangli
 *
 */
public class WebServiceInvokeTest {

	public static void main(String[] args) throws MalformedURLException{
		//��������wsdl�����ַ��URL

        URL url = new URL("http://localhost:8080/service/helloJaxWs?wsdl");

        //ͨ��QNameָ������ľ�����Ϣ

        QName sName = new QName("http://webservices.com/", "HelloJaxwsImplService");

        //��������

        Service service = Service.create(url, sName);

        //ʵ�ֽӿ�

        HelloJaxws ms = service.getPort(HelloJaxws.class);

        System.out.println(ms.sayHello());

	}
}

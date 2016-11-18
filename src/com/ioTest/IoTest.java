/**
 * 19lou.com
 */
package com.ioTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liaokangli
 *
 */
public class IoTest {
       public static void main(String[] args) throws IOException {
    	  
    
    	   Class classz = BufferedInputStream.class;
    	   Method[] methods = classz.getMethods();
    	   
    	   List<Method> methodDeal = new ArrayList<Method>();
    	   
    	   for(Method method:methods){
    		   if(method.getName().equals("read")){
    			   methodDeal.add(method); 
    		   }
    		   
    	   }
    	   
    	   // ����������
//    	   File file = new File("F:\\hadoopresult\\postresult\\post-result-210.txt");
//    	   System.out.println("�ļ���С��"+file.length());
//    	   
//    	   byte[] buffer = new byte[1631253];
//           int bufePosition = 0;
//           BufferedInputStream buf1 = new BufferedInputStream(new FileInputStream("F:\\hadoopresult\\postresult\\post-result-210.txt"));
//           
//           int count = 0;
//           while((bufePosition = buf1.read(buffer)) != -1){
//        	   String str = new String(buffer,0,bufePosition);
//        	   System.out.println(""+str);
//        	   count++;
//        	   
//           }
           
           // ���������
//           File fileOut = new File("F:\\testOut.txt");
//           System.out.println("����ļ���С��"+fileOut.length());
//           byte[] bufferOut = new byte[]{10,20,12,31};
//           BufferedOutputStream buf2 = new BufferedOutputStream(new FileOutputStream("F:\\testOut.txt"));
//           buf2.write(buffer);
          
//           System.out.println("position:" + count);
           
           // �ֽ�������
//           ByteArrayInputStream bufArray = new ByteArrayInputStream(bufferOut);
//           byte[] bufferByte = new byte[4];
//           int data = bufArray.read(bufferByte);
           
           // dataInputStream
           DataInputStream dataInput = new DataInputStream(new FileInputStream("F:\\123.txt"));
           byte[] bufData = new byte[8];
           
           int count = 0;
           int bufePosition = 0;
           System.out.println("��ʼ");
           while((bufePosition = dataInput.readShort()) != -1){
        	   System.out.println(""+bufePosition);
        	   count++;
        	   
           }
	}
}

package com.ioTest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;

/**
 * zip������
 * @author liaokangli
 *
 */
public class ZipTest {
	
	public static void main(String[] args){
//		testCheckedInputStream();
//		testDeflater();
		testGZIPInputStream();
	}
	
	/**
	 * 1������CheckedInputStream
	 * �����������紫���У��ж������ļ��Ƿ�һ����ͨ���ж�checksum�Ƿ�һ���ж������ļ��Ƿ�һ����
	 * ����У���ļ���������
	 */
	public static void testCheckedInputStream(){
		FileInputStream in = null;
		try{
			in = new FileInputStream("E:\\19¥��Ŀ\\�ⲿ��Դ\\demo_dw_v2.1.4_201506_dw ����ƽ̨_�ⲿ��Դ���ݸ��ٲ�ѯ.rar");
			CheckedInputStream checked = new CheckedInputStream(in,new Adler32());
			byte[] b = new byte[4096];
			while((checked.read(b))!=-1){
				System.out.println(new String(b,"UTF-8"));
			}
			in.close();
			checked.close();
			System.out.println("======:"+checked.getChecksum().getValue());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 2������Adler32.
	 * Adler32����checksum��Ŀ
	 */
	public static void testAdler32(){
		Adler32 adler32 = null;
	}
	
	
	/**
	 * 3������Deflater
	 * ѹ�����ݺͽ�ѹ������
	 * 
	 */
    public static void testDeflater(){
      try{
    	String inputString = "blahblahblah";
    	byte[] input = inputString.getBytes("UTF-8");
    	
    	// ѹ��
    	byte[] output = new byte[100];
    	Deflater compresser = new Deflater();
    	compresser.setInput(input);
    	compresser.finish();
    	int compressedDataLength = compresser.deflate(output);
    	compresser.end();
     	String compressString = new String(output,0,compressedDataLength,"UTF-8");
    	System.out.println("ѹ���������:"+compressString);
    	
    	// decompress the bytes
    	Inflater decompresser = new Inflater();
    	decompresser.setInput(output, 0, compressedDataLength);
    	byte[] result = new byte[100];
    	int resultLength = decompresser.inflate(result);
    	decompresser.end();
    	String outputString = new String(result,0,resultLength,"UTF-8");
    	System.out.println("��ѹ���������:"+outputString);
      }catch(Exception e){
    	  e.printStackTrace();
      }
    }
    
    /**
     * ���Բ��ý�ѹ���İ���ȡ������������
     */
    public static void testGZIPInputStream(){
    	BufferedReader gzin = null;
    	try{
    		gzin = new BufferedReader(new FileReader("F:\\hadoopDown\\user_society_info.txt.gz"));
    	    byte[] result = new byte[1024];
    	    int read = 0;
    	    String line = "";
    	    while((line = gzin.readLine()) != null){
    	    	System.out.println(line);
    	    }
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		if(gzin != null){
    			try {
					gzin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	
    }
    
    /**
     * ����GZIPInputStream
     */
    public static void testGZIPInputStream1(){
    	GZIPInputStream gzin = null;
    	try{
    		gzin = new GZIPInputStream(new FileInputStream("F:\\hadoopDown\\user_society_info.txt.gz"));
    	    byte[] result = new byte[1024];
    	    int read = 0;
    	    while((read = gzin.read(result)) != -1){
    	    	System.out.println(new String(result,"UTF-8"));
    	    }
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		if(gzin != null){
    			try {
					gzin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	
    }
}

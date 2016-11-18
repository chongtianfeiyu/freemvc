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
 * zip流测试
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
	 * 1、测试CheckedInputStream
	 * 可以用于网络传输中，判断两个文件是否一样。通过判断checksum是否一样判断两个文件是否一样。
	 * 用于校验文件的完整性
	 */
	public static void testCheckedInputStream(){
		FileInputStream in = null;
		try{
			in = new FileInputStream("E:\\19楼项目\\外部来源\\demo_dw_v2.1.4_201506_dw 数据平台_外部来源数据跟踪查询.rar");
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
	 * 2、测试Adler32.
	 * Adler32计算checksum数目
	 */
	public static void testAdler32(){
		Adler32 adler32 = null;
	}
	
	
	/**
	 * 3、测试Deflater
	 * 压缩数据和解压缩数据
	 * 
	 */
    public static void testDeflater(){
      try{
    	String inputString = "blahblahblah";
    	byte[] input = inputString.getBytes("UTF-8");
    	
    	// 压缩
    	byte[] output = new byte[100];
    	Deflater compresser = new Deflater();
    	compresser.setInput(input);
    	compresser.finish();
    	int compressedDataLength = compresser.deflate(output);
    	compresser.end();
     	String compressString = new String(output,0,compressedDataLength,"UTF-8");
    	System.out.println("压缩处理完成:"+compressString);
    	
    	// decompress the bytes
    	Inflater decompresser = new Inflater();
    	decompresser.setInput(output, 0, compressedDataLength);
    	byte[] result = new byte[100];
    	int resultLength = decompresser.inflate(result);
    	decompresser.end();
    	String outputString = new String(result,0,resultLength,"UTF-8");
    	System.out.println("解压缩处理完成:"+outputString);
      }catch(Exception e){
    	  e.printStackTrace();
      }
    }
    
    /**
     * 测试不用解压缩的包读取的数据是乱码
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
     * 测试GZIPInputStream
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

package com.ioTest;

import java.io.File;
import java.io.FileOutputStream;

public class TestSystemIo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testFileOutputStream();
	}
	
	/**
	 * 2、Files
	 * 测试FileOutputStream.将内存里面的数据写到文件里面去
	 */
	public static void testFileOutputStream(){
		FileOutputStream fileOutputStream = null ;
		String str = "测试FileOutputStream.将内存里面的数据写到文件里面去";
		try{
			fileOutputStream = new FileOutputStream(new File("G:\\testOuptStream"));
			for(int i = 0;i < 10000;i++){
				str = str + "测试FileOutputStream.将内存里面的数据写到文件里面去测试FileOutputStream.将内存里面的数据写到文件里面去";
			}
			while(true){
				
				fileOutputStream.write(str.getBytes());
				System.out.println("写完");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fileOutputStream != null){
				try{
					fileOutputStream.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}

}

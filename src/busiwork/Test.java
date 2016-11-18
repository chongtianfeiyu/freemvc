package busiwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import sun.nio.cs.StreamEncoder;

/**
 * 重启电脑就好了（奇怪)
 * 为什么文件中没有写入中字，好像是直接过滤掉了，过滤两个字节(改成英文过滤掉两个字符)。如果append改为true,却可以
 * @author liaokangli
 *
 */
public class Test {

	
	public static void main(String[] args){
//		testFileOutputStreamAppend();
		sdWrite();
	}
	
	
    /**
     * 不加append是否会过滤掉中字,答案：否
     */
	public static void testFileOutputStreamAppend(){
		try {
			FileOutputStream fos = new FileOutputStream(new File("F:\\testOut.txt"));
			String str = "中看的我是";
			fos.write(str.getBytes());
			fos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 测试为什么会过滤掉两个字节的字符，比如中字会被过滤掉
	 */
	public static void sdWrite(){
		char[] cbuf = {'中','看','的','我','是'};
		Test test = new Test();
		try {
			test.write(cbuf, 0, cbuf.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public  void write(char cbuf[], int off, int len) throws IOException {
    	// 不加true会过滤掉两个字节的字符
    	TestStreamDecoder se = TestStreamDecoder.forOutputStreamWriter(new FileOutputStream(new File("F:\\testOut.txt")), this, (String)null);
    	
        se.write(cbuf, off, len);
        se.flush();
        System.out.println("tt");
    }
    
}

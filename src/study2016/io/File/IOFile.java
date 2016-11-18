package study2016.io.File;

import java.io.File;
import java.io.IOException;

/**
 * 文件
 * @author liaokangli
 *
 */
public class IOFile {
	
	public static void main(String[] args){
		fileNormal();
	}
	
	/**
	 * 正常。路径问题
	 */
	public static void fileNormal(){
		// 当前目录 项目目录。是freeMvc 而不是freeMvc/src/study2016/io/file
		File file = new File("log.log");
		try {
			file.createNewFile();
			boolean exists = file.exists();
			System.out.println("====tt:"+exists);
			String absolutePath = file.getAbsolutePath();
			String canonicalPath = file.getCanonicalPath();
			System.out.println("====absolutePath:"+absolutePath);
			System.out.println("====canonicalPath:"+canonicalPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tt");
		
	}
	

}

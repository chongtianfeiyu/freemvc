package study2016.io.File;

import java.io.FilePermission;
import java.security.AccessController;

/**
 * 文件权限
 * @author liaokangli
 *
 */
public class IOFilePermission {

	public static void main(String[] args){
		filePermissionNormal();
	}
	
	/**
	 * 文件权限。需要在D:\Program Files\Java\jdk1.6.0_25\jre\lib\security\java.policy 
	 * 里面增加permission java.io.FilePermission "G:\\log_input.txt", "read"; 才不会报错
	 * 比如将下面的read改成write报错access denied
	 */
	public static void filePermissionNormal(){
		FilePermission fp = new FilePermission("G:\\log_input.txt","read");
		AccessController.checkPermission(fp);
	}
	
	
}

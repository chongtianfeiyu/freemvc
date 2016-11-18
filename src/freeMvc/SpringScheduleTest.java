/**
 * 19lou.com
 */
package freeMvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.*;
/**
 * @author liaokangli
 *
 */
public class SpringScheduleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("加载spring配置文件....");
		ApplicationContext context = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		System.out.println("加载配置文件完毕!");
	}

}

/**
 * 19lou.com
 */
package freeMvc;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import freeMvc.test1.InnerClass;

/**
 * @author liaokangli
 *
 */
public class javaTest {

	public static void main(String[] args) {
		Class classz = InnerClass.class;
		System.out.println(classz.getName());
		System.out.println("result:"+(1&64));
		System.out.println("aaa:"+getName("a","b","c","d"));
		
		//反射使用
		try {
			Class<?> class1 = Class.forName("freeMvc.SpringScheduleTest");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("类不存在");
		}
		
		XmlBeanDefinitionReader aa;
	}
	
	public static String getName(String aa,String...strings){
		String result="";
		for(int i=0;i<strings.length;i++){
			result = result + strings[i] + ",";
		}
		return result;
	}
}

/**
 * 19lou.com
 */
package freeMvc;

/**
 * @author liaokangli
 *
 */
public class test1 {
	private String name ;
    private int age;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Runtime.getRuntime().maxMemory());
	}
    
	
	class InnerClass{
        public InnerClass(){
            name = "chenssy";
            age = 23;
        }
    }
}

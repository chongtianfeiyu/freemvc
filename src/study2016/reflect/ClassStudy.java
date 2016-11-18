package study2016.reflect;

import study2016.serialize.SeriableWithConstructor;

/**
 * 反射class类
 * @author liaokangli
 *
 */
public class ClassStudy {
	
	public static void main(String[] args){
//		NewInstancePrivate nip = new NewInstancePrivate("tt");
		classNewInstance();
	}
	
	/**
	 * 反射new instance。
	 */
	public static void classNewInstance(){
		Class nipc = SeriableWithConstructor.class;
		try {
			Object object = nipc.newInstance();
			System.out.println("ts");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

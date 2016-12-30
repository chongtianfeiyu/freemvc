package study2016.javabasis.datatype;

/**
 * String type
 * @author liaokangli
 *
 */
public class StringType {
	
	public static void main(String[] args){
//		stringNormal();
		stringThreadSafe();
	}
	
	/**
	 * 下面的字符串除了new操作产生的字符串之外，其余可以在编译时期确定，
	 * 所以会存在字符串常量池中。
	 * http://developer.51cto.com/art/201106/266454.htm
	 * http://stackoverflow.com/questions/3052442/what-is-the-difference-between-text-and-new-stringtext
	 *http://stackoverflow.com/questions/22832671/does-new-string-update-the-string-pool-in-java
	 *http://stackoverflow.com/questions/14150628/string-constant-pool-java
	 */
	public static void stringNormal(){
		String str1 = "aaccc";
		String str2 = "aa"+"ccc";
		// 由于new String("ccc")需要在运行时期确定(多少内存），所以str3不存在常量池中
		String str3 = "aa" + new String("ccc");
		String str4 = new String("aaccc");
		
		
		String str5 = new String("yuio");
		String str6 = "yuio";
		String str7 = "yuio";
		
		String str9 = "mn";
		
		// 常量池中没有这个
		String str8 = new String(str9) + new String(str6);
//		str8.intern();
		
		// 其中uio是字符串常量。
		String str10 = new String(str9) + new String("uio");
		
		System.out.println("str1===str2:"+(str1 == str2));
		System.out.println("str2===str3:"+(str2 == str3));
		System.out.println("str3===str4:"+(str3 == str4));
		System.out.println("str5===str7:"+(str5 == str7));
		System.out.println("str5===str6 intern:"+(str5.intern() == str6));
	}
	
	/**
	 * 下面这个例子中，多线程情况下string的值是不改变的，只是引用改变了
	 */
	public static void stringThreadSafe(){
		final MyString myString = new MyString();
		
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				myString.setName("bbb");
				char t1 = myString.name.charAt(0);
				System.out.println("aa");
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				myString.setName("sss1");
				char t1 = myString.name.charAt(0);
				myString.name.hashCode();
				System.out.println("aa");
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	public static class MyString{
		private String name = "tt";

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
	/**
	 * StringBuffer,StringBuilder,String区别
	 * 为什么说StringBuffer比String快https://www.zhihu.com/question/20101840
	 * http://blog.csdn.net/liu136313/article/details/50851100
	 */
	public static void muttableStringBuffer(){
		// String buffer.线程安全，可变的
		StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("astb");
        sbuffer.setCharAt(0, 't');
        
        
	}

}

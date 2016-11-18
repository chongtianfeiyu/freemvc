package study2016.serialize;

import java.io.Serializable;

/**
 * 不带有默认构造器的序列化,还是能进行序列化和反序列化。跟构造器没有关系
 * @author liaokangli
 *
 */
public class SeriableWithConstructor implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	private String name = "tt";
	
	
	private SeriableWithConstructor(String name){
		this.name = name;
	}
	
	public SeriableWithConstructor(){
		System.out.println("invoke private SeriableWithConstructor");
	}

}

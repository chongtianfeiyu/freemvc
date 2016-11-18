package study2016.serialize;

import java.io.Serializable;

/**
 * 嵌套序列化类型
 * @author liaokangli
 *
 */
public class NestParentSeriable implements Serializable{
	
	public String bn = "bn";
	
	public SubParentSeriable sps = new SubParentSeriable();
	
	public SubParentNoSeriable spns = new SubParentNoSeriable();

}

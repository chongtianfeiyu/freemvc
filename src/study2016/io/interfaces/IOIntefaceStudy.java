package study2016.io.interfaces;

import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import study2016.serialize.ParentSeriable;

/**
 * io接口
 * @author liaokangli
 *
 */
public class IOIntefaceStudy {
	
	public static void main(String[] args){
		Closeable c;
		// 从二进制流中读取字节,并重构所有java基本类型数据
		DataInput di;
		// 将java基本类型转换为一系列字节,并写入二进制流中
		DataOutput ddo;
		// 从二进制流张读取字节，继承DataInput,并重构java对象，包括object,arrays,string
		ObjectInput oi;
		// 继承DataOutput,将java对象包括，object,arrays,string转换为字节流，并写入二进制流中
		ObjectOutput oo;
		
		
	}
	
	
	
	
	
	

}

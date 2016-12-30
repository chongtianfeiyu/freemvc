package study2016.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;


/**
 * 序列化
 * @author liaokangli
 *
 */
public class SerializeStudy {
	
	public static void main(String[] args){
		/** 正常序列化*/
		serializeNormal();
		
		/** 嵌套序列化类型*/
//		serializeNestedType();
		
		/** 未实现序列化的继承序列化*/
//		seriablizeExtendsNo();
		
		/** 实现序列化的继承未实现序列化*/
//		seriablizeExtendsWith();
		
//		seriablizeDynamicField();
		
//		seriablizeConstructor();
		
//		seriablizeArray();
		
//		seriablizeHook();
		
//		seriablizeDES();
		
		commonDerialize();
	}
	
	/**
	 * 正常序列化(成员变量包括public,protected,private,default的成员变量,嵌套的可序列化对象都会被序列化。但是静态变量，有transient声明的不可序列化)
	 * 。对修饰符的反应，以及方法(其实方法没有被序列化，查看序列化后的文件可以知道，根据jvm结构可以知道，对象的方法是位于方法区中的。具体参见笔记jvm对象定位——如何找到方法)
	 */
    public static void serializeNormal(){
      try{
    	ParentSeriable ps = new ParentSeriable();
    	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://parentSeriable.bin"));
    	oos.writeObject(ps);
      }catch(Exception e){
    	  e.printStackTrace();
      }
    }
    
    /**
     * 可序列化类嵌套不可序列化。比如NestParentSeriable类(可序列化)里面有个可序列化SubParentSeriable和不可序列化的对象SubParentNoSeriable
     * 抛异常，不可序列化类型将会报错，说不可序列化：java.io.NotSerializableException: study2016.serialize.SubParentNoSeriable
     */
    public static void serializeNestedType(){
    	try{
    		NestParentSeriable nps = new NestParentSeriable();
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://NestParentSeriable.bin"));
    		oos.writeObject(nps);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * 序列化继承.SubParentExtendsNo(本身没有实现序列化）继承了ParentSeriable(已经实现序列化）
     * SubParentExtendsNo里的成员可以序列化，其实不难理解：继承了父类的可序列化特性
     */
    public static void seriablizeExtendsNo(){
    	try{
    		SubParentExtendsNo spen = new SubParentExtendsNo();
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://SubParentExtendsNo.bin"));
    		oos.writeObject(spen);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * 序列化继承。SubParentSeriableWith(本身实现序列化），继承了没有序列化的类SubParentNoSeriable
     * SubParentNoSeriable里面的成员也是可以序列化的。其实这个也可以理解，继承的未实现序列化的类 的成员在SubParentSeriableWith变得可序列化
     */
    public static void seriablizeExtendsWith(){
    	try{
    		SubParentSeriableWith spen = new SubParentSeriableWith();
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://seriablizeExtendsWith.bin"));
    		oos.writeObject(spen);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * 动态添加字段。序列化后，在SeriablizeDynamicField 添加字段。
     * 反序列化后抛异常，不兼容的类。解决方案:添加版本号(必须是static final,很好理解,这个会存在方法区里面)
     */
    public static void seriablizeDynamicField(){
    	try{
    		SeriablizeDynamicField spen = new SeriablizeDynamicField();
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://SeriablizeDynamicField.bin"));
    		oos.writeObject(spen);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * 不具有默认构造器的序列化机制,可以反序列化回来
     */
    public static void seriablizeConstructor(){
    	
    	try{
//    		SeriableWithConstructor spen = new SeriableWithConstructor("as");
//    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://SeriableWithConstructor.bin"));
//    		oos.writeObject(spen);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * 序列化数组，
     */
    public static void seriablizeArray(){
    	
    	try{
    		Object[] as = new Object[2];
    		as[0] = new SubParentNoSeriable();
    		as[1] = new SubParentSeriable();
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://array.bin"));
    		oos.writeObject(as);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
	 * Externalizable 正常使用，具有serializable和transient两个功能
	 */
	public static void externalizableNormalUse(){
		
		try{
			// 序列化
			ExternalizableBlip ps = new ExternalizableBlip("aa",100);
	    	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://ExternalizableBlip.bin"));
	    	oos.writeObject(ps);
	    	// 反序列化
	    	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G://ExternalizableBlip.bin"));
	    	Object object = ois.readObject();
	    	System.out.println("tt");
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }
		
		
		
	}
    
    /**
     * 网络传输安全考虑，将某些字段hook,模糊化
     */
    public static void seriablizeHook(){
    	try{
    		SeriablizeHook sh = new SeriablizeHook();
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://SeriablizeHook.bin"));
    		oos.writeObject(sh);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    
	/**
	 * 网络传输安全考虑,对序列化对象进行加密,反序列化的时候需要用相应的秘钥
	 */
	public static void seriablizeDES(){
		try{
	    	ParentSeriable ps = new ParentSeriable();
	    	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G://seriablizeDES.bin"));
	    	// 取得加密
	    	Cipher cipher = Cipher.getInstance("DES");
	    	Key key = getKey("Hellow Word!".getBytes()); 
	    	cipher.init(Cipher.ENCRYPT_MODE, key);
	    	oos.writeObject(new SealedObject(ps,cipher));
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }
	}
    
    
    /**
     * 公用反序列化方法
     */
    public static void commonDerialize(){
      try{
		// 反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G://parentSeriable.bin"));
		Object object = ois.readObject();		
		ParentSeriable ps = (ParentSeriable)object;
		Object or = null;
		// 反射获取方法
		Class classz = object.getClass();
		if(classz.isAssignableFrom(SealedObject.class)){
			SealedObject seaObject = (SealedObject)object;
			// 取得加密
	    	Cipher cipher = Cipher.getInstance("DES");
	    	Key key = getKey("Hellow Word!".getBytes()); 
	    	cipher.init(Cipher.DECRYPT_MODE, key);
			or = seaObject.getObject(cipher);
		}
		Method[] methods = classz.getDeclaredMethods();
		for(Method method: methods){
			System.out.println(method.getName());
		}
		System.out.println("dd");
      }catch(Exception e){
    	  e.printStackTrace();
      }
    }
    
    /**
     * 获取key
     * @param arrBTmp
     * @return
     * @throws Exception
     */
    private static Key getKey(byte[] arrBTmp) throws Exception {  
        byte[] arrB = new byte[8];  
  
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {  
            arrB[i] = arrBTmp[i];  
        }  
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");  
        return key;  
    }  

}

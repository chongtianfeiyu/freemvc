package study2016.io.streams;

import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;

import study2016.io.streams.IOObjectOutputStream.OOS;

/**
 * IO ObjectStreamClass
 * @author liaokangli
 *
 */
public class IOObjectStreamClass {
	
	public static void main(String[] args){
		objectStreamClassNormal();
	}
	
	public static void objectStreamClassNormal(){
		ObjectStreamClass osc = ObjectStreamClass.lookup(OOS.class);
		for(ObjectStreamField field:osc.getFields()){
			System.out.println("========offset:"+field.getOffset());
		}
		System.out.println("ts");
	}

}

package study2016.serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 实现接口Externalizable的类
 * @author liaokangli
 *
 */
public  class ExternalizableBlip implements Externalizable{
	
    private int i;
	
	private String s;
	
	public ExternalizableBlip(){
		System.out.println("ExternalizableBlip constructor");
	}
	
	public ExternalizableBlip(String s,int i){
		System.out.println("ExternalizableBlip constructor with param");
		this.s = s;
		this.i = i;
	}
	

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("invoke writeExternal");
		out.writeObject(s);
		out.writeInt(i);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("invoke readExternal");
		s = (String)in.readObject();
//		i = in.readInt();
	}

	
	
}

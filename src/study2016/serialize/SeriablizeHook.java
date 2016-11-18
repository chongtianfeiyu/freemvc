package study2016.serialize;

import java.io.Serializable;

/**
 * 
 * @author liaokangli
 *
 */
public class SeriablizeHook implements Serializable{
	
	private int age = 2;
	
	private void writeObject(java.io.ObjectOutputStream stream)
	        throws java.io.IOException
	    {
	        // "Encrypt"/obscure the sensitive data
	        age = age << 2;
	        stream.defaultWriteObject();
	    }

	    private void readObject(java.io.ObjectInputStream stream)
	        throws java.io.IOException, ClassNotFoundException
	    {
	        stream.defaultReadObject();

	        // "Decrypt"/de-obscure the sensitive data
	        age = age << 2;
	    }

}

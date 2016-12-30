package study2016.io.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public class ObjectOutputStreamDemo {

	   public static void main(String[] args) {

	      double d = 1.59875d;
	      try {

	         // create a new file with an ObjectOutputStream
	         FileOutputStream out = new FileOutputStream("f:\\test.txt");
	         ObjectOutputStream oout = new ObjectOutputStream(out);

	         // write something in the file
	         oout.writeObject(new Example());
	         oout.flush();
	         oout.close();

	         // create an ObjectInputStream for the file we created before
	         ObjectInputStream ois =
	                 new ObjectInputStream(new FileInputStream("f:\\test.txt"));

	         // read an object from the stream and cast it to Example
	         Example a = (Example) ois.readObject();
	         
	         a.readObject(ois);
             a.writeObject(oout);
	         // print var of a
	         System.out.println("" + a.var);
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }

	   }

	   static public class Example implements Serializable {

	      static int var = 76458;
	      // assign a new serialPersistentFields 
	      private static final ObjectStreamField[] serialPersistentFields = {
	         new ObjectStreamField("var", Integer.TYPE)
	      };

	      private void readObject(ObjectInputStream in)
	              throws IOException, ClassNotFoundException {

	         // get the field and assign it at var
	         ObjectInputStream.GetField fields = in.readFields();

	         // get var
	         var = fields.get("var", 0);
	         System.out.println("tt");
	      }

	      private void writeObject(ObjectOutputStream out)
	              throws IOException {

	         // write into the ObjectStreamField array the variable string
	         ObjectOutputStream.PutField fields = out.putFields();
	         fields.put("var", var);
	         out.writeFields();
	         System.out.println("tt");

	      }
	   }
	}

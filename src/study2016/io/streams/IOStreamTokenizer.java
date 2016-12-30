package study2016.io.streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.StreamTokenizer;

/**
 * 类似字符串分割
 * 不过原理就是将指定要分割的分隔符放入缓存里面
 * 然后再用要分割的字符串去比对
 * 
 * @author liaokangli
 *
 */
public class IOStreamTokenizer {

	public static void main(String[] args){
//		streamTokenizerNormal();
		streamTokenizerNormal1();
	}
	
	/**
	 * 正常使用
	 */
	public static void streamTokenizerNormal(){
		String text = "Hello. This is a text that will be split "
				              + "into tokens. 1+1=2";
				      try {
				         // create a new file with an ObjectOutputStream
				         FileOutputStream out = new FileOutputStream("f:\\test.txt");
				         ObjectOutputStream oout = new ObjectOutputStream(out);

				         // write something in the file
				         oout.writeUTF(text);
				         oout.flush();

				         // create an ObjectInputStream for the file we created before
				         ObjectInputStream ois =
				                 new ObjectInputStream(new FileInputStream("f:\\test.txt"));

				         // create a new tokenizer
				         Reader r = new BufferedReader(new InputStreamReader(ois));
				         StreamTokenizer st = new StreamTokenizer(r);

				         // set chars a to e as ordinary
				         st.ordinaryChars('a', 'e');

				         // print the stream tokens
				         boolean eof = false;
				         do {

				            int token = st.nextToken();
				            switch (token) {
				               case StreamTokenizer.TT_EOF:
				                  System.out.println("End of File encountered.");
				                  eof = true;
				                  break;
				               case StreamTokenizer.TT_EOL:
				                  System.out.println("End of Line encountered.");
				                  break;
				               case StreamTokenizer.TT_WORD:
				                  System.out.println("Word: " + st.sval);
				                  break;
				               case StreamTokenizer.TT_NUMBER:
				                  System.out.println("Number: " + st.nval);
				                  break;
				               default:
				                  System.out.println((char) token + " encountered.");
				                  if (token == '!') {
				                     eof = true;
				                  }
				            }
				         } while (!eof);


				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
	}
	
	/**
	 * 类似分割
	 */
	public static void streamTokenizerNormal1(){
		try{
			StreamTokenizer st = new StreamTokenizer(new FileInputStream("f:\\testOut.txt"));
			
			while(st.nextToken() != StreamTokenizer.TT_EOF){
				System.out.println("Word: " + st.sval);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

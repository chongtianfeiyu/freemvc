package study2016.io.streams;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道字符流
 * 两个线程之间传送数据
 * @author liaokangli
 *
 */
public class IOPipedReaderWriter {
	
	public static void main(String[] args){
		pipedReaderWriterNormal();
	}
	
	public static void pipedReaderWriterNormal(){
		try{
			// 管道字符输入流
			final PipedReader pr = new PipedReader();
			
			// 管道字符输出流
			final PipedWriter pw = new PipedWriter();
			
			pr.connect(pw);
			
			Thread t1 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					int i = 0;
					try{
						while(true){
							pw.write("tt"+(i++));
							Thread.sleep(10000);
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			});
			
			Thread t2 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					char[] chars = new char[1024];
					int count = 0;
					try{
						while(true){
							if((count = pr.read(chars)) != -1){
								System.out.println(new String(chars));
							}
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
			});
			
			t1.start();
			t2.start();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

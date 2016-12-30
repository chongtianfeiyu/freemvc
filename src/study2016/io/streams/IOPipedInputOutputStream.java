package study2016.io.streams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流。写入和读出
 * @author liaokangli
 *
 */
public class IOPipedInputOutputStream {
	
	public static void main(String[] args){
		pipedStreamNormal();
	}
	
	/**
	 * 管道流正常。一个线程写入到管道，另一个线程从管道里面读出
	 */
	public static void pipedStreamNormal(){
		try{
			// 管道流输出
			final PipedOutputStream pos = new PipedOutputStream();
			
			// 管道流读入
			final PipedInputStream pis = new PipedInputStream();
			
			pis.connect(pos);
			
			Thread t1 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i = 0;i < 2000; i++){
						try {
							
							pos.write(i);
//							Thread.sleep(10000);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
			});
			
			Thread t2 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					int count = 0;
					while(true){
						try{
							Thread.sleep(1000);
						 if((count = pis.read()) != -1){
							 System.out.println(Thread.currentThread().getName()+":"+count);
						 }
							
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
				
			});
			
			Thread t3 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					int count = 0;
					while(true){
						try{
							Thread.sleep(1000);
						 if((count = pis.read()) != -1){
							 System.out.println(Thread.currentThread().getName()+":"+count);
						 }
							
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
				
			});
			
			
			
			t1.start();
			t2.start();
//			t3.start();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

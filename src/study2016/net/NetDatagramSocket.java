package study2016.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 数据报文socket. udp使用。
 * @author liaokangli
 *
 */
public class NetDatagramSocket {
	
	public static void main(String[] args){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				dsSender();
			}
			
		});
		
	  Thread t2 = new Thread(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			dsReceiver();
		}
		  
	  });
	  
	  t1.start();
	  t2.start();
		
	}
	
	/**
	 * 模拟ip发送数据报文,每隔1秒发送一次 udp
	 */
	public static void dsSender(){
		try{
			
			DatagramSocket ds = new DatagramSocket();
			String str = "Welcome java";
			InetAddress ip = InetAddress.getByName("127.0.0.1");
			
			for(int i = 0;i < 1000;i++){
				DatagramPacket dp = new DatagramPacket((str+i).getBytes(),(str+i).length(),ip,3000);		
				ds.send(dp);
				Thread.sleep(1000);
			}
			
			ds.close();
			
		}catch(Exception e){
			e.fillInStackTrace();
		}
	}
	
	/**
	 * 模拟ip接受数据报文。udp
	 */
	public static void dsReceiver(){
		try{
			DatagramSocket ds = new DatagramSocket(3000);
			byte[] buf = new byte[1024];
			while(true){
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				String str = new String(dp.getData(),0,dp.getLength());
				System.out.println(str);
			}
			
			
//			ds.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

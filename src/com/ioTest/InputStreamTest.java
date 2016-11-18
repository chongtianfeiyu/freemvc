package com.ioTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.zip.ZipOutputStream;

/**
 * inputStream测试 输入流
 * 读取字节
 * @author liaokangli
 * 
 */
public class InputStreamTest {

	public static void main(String[] args) {
//		 testBufferedInputStream();
//		 testByteArrayInputStream();
		 testDataInputStream();
//		 testFilterInputStream();
//		 testObjectOutputStream();
//		 testPipedInputStream1();
//		testPipedInputStream2();
//		 testSequenceInputStream();

//		 testFileInputStream();
//		testRandomAccessFile();
//		testPushbackInputStream();
		
	}

	/**
	 * 1、arrays 测试ByteArrayInputStream
	 */
	public static void testByteArrayInputStream() {
		ByteArrayInputStream byteArray = null;
		byte[] buffer = new byte[] { 10, 20, 30 };
		byte[] buffer1 = new byte[1];
		try {
			byteArray = new ByteArrayInputStream(buffer);
			int byteRead = 0;
			while ((byteRead = byteArray.read(buffer1)) != -1) {
				System.out.println(buffer1[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (byteArray != null) {
				try {
					byteArray.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 2.1、files 直接读取文件流。每次都是跟磁盘打交道 测试FileInputStream
	 */
	public static void testFileInputStream() {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(new File(
					"E:\\19lou生活馆数据\\trade-temai-11-20.xlsx"));
			byte[] buffer1 = new byte[1024];
			int byteRead = 0;
			while ((byteRead = fileInputStream.read(buffer1)) != -1) {
				System.out.println(new String(buffer1, 0, byteRead, "gbk"));
				System.out.println("****************************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 2.2、files
	 * 该类的实例支持对文件的随机读取和写入。随机存取文件的行为类似存储在文件系统中的一个大型字节数组。存在指向该隐含数组的光标或索引，称为文件指针。
	 * 读取操作从文件指针开始读取字节，并随着对字节的读取而前移此文件指针。如果随机存取文件以读取/写入模式创建，则写入操作也可用；
	 * 写入操作从文件指针开始写入字节，并随着对字节的写入而前移此文件指针。该文件指针可以通过 getFilePointer 方法读取，并通过 seek
	 * 方法设置。 测试RandomAccessFile
	 */
	public static void testRandomAccessFile() {
		RandomAccessFile randomAccessFile = null;
		try {
			// 从设置的位置开始读取数据
			randomAccessFile = new RandomAccessFile("E:\\19lou生活馆数据\\xtx.txt",
					"rw");
			System.out.println("randomAccessFile的初始位置:"
					+ randomAccessFile.getFilePointer());
			// 从3位置读取数据
			randomAccessFile.seek(0);
			byte[] buff = new byte[1024];
			int byteRead = 0;
			while ((byteRead = randomAccessFile.read(buff)) != -1) {
				System.out.println(new String(buff, 0, byteRead, "gbk"));
				System.out.println("************");
			}
			
			// 重复读取实验
			randomAccessFile.seek(0);
			while ((byteRead = randomAccessFile.read(buff)) != -1) {
				System.out.println(new String(buff, 0, byteRead, "gbk"));
				System.out.println("dd************");
			}

			// 在文件尾部追加数据,将记录指针移动到最后
			randomAccessFile.seek(randomAccessFile.length());
			randomAccessFile.write("\n我是追加的\n".getBytes());

			// 任意位置插入数据，将记录指针移动到指定位置.这种追加方式会覆盖掉追加内容长度的数据。
			// 需要将追加点后面的数据放入临时文件，然后再追加
			randomAccessFile.seek(7);
			randomAccessFile.write("任意位置追加".getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (randomAccessFile != null) {
				try {
					randomAccessFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 3、piple 
	 * 管道流。
	 * 应用场景：
	 * Java IO中的管道为运行在同一个JVM中的两个线程提供了通信的能力。所以管道也可以作为数据源以及目标媒介。

     * 你不能利用管道与不同的JVM中的线程通信(不同的进程)。在概念上，Java的管道不同于Unix/Linux系统中的管道。
     * 在Unix/Linux中，运行在不同地址空间的两个进程可以通过管道通信。在Java中，通信的双方应该是运行在同一进程中的不同线程。
     * 
     * 内部源码实现看了有点类似于消费者生成者模式
	 * 测试PipedInputStream
	 * 
	 * @throws IOException
	 */
	public static void testPipedInputStream() {

		class Outter implements Runnable {

			private PipedOutputStream out;

			public Outter(PipedOutputStream out) {
				this.out = out;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String data = "有点郁闷";
				try {
					out.write(data.getBytes());
					out.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		class Inner implements Runnable {

			private PipedInputStream in;

			public Inner(PipedInputStream in) {
				this.in = in;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				byte[] buf = new byte[1024];
				try {
					int len = in.read(buf);
					String data = new String(buf, 0, len);
					System.out.println("从管道流中读取到数据：" + data);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		// 创建输出管道流---将数据（内存）写入到管道中
		PipedOutputStream pipeOut = new PipedOutputStream();
		// 创建输入管道流---从管道中读数据(到内存）
		PipedInputStream pipeIn = new PipedInputStream(4);
		try {
			// 使用管道将输出流与输入流进行连接。
			pipeIn.connect(pipeOut);
			new Thread(new Outter(pipeOut)).start();
			new Thread(new Inner(pipeIn)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 3、piple  同一个线程死锁测试(因为while循环里面一直wait(1000),每隔1s执行一次wait(1000)。没人改变in的值，所以死锁了）
	 * 管道流。
	 * 应用场景：
	 * Java IO中的管道为运行在同一个JVM中的两个线程提供了通信的能力。所以管道也可以作为数据源以及目标媒介。

     * 你不能利用管道与不同的JVM中的线程通信(不同的进程)。在概念上，Java的管道不同于Unix/Linux系统中的管道。
     * 在Unix/Linux中，运行在不同地址空间的两个进程可以通过管道通信。在Java中，通信的双方应该是运行在同一进程中的不同线程。
     * 
     * 内部源码实现看了有点类似于消费者生成者模式
	 * 测试PipedInputStream
	 * 
	 * @throws IOException
	 */
	public static void testPipedInputStream1() {

		class Outter implements Runnable {

			private PipedOutputStream out;
			
			private PipedInputStream in;

			public Outter(PipedOutputStream out,PipedInputStream in) {
				this.out = out;
				this.in = in;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				byte[] buf = new byte[1024];
				try {
					int len = in.read(buf);
					String data1 = new String(buf, 0, len);
					System.out.println("从管道流中读取到数据：" + data1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				String data = "有点郁闷";
				try {
					out.write(data.getBytes());
					out.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				


			}

		}

		

		// 创建输出管道流---将数据（内存）写入到管道中
		PipedOutputStream pipeOut = new PipedOutputStream();
		// 创建输入管道流---从管道中读数据(到内存）
		PipedInputStream pipeIn = new PipedInputStream(4);
		try {
			// 使用管道将输出流与输入流进行连接。
			pipeIn.connect(pipeOut);
			new Thread(new Outter(pipeOut,pipeIn)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 3、管道流正常测试
	 * 测试PipedInputStream
	 * 
	 * @throws IOException
	 */
	public static void testPipedInputStream2() {

		class Outter implements Runnable {

			private PipedOutputStream out;
			

			public Outter(PipedOutputStream out) {
				this.out = out;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				
				String data = "有点郁闷";
				try {
					out.write(data.getBytes());
					out.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				


			}

		}
		
		class Inner implements Runnable{
			
			
			private PipedInputStream in;

			public Inner(PipedInputStream in) {
				this.in = in;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				byte[] buf = new byte[4096];
				try {
					int len = in.read(buf);
					String data1 = new String(buf, 0, len);
					System.out.println("从管道流中读取到数据：" + data1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				


			}
			
		}

		

		// 创建输出管道流---将数据（内存）写入到管道中
		PipedOutputStream pipeOut = new PipedOutputStream();
		// 创建输入管道流---从管道中读数据(到内存）。如果把4去掉，将能读取出超过4个字节的数据。
		PipedInputStream pipeIn = new PipedInputStream(4);
		try {
			// 使用管道将输出流与输入流进行连接。
			pipeIn.connect(pipeOut);
			new Thread(new Outter(pipeOut)).start();
			new Thread(new Inner(pipeIn)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 4、buffering
	 * 
	 * 将读取到的指定数量的文件流先缓存到缓存区里面。减少了每次与磁盘进行打交道 测试BufferedInputStream
	 */
	public static void testBufferedInputStream() {
		BufferedInputStream bufferedInput = null;
		byte[] buffer = new byte[8000];

		try {
			bufferedInput = new BufferedInputStream(new FileInputStream(
					"E:\\19lou生活馆数据\\trade-temai-11-20.xlsx"));
			int bytesRead = 0;
			while ((bytesRead = bufferedInput.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, bytesRead, "gbk"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (bufferedInput != null) {
				try {
					bufferedInput.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	

	}
	
	/**
	 * 5、filtering
	 * “封装其它的输入流，并为它们提供额外的功能”。它的常用的子类有BufferedInputStream和DataInputStream,PushbackInputStream。
	 * BufferedInputStream的作用就是为“输入流提供缓冲功能，以及mark()和reset()功能
	 * DataInputStream 是用来装饰其它输入流，它“允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型”
	 * PushbackInputStream回退流
	 * 测试FilterInputStream
	 */
	public static void testFilterInputStream() {
		FilterInputStream filterInputStream = null;
		byte[] buffer = new byte[1024];
		try {

			// FilterInputStream构造器是供子类使用，因此使用匿名类构造子类
			filterInputStream = new FilterInputStream(new FileInputStream(
					"E:\\19lou生活馆数据\\trade-temai-11-20.xlsx")) {

			};
			int byteRead = 0;
			while ((byteRead = filterInputStream.read(buffer)) != -1) {
				System.out.println(byteRead);
			}
		} catch (Exception e) {

		} finally {
			if (filterInputStream != null) {
				try {
					filterInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	/**
	 * 6、parsing
	 * 回退流
	 * 测试PushbackInputStream
	 */
	public static void testPushbackInputStream(){
		// 从bytearray读取
		PushbackInputStream pushBackInputStream = null;
		String str = "www.mldnjava.cn";
		ByteArrayInputStream bai = null;
		
		// 从文件读取
		PushbackInputStream pushBackFile = null;
		try{
			bai = new ByteArrayInputStream(str.getBytes());
			pushBackInputStream = new PushbackInputStream(bai);
			System.out.println("读取之后的数据为：");
			int temp = 0;
			while ((temp = pushBackInputStream.read()) != -1){
				if(temp == '.'){
					pushBackInputStream.unread(temp);
					temp = pushBackInputStream.read();
					System.out.println("(退回"+(char)temp+")");
				}else{
					System.out.println((char)temp);
				}
			}
			
			// 从文件读取
			byte[] buff = new byte[4];
			pushBackFile = new PushbackInputStream(new FileInputStream("E:\\19lou生活馆数据\\xtx.txt"),4);
			System.out.println("-----------");
			int tempp = 0;
			while((tempp = pushBackFile.read(buff)) != -1){
				if(buff[3] == '.'){
					pushBackFile.unread((char)buff[3]);
					// buff[3]在下面的读中存在
					tempp = pushBackFile.read(buff);
					System.out.println("(退回"+(char)buff[3]+")");
				}else{
					System.out.println(buff);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pushBackInputStream != null){
				try {
					pushBackInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bai != null){
				try {
					bai.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pushBackFile != null){
				try{
					pushBackFile.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 7、data 
	 * 将基本 Java 数据类型读出
	 * 测试DataInputStream,直接从文件读取1024大小数据
	 */
	public static void testDataInputStream() {
		DataInputStream dataInputStream = null;
		byte[] buffer = new byte[1];
		try {
			dataInputStream = new DataInputStream(new FileInputStream(
					"E:\\19lou生活馆数据\\xtx.txt"));
			
			// 基本读取，字节
//			int byteRead = 0;
//			while ((byteRead = dataInputStream.read(buffer)) != -1) {
//				System.out.println(buffer[0]);
//			}
			//读取java基本类型,下面的无法执行，先把上面的注释掉，因为无法重复读
			// 无法读取整型数字，若文本里面存储的是12.实际是49 50
			System.out.println("********************");
			int resultInt = dataInputStream.readInt();
			System.out.println(resultInt);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (dataInputStream != null) {
				try {
					dataInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	

	/**
	 * 8、对象流
	 * 用于序列化中
	 * 测试ObjectOutputStream
	 */
	public static void testObjectOutputStream() {

		class Person implements Serializable {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			int id;
			String name;

			Person(int id, String name) {
				this.id = id;
				this.name = name;
			}

			public String toString() {
				return "id:" + id + " name:" + name;
			}
		}
		try {
			FileOutputStream fop = new FileOutputStream("d:/a.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fop);
			Person person = new Person(1, "zhang");
			oos.writeObject(person);
			person = new Person(2, "dd");
			oos.writeObject(person);
			person = new Person(3, "hhh");
			oos.writeObject(person);
			oos.close();
			FileInputStream fis = new FileInputStream("d:/a.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			for (int i = 0; i < 3; i++) {
				Person p2 = (Person) ois.readObject();
				System.out.println(p2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 9、顺序流
	 * 测试SequenceInputStream
	 * SequenceInputStream合并流，将与之相连接的流集组合成一个输入流并从第一个输入流开始读取，
	 * 直到到达文件末尾，接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末 尾为止。 合并流的作用是将多个源合并合一个源。
	 * 可接收枚举类所封闭的多个字节流对象。
	 */
	public static void testSequenceInputStream() {
		SequenceInputStream sis = null;
		BufferedOutputStream bos = null;

		try {
			// 构建流集合
			Vector<InputStream> vector = new Vector<InputStream>();
			vector.addElement(new FileInputStream(
					"E:\\19lou生活馆数据\\newlife\\buy_tick.txt"));
			vector.addElement(new FileInputStream(
					"E:\\19lou生活馆数据\\newlife\\dd.txt"));
			vector.addElement(new FileInputStream(
					"E:\\19lou生活馆数据\\newlife\\ddd.txt"));

			Enumeration<InputStream> e = vector.elements();

			sis = new SequenceInputStream(e);
			bos = new BufferedOutputStream(
					new FileOutputStream("D:\\text4.txt"));
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = sis.read(buf)) != -1) {
				bos.write(buf, 0, len);
				bos.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sis != null) {
					sis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (bos != null) {
					bos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}


}

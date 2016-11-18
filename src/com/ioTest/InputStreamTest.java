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
 * inputStream���� ������
 * ��ȡ�ֽ�
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
	 * 1��arrays ����ByteArrayInputStream
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
	 * 2.1��files ֱ�Ӷ�ȡ�ļ�����ÿ�ζ��Ǹ����̴򽻵� ����FileInputStream
	 */
	public static void testFileInputStream() {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(new File(
					"E:\\19lou���������\\trade-temai-11-20.xlsx"));
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
	 * 2.2��files
	 * �����ʵ��֧�ֶ��ļ��������ȡ��д�롣�����ȡ�ļ�����Ϊ���ƴ洢���ļ�ϵͳ�е�һ�������ֽ����顣����ָ�����������Ĺ�����������Ϊ�ļ�ָ�롣
	 * ��ȡ�������ļ�ָ�뿪ʼ��ȡ�ֽڣ������Ŷ��ֽڵĶ�ȡ��ǰ�ƴ��ļ�ָ�롣��������ȡ�ļ��Զ�ȡ/д��ģʽ��������д�����Ҳ���ã�
	 * д��������ļ�ָ�뿪ʼд���ֽڣ������Ŷ��ֽڵ�д���ǰ�ƴ��ļ�ָ�롣���ļ�ָ�����ͨ�� getFilePointer ������ȡ����ͨ�� seek
	 * �������á� ����RandomAccessFile
	 */
	public static void testRandomAccessFile() {
		RandomAccessFile randomAccessFile = null;
		try {
			// �����õ�λ�ÿ�ʼ��ȡ����
			randomAccessFile = new RandomAccessFile("E:\\19lou���������\\xtx.txt",
					"rw");
			System.out.println("randomAccessFile�ĳ�ʼλ��:"
					+ randomAccessFile.getFilePointer());
			// ��3λ�ö�ȡ����
			randomAccessFile.seek(0);
			byte[] buff = new byte[1024];
			int byteRead = 0;
			while ((byteRead = randomAccessFile.read(buff)) != -1) {
				System.out.println(new String(buff, 0, byteRead, "gbk"));
				System.out.println("************");
			}
			
			// �ظ���ȡʵ��
			randomAccessFile.seek(0);
			while ((byteRead = randomAccessFile.read(buff)) != -1) {
				System.out.println(new String(buff, 0, byteRead, "gbk"));
				System.out.println("dd************");
			}

			// ���ļ�β��׷������,����¼ָ���ƶ������
			randomAccessFile.seek(randomAccessFile.length());
			randomAccessFile.write("\n����׷�ӵ�\n".getBytes());

			// ����λ�ò������ݣ�����¼ָ���ƶ���ָ��λ��.����׷�ӷ�ʽ�Ḳ�ǵ�׷�����ݳ��ȵ����ݡ�
			// ��Ҫ��׷�ӵ��������ݷ�����ʱ�ļ���Ȼ����׷��
			randomAccessFile.seek(7);
			randomAccessFile.write("����λ��׷��".getBytes());

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
	 * 3��piple 
	 * �ܵ�����
	 * Ӧ�ó�����
	 * Java IO�еĹܵ�Ϊ������ͬһ��JVM�е������߳��ṩ��ͨ�ŵ����������Թܵ�Ҳ������Ϊ����Դ�Լ�Ŀ��ý�顣

     * �㲻�����ùܵ��벻ͬ��JVM�е��߳�ͨ��(��ͬ�Ľ���)���ڸ����ϣ�Java�Ĺܵ���ͬ��Unix/Linuxϵͳ�еĹܵ���
     * ��Unix/Linux�У������ڲ�ͬ��ַ�ռ���������̿���ͨ���ܵ�ͨ�š���Java�У�ͨ�ŵ�˫��Ӧ����������ͬһ�����еĲ�ͬ�̡߳�
     * 
     * �ڲ�Դ��ʵ�ֿ����е�������������������ģʽ
	 * ����PipedInputStream
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
				String data = "�е�����";
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
					System.out.println("�ӹܵ����ж�ȡ�����ݣ�" + data);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		// ��������ܵ���---�����ݣ��ڴ棩д�뵽�ܵ���
		PipedOutputStream pipeOut = new PipedOutputStream();
		// ��������ܵ���---�ӹܵ��ж�����(���ڴ棩
		PipedInputStream pipeIn = new PipedInputStream(4);
		try {
			// ʹ�ùܵ�����������������������ӡ�
			pipeIn.connect(pipeOut);
			new Thread(new Outter(pipeOut)).start();
			new Thread(new Inner(pipeIn)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 3��piple  ͬһ���߳���������(��Ϊwhileѭ������һֱwait(1000),ÿ��1sִ��һ��wait(1000)��û�˸ı�in��ֵ�����������ˣ�
	 * �ܵ�����
	 * Ӧ�ó�����
	 * Java IO�еĹܵ�Ϊ������ͬһ��JVM�е������߳��ṩ��ͨ�ŵ����������Թܵ�Ҳ������Ϊ����Դ�Լ�Ŀ��ý�顣

     * �㲻�����ùܵ��벻ͬ��JVM�е��߳�ͨ��(��ͬ�Ľ���)���ڸ����ϣ�Java�Ĺܵ���ͬ��Unix/Linuxϵͳ�еĹܵ���
     * ��Unix/Linux�У������ڲ�ͬ��ַ�ռ���������̿���ͨ���ܵ�ͨ�š���Java�У�ͨ�ŵ�˫��Ӧ����������ͬһ�����еĲ�ͬ�̡߳�
     * 
     * �ڲ�Դ��ʵ�ֿ����е�������������������ģʽ
	 * ����PipedInputStream
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
					System.out.println("�ӹܵ����ж�ȡ�����ݣ�" + data1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				String data = "�е�����";
				try {
					out.write(data.getBytes());
					out.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				


			}

		}

		

		// ��������ܵ���---�����ݣ��ڴ棩д�뵽�ܵ���
		PipedOutputStream pipeOut = new PipedOutputStream();
		// ��������ܵ���---�ӹܵ��ж�����(���ڴ棩
		PipedInputStream pipeIn = new PipedInputStream(4);
		try {
			// ʹ�ùܵ�����������������������ӡ�
			pipeIn.connect(pipeOut);
			new Thread(new Outter(pipeOut,pipeIn)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 3���ܵ�����������
	 * ����PipedInputStream
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
				
				
				
				String data = "�е�����";
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
					System.out.println("�ӹܵ����ж�ȡ�����ݣ�" + data1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				


			}
			
		}

		

		// ��������ܵ���---�����ݣ��ڴ棩д�뵽�ܵ���
		PipedOutputStream pipeOut = new PipedOutputStream();
		// ��������ܵ���---�ӹܵ��ж�����(���ڴ棩�������4ȥ�������ܶ�ȡ������4���ֽڵ����ݡ�
		PipedInputStream pipeIn = new PipedInputStream(4);
		try {
			// ʹ�ùܵ�����������������������ӡ�
			pipeIn.connect(pipeOut);
			new Thread(new Outter(pipeOut)).start();
			new Thread(new Inner(pipeIn)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 4��buffering
	 * 
	 * ����ȡ����ָ���������ļ����Ȼ��浽���������档������ÿ������̽��д򽻵� ����BufferedInputStream
	 */
	public static void testBufferedInputStream() {
		BufferedInputStream bufferedInput = null;
		byte[] buffer = new byte[8000];

		try {
			bufferedInput = new BufferedInputStream(new FileInputStream(
					"E:\\19lou���������\\trade-temai-11-20.xlsx"));
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
	 * 5��filtering
	 * ����װ����������������Ϊ�����ṩ����Ĺ��ܡ������ĳ��õ�������BufferedInputStream��DataInputStream,PushbackInputStream��
	 * BufferedInputStream�����þ���Ϊ���������ṩ���幦�ܣ��Լ�mark()��reset()����
	 * DataInputStream ������װ����������������������Ӧ�ó�����������޹ط�ʽ�ӵײ��������ж�ȡ���� Java �������͡�
	 * PushbackInputStream������
	 * ����FilterInputStream
	 */
	public static void testFilterInputStream() {
		FilterInputStream filterInputStream = null;
		byte[] buffer = new byte[1024];
		try {

			// FilterInputStream�������ǹ�����ʹ�ã����ʹ�������๹������
			filterInputStream = new FilterInputStream(new FileInputStream(
					"E:\\19lou���������\\trade-temai-11-20.xlsx")) {

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
	 * 6��parsing
	 * ������
	 * ����PushbackInputStream
	 */
	public static void testPushbackInputStream(){
		// ��bytearray��ȡ
		PushbackInputStream pushBackInputStream = null;
		String str = "www.mldnjava.cn";
		ByteArrayInputStream bai = null;
		
		// ���ļ���ȡ
		PushbackInputStream pushBackFile = null;
		try{
			bai = new ByteArrayInputStream(str.getBytes());
			pushBackInputStream = new PushbackInputStream(bai);
			System.out.println("��ȡ֮�������Ϊ��");
			int temp = 0;
			while ((temp = pushBackInputStream.read()) != -1){
				if(temp == '.'){
					pushBackInputStream.unread(temp);
					temp = pushBackInputStream.read();
					System.out.println("(�˻�"+(char)temp+")");
				}else{
					System.out.println((char)temp);
				}
			}
			
			// ���ļ���ȡ
			byte[] buff = new byte[4];
			pushBackFile = new PushbackInputStream(new FileInputStream("E:\\19lou���������\\xtx.txt"),4);
			System.out.println("-----------");
			int tempp = 0;
			while((tempp = pushBackFile.read(buff)) != -1){
				if(buff[3] == '.'){
					pushBackFile.unread((char)buff[3]);
					// buff[3]������Ķ��д���
					tempp = pushBackFile.read(buff);
					System.out.println("(�˻�"+(char)buff[3]+")");
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
	 * 7��data 
	 * ������ Java �������Ͷ���
	 * ����DataInputStream,ֱ�Ӵ��ļ���ȡ1024��С����
	 */
	public static void testDataInputStream() {
		DataInputStream dataInputStream = null;
		byte[] buffer = new byte[1];
		try {
			dataInputStream = new DataInputStream(new FileInputStream(
					"E:\\19lou���������\\xtx.txt"));
			
			// ������ȡ���ֽ�
//			int byteRead = 0;
//			while ((byteRead = dataInputStream.read(buffer)) != -1) {
//				System.out.println(buffer[0]);
//			}
			//��ȡjava��������,������޷�ִ�У��Ȱ������ע�͵�����Ϊ�޷��ظ���
			// �޷���ȡ�������֣����ı�����洢����12.ʵ����49 50
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
	 * 8��������
	 * �������л���
	 * ����ObjectOutputStream
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
	 * 9��˳����
	 * ����SequenceInputStream
	 * SequenceInputStream�ϲ���������֮�����ӵ�������ϳ�һ�����������ӵ�һ����������ʼ��ȡ��
	 * ֱ�������ļ�ĩβ�����Ŵӵڶ�����������ȡ���������ƣ�ֱ��������������һ�����������ļ�ĩ βΪֹ�� �ϲ����������ǽ����Դ�ϲ���һ��Դ��
	 * �ɽ���ö��������յĶ���ֽ�������
	 */
	public static void testSequenceInputStream() {
		SequenceInputStream sis = null;
		BufferedOutputStream bos = null;

		try {
			// ����������
			Vector<InputStream> vector = new Vector<InputStream>();
			vector.addElement(new FileInputStream(
					"E:\\19lou���������\\newlife\\buy_tick.txt"));
			vector.addElement(new FileInputStream(
					"E:\\19lou���������\\newlife\\dd.txt"));
			vector.addElement(new FileInputStream(
					"E:\\19lou���������\\newlife\\ddd.txt"));

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

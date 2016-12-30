/**
 * 19lou.com
 */
package com.commonTest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * 模拟mysql字符编码转换过程
 * @author liaokangli
 *
 */
public class CommonTest4 {
     public static void main(String[] args) throws UnsupportedEncodingException {
    	String orStr = "中";
    	System.out.println("中的gbk,十六进制:"+Hex.encodeHexStr(orStr.getBytes("gbk")));;
    	System.out.println("中的utf-8,十六进制:"+Hex.encodeHexStr(orStr.getBytes("utf-8")));;
    	System.out.println("范的,十六进制:"+new String(orStr.getBytes("utf-8"),"gbk"));;
//		Person p = new Person("");
//		System.out.print(p);
		
		String str = "范";
	    // utf8编码(终端）
		byte[] utf8 = str.getBytes("utf-8");
		String aa1 = new String(utf8,"utf-8");
		System.out.println(aa1);
		System.out.println("范的utf8,十六进制:"+Hex.encodeHexStr(utf8));
		
		
		//服务器从gbk-》转换为utf8。即使用gbk解码，再使用utf8编码
         //用gbk解码（服务器）,因为gbk表示一个字符是两个字节，而utf-8是三个字节，
		  //所以截断,从0开始解码，长度是2个字节
		String gbkstr = new String(utf8,0,2,"GBK");
		System.out.println("范的utf8经gbk解码,十六进制:"+Arrays.toString(gbkstr.getBytes("gbk")));
        
		// 用utf8编码
		byte[] utf88 = gbkstr.getBytes("utf-8");
		System.out.println("范的utf8经gbk解码再经utf8编码,十六进制:"+Hex.encodeHexStr(utf88));
        
		
		System.out.println("====== 查询select编码过程：从内部字符集转换为result_sets字符集");
		
		//将e991bc使用内部操作字符集(字段、表、数据库、服务器选一个，这里因为表设置了字符集utf8)utf8解码,返回给客户端
		// 采用result_sets编码：utf8.告诉客户端我采用utf8编码 （server和result_sets一样）
		// 无需转换
		// 终端显示将	
		System.out.println("查询结果:"+new String(utf88,"utf-8"));
		
		// 情况二：result_sets:gbk,server:gbk
		// 1、内部字符集解码
		String reaa = new String(utf88,"utf-8");
		// 采用result_sets编码：gbk.结果返回给客户端
		byte[] resultSets = reaa.getBytes("gbk"); 
		// 终端显示,对	resultSets解码，	
		System.out.println("情况二:"+new String(resultSets,"gbk"));
	
		System.out.println(Hex.encodeHex("42E292E7".getBytes()));
		
	}
     
    static class Person{
    	private String name;
    	public Person(String name){
    		this.name = name;
    	}
    }
    /**
     * Gbk2utf8.
     * 
     * @param chenese the chenese
     * 
     * @return the byte[]
     */
    public static byte[] gbk2utf8(String chenese) {
        
        // Step 1: 得到GBK编码下的字符数组，一个中文字符对应这里的一个c[i]
        char c[] = chenese.toCharArray();
        
        // Step 2: UTF-8使用3个字节存放一个中文字符，所以长度必须为字符的3倍
        byte[] fullByte = new byte[3 * c.length];
        
        // Step 3: 循环将字符的GBK编码转换成UTF-8编码
        for (int i = 0; i < c.length; i++) {
            
            // Step 3-1：将字符的ASCII编码转换成2进制值
            int m = (int) c[i];
            String word = Integer.toBinaryString(m);
            System.out.println(word);

            // Step 3-2：将2进制值补足16位(2个字节的长度) 
            StringBuffer sb = new StringBuffer();
            int len = 16 - word.length();
            for (int j = 0; j < len; j++) {
                sb.append("0");
            }
            // Step 3-3：得到该字符最终的2进制GBK编码
            // 形似：1000 0010 0111 1010
            sb.append(word);
            
            // Step 3-4：最关键的步骤，根据UTF-8的汉字编码规则，首字节
            // 以1110开头，次字节以10开头，第3字节以10开头。在原始的2进制
            // 字符串中插入标志位。最终的长度从16--->16+3+2+2=24。
            sb.insert(0, "1110");
            sb.insert(8, "10");
            sb.insert(16, "10");
            System.out.println(sb.toString());

            // Step 3-5：将新的字符串进行分段截取，截为3个字节
            String s1 = sb.substring(0, 8);
            String s2 = sb.substring(8, 16);
            String s3 = sb.substring(16);

            // Step 3-6：最后的步骤，把代表3个字节的字符串按2进制的方式
            // 进行转换，变成2进制的整数，再转换成16进制值
            byte b0 = Integer.valueOf(s1, 2).byteValue();
            byte b1 = Integer.valueOf(s2, 2).byteValue();
            byte b2 = Integer.valueOf(s3, 2).byteValue();
            
            // Step 3-7：把转换后的3个字节按顺序存放到字节数组的对应位置
            byte[] bf = new byte[3];
            bf[0] = b0;
            bf[1] = b1;
            bf[2] = b2;
            
            fullByte[i * 3] = bf[0];            
            fullByte[i * 3 + 1] = bf[1];            
            fullByte[i * 3 + 2] = bf[2];
            
            // Step 3-8：返回继续解析下一个中文字符
        }
        return fullByte;
    }
}

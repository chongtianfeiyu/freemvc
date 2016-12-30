package com.regular;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author liaokangli
 *
 */
public class RegularTest {
	
	public static void main(String[] args) throws ParseException{
//		testText();
//		testSingle();
//		testCharSet();
//		testSpecial();
//		testSpecialMeta();
//		testfanxiegan();
//		testNoLetter();
//		testPostCode();
//		testBlankChar();
//		testRepeaMatchOneMore();
//		testRepeaMatchZeroMore();
//		testRepeaMatchZeroOne();
//		testRepeaMatchNum();
//		testRepeaMatchRange();
//		testRepeaMatchAtLeast();
//		testRepeaMatchOver();
//		testLocationWordBound();
//		testStringBound();
//		testTailBound();
//		testEnterBound();
//		testSubExpress1();
//		testSubExpress2();
//		testTrackback();
//		testReplaceTrackBack();
		
//		testLookRound();
//		testLookbehid();
//		testLookbehidahead();
//		testNotLookahead();
//		testConditionTrackBack();
		testConditionLookahead();
		
		
//		testNot();
		
		
		
//		testtt1();
//		testtt();
//		testtt2();
	}
	
	public static void testtt1(){
		String str = "0,0,0";
		Pattern pattern = Pattern.compile("(,|^){1}(0){1}(,|$){1}");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
		boolean flag = str.matches("(,|^){1}(0){1}(,|$){1}");
		boolean flag1 = Pattern.compile("(,|^){1}(0){1}(,|$){1}").matcher(str).find();
		System.out.println("tt");
	}
	
	public static void testtt(){
		String str = "早知道,家居,abc早知道,,相亲,bbb早知道avc,美食,早知道,早知道兴趣,早知道早知道,汽车,早知道$,婚庆,早知道";
		String str1 = "早知道";
//		Pattern pattern = Pattern.compile("(,|^){1}(早知道){1}(,|$){1}");
//		Pattern pattern = Pattern.compile("[,^](早知道){1}[,$]");
		Pattern pattern = Pattern.compile("(,)?早知道(?:(?=,),)");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	public static void testtt2(){
		String str = "30,0 h";

		Pattern pattern = Pattern.compile("(\\d+)(?:(?=,),\\d+)");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 匹配纯文本
	 */
	public static void testText(){
		String str = "Hello,my name is Ben.please visit my website at http://www.forta.com/.";
		Pattern pattern = Pattern.compile("My");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 匹配任意字符
	 */
	public static void testSingle(){
		String str = "sales1.txt\n orders3.txt\n sales2.txt\n sales3.txt\n sal.xls\n psales4.txt";
		Pattern pattern = Pattern.compile(".sales.\\.txt");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 匹配字符集合
	 */
	public static void testCharSet(){
		String str = "sales1.txt\n orders3.txt\n sales2.txt\n sales3.txt\n sal.xls\n psales4.txt";
		Pattern pattern = Pattern.compile("[ns]a[^0-9]");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 匹配特殊字符,使用转义\\
	 */
	public static void testSpecial(){
		String str = "myArray[0] myArray0";
		Pattern pattern = Pattern.compile("myArray\\[\\d\\]");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 匹配特殊字符及元字符，使用\\.匹配myArray[0],myArray[1]...
	 */
	public static void testSpecialMeta(){
		
		String str = "myArray[0] myArray0 myArray[1] myArray[2] myArray[3] \\abc";
		Pattern pattern = Pattern.compile("myArray[0]");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
	}
	
	/**
	 * 匹配特殊字符及元字符，使用\\(四个反斜杠).匹配myArray[0],myArray[1]...
	 */
	public static void testfanxiegan(){
		
		String str = "myArray[0] myArray0 myArray[1] myArray[2] myArray[3] \\abc";
		Pattern pattern = Pattern.compile("\\\\");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
	}
	
	/**
	 * 匹配字母和数字
	 */
	public static void testNoLetter(){
		
		String str = "abcd_ asdfg _ * aaaa& %";
		Pattern pattern = Pattern.compile("[\\W]");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
	}
	
	/**
	 * 匹配邮政编码
	 */
	public static void testPostCode(){
		String str = "11213 a1a2a3";
		Pattern pattern = Pattern.compile("\\w\\d\\w\\d\\w\\d");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 匹配空白字符
	 */
	public static void testBlankChar(){
		String str = "aa bb yu \r";
		Pattern pattern = Pattern.compile("\\r+");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
	}
	
	/**
	 * 匹配不在字符集合
	 */
	public static void testNot(){
		String str = "aa bb yu 0 1 9";
		Pattern pattern = Pattern.compile("[^ab]");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 重复匹配（+）,一个或者多个字符。最少一次
	 */
	public static void testRepeaMatchOneMore(){
		String str = "abc@forta_a.com,bttt,liaokangli@163.com,ssss,123,abc.tt@163.com.asb";
		Pattern pattern = Pattern.compile("[\\w.]+@[\\w]+\\.\\w+");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 重复匹配（*），零个或者多个字符。可以匹配零次.匹配"ben@forta.com",第一个字符必须是字母或者数字，不能以点开头
	 */
	public static void testRepeaMatchZeroMore(){
		String str = "Hello .ben@forta.com is my email address abcd*cccc@163.com abcd|aaa@163.com";
		Pattern pattern = Pattern.compile("\\w+[\\w.*]*@[\\w.]+\\w+");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
	}
	
	/**
	 * 重复匹配（？）,零个或者一个字符。最多不超过一次。http或者https
	 */
	public static void testRepeaMatchZeroOne(){
		String str = "The URL is http://wwww.\forta.com/,to connect securely use https://wwww.forta.com/ instead";
		Pattern pattern = Pattern.compile("https?://[\\w.]+");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 匹配重复次数。{num1}。匹配颜色代码值
	 */
	public static void testRepeaMatchNum(){
		String str = "<Body bgcolor='#336633' Text='#FFFFFF' ts='#zzzzzz' maginwidth='0' maginheight='10'";
		Pattern pattern = Pattern.compile("#\\p{XDigit}{6}");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
	}
	
	
	/**
	 * 匹配重复次数，区间{num1,num2}
	 */
	public static void testRepeaMatchRange(){
		String str = "4/8/03 10-6-2004 2/2/2 01-01-01 aa-bb 01- 0000-35 01\23\45";
		Pattern pattern = Pattern.compile("\\d{1,2}[-\\/]\\d{1,2}[-\\/]\\d{2,4}");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 匹配至少次数
	 */
	public static void testRepeaMatchAtLeast(){
		String str = "1001:$496.80 1002:$4960.80 1003:$000.80";
		Pattern pattern = Pattern.compile("\\$\\d{3,}\\.\\d{2}");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 防止过度匹配(使用懒惰型。比如说<B>ak</B>html <B>tt</B> 应该匹配两个，
	 * *和+都是贪婪型
	 */
	public static void testRepeaMatchOver(){
		String str = "this offer is not available to customers living in <B>ak</B> and <B>hi</B>";
		Pattern pattern = Pattern.compile("<[Bb]>.*</[Bb]>");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 位置匹配：单词边界。\b。注意java里面要用\\b.
	 * 使用一个\b,只能匹配以cat开头的单词。貌似java没有用
	 */
	public static void testLocationWordBound(){
		String str = "The cat scattered his food all over the room cape aa bcap";
		Pattern pattern = Pattern.compile("\\bcat");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 位置匹配:字符串边界,开头匹配.注意*后面要加个?,懒惰型版本,否则会匹配到结尾
	 * 
	 */
	public static void testStringBound(){
		String str = " <?xml version='1.0' encoding='utf-8'?><wsdl:definitions targetNamespace='http://tips.cf'> <?xml version='1.0' encoding='utf-8'?>";
		Pattern pattern = Pattern.compile("^\\s*<\\?xml.*?\\?>");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 位置匹配:匹配结尾
	 */
	public static void testTailBound(){
		String str = "this is http request <hbs123456>  ";
		Pattern pattern = Pattern.compile("<.*?>\\s*$");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 位置匹配:分行匹配模式.注意(?m)可以是其他分隔符，不一定是换行符
	 * str1是以逗号分隔，可以把//1的试试,
	 */
	public static void testEnterBound(){
		String str = "<script>\n   // abcd \n //csd";
		String str1 = "<script>,  // abcd , //csd \n //tsg \n //gh";

		System.out.println(str);
//		Pattern pattern = Pattern.compile("(?m),\\s*//.*?"); //1
//		Matcher m = pattern.matcher(str1); //1
		Pattern pattern = Pattern.compile("(?m)^\\s*//.*$");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
	}
	
	/**
	 * 子表达式匹配。要匹配ip地址
	 */
	public static void testSubExpress1(){
		String str = "ping hog.forta.com [12.159.46.200] with 32 bytes \\ of data";
		Pattern pattern = Pattern.compile("(\\d{1,3}\\.){3}\\d{1,3}");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 子表达式匹配。匹配年份
	 */
	public static void testSubExpress2(){
		String str = "DBO:1967-08-17 ASDB:2014-02-09 RRRRRRRRRRR:8709-00-00";
		Pattern pattern = Pattern.compile("(19|20)\\d{2}");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 回溯引用。注意是\\1 而不是\1。要不然会当成普通字符\1
	 */
	public static void testTrackback(){
		
		String str = "<H1>WELOCOM AAA</H1> TS gh aert <H2>bghh</H3> TS gh aert <H6>bghh</H6>";
		Pattern pattern = Pattern.compile("<([hH][1-6])>.*?</\\1>");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
	}
	
	/**
	 * 回溯引用替换操作。$1代表第一个子表达式
	 */
	public static void testReplaceTrackBack(){
		
		String str = "<H1>wecolm tt</H1> TS gh aert <H2>bghh</H3> TS gh aert <H6>bghh</H6>";
		
		String replaceStr = str.replaceAll("(<[hH]1>)(.*?)(</[hH]1>)", "$1\\U$2\\E$3");
		System.out.println(replaceStr);
		
	}
	
	/**
	 * 前后查找_向前查找。匹配<titile></titile>之间的内容，
	 * 但是不把titile匹配出来.
	 * 这个模式匹配:之前的字符，如http,https,ftp.但是不显示:
	 * 注意此处在+后面使用?非贪婪模式，否则会匹配到最后，只出现一条记录
	 */
	public static void testLookRound(){
		String str = "http://wwww.forta.com/ https://mail.forta.com/ ftp://ftp.forta.com/";
		Pattern parttern = Pattern.compile("http:(?=:)");
		Matcher m = parttern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
		
	}
	
	/**
	 * 前后查找_向后查找。匹配数字，但是不显示$
	 * 原理：先匹配[0-9.]+ 然后往回到数字比如2的前一个位置,依次匹配$,a(注意不是a,$.顺序不能反)
	 */
	public static void testLookbehid(){
		String str = "ABC01: a$23.45 HGG42: $52.3 total items:4";
		Pattern pattern = Pattern.compile("(?<=a\\$)[0-9.]+");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	/**
	 * 前后查找_结合使用.匹配<title></title>之间的文本，但是不显示<titile>和<title>
	 */
	public static void testLookbehidahead(){
		String str = "<head><title>ben forta's homepage</title><title>aaaaben forta's homepage</title></head>";
		Pattern pattern = Pattern.compile("(?<=<[tT][iI][tT][lL][eE]>).*?(?=</[tT][iI][tT][lL][eE]>)");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	
	/**
	 * 负前后查找_负(非)向前查找。使用\\b单词边界，防止$30里面的0也被匹配到
	 */
	public static void testNotLookahead(){
		String str = "I paid $30 for 100 apples 50 oranges,and 60 pears.i save $5 on this order";
		Pattern pattern = Pattern.compile("\\b(?<!\\$)\\d+\\b");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
	}
	
	
	/**
	 * 嵌入条件回溯引用法。比如匹配北美电话号码.(123)456-789 和123-456-789是正确的。其他格式是不正确的。
	 */
	public static void testConditionTrackBack(){
		String str = "123-456-789 (123-456-789 123456789 (123)456-789 (123)-456-789";
		Pattern pattern = Pattern.compile("(\\()?\\d{3}(?:(1)\\)|-)\\d{3}-\\d{4}");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
	}
	
	/**
	 * 嵌入条件前后查找法。比如匹配美国的邮政编码。使用
	 * 有两种形式:一种是123456形式的zip格式，另一种是12345-6789形式的zip+4格式
	 * http://stackoverflow.com/questions/8945398/java-support-for-conditional-lookahead
	 * java不支持。下面这个正则只找到44444-4444,因为java把它当做是向前查找，而不是嵌入条件
	 * 详情查阅jdk
	 */
	public static void testConditionLookahead(){
		
		String str = "11111 22222 33333-  44444-4444";
		// 将匹配33333-前面的33333
//		Pattern pattern = Pattern.compile("\\d{5}(-\\d{4})?");
		// java不支持,可以使用下面这个正则解决
//		Pattern pattern = Pattern.compile("\\d{5}(?:(?=-)-\\d{4})");
		Pattern pattern = Pattern.compile("\\d{5}(?=(-\\d{4}|\\s|$))(-\\d{4})?");
		Matcher m = pattern.matcher(str);
		while(m.find()){
			System.out.println("group:"+m.group()+";"+m.start()+";"+m.end());
		}
		
		
	}
	
	
	
	
	
	
	


}

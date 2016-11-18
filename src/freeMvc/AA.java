///**
// * 19lou.com
// */
//package freeMvc;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import edu.fudan.nlp.tag.POSTagger;
//
///**
// * @author liaokangli
// *
// */
//public class AA {
//
//	
//
//	public static void main(String[] args) throws Exception {
//		
//		String content = "2014_09_21^2014_09_29^linan^[/赞]";
//		int index1 = content.lastIndexOf("^");
//		String subString = content.substring(index1+1);
//		
//		POSTagger tag = new POSTagger("models/pos.c7.110919.gz");
//		String str = "上万毫升";
//		String s = tag.tag(str);
//		String s1 = tag.tagShort(str);
//		String[][] result = tag.tag2Array(str);
//		System.out.println(result[0]);
//		
//		List<String> aa = new ArrayList<String>();
//		aa.add("aa");
//		aa.add("bb");
//		List<String> bb = aa.subList(1, 2);
//		String dd = aa.get(0);
//		aa.remove(0);
////		String cc = bb.get(bb.size() - 1);
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date1 = sf.parse("2014-10-11 14:00:00");
//		long time1 = date1.getTime();
//		Date date2 = sf.parse("2014-10-11 14:35:00");
//		System.out.println(time1+" "+date2.getTime());
//		
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
//		calendar.set(Calendar.HOUR_OF_DAY, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
//		calendar.getTime();
//		
//		// 以[/开头,以]结束的字符串/.*]    .*]
//		String contents = "我们觉得很[/赞][/惊讶][abc][/搞笑[/搞笑]]aaa,[/赞]aaaaaa[/赞]";
//        Pattern p = Pattern.compile("\\[\\/[^\\[\\/]*?]");
//        Matcher m = p.matcher(contents);
//        while (m.find()) {
//            System.out.println(contents.substring(m.start(), m.end()));
//        }
//        
//        // 以[/开头,以]结束的字符串/.*]    .*]
////		String contents1 = "我们觉得很[/赞][/惊讶][abc][/搞笑[/搞笑]]";
////	    Pattern p1 = Pattern.compile("\\[\\/赞]");
////	    Matcher m1 = p.matcher(contents);
////	    while (m1.find()) {
////	         System.out.println(contents1.substring(m1.start(), m1.end()));
////	    }
//        
//        // 另一种方法匹配
//        int index = 0;
//        String searchText = "[/搞笑]";
//        while(true){     	
//        	int position = contents.indexOf(searchText,index);
//        	if(position >= 0){
//        		index = position + searchText.length();
//        		System.out.println("新的方法:"+contents.substring(position,position + searchText.length()));
//        		continue;
//        	}else{
//        		break;
//        	}
//        }
//       
//	}
//
//}

///**
// * 19lou.com
// */
//package freeMvc;
//
//import java.text.DateFormat;
//import java.text.DecimalFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Map.Entry;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//
//
///**
// * 定时任务
// * @author liaokangli
// *
// */
//@Component
//
//public class SayScheduled extends AA{
//	
//	
//	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	
//	private static final String SCEN_Id = "adclick";
//
//	/**
//	 * 每天凌晨一点执行将会刷新mongo，13点，14点刷新Adclick缓存,刷新一个月
//	 * 对13个城市
//	 */
//	@Scheduled(cron="*/1 * * * * ?")   
//	public void refreshAdclickCache(){
//		System.out.println("时间："+new Date().getSeconds());	
//		
//	}
//}

package constxiong.interview;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 测试时间和日期
 * @author ConstXiong
 * @date 2019-11-01 11:05:59
 */
public class TestDateAndTime {

	public static void main(String[] args) {
		//获取当前的年、月、日、时、分、秒、毫秒、纳秒
		//年
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
		//JDK 1.8 java.time 包
		System.out.println(Year.now());
		System.out.println(LocalDate.now().getYear());
		
		//月
		System.out.println(Calendar.getInstance().get(Calendar.MONTH)+1);
		//JDK 1.8 java.time 包
		System.out.println(MonthDay.now().getMonthValue());
		System.out.println(LocalDate.now().getMonthValue());
		
		//日
		System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		//JDK 1.8 java.time 包
		System.out.println(MonthDay.now().getDayOfMonth());
		System.out.println(LocalDate.now().getDayOfMonth());
		
		//时
		System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		//JDK 1.8 java.time 包
		System.out.println(LocalTime.now().getHour());
		
		//分
		System.out.println(Calendar.getInstance().get(Calendar.MINUTE));
		//JDK 1.8 java.time 包
		System.out.println(LocalTime.now().getMinute());
		
		//秒
		System.out.println(Calendar.getInstance().get(Calendar.SECOND));
		//JDK 1.8 java.time 包
		System.out.println(LocalTime.now().getSecond());
		
		//毫秒
		System.out.println(Calendar.getInstance().get(Calendar.MILLISECOND));
		
		//纳秒
		System.out.println(LocalTime.now().getNano());
		
		
		//当前时间毫秒数
		System.out.println(System.currentTimeMillis());
		System.out.println(Calendar.getInstance().getTimeInMillis());
		
		
		//某月最后一天
		//2018-05月最后一天,6月1号往前一天
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2018);
		c.set(Calendar.MONTH, 5);
		c.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH));
		//JDK 1.8 java.time 包
		LocalDate date = LocalDate.of(2019, 6, 1).minusDays(1);
		System.out.println(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());
		
		
		//格式化日期
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		//JDK 1.8 java.time 包
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
}

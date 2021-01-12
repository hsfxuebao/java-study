package javase;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.TimeZone;

/**
 * @author haoshaofei
 * @date 2020/04/15
 */
public class StringTest {

	public static void main(String[] args) {

		//2：string的intern使用
		//s1是基本类型，比较值。s2是string实例，比较实例地址
		//字符串类型用equals方法比较时只会比较值
		String s1 = "a";
		String s2 = new String("a");
		//调用intern时,如果s2中的字符不在常量池，则加入常量池并返回常量的引用
		String s3 = s2.intern();
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);

		System.out.println(LocalDate.now().getDayOfYear());

		final LocalDate now = LocalDate.now();
		final LocalDate now1 = LocalDate.of(2020,12,3);
		System.out.println("isBefore" + now.isBefore(now1));
		System.out.println("isEqual" + now.isEqual(now1));
		System.out.println("isAfter" + now.isAfter(now1));
		System.out.println("---------");

		final LocalDate localDate
				=
				LocalDateTime.ofInstant(Instant.ofEpochMilli(1606818281000L), TimeZone.getDefault().toZoneId())
						.toLocalDate().plusDays(3);
		System.out.println("localDae isAfter" + localDate.isBefore(now) + localDate + now);


		final LocalDate localDate1 =
				LocalDateTime.ofInstant(Instant.ofEpochMilli(1604226281000L), TimeZone.getDefault().toZoneId())
						.toLocalDate().plusDays(3);
		System.out.println("localDae isAfter" + localDate1.isBefore(now) + localDate1 + now);
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toHexString(10));


		final LocalDateTime yyyyMMddHHmmss =
				LocalDateTime.parse("20201212121212", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		System.out.println();

		final LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(1607153352000L), ZoneId.systemDefault());
		System.out.println(localDateTime);
		final long timestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		System.out.println(timestamp);
		final long l = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
		System.out.println(l);
		final long until = localDateTime.until(LocalDateTime.now(), ChronoUnit.HOURS);
		System.out.println(until);


		String str = "web_1234";
		final boolean web = str.startsWith("web");
		System.out.println("str is start with web" + web);


	}

}

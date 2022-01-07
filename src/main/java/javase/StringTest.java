package javase;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import cn.hutool.core.codec.Base32;


/**
 * @author hsfxuebao
 * @date 2020/04/15
 */
public class StringTest {

	public static void main(String[] args) {

		final int i1 = new BigDecimal("40").multiply(new BigDecimal("0.0392"))
				.setScale(0, BigDecimal.ROUND_DOWN).intValue();
		System.out.println(i1);

		System.out.println(Long.toUnsignedString(32, 32));

		List<User> lists = new ArrayList<User>();
		for (int i = 0; i < 4; i++) {
			User user = new User();
			user.setNumber(i);
			user.setAge(5-i);
			lists.add(user);
		}
		User user1 = new User();
		user1.setAge(3);
		user1.setNumber(3);
		lists.add(user1);
		User user2 = new User();
		user2.setAge(3);
		user2.setNumber(1);
		lists.add(user2);

//		lists.add(3);
//		lists.add(2);
//		lists.add(1);
//		lists.add(4);
//		lists.add(5);
//		lists.add(6);
//		lists.add(8);
//		lists.add(7);
		final List<User> collect = lists.stream().sorted(Comparator.comparingInt(User::getNumber).reversed().thenComparing(User::getAge)).limit(5).collect(Collectors.toList());
		for (User user : collect) {
			System.out.println(user);
		}



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

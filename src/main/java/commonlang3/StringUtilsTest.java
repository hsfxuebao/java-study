package commonlang3;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hsfxuebao
 * @date 2020/04/15
 */
public class StringUtilsTest {


	public static void main(String[] args) {

//		String str = "wedwsww";
//		String s = StringUtils.substringBetween(str, "w", "s");
//		System.out.println(s);
//
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		String join = StringUtils.join(list, ",");
//		System.out.println(join);

//		Map<String, String> map = new HashMap<>();
//		map.put("河北","1");
//		map.put("河南", "2");
//		System.out.println(map.entrySet().contains("河北"));

		LocalDate deviceLocalDate = timestamp2DateTime(1638887337907L).toLocalDate();
		long diffDay = ChronoUnit.DAYS.between(deviceLocalDate, LocalDate.now());
		System.out.println(diffDay);
	}

	public static LocalDateTime timestamp2DateTime(long timestamp) {
		Instant instant = Instant.ofEpochMilli(timestamp);
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
	}

}

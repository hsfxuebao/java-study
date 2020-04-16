package commonlang3;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoshaofei
 * @date 2020/04/15
 */
public class StringUtilsTest {


	public static void main(String[] args) {

		String str = "wedwsww";
		String s = StringUtils.substringBetween(str, "w", "s");
		System.out.println(s);

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		String join = StringUtils.join(list, ",");
		System.out.println(join);

	}

}

//package guava;
//
//import com.google.common.base.Splitter;
//
//import java.util.List;
//import java.util.regex.Pattern;
//
///**
// * @author hsfxuebao
// * @date 2020/04/15
// * 测试split和Splitter的区别
// */
//public class SplitterTest {
//
//	public static void main(String[] args) {
//
//		String targetStr = "1";
//		String[] splitStrs = targetStr.split("//|");
//		for (String spiltStr : splitStrs) {
//			System.out.println(spiltStr);
//		}
//		System.out.println("-===============");
//
//
//		Iterable<String> stringIterable = Splitter.on("|").split(targetStr);
//		System.out.println(stringIterable);
//		System.out.println("-===============");
//
//		String[] splitStrs1 = targetStr.split("\\|");
//		String[] splitStrs2 = targetStr.split("[|]");
//		String[] splitStrs3 = targetStr.split(Pattern.quote("|"));
//		for (String spiltStr : splitStrs1) {
//			System.out.println(spiltStr);
//		}
//		System.out.println("-===============");
//		for (String spiltStr : splitStrs2) {
//			System.out.println(spiltStr);
//		}
//		System.out.println("-===============");
//		for (String spiltStr : splitStrs3) {
//			System.out.println(spiltStr);
//		}
//		System.out.println("-===============");
//
//
//		String[] split = "a,b,,".split(","); // java内置的会忽略空内容
//		for (String spiltStr : split) {
//			System.out.println(spiltStr);
//		}
//		System.out.println("-===============");
//
//		List<String> splitToList = Splitter.on(",").splitToList("a,b,,");//guava不会忽略
//		for (String spiltStr : splitToList) {
//			System.out.println(spiltStr);
//		}
//
//		// 或者可以自由选择的忽略　，像java一样，忽略空字符串
//		System.out.println("-===============");
//
//		List<String> splitToList1 = Splitter.on(",").omitEmptyStrings().trimResults().splitToList("a,b,,");
//		for (String spiltStr : splitToList1) {
//			System.out.println(spiltStr);
//		}
//		System.out.println("-===============");
//
//
//		String str = "AAAdasdasdasAAAdsadasfasfasfasfdAAA";
//		String[] as = str.split("A");
//		for (String s : as) {
//			System.out.print(s);
//			System.out.print("-");
//		}
//
//		Iterable<String> a = Splitter.on("A").split(str);
//		for (String s : a) {
//			System.out.println(s);
//		}
//	}
//}

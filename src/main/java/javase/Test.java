package javase;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author hsfxuebao
 * Created on 2021-04-09
 */
public class Test {


    public static void main(String[] args) {
        String str = "/rest/n/nebula/qrcode/invitation?layoutType=4&code=8999999621&spv=fwkTNqvUm23b0AG2Z%2FkW4k%2Fk92fgtA3PWwjR6i8gdt6XYL%2Fcxzr1jv6vQTzlGVN6";

        System.out.println(parseQuery(str));

    }

    public static Multimap<String, String> parseQuery(String queryPart) {
        if (StringUtils.isBlank(queryPart)) {
            return null;
        }
        if (queryPart.contains("?")) {
            // double ? error
            queryPart = queryPart.replace("?", "&");
        }
        String[] params = queryPart.split("&");
        Multimap<String, String> map = ArrayListMultimap.create();
        for (String param : params) {
            String[] part = param.split("=");
            if (part.length < 2) {
                map.put(part[0], StringUtils.EMPTY);
            } else {
                map.put(part[0], safeUrlDecode(part[1]));
            }
        }
        return map;
    }
    public static String safeUrlDecode(String content) {
        if (StringUtils.isEmpty(content)) {
            return StringUtils.EMPTY;
        }
        if (content.contains("%")) {
            try {
                return URLDecoder.decode(content, UTF_8.name());
            } catch (UnsupportedEncodingException e) {
                return content;
            }
        }
        return content;
    }

}

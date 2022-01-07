package javase;

import java.time.LocalDate;
import java.time.ZoneOffset;

/**
 * @author hsfxuebao
 * Created on 2021-04-15
 */
public class LocalDateUtils {

    public static void main(String[] args) {

        long todayStartTime = LocalDate.now().atTime(0, 0, 0)
                .toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(todayStartTime);

    }

}

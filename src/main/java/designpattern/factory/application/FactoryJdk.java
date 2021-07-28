package designpattern.factory.application;

import java.util.Calendar;

/**
 * @author haoshaofei <haoshaofei@kuaishou.com>
 * Created on 2021-07-28
 */
public class FactoryJdk {


    public static void main(String[] args) {

        // getInstance是Clendar的静态方法
        Calendar cal = Calendar.getInstance();
        // 注意月份是从0开始的，所以月份要加+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));

    }
}

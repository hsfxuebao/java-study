package javase;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.jmx.snmp.SnmpTooBigException;

/**
 * @author haoshaofei <haoshaofei@kuaishou.com>
 * Created on 2020-12-05
 */
public class LRU extends LinkedHashMap<String, String> {

    int size = 10000;
    Map<Object, Object> keyMap = new LinkedHashMap<Object, Object>(size, .75F, true){

        @Override
        protected boolean removeEldestEntry(Entry<Object, Object> eldest) {

            boolean toBig = size() > size;

            return toBig;
        }
    };


}

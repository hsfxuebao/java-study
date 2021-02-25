package jvm.tools.memoryleak;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {
    static List list = new ArrayList();

    public void oomTests() {
        Object obj = new Object();
        list.add(obj);
    }

}
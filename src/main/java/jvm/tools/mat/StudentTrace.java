package jvm.tools.mat;

import java.util.ArrayList;
import java.util.List;

/**
 * 有一个学生浏览网页的记录程序，它将记录 每个学生访问过的网站地址。
 * 它由三个部分组成：Student、WebPage和StudentTrace三个类
 *
 *  -XX:+HeapDumpBeforeFullGC -XX:HeapDumpPath=D:\Date\github\java\JVM\src\com\cpucode\java\gui\tools\mat\student.hprof
 */
public class StudentTrace {
    static List<WebPage> webPages = new ArrayList<WebPage>();

    public static void createWebPages(){
        for (int i = 0; i < 100; i++) {
            WebPage wp = new WebPage();

            wp.setUrl("www.CpuCode" + Integer.toString(i) + ".com");
            wp.setContent(Integer.toString(i));

            webPages.add(wp);
        }
    }

    public static void main(String[] args) {
        //创建了100个网页
        createWebPages();

        //创建3个学生对象
        Student st3 = new Student(3, "Cpu");
        Student st5 = new Student(5, "Code");
        Student st7 = new Student(7, "cpuCode");

        for (int i = 0; i < webPages.size(); i++) {
            if (i % st3.getId() == 0) {
                st3.visit(webPages.get(i));
            }

            if (i % st5.getId() == 0){
                st5.visit(webPages.get(i));
            }

            if (i % st7.getId() == 0) {
                st7.visit(webPages.get(i));
            }
        }

        webPages.clear();

        System.gc();
    }
}

class Student{
    private int id;
    private String name;
    private List<WebPage> history = new ArrayList<>();

    public Student(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WebPage> getHistory() {
        return history;
    }

    public void setHistory(List<WebPage> history) {
        this.history = history;
    }

    public void visit(WebPage wp){
        if(wp != null){
            history.add(wp);
        }
    }
}

class WebPage{
    private String url;
    private String content;

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
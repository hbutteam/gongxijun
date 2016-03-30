package com.qunar.fresh.servlet;


/**
 * Created by gongxijun on 16-3-22.
 */
public interface InterfaceServlet {

    public static final String K_USERNAME = "name";
    public static final String K_A1 = "/a/1.do";
    public static final String K_A2 = "/a/2.do";
    public static final String KEY_MAP = "TOKEN";
    public static final String CONST_STRING = " SELECT url , count(cnt) as cnt  FROM PageVistor group by url";
    public static final String STATEMENT = "访问3.do的URL为：" +
            "http://localhost:8080/count/3.do<br/>\n" +
            "访问1.do的URL为：http://localhost:8080/a/1.do<br/>\n" +
            "访问2.do的URL为：http://localhost:8080/a/2.do<br/>\n" +
            "默认登陆地址为：http://localhost:8080<br/>";

}

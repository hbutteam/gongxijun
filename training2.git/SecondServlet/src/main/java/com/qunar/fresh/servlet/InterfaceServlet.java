package com.qunar.fresh.servlet;


/**
 * Created by gongxijun on 16-3-22.
 */
public  interface InterfaceServlet {

    public static final String K_USERNAME = "name";
    public static final String K_A1 = "/second/a/1.do";
    public static final String K_A2 = "/second/a/2.do";
    public static final String KEY_MAP ="TOKEN";
    public static final String STATEMENT ="访问3.do的URL为：" +
            "http://localhost:8080/second/count/3.do<br/>\n" +
            "访问1.do的URL为：http://localhost:8080/second/a/1.do<br/>\n" +
            "访问2.do的URL为：http://localhost:8080/second/a/2.do<br/>\n" +
            "默认登陆地址为：http://localhost:8080/second/<br/>";

}

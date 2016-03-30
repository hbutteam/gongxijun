package com.qunar.fresh.servlet;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by gongxijun on 16-3-21.
 */
public class LoginServlet extends HttpServlet implements InterfaceServlet {

    static Logger logger;

    static {
        logger = LoggerFactory.getLogger(LoginServlet.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter(K_USERNAME);
        Cookie[] cookie = req.getCookies();

        Preconditions.checkNotNull(cookie);
        for (Cookie as : cookie) {
            as.setMaxAge(0);
        }
        //创建cookie，并设置保存时间
        Cookie UserCookie = new Cookie(K_USERNAME, URLEncoder.encode(username, "UTF-8"));
        UserCookie.setMaxAge(3600 * 24);    //一天
        resp.addCookie(UserCookie);

        out.println("<HTML>");
        out.println("  <HEAD><TITLE>FourServlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("<p>");
        out.print(STATEMENT);
        out.print(String.format("</p>hi ,%s", username));
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();

    }
}

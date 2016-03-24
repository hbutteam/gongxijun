package com.qunar.fresh.servlet.count;

import com.google.common.base.Preconditions;
import com.qunar.fresh.servlet.InterfaceServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Map;


/**
 * Created by gongxijun on 16-3-21.
 */
public class ThreeServlet extends HttpServlet implements InterfaceServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = "";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie[] cookie = req.getCookies();
        Preconditions.checkNotNull(cookie);
        for (Cookie as : cookie) {
                 username = URLDecoder.decode(as.getValue(), "UTF-8");
        }
        Map<String, Integer> KeyMap = (Map<String, Integer>) req.getSession().getAttribute(KEY_MAP);
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>SecondServlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("<p>");
        out.print(STATEMENT);
        out.print("</p>hi ," + username);
        out.print("<br/>");
        out.print("a/1.do     " + KeyMap.get(K_A1) + "<br/>");
        out.print("a/2.do     " + KeyMap.get(K_A2) + "<br/>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();

    }
}

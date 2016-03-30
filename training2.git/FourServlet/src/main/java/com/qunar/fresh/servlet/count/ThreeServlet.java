package com.qunar.fresh.servlet.count;

import com.google.common.base.Preconditions;
import com.qunar.bean.PageVistor;
import com.qunar.dbutil.DbUtil;
import com.qunar.fresh.servlet.InterfaceServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;


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
        DbUtil dbUtil = new DbUtil();
        //Map<String, Integer> KeyMap = (Map<String, Integer>) req.getSession().getAttribute(KEY_MAP);
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>SecondServlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("<p>");
        out.print(STATEMENT);
        out.print(String.format("</p>hi ,%s", username));
        out.print("<br/>");
        List<PageVistor> list = dbUtil.Query(CONST_STRING);
        for (PageVistor pastor : list) {
            if (pastor.getUrl().equalsIgnoreCase(K_A1) || pastor.getUrl().equalsIgnoreCase(K_A2)) {
                out.println(String.format("%s    : %d", pastor.getUrl(), pastor.getCnt()));
                out.print("<br/>");
            }
        }

        out.print("<br/>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();

    }
}

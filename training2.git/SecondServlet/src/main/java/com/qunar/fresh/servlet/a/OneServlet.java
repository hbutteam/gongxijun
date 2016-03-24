package com.qunar.fresh.servlet.a;


import com.google.common.base.Preconditions;
import com.qunar.fresh.servlet.InterfaceServlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;


/**
 * Created by gongxijun on 16-3-21.
 */
public class OneServlet extends HttpServlet implements InterfaceServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username ="";
        resp.setContentType("text/html ");
        PrintWriter out = resp.getWriter();
        Cookie[] cookie = req.getCookies();
        Preconditions.checkNotNull(cookie);
        for (Cookie as : cookie) {
           username = URLDecoder.decode(as.getValue(), "UTF-8");
        }
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>SecondServlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("<p>");
        out.print(STATEMENT);
        out.print("</p>hi ," + username + "<br/>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
    }


}

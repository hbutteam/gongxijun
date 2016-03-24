package com.qunar.fresh.filter;

import com.google.common.collect.Maps;
import com.qunar.dbutil.DbUtil;
import com.qunar.fresh.servlet.InterfaceServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**
 * Created by gongxijun on 16-3-21.
 */
public class DoFilter implements Filter, InterfaceServlet {

    public static Map<String, Integer> KeyMap;
    public static Logger logger;

    static {
        logger = LoggerFactory.getLogger(DoFilter.class);
        KeyMap = Maps.newHashMap();
    }

    public DoFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        logger.info("Filter is coming....!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //进行字符校验
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        //logger.info("it's a tag stand for the filter is starting");
        //获取URL字符串
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String uri = req.getRequestURI();
        if(uri.equalsIgnoreCase(K_A1)||uri.equalsIgnoreCase(K_A2)) {
            KeyMap.put(uri, (KeyMap.containsKey(uri) ? KeyMap.get(uri) + 1 : 1));
            DbUtil dbUtil = new DbUtil();
            String sql = "insert into PageVistor (cnt,url) values(" + KeyMap.get(uri) + ",'" + uri + "')";
            dbUtil.Update(sql);
            req.getSession().setAttribute(KEY_MAP, KeyMap);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
    //logger.info("it's a tag stand for the filter is ending");

    @Override
    public void destroy() {

        logger.info("过滤器结束.....!");
    }
}

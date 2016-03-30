package com.qunar.flight.control;


import com.google.common.collect.Maps;
import com.qunar.flight.bean.TicketBean;
import com.qunar.flight.model.HNFlightTicket;
import com.qunar.flight.model.HkFlightTicket;
import com.qunar.flight.model.imp.impTicket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gongxijun on 16-3-29.
 */


@Controller
@RequestMapping("/fight")
public class ControlFlight /*implements Controller*/ {

    static Map<String, impTicket> ticketType = Maps.newHashMap();

    {
        ticketType.put("香港航空", new HkFlightTicket());
        ticketType.put("海南航空", new HNFlightTicket());
    }

    @RequestMapping(value = "/start.do", method = RequestMethod.GET)
    public ModelAndView BuyAirTicket() {

        return new ModelAndView("buy");
    }

    @RequestMapping(value = "/buy.do", method = RequestMethod.POST)
    public ModelAndView FlightEntering(HttpServletRequest req) throws ParseException {

        TicketBean ticketBean = new TicketBean();
        ticketBean.setFight_type(req.getParameter("flight_type"));
        ticketBean.setFight_addr("北京大学");
        ticketBean.setFight_id(Integer.valueOf(req.getParameter("flight_id")));
        ticketBean.setCard_id(req.getParameter("card_id"));
        //从身份证中计算年龄
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        java.util.Date d1 = sdf.parse(ticketBean.getCard_id().substring(6, 14));
        java.util.Date d2 = new java.util.Date();
        long result = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);

        ticketBean.setAge((int) (result / 365));
        ticketBean.setFight_date(Date.valueOf(req.getParameter("user_date")));
        impTicket ticket = ticketType.get(ticketBean.getFight_type());

        boolean tag = ticket.FlightEntering(ticketBean);

        String show_text = tag ? "购买机票成功！" : "不符合条件，不能购买！";
        Map model = Maps.newHashMap();
        model.put("showText", show_text);
        return new ModelAndView("show", model);
    }

    @RequestMapping(value = "/flight.do", method = RequestMethod.GET)
    public ModelAndView QueryAirTicket() {

        return new ModelAndView("flight");
    }

    @RequestMapping(value = "/result.do", method = RequestMethod.GET)
    public ModelAndView ShowAirTicket(HttpServletRequest req) {

        impTicket imp = new HNFlightTicket();
        String key = req.getParameter("flight_id");
        Map model = new HashMap();
        model.put("List", imp.QueryEntering(key));
        return new ModelAndView("result", model);
    }
}

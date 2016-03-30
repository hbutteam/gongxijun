package com.qunar.flight.model.imp;

import com.qunar.flight.bean.TicketBean;

import java.util.List;

/**
 * Created by gongxijun on 16-3-29.
 */
public interface impTicket {

    /**
     * 机票查询
     *
     * @return 机票信息结果
     */
    public List<TicketBean> QueryEntering(String key);

    /**
     * 机票录入
     */
    public boolean FlightEntering(TicketBean ticketBean);
}

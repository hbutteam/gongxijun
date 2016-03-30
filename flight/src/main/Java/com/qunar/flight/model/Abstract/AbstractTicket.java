package com.qunar.flight.model.Abstract;

import com.google.common.base.Preconditions;
import com.qunar.flight.bean.TicketBean;
import com.qunar.flight.model.imp.impTicket;
import com.qunar.flight.util.DbUtil;

import java.util.List;

/**
 * Created by gongxijun on 16-3-29.
 */
public abstract class AbstractTicket implements impTicket {

    private Integer limitAge;

    public AbstractTicket(Integer limitAge) {
        this.limitAge = limitAge;
    }

    public Integer getLimitAge() {
        return limitAge;
    }

    public void setLimitAge(Integer limitAge) {
        this.limitAge = limitAge;
    }

    /**
     * 机票查询
     *
     * @return 机票信息结果
     */
    @Override
    public List<TicketBean> QueryEntering(String key) {

        String sql;
        if (key == null || key.isEmpty() || key.equals(""))
            sql = String.format("select * from FightForm");
        else
            sql = String.format("select * from FightForm where fight_id=%s", key);

        DbUtil dbUtil = new DbUtil();

        return dbUtil.Query(sql);
    }


    /**
     * 机票录入
     */
    @Override
    public boolean FlightEntering(TicketBean ticketBean) {

        Preconditions.checkNotNull(ticketBean);
        if (ticketBean.getAge() <= limitAge) return false;

        String sql = "INSERT INTO FightForm (fight_type,fight_addr,fight_id,card_id,age,fight_date) " +
                "VALUES('" + ticketBean.getFight_type() + "','" + ticketBean.getFight_Address() + "'," + ticketBean.getFight_id() + ",'"
                + ticketBean.getCard_id() + "'," + ticketBean.getAge() + ",'" + ticketBean.getFight_date() + "')";


        DbUtil dbUtil = new DbUtil();
        dbUtil.Update(sql);

        return true;
    }
}

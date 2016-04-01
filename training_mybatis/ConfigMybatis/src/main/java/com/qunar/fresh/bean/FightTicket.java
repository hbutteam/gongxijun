package com.qunar.fresh.bean;

import com.qunar.fresh.bean.imp.Ticket;

/**
 * Created by gongxijun on 16-4-1.
 */
public class FightTicket implements Ticket {


    private int id;
    private String name;
    private int cnt;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

package com.qunar.flight.bean;

import java.sql.Date;

/**
 * Created by gongxijun on 16-3-29.
 */
public class TicketBean {

    private int id;

    private String fight_type;
    private String fight_addr;
    private int fight_id;
    private String card_id;
    private int age;
    private Date fight_date;

    public TicketBean() {

    }

    public TicketBean(int id, String fight_type, String fight_addr, int fight_id, String card_id, int age, Date fight_date) {
        this.id = id;
        this.fight_type = fight_type;
        this.fight_addr = fight_addr;
        this.fight_id = fight_id;
        this.card_id = card_id;
        this.age = age;
        this.fight_date = fight_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFight_type() {
        return fight_type;
    }

    public void setFight_type(String fight_type) {
        this.fight_type = fight_type;
    }

    public String getFight_addr() {
        return fight_addr;
    }

    public void setFight_addr(String fight_addr) {
        this.fight_addr = fight_addr;
    }

    public int getFight_id() {
        return fight_id;
    }

    public void setFight_id(int fight_id) {
        this.fight_id = fight_id;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getFight_date() {
        return fight_date;
    }

    public void setFight_date(Date fight_date) {
        this.fight_date = fight_date;
    }
}

package com.qunar.flight.bean;

import java.sql.Date;

/**
 * Created by gongxijun on 16-3-29.
 */
public class TicketBean {

    private int id;

    private String fight_type;
    private String fight_Address;
    private int fight_id;
    private String card_id;
    private int age;
    private Date fight_date;

    public TicketBean() {

    }

    public TicketBean(int id, String fight_type, String fight_Address, int fight_id, String card_id, int age, Date fight_date) {
        this.id = id;
        this.fight_type = fight_type;
        this.fight_Address = fight_Address;
        this.fight_id = fight_id;
        this.card_id = card_id;
        this.age = age;
        this.fight_date = fight_date;
    }

    /**
     * 判断填写的单子是否正确：
     * 此处应该有严格约束.
     *
     * @return 判断数据是否填全
     */
    public boolean isempty() {
        return ((this.fight_type == null) || (this.fight_date == null)||
                (this.card_id == null) || (this.fight_id == 0));
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

    public String getFight_Address() {
        return fight_Address;
    }

    public void setFight_Address(String fight_Address) {
        this.fight_Address = fight_Address;
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

package com.qunar.fresh.bean;

import com.qunar.fresh.bean.imp.Employer;

/**
 * Created by gongxijun on 16-4-1.
 */
public class FightEmployers implements Employer {


    private static FightEmployers instance = null;

    private int id;
    private String qtalk_id;
    private String employer_name;
    private String tell;
    private String work_address;
    private String sex;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQtalk_id() {
        return qtalk_id;
    }

    public void setQtalk_id(String qtalk_id) {
        this.qtalk_id = qtalk_id;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getWork_address() {
        return work_address;
    }

    public void setWork_address(String work_address) {
        this.work_address = work_address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static FightEmployers NewFightTicke() {

        if (null == instance) {
            instance = new FightEmployers();
        }
        return instance;
    }

}

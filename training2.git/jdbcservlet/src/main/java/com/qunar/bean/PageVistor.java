package com.qunar.bean;

/**
 * Created by gongxijun on 16-3-22.
 */
public class PageVistor {

    private Integer id;
    private String name;
    private Integer cnt;
    private String url;

    public PageVistor(int id, String name, String url, int cnt) {

        this.id = id;
        this.name = name;
        this.url = url;
        this.cnt = cnt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

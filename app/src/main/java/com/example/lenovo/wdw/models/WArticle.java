package com.example.lenovo.wdw.models;

/**
 * Created by Administrator on 2016/4/11.
 */
public class WArticle {

    private String pk;
    private String title;
    private String app_ids;
    private String date;
    private String auther_name;
    private String weburl;
    private String is_full;
    private String content;
    private String full_url;
    private WSpecialInfo special_info;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApp_ids() {
        return app_ids;
    }

    public void setApp_ids(String app_ids) {
        this.app_ids = app_ids;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuther_name() {
        return auther_name;
    }

    public void setAuther_name(String auther_name) {
        this.auther_name = auther_name;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getIs_full() {
        return is_full;
    }

    public void setIs_full(String is_full) {
        this.is_full = is_full;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public WSpecialInfo getSpecial_info() {
        return special_info;
    }

    public void setSpecial_info(WSpecialInfo special_info) {
        this.special_info = special_info;
    }
}

package com.example.lenovo.wdw.models;

import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */
public class WWeekendS {

    private String pk;
    private String source;
    private String redis_score;
    private String title;
    private String date;
    private String tag;
    private List<WContacts> contacts;
    private String cate_id;
    private String category_name;
    private List<WThumbanil_medias> thumbnail_medias;
    private String time_str;
    private String author_name;
    private String address;
    private String pos_str;
    private String price;
    private String content;
    private String share_content;
    private String share_url;
    private String full_url;
    private String open_type;
    private WWeekend weekend;
    private String tpl_cell_style;


    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRedis_score() {
        return redis_score;
    }

    public void setRedis_score(String redis_score) {
        this.redis_score = redis_score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<WContacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<WContacts> contacts) {
        this.contacts = contacts;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<WThumbanil_medias> getThumbnail_medias() {
        return thumbnail_medias;
    }

    public void setThumbnail_medias(List<WThumbanil_medias> thumbnail_medias) {
        this.thumbnail_medias = thumbnail_medias;
    }

    public String getTime_str() {
        return time_str;
    }

    public void setTime_str(String time_str) {
        this.time_str = time_str;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPos_str() {
        return pos_str;
    }

    public void setPos_str(String pos_str) {
        this.pos_str = pos_str;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShare_content() {
        return share_content;
    }

    public void setShare_content(String share_content) {
        this.share_content = share_content;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public String getOpen_type() {
        return open_type;
    }

    public void setOpen_type(String open_type) {
        this.open_type = open_type;
    }

    public WWeekend getWeekend() {
        return weekend;
    }

    public void setWeekend(WWeekend weekend) {
        this.weekend = weekend;
    }

    public String getTpl_cell_style() {
        return tpl_cell_style;
    }

    public void setTpl_cell_style(String tpl_cell_style) {
        this.tpl_cell_style = tpl_cell_style;
    }
}

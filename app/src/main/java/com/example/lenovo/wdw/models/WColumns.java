package com.example.lenovo.wdw.models;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
public class WColumns {
    private String pk;
    private String score;
    private String title;
    private String build_banner;
    private String rank;
    private WBanner banner;
    private String style;
    private String show_more;
    private List<WItems> items;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBuild_banner() {
        return build_banner;
    }

    public void setBuild_banner(String build_banner) {
        this.build_banner = build_banner;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public WBanner getBanner() {
        return banner;
    }

    public void setBanner(WBanner banner) {
        this.banner = banner;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getShow_more() {
        return show_more;
    }

    public void setShow_more(String show_more) {
        this.show_more = show_more;
    }

    public List<WItems> getItems() {
        return items;
    }

    public void setItems(List<WItems> items) {
        this.items = items;
    }
}

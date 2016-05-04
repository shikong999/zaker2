package com.example.lenovo.wdw.models;

/**
 * Created by Administrator on 2016/4/11.
 */
public class WItems {
    private String pk;
    private String title;
    private String tag;
    private String content;
    private String share_content;
    private WBanner pic;
    private String tpl_cell_style;
    private String click_stat_url;
    private String type;
    private WArticle article;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public WBanner getPic() {
        return pic;
    }

    public void setPic(WBanner pic) {
        this.pic = pic;
    }

    public String getTpl_cell_style() {
        return tpl_cell_style;
    }

    public void setTpl_cell_style(String tpl_cell_style) {
        this.tpl_cell_style = tpl_cell_style;
    }

    public String getClick_stat_url() {
        return click_stat_url;
    }

    public void setClick_stat_url(String click_stat_url) {
        this.click_stat_url = click_stat_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WArticle getArticle() {
        return article;
    }

    public void setArticle(WArticle article) {
        this.article = article;
    }
}

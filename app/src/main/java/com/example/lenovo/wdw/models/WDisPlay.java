package com.example.lenovo.wdw.models;

/**
 * Created by Administrator on 2016/4/11.
 */
public class WDisPlay {
    private String pk;
    private String title;
    private WBanner pic;
    private String click_stat_url;
    private String type;
    private WBlockInfo block_info;

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

    public WBanner getPic() {
        return pic;
    }

    public void setPic(WBanner pic) {
        this.pic = pic;
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

    public WBlockInfo getBlock_info() {
        return block_info;
    }

    public void setBlock_info(WBlockInfo block_info) {
        this.block_info = block_info;
    }
}

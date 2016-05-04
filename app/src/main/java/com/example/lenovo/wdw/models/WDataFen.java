package com.example.lenovo.wdw.models;

import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */
public class WDataFen {

    private WInfoFen info;
    private List<WWeekendS> weekends;

    public WInfoFen getInfo() {
        return info;
    }

    public void setInfo(WInfoFen info) {
        this.info = info;
    }

    public List<WWeekendS> getWeekends() {
        return weekends;
    }

    public void setWeekends(List<WWeekendS> weekends) {
        this.weekends = weekends;
    }
}

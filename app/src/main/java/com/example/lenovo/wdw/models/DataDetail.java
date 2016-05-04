package com.example.lenovo.wdw.models;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
public class DataDetail {
    private WInfo info;
    private List<WColumns> columns;
    private List<WPromote> promote;
    private List<WDisPlay> display;

    public WInfo getInfo() {
        return info;
    }

    public void setInfo(WInfo info) {
        this.info = info;
    }

    public List<WColumns> getColumns() {
        return columns;
    }

    public void setColumns(List<WColumns> columns) {
        this.columns = columns;
    }

    public List<WPromote> getPromote() {
        return promote;
    }

    public void setPromote(List<WPromote> promote) {
        this.promote = promote;
    }

    public List<WDisPlay> getDisplay() {
        return display;
    }

    public void setDisplay(List<WDisPlay> display) {
        this.display = display;
    }
}

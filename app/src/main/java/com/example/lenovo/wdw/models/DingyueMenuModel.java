package com.example.lenovo.wdw.models;

import com.example.lenovo.wdw.utils.JsonResponseParse;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * 订阅菜单条目JavaBean
 */
@HttpResponse(parser = JsonResponseParse.class)
public class DingyueMenuModel {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pk : 310000
         * title : 今日看点
         * block_title : 今日看点
         * is_end : Y
         * data_type :
         * list_icon :
         * list_stitle :
         * block_bg_key : 3
         * no_offline_down : N
         * need_userinfo : YES
         * p_pk :
         * pic : http://zkres.myzaker.com/data/image/logo/ipad3/1057.png
         * large_pic : http://zkres.myzaker.com/data/image/logo/ipad3/1057.png
         * api_url : http://iphone.myzaker.com/zaker/daily_hot.php?app_id_4=310000
         * block_color : #2e4260
         */

        private List<BlocksDataBean> blocksData;

        public List<BlocksDataBean> getBlocksData() {
            return blocksData;
        }

        public void setBlocksData(List<BlocksDataBean> blocksData) {
            this.blocksData = blocksData;
        }

        public static class BlocksDataBean {
            private String title;
            private String pic;
            private String api_url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getApi_url() {
                return api_url;
            }

            public void setApi_url(String api_url) {
                this.api_url = api_url;
            }
        }
    }
}

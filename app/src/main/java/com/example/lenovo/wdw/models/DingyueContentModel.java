package com.example.lenovo.wdw.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.lenovo.wdw.utils.JsonResponseParse;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * 订阅内容JavaBean
 */
@HttpResponse(parser = JsonResponseParse.class)
public class DingyueContentModel {
    /**
     * articles : [{"pk":"570cad60a07aec7b310004c7","app_ids":"3","title":"金正恩手握新王牌 价格低廉用得起","title_line_break":"金正恩手握新王牌 价格低廉用得起","date":"2016-04-12 16:10:05","auther_name":"国际先驱导报","weburl":"http://iphone.myzaker.com/l.php?l=570cad60a07aec7b310004c7","media":[{"type":"image","id":"570cad5da07aec7b310004c6","url":"http://zkres.myzaker.com/201604/570cad5da07aec7b310004c6_640.jpg","m_url":"http://zkres.myzaker.com/201604/570cad5da07aec7b310004c6_320.jpg","min_url":"http://zkres.myzaker.com/201604/570cad5da07aec7b310004c6_120.jpg","raw_url":"http://img1.gtimg.com/news/pics/hv1/180/82/2051/133387365.jpg","w":"640","h":"421"}],"is_full":"NO","full_url":"http://iphone.myzaker.com/zaker/article_mongo.php?app_id=3&pk=570cad60a07aec7b310004c7&m=1460449409","special_info":{"show_jingcai":"Y"}}]
     * ipadconfig : {"pages":[{"pk":"1","page":"1","tpl_group":"6","tpl_type":"news","tpl_style":"4","articles":"559cece09490cb3a6b00000a,570cc4919490cb02530000df,570cbee29490cb6f76000153,570cc59f9490cbf8620000a5,570cc4979490cb4376000171,570cc6e31bc8e0e37600002a","diy":{"bgimage_url":"http://upload.myzaker.com/data/image/template/iphone/1057.png?1418985329","bgimage_frame":"0,0,320,60","title_h":"60","hide_title":"YES","open_type":""}}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private infoBean info;
        private IpadconfigBean ipadconfig;
        private blockInfoBean block_info;

        /**
         * pk : 570cad60a07aec7b310004c7
         * app_ids : 3
         * title : 金正恩手握新王牌 价格低廉用得起
         * title_line_break : 金正恩手握新王牌 价格低廉用得起
         * date : 2016-04-12 16:10:05
         * auther_name : 国际先驱导报
         * weburl : http://iphone.myzaker.com/l.php?l=570cad60a07aec7b310004c7
         * media : [{"type":"image","id":"570cad5da07aec7b310004c6","url":"http://zkres.myzaker.com/201604/570cad5da07aec7b310004c6_640.jpg","m_url":"http://zkres.myzaker.com/201604/570cad5da07aec7b310004c6_320.jpg","min_url":"http://zkres.myzaker.com/201604/570cad5da07aec7b310004c6_120.jpg","raw_url":"http://img1.gtimg.com/news/pics/hv1/180/82/2051/133387365.jpg","w":"640","h":"421"}]
         * is_full : NO
         * full_url : http://iphone.myzaker.com/zaker/article_mongo.php?app_id=3&pk=570cad60a07aec7b310004c7&m=1460449409
         * special_info : {"show_jingcai":"Y"}
         */

        private List<ArticlesBean> articles;

        public blockInfoBean getBlock_info() {
            return block_info;
        }

        public void setBlock_info(blockInfoBean block_info) {
            this.block_info = block_info;
        }

        public infoBean getInfo() {
            return info;
        }

        public void setInfo(infoBean info) {
            this.info = info;
        }

        public IpadconfigBean getIpadconfig() {
            return ipadconfig;
        }

        public void setIpadconfig(IpadconfigBean ipadconfig) {
            this.ipadconfig = ipadconfig;
        }

        public List<ArticlesBean> getArticles() {
            return articles;
        }

        public void setArticles(List<ArticlesBean> articles) {
            this.articles = articles;
        }

        public static class blockInfoBean{
            private String title;
            private diyBean diy;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public diyBean getDiy() {
                return diy;
            }

            public void setDiy(diyBean diy) {
                this.diy = diy;
            }

            public static class diyBean{
                private String bgimage_url;

                public String getBgimage_url() {
                    return bgimage_url;
                }

                public void setBgimage_url(String bgimage_url) {
                    this.bgimage_url = bgimage_url;
                }
            }
        }

        public static class infoBean {
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class IpadconfigBean {
            /**
             * pk : 1
             * page : 1
             * tpl_group : 6
             * tpl_type : news
             * tpl_style : 4
             * articles : 559cece09490cb3a6b00000a,570cc4919490cb02530000df,570cbee29490cb6f76000153,570cc59f9490cbf8620000a5,570cc4979490cb4376000171,570cc6e31bc8e0e37600002a
             * diy : {"bgimage_url":"http://upload.myzaker.com/data/image/template/iphone/1057.png?1418985329","bgimage_frame":"0,0,320,60","title_h":"60","hide_title":"YES","open_type":""}
             */

            private List<PagesBean> pages;

            public List<PagesBean> getPages() {
                return pages;
            }

            public void setPages(List<PagesBean> pages) {
                this.pages = pages;
            }

            public static class PagesBean {
                /**
                 * bgimage_url : http://upload.myzaker.com/data/image/template/iphone/1057.png?1418985329
                 * bgimage_frame : 0,0,320,60
                 * title_h : 60
                 * hide_title : YES
                 * open_type :
                 */

                private DiyBean diy;

                public DiyBean getDiy() {
                    return diy;
                }

                public void setDiy(DiyBean diy) {
                    this.diy = diy;
                }

                public static class DiyBean {
                    private String bgimage_url;
                    private String bgimage_frame;
                    private String title_h;

                    public String getBgimage_url() {
                        return bgimage_url;
                    }

                    public void setBgimage_url(String bgimage_url) {
                        this.bgimage_url = bgimage_url;
                    }

                    public String getBgimage_frame() {
                        return bgimage_frame;
                    }

                    public void setBgimage_frame(String bgimage_frame) {
                        this.bgimage_frame = bgimage_frame;
                    }

                    public String getTitle_h() {
                        return title_h;
                    }

                    public void setTitle_h(String title_h) {
                        this.title_h = title_h;
                    }
                }
            }
        }

        public static class ArticlesBean implements Parcelable {
            private String pk;
            private String title;
            private String date;
            private String auther_name;
            private String weburl;
            private String full_url;
            /**
             * type : image
             * id : 570cad5da07aec7b310004c6
             * url : http://zkres.myzaker.com/201604/570cad5da07aec7b310004c6_640.jpg
             * m_url : http://zkres.myzaker.com/201604/570cad5da07aec7b310004c6_320.jpg
             * min_url : http://zkres.myzaker.com/201604/570cad5da07aec7b310004c6_120.jpg
             * raw_url : http://img1.gtimg.com/news/pics/hv1/180/82/2051/133387365.jpg
             * w : 640
             * h : 421
             */

            private List<MediaBean> media;

            protected ArticlesBean(Parcel in) {
                pk = in.readString();
                title = in.readString();
                date = in.readString();
                auther_name = in.readString();
                weburl = in.readString();
                full_url = in.readString();
            }

            public static final Creator<ArticlesBean> CREATOR = new Creator<ArticlesBean>() {
                @Override
                public ArticlesBean createFromParcel(Parcel in) {
                    return new ArticlesBean(in);
                }

                @Override
                public ArticlesBean[] newArray(int size) {
                    return new ArticlesBean[size];
                }
            };

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

            public String getFull_url() {
                return full_url;
            }

            public void setFull_url(String full_url) {
                this.full_url = full_url;
            }

            public List<MediaBean> getMedia() {
                return media;
            }

            public void setMedia(List<MediaBean> media) {
                this.media = media;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(pk);
                dest.writeString(title);
                dest.writeString(date);
                dest.writeString(auther_name);
                dest.writeString(weburl);
                dest.writeString(full_url);
            }

            public static class MediaBean {
                private String type;
                private String url;
                private String w;
                private String h;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getW() {
                    return w;
                }

                public void setW(String w) {
                    this.w = w;
                }

                public String getH() {
                    return h;
                }

                public void setH(String h) {
                    this.h = h;
                }
            }
        }
    }
}

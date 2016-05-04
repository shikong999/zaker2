package com.example.lenovo.wdw.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.lenovo.wdw.utils.JsonResponseParse;

import org.xutils.http.annotation.HttpResponse;

import java.util.List;

/**
 * 订阅轮播图JavaBean
 */
@HttpResponse(parser = JsonResponseParse.class)
public class DingyueViewPageModel {

    /**
     * stat : 1
     * msg : OK
     * data : {"info":{"common_api_url":"http://iphone.myzaker.com/zaker/common_api.php","readstat":"http://stat.myzaker.com/stat.php"},"list":[{"pk":"570e24759490cba12d000013","promotion_img":"http://zkres3.myzaker.com/img_upload/editor/img_upload/20160413/up_1460544599_58108.jpg","img_height":"360","img_width":"640","title":"切尔诺贝利30年 遭受高辐射的儿童","end_time":"1460553600","type":"a","pop_type":"","hide_mask":"Y","ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=570e24759490cba12d000013&position=my_subscriptions_promotion&click_stat=1","stat_read_url":"http://adm.myzaker.com/ads_stat.php?ads_id=570e24759490cba12d000013&position=my_subscriptions_promotion_read&action=read","tag_info":{"type":"img","text":"频道","image_url":"http://zkres.myzaker.com/data/image/mark/channel_2x.png","img_height":"26","img_width":"46","tag_position":"1"},"start_time":"1460548800","article":{"pk":"570e241a9490cb092f000192","title":"切尔诺贝利30年 遭受高辐射的儿童","app_ids":"2","date":"2016-04-13 21:20:00","auther_name":"腾讯新闻","weburl":"http://iphone.myzaker.com/l.php?l=570e241a9490cb092f000192","is_full":"NO","content":"","full_url":"http://iphone.myzaker.com/zaker/article_mongo.php?app_id=2&pk=570e241a9490cb092f000192"},"post":{"pk":"570c9fcf9490cb7276000161","discussion_id":"86","auther":{"name":"侯虹斌","uid":"11415800","user_flag":[{"pic":"http://zkres.myzaker.com/data/image/discussion/img/ic_official_user_flag_celebrity.png"}],"icon":"http://wx.qlogo.cn/mmopen/JEnzUUrDvD0VOpTjVMGniaS3eGvZzGRTfGjydODjn17KIdBUg4YEXx9eMlicpyKSb6gKMatN5EG4SWckGhf8LlXZS25I9MBDPN/0"},"title":"","date":"2016-04-12 15:12:15","comment_count":"93","hot_num":"2464","post_tag":[{"name":"活动","icon":"http://zkres.myzaker.com/data/image/mark2/activity_2x.png?v=20150612"},{"name":"置顶","icon":"http://zkres.myzaker.com/data/image/mark2/stick3_2x.png"}],"content":"各位ZAKER的朋友，大家好！我是侯虹斌。很高兴作为ZAKER 女神来了直播访谈的嘉宾，跟ZAKER的朋友一起交流分享。前不久《她最后去了相亲角》视频刷遍朋友圈，你怎么看待剩男剩女和婚姻？这是心灵鸡汤，或者说是消费剩女？ 本期主题：剩or不剩，谁说了算？ 直播时间：4月13日晚上8点-9点 参与方式：在本帖中直接留言评论，即可参与直播，嘉宾会在直播当天，挑选问题进行回答。 欢迎大家加入ZAKER时尚女神群：451124600 ，活动信息将第一时间在里面公布哦！ 【新用户下载ZAKER客户端\u2014\u2014点击首页右下\u201c社区\u201d按钮\u2014\u2014在\u201c话题\u201d里找到\u201c女神转型记\u201d，右侧+关注并点击进入即可参与。】 ","medias":[{"type":"image","id":"570daf529490cb132f0000b5","w":"1242","h":"878","url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h800.jpg","m_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h400.jpg","s_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h200.jpg","min_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h120.jpg","raw_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg"},{"type":"image","id":"570daf529490cb132f0000b6","w":"1242","h":"1353","url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h800.jpg","m_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h400.jpg","s_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h200.jpg","min_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h120.jpg","raw_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg"}],"weburl":"http://dis.myzaker.com/api/l.php?discussion_id=86&post_id=570c9fcf9490cb7276000161","content_url":"http://dis.myzaker.com/api/view_post.php?discussion_id=86&post_id=570c9fcf9490cb7276000161&_appid=&_version=","comment_list_url":"http://dis.myzaker.com/api/get_comment.php?discussion_id=86&post_id=570c9fcf9490cb7276000161","discussion":{"pk":"86","title":"女神转型记","stitle":"女生小天地","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=86","block_color":"","subscribe_count":"179892","post_count":"8553"}}}]}
     */

    private String stat;
    private String msg;
    /**
     * info : {"common_api_url":"http://iphone.myzaker.com/zaker/common_api.php","readstat":"http://stat.myzaker.com/stat.php"}
     * list : [{"pk":"570e24759490cba12d000013","promotion_img":"http://zkres3.myzaker.com/img_upload/editor/img_upload/20160413/up_1460544599_58108.jpg","img_height":"360","img_width":"640","title":"切尔诺贝利30年 遭受高辐射的儿童","end_time":"1460553600","type":"a","pop_type":"","hide_mask":"Y","ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=570e24759490cba12d000013&position=my_subscriptions_promotion&click_stat=1","stat_read_url":"http://adm.myzaker.com/ads_stat.php?ads_id=570e24759490cba12d000013&position=my_subscriptions_promotion_read&action=read","tag_info":{"type":"img","text":"频道","image_url":"http://zkres.myzaker.com/data/image/mark/channel_2x.png","img_height":"26","img_width":"46","tag_position":"1"},"start_time":"1460548800","article":{"pk":"570e241a9490cb092f000192","title":"切尔诺贝利30年 遭受高辐射的儿童","app_ids":"2","date":"2016-04-13 21:20:00","auther_name":"腾讯新闻","weburl":"http://iphone.myzaker.com/l.php?l=570e241a9490cb092f000192","is_full":"NO","content":"","full_url":"http://iphone.myzaker.com/zaker/article_mongo.php?app_id=2&pk=570e241a9490cb092f000192"},"post":{"pk":"570c9fcf9490cb7276000161","discussion_id":"86","auther":{"name":"侯虹斌","uid":"11415800","user_flag":[{"pic":"http://zkres.myzaker.com/data/image/discussion/img/ic_official_user_flag_celebrity.png"}],"icon":"http://wx.qlogo.cn/mmopen/JEnzUUrDvD0VOpTjVMGniaS3eGvZzGRTfGjydODjn17KIdBUg4YEXx9eMlicpyKSb6gKMatN5EG4SWckGhf8LlXZS25I9MBDPN/0"},"title":"","date":"2016-04-12 15:12:15","comment_count":"93","hot_num":"2464","post_tag":[{"name":"活动","icon":"http://zkres.myzaker.com/data/image/mark2/activity_2x.png?v=20150612"},{"name":"置顶","icon":"http://zkres.myzaker.com/data/image/mark2/stick3_2x.png"}],"content":"各位ZAKER的朋友，大家好！我是侯虹斌。很高兴作为ZAKER 女神来了直播访谈的嘉宾，跟ZAKER的朋友一起交流分享。前不久《她最后去了相亲角》视频刷遍朋友圈，你怎么看待剩男剩女和婚姻？这是心灵鸡汤，或者说是消费剩女？ 本期主题：剩or不剩，谁说了算？ 直播时间：4月13日晚上8点-9点 参与方式：在本帖中直接留言评论，即可参与直播，嘉宾会在直播当天，挑选问题进行回答。 欢迎大家加入ZAKER时尚女神群：451124600 ，活动信息将第一时间在里面公布哦！ 【新用户下载ZAKER客户端\u2014\u2014点击首页右下\u201c社区\u201d按钮\u2014\u2014在\u201c话题\u201d里找到\u201c女神转型记\u201d，右侧+关注并点击进入即可参与。】 ","medias":[{"type":"image","id":"570daf529490cb132f0000b5","w":"1242","h":"878","url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h800.jpg","m_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h400.jpg","s_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h200.jpg","min_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h120.jpg","raw_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg"},{"type":"image","id":"570daf529490cb132f0000b6","w":"1242","h":"1353","url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h800.jpg","m_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h400.jpg","s_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h200.jpg","min_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h120.jpg","raw_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg"}],"weburl":"http://dis.myzaker.com/api/l.php?discussion_id=86&post_id=570c9fcf9490cb7276000161","content_url":"http://dis.myzaker.com/api/view_post.php?discussion_id=86&post_id=570c9fcf9490cb7276000161&_appid=&_version=","comment_list_url":"http://dis.myzaker.com/api/get_comment.php?discussion_id=86&post_id=570c9fcf9490cb7276000161","discussion":{"pk":"86","title":"女神转型记","stitle":"女生小天地","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=86","block_color":"","subscribe_count":"179892","post_count":"8553"}}}]
     */

    private DataBean data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * common_api_url : http://iphone.myzaker.com/zaker/common_api.php
         * readstat : http://stat.myzaker.com/stat.php
         */

        private InfoBean info;
        /**
         * pk : 570e24759490cba12d000013
         * promotion_img : http://zkres3.myzaker.com/img_upload/editor/img_upload/20160413/up_1460544599_58108.jpg
         * img_height : 360
         * img_width : 640
         * title : 切尔诺贝利30年 遭受高辐射的儿童
         * end_time : 1460553600
         * type : a
         * pop_type :
         * hide_mask : Y
         * ads_stat_url : http://adm.myzaker.com/ads_stat.php?ads_id=570e24759490cba12d000013&position=my_subscriptions_promotion&click_stat=1
         * stat_read_url : http://adm.myzaker.com/ads_stat.php?ads_id=570e24759490cba12d000013&position=my_subscriptions_promotion_read&action=read
         * tag_info : {"type":"img","text":"频道","image_url":"http://zkres.myzaker.com/data/image/mark/channel_2x.png","img_height":"26","img_width":"46","tag_position":"1"}
         * start_time : 1460548800
         * article : {"pk":"570e241a9490cb092f000192","title":"切尔诺贝利30年 遭受高辐射的儿童","app_ids":"2","date":"2016-04-13 21:20:00","auther_name":"腾讯新闻","weburl":"http://iphone.myzaker.com/l.php?l=570e241a9490cb092f000192","is_full":"NO","content":"","full_url":"http://iphone.myzaker.com/zaker/article_mongo.php?app_id=2&pk=570e241a9490cb092f000192"}
         * post : {"pk":"570c9fcf9490cb7276000161","discussion_id":"86","auther":{"name":"侯虹斌","uid":"11415800","user_flag":[{"pic":"http://zkres.myzaker.com/data/image/discussion/img/ic_official_user_flag_celebrity.png"}],"icon":"http://wx.qlogo.cn/mmopen/JEnzUUrDvD0VOpTjVMGniaS3eGvZzGRTfGjydODjn17KIdBUg4YEXx9eMlicpyKSb6gKMatN5EG4SWckGhf8LlXZS25I9MBDPN/0"},"title":"","date":"2016-04-12 15:12:15","comment_count":"93","hot_num":"2464","post_tag":[{"name":"活动","icon":"http://zkres.myzaker.com/data/image/mark2/activity_2x.png?v=20150612"},{"name":"置顶","icon":"http://zkres.myzaker.com/data/image/mark2/stick3_2x.png"}],"content":"各位ZAKER的朋友，大家好！我是侯虹斌。很高兴作为ZAKER 女神来了直播访谈的嘉宾，跟ZAKER的朋友一起交流分享。前不久《她最后去了相亲角》视频刷遍朋友圈，你怎么看待剩男剩女和婚姻？这是心灵鸡汤，或者说是消费剩女？ 本期主题：剩or不剩，谁说了算？ 直播时间：4月13日晚上8点-9点 参与方式：在本帖中直接留言评论，即可参与直播，嘉宾会在直播当天，挑选问题进行回答。 欢迎大家加入ZAKER时尚女神群：451124600 ，活动信息将第一时间在里面公布哦！ 【新用户下载ZAKER客户端\u2014\u2014点击首页右下\u201c社区\u201d按钮\u2014\u2014在\u201c话题\u201d里找到\u201c女神转型记\u201d，右侧+关注并点击进入即可参与。】 ","medias":[{"type":"image","id":"570daf529490cb132f0000b5","w":"1242","h":"878","url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h800.jpg","m_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h400.jpg","s_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h200.jpg","min_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h120.jpg","raw_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg"},{"type":"image","id":"570daf529490cb132f0000b6","w":"1242","h":"1353","url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h800.jpg","m_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h400.jpg","s_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h200.jpg","min_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h120.jpg","raw_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg"}],"weburl":"http://dis.myzaker.com/api/l.php?discussion_id=86&post_id=570c9fcf9490cb7276000161","content_url":"http://dis.myzaker.com/api/view_post.php?discussion_id=86&post_id=570c9fcf9490cb7276000161&_appid=&_version=","comment_list_url":"http://dis.myzaker.com/api/get_comment.php?discussion_id=86&post_id=570c9fcf9490cb7276000161","discussion":{"pk":"86","title":"女神转型记","stitle":"女生小天地","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=86","block_color":"","subscribe_count":"179892","post_count":"8553"}}
         */

        private List<ListBean> list;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class InfoBean {
            private String common_api_url;
            private String readstat;

            public String getCommon_api_url() {
                return common_api_url;
            }

            public void setCommon_api_url(String common_api_url) {
                this.common_api_url = common_api_url;
            }

            public String getReadstat() {
                return readstat;
            }

            public void setReadstat(String readstat) {
                this.readstat = readstat;
            }
        }

        public static class ListBean implements Parcelable {
            private String pk;
            private String promotion_img;
            private String img_height;
            private String img_width;
            private String title;
            private String end_time;
            private String type;
            private String pop_type;
            private String hide_mask;
            private String ads_stat_url;
            private String stat_read_url;
            /**
             * type : img
             * text : 频道
             * image_url : http://zkres.myzaker.com/data/image/mark/channel_2x.png
             * img_height : 26
             * img_width : 46
             * tag_position : 1
             */

            private TagInfoBean tag_info;

            private TopicBean topic;

            public BlockInfoBean getBlock_info() {
                return block_info;
            }

            public void setBlock_info(BlockInfoBean block_info) {
                this.block_info = block_info;
            }

            public TopicBean getTopic() {
                return topic;
            }

            public void setTopic(TopicBean topic) {
                this.topic = topic;
            }

            private BlockInfoBean block_info;
            private String start_time;
            /**
             * pk : 570e241a9490cb092f000192
             * title : 切尔诺贝利30年 遭受高辐射的儿童
             * app_ids : 2
             * date : 2016-04-13 21:20:00
             * auther_name : 腾讯新闻
             * weburl : http://iphone.myzaker.com/l.php?l=570e241a9490cb092f000192
             * is_full : NO
             * content :
             * full_url : http://iphone.myzaker.com/zaker/article_mongo.php?app_id=2&pk=570e241a9490cb092f000192
             */

            private ArticleBean article;
            /**
             * pk : 570c9fcf9490cb7276000161
             * discussion_id : 86
             * auther : {"name":"侯虹斌","uid":"11415800","user_flag":[{"pic":"http://zkres.myzaker.com/data/image/discussion/img/ic_official_user_flag_celebrity.png"}],"icon":"http://wx.qlogo.cn/mmopen/JEnzUUrDvD0VOpTjVMGniaS3eGvZzGRTfGjydODjn17KIdBUg4YEXx9eMlicpyKSb6gKMatN5EG4SWckGhf8LlXZS25I9MBDPN/0"}
             * title :
             * date : 2016-04-12 15:12:15
             * comment_count : 93
             * hot_num : 2464
             * post_tag : [{"name":"活动","icon":"http://zkres.myzaker.com/data/image/mark2/activity_2x.png?v=20150612"},{"name":"置顶","icon":"http://zkres.myzaker.com/data/image/mark2/stick3_2x.png"}]
             * content : 各位ZAKER的朋友，大家好！我是侯虹斌。很高兴作为ZAKER 女神来了直播访谈的嘉宾，跟ZAKER的朋友一起交流分享。前不久《她最后去了相亲角》视频刷遍朋友圈，你怎么看待剩男剩女和婚姻？这是心灵鸡汤，或者说是消费剩女？ 本期主题：剩or不剩，谁说了算？ 直播时间：4月13日晚上8点-9点 参与方式：在本帖中直接留言评论，即可参与直播，嘉宾会在直播当天，挑选问题进行回答。 欢迎大家加入ZAKER时尚女神群：451124600 ，活动信息将第一时间在里面公布哦！ 【新用户下载ZAKER客户端——点击首页右下“社区”按钮——在“话题”里找到“女神转型记”，右侧+关注并点击进入即可参与。】
             * medias : [{"type":"image","id":"570daf529490cb132f0000b5","w":"1242","h":"878","url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h800.jpg","m_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h400.jpg","s_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h200.jpg","min_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h120.jpg","raw_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg"},{"type":"image","id":"570daf529490cb132f0000b6","w":"1242","h":"1353","url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h800.jpg","m_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h400.jpg","s_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h200.jpg","min_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg.h120.jpg","raw_url":"http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b6.jpg"}]
             * weburl : http://dis.myzaker.com/api/l.php?discussion_id=86&post_id=570c9fcf9490cb7276000161
             * content_url : http://dis.myzaker.com/api/view_post.php?discussion_id=86&post_id=570c9fcf9490cb7276000161&_appid=&_version=
             * comment_list_url : http://dis.myzaker.com/api/get_comment.php?discussion_id=86&post_id=570c9fcf9490cb7276000161
             * discussion : {"pk":"86","title":"女神转型记","stitle":"女生小天地","pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","large_pic":"http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png","api_url":"http://dis.myzaker.com/api/get_post.php?discussion_id=86","block_color":"","subscribe_count":"179892","post_count":"8553"}
             */

            private PostBean post;

            protected ListBean(Parcel in) {
                pk = in.readString();
                promotion_img = in.readString();
                img_height = in.readString();
                img_width = in.readString();
                title = in.readString();
                end_time = in.readString();
                type = in.readString();
                pop_type = in.readString();
                hide_mask = in.readString();
                ads_stat_url = in.readString();
                stat_read_url = in.readString();
                start_time = in.readString();
            }

            public static final Creator<ListBean> CREATOR = new Creator<ListBean>() {
                @Override
                public ListBean createFromParcel(Parcel in) {
                    return new ListBean(in);
                }

                @Override
                public ListBean[] newArray(int size) {
                    return new ListBean[size];
                }
            };

            public String getPk() {
                return pk;
            }

            public void setPk(String pk) {
                this.pk = pk;
            }

            public String getPromotion_img() {
                return promotion_img;
            }

            public void setPromotion_img(String promotion_img) {
                this.promotion_img = promotion_img;
            }

            public String getImg_height() {
                return img_height;
            }

            public void setImg_height(String img_height) {
                this.img_height = img_height;
            }

            public String getImg_width() {
                return img_width;
            }

            public void setImg_width(String img_width) {
                this.img_width = img_width;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPop_type() {
                return pop_type;
            }

            public void setPop_type(String pop_type) {
                this.pop_type = pop_type;
            }

            public String getHide_mask() {
                return hide_mask;
            }

            public void setHide_mask(String hide_mask) {
                this.hide_mask = hide_mask;
            }

            public String getAds_stat_url() {
                return ads_stat_url;
            }

            public void setAds_stat_url(String ads_stat_url) {
                this.ads_stat_url = ads_stat_url;
            }

            public String getStat_read_url() {
                return stat_read_url;
            }

            public void setStat_read_url(String stat_read_url) {
                this.stat_read_url = stat_read_url;
            }

            public TagInfoBean getTag_info() {
                return tag_info;
            }

            public void setTag_info(TagInfoBean tag_info) {
                this.tag_info = tag_info;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public ArticleBean getArticle() {
                return article;
            }

            public void setArticle(ArticleBean article) {
                this.article = article;
            }

            public PostBean getPost() {
                return post;
            }

            public void setPost(PostBean post) {
                this.post = post;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(pk);
                dest.writeString(promotion_img);
                dest.writeString(img_height);
                dest.writeString(img_width);
                dest.writeString(title);
                dest.writeString(end_time);
                dest.writeString(type);
                dest.writeString(pop_type);
                dest.writeString(hide_mask);
                dest.writeString(ads_stat_url);
                dest.writeString(stat_read_url);
                dest.writeString(start_time);
            }

            public static class TagInfoBean {
                private String type;
                private String text;
                private String image_url;
                private String img_height;
                private String img_width;
                private String tag_position;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }

                public String getImg_height() {
                    return img_height;
                }

                public void setImg_height(String img_height) {
                    this.img_height = img_height;
                }

                public String getImg_width() {
                    return img_width;
                }

                public void setImg_width(String img_width) {
                    this.img_width = img_width;
                }

                public String getTag_position() {
                    return tag_position;
                }

                public void setTag_position(String tag_position) {
                    this.tag_position = tag_position;
                }
            }

            public static class TopicBean {
                private String pk;
                private String title;
                private String api_url;

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

                public String getApi_url() {
                    return api_url;
                }

                public void setApi_url(String api_url) {
                    this.api_url = api_url;
                }
            }

            public static class BlockInfoBean {
                private String pk;
                private String title;
                private String api_url;

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

                public String getApi_url() {
                    return api_url;
                }

                public void setApi_url(String api_url) {
                    this.api_url = api_url;
                }
            }

            public static class ArticleBean {
                private String pk;
                private String title;
                private String app_ids;
                private String date;
                private String auther_name;
                private String weburl;
                private String is_full;
                private String content;
                private String full_url;

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
            }

            public static class PostBean {
                private String pk;
                private String discussion_id;
                /**
                 * name : 侯虹斌
                 * uid : 11415800
                 * user_flag : [{"pic":"http://zkres.myzaker.com/data/image/discussion/img/ic_official_user_flag_celebrity.png"}]
                 * icon : http://wx.qlogo.cn/mmopen/JEnzUUrDvD0VOpTjVMGniaS3eGvZzGRTfGjydODjn17KIdBUg4YEXx9eMlicpyKSb6gKMatN5EG4SWckGhf8LlXZS25I9MBDPN/0
                 */

                private AutherBean auther;
                private String title;
                private String date;
                private String comment_count;
                private String hot_num;
                private String content;
                private String weburl;
                private String content_url;
                private String comment_list_url;
                /**
                 * pk : 86
                 * title : 女神转型记
                 * stitle : 女生小天地
                 * pic : http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png
                 * large_pic : http://disres.myzaker.com/img_upload/discussion/disicon/2016/03/07/56dd3fc19490cbff7a00013f.png
                 * api_url : http://dis.myzaker.com/api/get_post.php?discussion_id=86
                 * block_color :
                 * subscribe_count : 179892
                 * post_count : 8553
                 */

                private DiscussionBean discussion;
                /**
                 * name : 活动
                 * icon : http://zkres.myzaker.com/data/image/mark2/activity_2x.png?v=20150612
                 */

                private List<PostTagBean> post_tag;
                /**
                 * type : image
                 * id : 570daf529490cb132f0000b5
                 * w : 1242
                 * h : 878
                 * url : http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h800.jpg
                 * m_url : http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h400.jpg
                 * s_url : http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h200.jpg
                 * min_url : http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg.h120.jpg
                 * raw_url : http://disres.myzaker.com/img_upload/discussion/2016/04/13/570daf529490cb132f0000b5.jpg
                 */

                private List<MediasBean> medias;

                public String getPk() {
                    return pk;
                }

                public void setPk(String pk) {
                    this.pk = pk;
                }

                public String getDiscussion_id() {
                    return discussion_id;
                }

                public void setDiscussion_id(String discussion_id) {
                    this.discussion_id = discussion_id;
                }

                public AutherBean getAuther() {
                    return auther;
                }

                public void setAuther(AutherBean auther) {
                    this.auther = auther;
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

                public String getComment_count() {
                    return comment_count;
                }

                public void setComment_count(String comment_count) {
                    this.comment_count = comment_count;
                }

                public String getHot_num() {
                    return hot_num;
                }

                public void setHot_num(String hot_num) {
                    this.hot_num = hot_num;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getWeburl() {
                    return weburl;
                }

                public void setWeburl(String weburl) {
                    this.weburl = weburl;
                }

                public String getContent_url() {
                    return content_url;
                }

                public void setContent_url(String content_url) {
                    this.content_url = content_url;
                }

                public String getComment_list_url() {
                    return comment_list_url;
                }

                public void setComment_list_url(String comment_list_url) {
                    this.comment_list_url = comment_list_url;
                }

                public DiscussionBean getDiscussion() {
                    return discussion;
                }

                public void setDiscussion(DiscussionBean discussion) {
                    this.discussion = discussion;
                }

                public List<PostTagBean> getPost_tag() {
                    return post_tag;
                }

                public void setPost_tag(List<PostTagBean> post_tag) {
                    this.post_tag = post_tag;
                }

                public List<MediasBean> getMedias() {
                    return medias;
                }

                public void setMedias(List<MediasBean> medias) {
                    this.medias = medias;
                }

                public static class AutherBean {
                    private String name;
                    private String uid;
                    private String icon;
                    /**
                     * pic : http://zkres.myzaker.com/data/image/discussion/img/ic_official_user_flag_celebrity.png
                     */

                    private List<UserFlagBean> user_flag;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUid() {
                        return uid;
                    }

                    public void setUid(String uid) {
                        this.uid = uid;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }

                    public List<UserFlagBean> getUser_flag() {
                        return user_flag;
                    }

                    public void setUser_flag(List<UserFlagBean> user_flag) {
                        this.user_flag = user_flag;
                    }

                    public static class UserFlagBean {
                        private String pic;

                        public String getPic() {
                            return pic;
                        }

                        public void setPic(String pic) {
                            this.pic = pic;
                        }
                    }
                }

                public static class DiscussionBean {
                    private String pk;
                    private String title;
                    private String stitle;
                    private String pic;
                    private String large_pic;
                    private String api_url;
                    private String block_color;
                    private String subscribe_count;
                    private String post_count;

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

                    public String getStitle() {
                        return stitle;
                    }

                    public void setStitle(String stitle) {
                        this.stitle = stitle;
                    }

                    public String getPic() {
                        return pic;
                    }

                    public void setPic(String pic) {
                        this.pic = pic;
                    }

                    public String getLarge_pic() {
                        return large_pic;
                    }

                    public void setLarge_pic(String large_pic) {
                        this.large_pic = large_pic;
                    }

                    public String getApi_url() {
                        return api_url;
                    }

                    public void setApi_url(String api_url) {
                        this.api_url = api_url;
                    }

                    public String getBlock_color() {
                        return block_color;
                    }

                    public void setBlock_color(String block_color) {
                        this.block_color = block_color;
                    }

                    public String getSubscribe_count() {
                        return subscribe_count;
                    }

                    public void setSubscribe_count(String subscribe_count) {
                        this.subscribe_count = subscribe_count;
                    }

                    public String getPost_count() {
                        return post_count;
                    }

                    public void setPost_count(String post_count) {
                        this.post_count = post_count;
                    }
                }

                public static class PostTagBean {
                    private String name;
                    private String icon;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }
                }

                public static class MediasBean {
                    private String type;
                    private String id;
                    private String w;
                    private String h;
                    private String url;
                    private String m_url;
                    private String s_url;
                    private String min_url;
                    private String raw_url;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
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

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getM_url() {
                        return m_url;
                    }

                    public void setM_url(String m_url) {
                        this.m_url = m_url;
                    }

                    public String getS_url() {
                        return s_url;
                    }

                    public void setS_url(String s_url) {
                        this.s_url = s_url;
                    }

                    public String getMin_url() {
                        return min_url;
                    }

                    public void setMin_url(String min_url) {
                        this.min_url = min_url;
                    }

                    public String getRaw_url() {
                        return raw_url;
                    }

                    public void setRaw_url(String raw_url) {
                        this.raw_url = raw_url;
                    }
                }
            }
        }
    }
}

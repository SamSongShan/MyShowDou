package com.example.a11355.myshowdou.News.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11355 on 2017/6/9.
 */

public class NewsListEntity implements Parcelable {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * postid : HLQID782050835RB
         * hasCover : false
         * hasHead : 1
         * replyCount : 1504
         * videosource : 新媒体
         * hasImg : 1
         * digest :
         * hasIcon : false
         * docid : 9IG74V5H00963VRO_CMOC2PN005179VEDupdateDoc
         * title : 本以为是酒吧艳遇，结果太悲催了
         * TAGS : 视频
         * videoTopic : {"alias":"网易原创微型搞笑短剧","tname":"轻松一刻","ename":"T1470044710290","tid":"T1470044710290","topic_icons":"http://dingyue.nosdn.127.net/fLhNMPJUZjhhZ6DWq14VmZal3aPoH7aQ2w2YAK0Fm57Ll1495707252134.png"}
         * order : 1
         * priority : 354
         * lmodify : 2017-06-12 20:56:16
         * boardid : video_bbs
         * length : 93
         * ads : [{"title":"俄罗斯民众展示巨型国旗庆\"俄罗斯日\"","skipID":"00AO0001|2260414","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/640b1b297893484098e9f96ed74706f820170612210152.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2260414"},{"title":"英穆斯林伦敦桥发玫瑰 称展现爱与团结","skipID":"00AO0001|2260400","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/0b6bbd8d4d594109b3e4ce846faef7e720170612192011.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2260400"},{"title":"\"苗柏\"即将登陆 深圳台风预警升至黄色","skipID":"00AP0001|2260397","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/c582c45f53df4b91aef803b2ac007a5020170612183636.jpeg","subtitle":"","skipType":"photoset","url":"00AP0001|2260397"},{"title":"狂风暴雨之夜 安徽一独居老人房屋被拆","skipID":"00AP0001|2260394","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/733cc22dcf254461a7a8ed17470946b920170612181120.jpeg","subtitle":"","skipType":"photoset","url":"00AP0001|2260394"},{"title":"探访叙利亚装甲车维修厂 场面壮观","skipID":"00AO0001|2260396","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/db2226bc724d436f91d2a0f7a80b9fb420170612181928.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2260396"}]
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
         * template : normal1
         * votecount : 1327
         * skipID : VHLQID782
         * alias : Top News
         * skipType : video
         * cid : C1348646712614
         * hasAD : 1
         * source : 轻松一刻
         * videoID : VHLQID782
         * ename : androidnews
         * tname : 头条
         * imgsrc : http://cms-bucket.nosdn.127.net/2be19849dcb5435982afb18dc6b7941720170612205534.jpeg
         * ptime : 2017-06-12 20:45:56
         * url_3w : http://news.163.com/17/0612/16/CMO9NP7G00018AOQ.html
         * ltitle : 习近平批准军队新设立"八一勋章" 为军队最高荣誉
         * url : http://3g.163.com/news/17/0612/16/CMO9NP7G00018AOQ.html
         * subtitle :
         * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/f05bae46e3494f5481fc9e0d982f1c3e20170612144438.png"},{"imgsrc":"http://cms-bucket.nosdn.127.net/0d386a9628b64d9b973f22d7d933d5eb20170612144438.png"}]
         */

        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private String videosource;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private String TAGS;
        private VideoTopicBean videoTopic;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private int length;
        private String topic_background;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private String videoID;
        private String ename;
        private String tname;
        private String imgsrc;
        private String ptime;
        private String url_3w;
        private String ltitle;
        private String url;
        private String subtitle;
        private List<AdsBean> ads;
        private List<ImgextraBean> imgextra;

        private int type;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public DataBean(int type) {
            this.type = type;
        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getVideosource() {
            return videosource;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTAGS() {
            return TAGS;
        }

        public void setTAGS(String TAGS) {
            this.TAGS = TAGS;
        }

        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getVideoID() {
            return videoID;
        }

        public void setVideoID(String videoID) {
            this.videoID = videoID;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class VideoTopicBean implements Parcelable {
            /**
             * alias : 网易原创微型搞笑短剧
             * tname : 轻松一刻
             * ename : T1470044710290
             * tid : T1470044710290
             * topic_icons : http://dingyue.nosdn.127.net/fLhNMPJUZjhhZ6DWq14VmZal3aPoH7aQ2w2YAK0Fm57Ll1495707252134.png
             */

            private String alias;
            private String tname;
            private String ename;
            private String tid;
            private String topic_icons;

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTopic_icons() {
                return topic_icons;
            }

            public void setTopic_icons(String topic_icons) {
                this.topic_icons = topic_icons;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.alias);
                dest.writeString(this.tname);
                dest.writeString(this.ename);
                dest.writeString(this.tid);
                dest.writeString(this.topic_icons);
            }

            public VideoTopicBean() {
            }

            protected VideoTopicBean(Parcel in) {
                this.alias = in.readString();
                this.tname = in.readString();
                this.ename = in.readString();
                this.tid = in.readString();
                this.topic_icons = in.readString();
            }

            public static final Creator<VideoTopicBean> CREATOR = new Creator<VideoTopicBean>() {
                @Override
                public VideoTopicBean createFromParcel(Parcel source) {
                    return new VideoTopicBean(source);
                }

                @Override
                public VideoTopicBean[] newArray(int size) {
                    return new VideoTopicBean[size];
                }
            };
        }

        public static class AdsBean implements Parcelable {
            /**
             * title : 俄罗斯民众展示巨型国旗庆"俄罗斯日"
             * skipID : 00AO0001|2260414
             * tag : photoset
             * imgsrc : http://cms-bucket.nosdn.127.net/640b1b297893484098e9f96ed74706f820170612210152.jpeg
             * subtitle :
             * skipType : photoset
             * url : 00AO0001|2260414
             */

            private String title;
            private String skipID;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String skipType;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSkipID() {
                return skipID;
            }

            public void setSkipID(String skipID) {
                this.skipID = skipID;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getSkipType() {
                return skipType;
            }

            public void setSkipType(String skipType) {
                this.skipType = skipType;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.title);
                dest.writeString(this.skipID);
                dest.writeString(this.tag);
                dest.writeString(this.imgsrc);
                dest.writeString(this.subtitle);
                dest.writeString(this.skipType);
                dest.writeString(this.url);
            }

            public AdsBean() {
            }

            protected AdsBean(Parcel in) {
                this.title = in.readString();
                this.skipID = in.readString();
                this.tag = in.readString();
                this.imgsrc = in.readString();
                this.subtitle = in.readString();
                this.skipType = in.readString();
                this.url = in.readString();
            }

            public static final Creator<AdsBean> CREATOR = new Creator<AdsBean>() {
                @Override
                public AdsBean createFromParcel(Parcel source) {
                    return new AdsBean(source);
                }

                @Override
                public AdsBean[] newArray(int size) {
                    return new AdsBean[size];
                }
            };
        }

        public static class ImgextraBean implements Parcelable {
            /**
             * imgsrc : http://cms-bucket.nosdn.127.net/f05bae46e3494f5481fc9e0d982f1c3e20170612144438.png
             */

            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.imgsrc);
            }

            public ImgextraBean() {
            }

            protected ImgextraBean(Parcel in) {
                this.imgsrc = in.readString();
            }

            public static final Creator<ImgextraBean> CREATOR = new Creator<ImgextraBean>() {
                @Override
                public ImgextraBean createFromParcel(Parcel source) {
                    return new ImgextraBean(source);
                }

                @Override
                public ImgextraBean[] newArray(int size) {
                    return new ImgextraBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.postid);
            dest.writeByte(this.hasCover ? (byte) 1 : (byte) 0);
            dest.writeInt(this.hasHead);
            dest.writeInt(this.replyCount);
            dest.writeString(this.videosource);
            dest.writeInt(this.hasImg);
            dest.writeString(this.digest);
            dest.writeByte(this.hasIcon ? (byte) 1 : (byte) 0);
            dest.writeString(this.docid);
            dest.writeString(this.title);
            dest.writeString(this.TAGS);
            dest.writeParcelable(this.videoTopic, flags);
            dest.writeInt(this.order);
            dest.writeInt(this.priority);
            dest.writeString(this.lmodify);
            dest.writeString(this.boardid);
            dest.writeInt(this.length);
            dest.writeString(this.topic_background);
            dest.writeString(this.template);
            dest.writeInt(this.votecount);
            dest.writeString(this.skipID);
            dest.writeString(this.alias);
            dest.writeString(this.skipType);
            dest.writeString(this.cid);
            dest.writeInt(this.hasAD);
            dest.writeString(this.source);
            dest.writeString(this.videoID);
            dest.writeString(this.ename);
            dest.writeString(this.tname);
            dest.writeString(this.imgsrc);
            dest.writeString(this.ptime);
            dest.writeString(this.url_3w);
            dest.writeString(this.ltitle);
            dest.writeString(this.url);
            dest.writeString(this.subtitle);
            dest.writeList(this.ads);
            dest.writeList(this.imgextra);
            dest.writeInt(this.type);
        }

        protected DataBean(Parcel in) {
            this.postid = in.readString();
            this.hasCover = in.readByte() != 0;
            this.hasHead = in.readInt();
            this.replyCount = in.readInt();
            this.videosource = in.readString();
            this.hasImg = in.readInt();
            this.digest = in.readString();
            this.hasIcon = in.readByte() != 0;
            this.docid = in.readString();
            this.title = in.readString();
            this.TAGS = in.readString();
            this.videoTopic = in.readParcelable(VideoTopicBean.class.getClassLoader());
            this.order = in.readInt();
            this.priority = in.readInt();
            this.lmodify = in.readString();
            this.boardid = in.readString();
            this.length = in.readInt();
            this.topic_background = in.readString();
            this.template = in.readString();
            this.votecount = in.readInt();
            this.skipID = in.readString();
            this.alias = in.readString();
            this.skipType = in.readString();
            this.cid = in.readString();
            this.hasAD = in.readInt();
            this.source = in.readString();
            this.videoID = in.readString();
            this.ename = in.readString();
            this.tname = in.readString();
            this.imgsrc = in.readString();
            this.ptime = in.readString();
            this.url_3w = in.readString();
            this.ltitle = in.readString();
            this.url = in.readString();
            this.subtitle = in.readString();
            this.ads = new ArrayList<AdsBean>();
            in.readList(this.ads, AdsBean.class.getClassLoader());
            this.imgextra = new ArrayList<ImgextraBean>();
            in.readList(this.imgextra, ImgextraBean.class.getClassLoader());
            this.type = in.readInt();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.data);
    }

    public NewsListEntity() {
    }

    protected NewsListEntity(Parcel in) {
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<NewsListEntity> CREATOR = new Parcelable.Creator<NewsListEntity>() {
        @Override
        public NewsListEntity createFromParcel(Parcel source) {
            return new NewsListEntity(source);
        }

        @Override
        public NewsListEntity[] newArray(int size) {
            return new NewsListEntity[size];
        }
    };
}

package com.example.a11355.myshowdou.Knowledges;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11355 on 2017/7/6.
 */

public class KnowlegesEntity implements Parcelable {


    /**
     * error : false
     * results : [{"_id":"595b6634421aa90ca3bb6a9c","createdAt":"2017-07-04T17:56:04.67Z","desc":"用编译时注解生成代理类来管理Retrofit Call的生命周期","publishedAt":"2017-07-05T11:15:30.556Z","source":"web","type":"Android","url":"https://github.com/luckyandyzhang/RetrofitLifecycle","used":true,"who":"Andy Zhang"},{"_id":"595c3db1421aa90ca209c3f1","createdAt":"2017-07-05T09:15:29.322Z","desc":"使用TabLayout看这篇就够了","publishedAt":"2017-07-05T11:15:30.556Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247485476&idx=1&sn=f6d28e484e574fc9196f1aece5017827&chksm=96cda969a1ba207f99a37ae36c76c32cf7d276382be7bb58949187a3596be202407506bfb066#rd","used":true,"who":"陈宇明"},{"_id":"595c4fa3421aa90c9203d32b","createdAt":"2017-07-05T10:32:03.638Z","desc":"重新理解响应式编程","images":["http://img.gank.io/894e2a22-f76b-4550-a476-54f14f0cb1cb"],"publishedAt":"2017-07-05T11:15:30.556Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/c95e29854cb1","used":true,"who":"ladingwu"},{"_id":"595ad074421aa90ca3bb6a90","createdAt":"2017-07-04T07:17:08.609Z","desc":"Android 有两套相机 Api，使用起来很麻烦，好在 Foto 开源了他们在 Android 上的 Camera 封装 Api，力荐！","images":["http://img.gank.io/0a15bae7-c513-4feb-bbe2-1273b8b809ce"],"publishedAt":"2017-07-04T11:50:36.484Z","source":"chrome","type":"Android","url":"https://github.com/Fotoapparat/Fotoapparat","used":true,"who":"代码家"},{"_id":"595ad096421aa90cb4724b5b","createdAt":"2017-07-04T07:17:42.635Z","desc":"MD 风格的日历组件，很精致哦。","images":["http://img.gank.io/75a6251f-ffaf-41dc-8dbc-fa58802b0d8e"],"publishedAt":"2017-07-04T11:50:36.484Z","source":"chrome","type":"Android","url":"https://github.com/Applandeo/Material-Calendar-View","used":true,"who":"代码家"},{"_id":"595ad0d4421aa90cb4724b5c","createdAt":"2017-07-04T07:18:44.154Z","desc":"非常 Fancy 的选项过滤器。","images":["http://img.gank.io/f9e1e0ef-88fc-4e02-8620-2cf1700966c5"],"publishedAt":"2017-07-04T11:50:36.484Z","source":"chrome","type":"Android","url":"https://github.com/Krupen/FabulousFilter","used":true,"who":"代码家"},{"_id":"595aec75421aa90c9203d31c","createdAt":"2017-07-04T09:16:37.902Z","desc":"Android单元测试框架Robolectric3.0(二)：数据篇","publishedAt":"2017-07-04T11:50:36.484Z","source":"web","type":"Android","url":"http://url.cn/4BHx7ZG","used":true,"who":"陈宇明"},{"_id":"595b0bed421aa90ca3bb6a98","createdAt":"2017-07-04T11:30:53.793Z","desc":"前端每周清单第 20 期：React 组件解耦之道；基于Headless Chrome的自动化测试；Angular 2/4是否为时已晚？","publishedAt":"2017-07-04T11:50:36.484Z","source":"chrome","type":"Android","url":"https://zhuanlan.zhihu.com/p/27684971","used":true,"who":"王下邀月熊"},{"_id":"595b0f5a421aa90cb4724b60","createdAt":"2017-07-04T11:45:30.184Z","desc":"Android App Performance Optimization","publishedAt":"2017-07-04T11:50:36.484Z","source":"web","type":"Android","url":"https://blog.mindorks.com/android-app-performance-optimization-cdccb422e38e","used":true,"who":"AMIT SHEKHAR"},{"_id":"593f2091421aa92c769a8c6a","createdAt":"2017-06-13T07:15:29.423Z","desc":"Android之自定义View：侧滑删除","publishedAt":"2017-06-15T13:55:57.947Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247484934&idx=1&sn=f2a40261efe8ebee45804e9df93c1cce&chksm=96cda74ba1ba2e5dbbac15a9e57b5329176d1fe43478e5c63f7bc502a6ca50e4dfa6c0a9041e#rd","used":true,"who":"陈宇明"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Parcelable {
        /**
         * _id : 595b6634421aa90ca3bb6a9c
         * createdAt : 2017-07-04T17:56:04.67Z
         * desc : 用编译时注解生成代理类来管理Retrofit Call的生命周期
         * publishedAt : 2017-07-05T11:15:30.556Z
         * source : web
         * type : Android
         * url : https://github.com/luckyandyzhang/RetrofitLifecycle
         * used : true
         * who : Andy Zhang
         * images : ["http://img.gank.io/894e2a22-f76b-4550-a476-54f14f0cb1cb"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        private int myType;

        public ResultsBean(int myType) {
            this.myType = myType;
        }

        public int getMyType() {
            return myType;
        }

        public void setMyType(int myType) {
            this.myType = myType;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

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

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this._id);
            dest.writeString(this.createdAt);
            dest.writeString(this.desc);
            dest.writeString(this.publishedAt);
            dest.writeString(this.source);
            dest.writeString(this.type);
            dest.writeString(this.url);
            dest.writeByte(this.used ? (byte) 1 : (byte) 0);
            dest.writeString(this.who);
            dest.writeStringList(this.images);
        }

        public ResultsBean() {
        }

        protected ResultsBean(Parcel in) {
            this._id = in.readString();
            this.createdAt = in.readString();
            this.desc = in.readString();
            this.publishedAt = in.readString();
            this.source = in.readString();
            this.type = in.readString();
            this.url = in.readString();
            this.used = in.readByte() != 0;
            this.who = in.readString();
            this.images = in.createStringArrayList();
        }

        public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
            @Override
            public ResultsBean createFromParcel(Parcel source) {
                return new ResultsBean(source);
            }

            @Override
            public ResultsBean[] newArray(int size) {
                return new ResultsBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.error ? (byte) 1 : (byte) 0);
        dest.writeList(this.results);
    }

    public KnowlegesEntity() {
    }

    protected KnowlegesEntity(Parcel in) {
        this.error = in.readByte() != 0;
        this.results = new ArrayList<ResultsBean>();
        in.readList(this.results, ResultsBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<KnowlegesEntity> CREATOR = new Parcelable.Creator<KnowlegesEntity>() {
        @Override
        public KnowlegesEntity createFromParcel(Parcel source) {
            return new KnowlegesEntity(source);
        }

        @Override
        public KnowlegesEntity[] newArray(int size) {
            return new KnowlegesEntity[size];
        }
    };
}

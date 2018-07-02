package com.example.a11355.myshowdou.Utils;

/**
 * 常量
 */
public interface Constant {

    interface URL {
        String BaseUrl = "http://c.m.163.com/";
        String BaseImg = "http://c.m.163.com/";

        public static final String TOP_URL = BaseUrl + "nc/article/headline/";
        // 头条
        public static final String TOP_ID = "T1348647909107";
        // nba
        public static final String NBA_ID = "T1348649145984";
        // 汽车
        public static final String CAR_ID = "T1348654060988";
        // 笑话
        public static final String JOKE_ID = "T1350383429665";
        public static final String END_URL = "/%d-%d.html";

        // http://c.m.163.com/nc/article/CN2D57LK000181BT/full.html//详情页

        public static final String NEW_DETAIL = BaseUrl + "nc/article/%s/full.html";

        //http://c.m.163.com/nc/video/list/V9LG4B3A0/n/0-10.html 视频

        //视频
        public static final String Videos = BaseUrl + "nc/video/list/%s/n/%d-10.html";

        //http://gank.io/api/search/query/listview/category/%E7%A6%8F%E5%88%A9/count/10/page/7  图片
       //图片
        public static final String Photo = "http://gank.io/api/data/福利/10/%d";
       // http://gank.io/api/data/Android/10/1
        //技术
       public static final String Knowleges = "http://gank.io/api/data/Android/10/%d";


    }

    interface Strings {
        String[] NewsDetailTitle = {"头条", "NBA", "汽车", "笑话"};
        String[] NewsDetailTitleUrl = {
                "T1348647909107",//头条
                "T1348649145984",//nba
                "T1348654060988",//汽车
                "T1350383429665"//笑话
        };
        String[] VideoDetailTitleUrl = {
                "V9LG4B3A0",//热点视频
                "V9LG4CHOR",//娱乐视频
                "V9LG4E6VR",//搞笑视频
                "00850FRB"//精品视频
        };

        //手机号正则
        String RegexMobile = "^1(3[0-9]|4[5,7]|5[0-9]|7[0-9]|8[0-9])\\d{8}$";
        //邮箱正则
        String RegexEmail = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        //身份证正则
        String RegexIdNum = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";


        //权限提醒
        String PermissionFileTips = "本应用保存数据时被系统拒绝，请手动授权。\n" +
                "授权方式：点击设置按钮进入应用设置页面，选择权限(或权限管理)->存储空间\n请选择允许";
        //权限提醒
        String PermissionCameraTips = "本应用未获取到拍照权限，请手动授权。\n" +
                "授权方式：点击设置按钮进入应用设置页面，选择权限(或权限管理)->相机\n请选择允许";

        // " 号错误提示
        String ErrorTips1 = "不可包含 \" 号";
        // \ 号错误提示
        String ErrorTips2 = "不可包含 \\ 号";
        // | 号错误提示
        String ErrorTips3 = "不可包含 | 号";
        // _ 号错误提示
        String ErrorTips4 = "不可包含 _ 号";
    }

    interface Integers {
        //操作成功
        int SUC = 200;
        //操作失败
        int FAIL = 300;
        //数据为空
        int NULL = 400;
        //数据异常
        int ABNORMAL = 500;

        //短信验证码重试秒数
        int CodeRetryTime = 120;
        //用户编号基底
        long BaseUserCode = 10000000;
        //中奖号码基底
        long BaseLuckyCode = 10000001;
        //验证码失效时间 --130秒
        long CodeInvalidTime = 130 * 1000;
        //加入购物车动画时长
        long CartAnimDuration = 1500;
        //输入框较长的长度限制
        int EditLengthLong = 140;
        //输入框一般的长度限制
        int EditLengthMiddle = 60;
        //输入框较短的长度限制
        int EditLengthShort = 20;
    }

    interface ID {

    }

    interface Code {
        //打开相册请求码
        int AlbumCode = 0x0001;
        //拍照请求码
        int CameraCode = 0x0002;
        //修改昵称请求码
        int UpdateAliasCode = 0x0003;
        //修改出生年月请求码
        int UpdateBirthdayCode = 0x0004;
        //修改现居地请求码
        int UpdateBirthplaceCode = 0x0005;
        //修改手机请求码
        int UpdateMobileCode = 0x0006;
        //修改邮箱请求码
        int UpdateEmailCode = 0x0007;
        //修改详细地址请求码
        int UpdateAddressCode = 0x0008;
        //提现密码
        int WithdrawPwdCode = 0x000A;
        //打款申请
        int BusinessCode = 0x000B;
        //上传门面照片
        int UploadStoreCode = 0x000C;
        //上传营业执照
        int UploadAuthCode = 0x000D;
        //上传身份证正反面
        int UploadIdCode = 0x000E;
        //上传业务员合照
        int UploadClerkCode = 0x000F;
        //上传税务证
        int UploadTaxCode = 0x0010;
        //上传承诺书
        int UploadLetterCode = 0x0011;

        int PermissionCode = 0x1001;
        int PermissionStorageCode = 0x1002;
        int PermissionCameraCode = 0x1003;

        //登录跳转注册请求码
        int RegisterCode = 0x2001;
        //进入登录页请求码
        int IntoLoginCode = 0x2002;
        //进入认证
        int IntoCertifyCode = 0x2003;

        int EditCode = 0x3001;
        int AddCode = 0x3002;
    }
}

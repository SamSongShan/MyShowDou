package com.example.a11355.myshowdou;

import cn.bmob.v3.BmobObject;

/**
 * Created by 11355 on 2017/5/14.
 */

public class VersionController extends BmobObject {

    private String versionNum;
    private String downloadUrl;
    private String description;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }
}

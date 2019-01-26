package com.eostoken.opensdk.kylin.model;

import com.google.gson.annotations.SerializedName;

public class KylinResult {

    //消息
    private String message;

    //状态码，0表示成功
    private int code;

    //协议的路径
    private String path;

    @SerializedName("platformid")
    private String platformId;

    private String authorization;

    public KylinResult() {

    }

    public KylinResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
}

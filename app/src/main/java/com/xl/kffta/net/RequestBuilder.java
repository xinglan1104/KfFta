package com.xl.kffta.net;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;


/**
 * 请求的基类 后续请求都通过这个方法来发送
 */
public class RequestBuilder {

    private static final String TAG = "RequestBuilder";

    private Context mContent;

    private ResponseCallback mCallback;
    private HashMap<String, String> mParams = new HashMap<>();

    public RequestBuilder() {

    }

    public ResponseCallback getCallback() {
        return mCallback;
    }

    /**
     * 默认为后台请求
     */
    private boolean mIsBg = true;
    private String url = "";
    private String header = "";
    private String headerName = "";

    /**
     * 超时时间
     */
    private int mTimeOutLength = 1000;

    /**
     * 构造参数 每个请求都需要context，action
     *
     * @param context
     */
    public RequestBuilder(Context context) {
        mContent = context;
    }

    public void setCallback(ResponseCallback mCallback) {
        this.mCallback = mCallback;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 是否为后台请求，默认为后台请求。
     * 如果不是后台请求 会显示请求的进度条
     *
     * @param isBg
     * @return
     */
    public RequestBuilder setIsBg(boolean isBg) {
        mIsBg = isBg;
        return this;
    }

    /**
     * 设置请求的超时时间 现在仅同步请求有效
     *
     * @param timeOut
     * @return
     */
    public RequestBuilder setTimeOut(int timeOut) {
        mTimeOutLength = timeOut;
        return this;
    }

    public RequestBuilder addParams(Map<String, String> params) {
        this.mParams = (HashMap<String, String>) params;
        return this;
    }

    public HashMap<String, String> getParams() {
        return mParams;
    }

    /**
     * 发送异步请求
     *
     * @param callback 请求的回调
     */
    public void sendRequest(final ResponseCallback callback) {

        //请求的发送操作
        NetManager.Companion.getManager().sendRequest(this);
    }
}

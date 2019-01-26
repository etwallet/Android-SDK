package com.eostoken.opensdk.simple;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import com.eostoken.opensdk.Constant;
import com.eostoken.opensdk.ETUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class ETManager {

    private static ETManager sInstance;

    private ETListener mListener;
    //回调的状态
    private final static int SUCCESS = 1;
    private final static int CANCEL = 0;
    private final static int ERROR = 2;
    //ET uri
    private final static String ET_SCHEME_HOST = "et_sdk://et.pull";
    private final static String SIMPLEWALLET_SCHEME_HOST = "simplewallet://eos.io";

    private ETManager() {
    }

    public static ETManager getInstance() {
        if (sInstance == null) {
            synchronized (ETManager.class) {
                if (sInstance == null) {
                    sInstance = new ETManager();
                }
            }
        }
        return sInstance;
    }

    private void setETListener(ETListener listener) {
        this.mListener = listener;
    }

    /**
     * 执行操作
     */
    private void doAction(Context context, String param, ETListener listener) {
        //设置监听器
        setETListener(listener);
        pullUpET(context, param);
    }

    /**
     * 转账
     */
    public void transfer(Context context, String transferData) {
        transfer(context, transferData, null);
    }

    /**
     * 转账
     */
    public void transfer(Context context, String transferData, ETListener listener) {
        doAction(context, transferData, listener);
    }

    /**
     * 提交交易
     */
    public void pushTransaction(Context context, String transactionData) {
        pushTransaction(context, transactionData, null);
    }

    /**
     * 提交交易
     */
    public void pushTransaction(Context context, String transactionData, ETListener listener) {
        doAction(context, transactionData, listener);
    }

    /**
     * 授权登陆
     */
    public void authLogin(Context context, String authData) {
        authLogin(context, authData, null);
    }

    /**
     * 授权登陆
     */
    public void authLogin(Context context, String authData, ETListener listener) {
        doAction(context, authData, listener);
    }

    /**
     * 签名
     */
    public void sign(Context context, String messageToSign) {
        sign(context, messageToSign, null);
    }

    /**
     * 签名
     */
    public void sign(Context context, String messageToSign, ETListener listener) {
        doAction(context, messageToSign, listener);
    }

    /**
     * 解析数据，并回调
     */
    public void parseIntent(Intent intent) {
        if (mListener == null) {
            return;
        }

        int status = intent.getIntExtra("status", 0);
        String result = intent.getStringExtra("result");
        if (result == null) {
            mListener.onError("Unknown error");
            return;
        }

        switch (status) {
            case ERROR:
                mListener.onError(result);
                break;
            case CANCEL:
                mListener.onCancel(result);
                break;
            case SUCCESS:
            default:
                mListener.onSuccess(result);
                break;
        }
    }

    /**
     * 拉起ET
     */
    private void pullUpET(Context context, String param) {
        Intent intent = new Intent();
        //传递包名、类名、app名
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("className", ETAssistActivity.class.getName());
        intent.putExtra("appName", ETUtil.getAppName(context));
        intent.putExtra("time", String.valueOf(System.currentTimeMillis()));

        //拼凑uri
        intent.setData(getParamUri(param));
        intent.setAction(Intent.ACTION_VIEW);
        //保证新启动的APP有单独的堆栈，如果希望新启动的APP和原有APP使用同一个堆栈则去掉该项
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            if (mListener != null) {
                mListener.onCancel("Please install ET or upgrade to at least 3.1.4 versions");
            }
        }
    }

    /**
     * 获取uri
     */
    private Uri getParamUri(String param) {
        //将param encode处理
        try {
            param = URLEncoder.encode(param, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String temp = ET_SCHEME_HOST + "?param=" + param;
        return Uri.parse(temp);
    }

}

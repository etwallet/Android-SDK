package com.eostoken.opensdk.simple;

public interface ETListener {

    void onSuccess(String data);

    void onError(String data);

    void onCancel(String data);
}

package com.eostoken.opensdk.kylin;

import com.eostoken.opensdk.kylin.model.KylinResult;

import java.util.Map;

public interface KylinCallback {

    /**
     * @param params 不同接口传递其他额外参数
     * @param result 每个接口都会有的result
     */
    void callback(Map<String, Object> params, KylinResult result);
}

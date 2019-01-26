package com.eostoken.opensdk.kylin;

import android.app.Activity;
import android.os.Bundle;

public class KylinAssistActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在回调的activity处理逻辑
        KylinManager.getInstance().parseIntent(getIntent());
        this.finish();
    }

}

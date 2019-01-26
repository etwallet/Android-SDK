package com.eostoken.opensdk.simple;

import android.app.Activity;
import android.os.Bundle;

public class ETAssistActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在回调的activity处理逻辑
        ETManager.getInstance().parseIntent(getIntent());
        this.finish();
    }

}

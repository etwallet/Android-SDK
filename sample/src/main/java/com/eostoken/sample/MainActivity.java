package com.eostoken.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.eostoken.opensdk.simple.ETListener;
import com.eostoken.opensdk.simple.ETManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //transfer
        findViewById(R.id.tv_transfer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ETManager.getInstance().transfer(MainActivity.this, getTransferData(), new ETListener() {
                    @Override
                    public void onSuccess(String data) {
                        System.out.println("onSuccess-----------"+data);
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //pushTransaction
        findViewById(R.id.tv_push_transaction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ETManager.getInstance().pushTransaction(MainActivity.this, getPushTransactionData(), new ETListener() {
                    @Override
                    public void onSuccess(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //authLogin
        findViewById(R.id.tv_auth_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ETManager.getInstance().authLogin(MainActivity.this, getAuthLoginData(), new ETListener() {
                    @Override
                    public void onSuccess(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //sign
        findViewById(R.id.tv_sign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ETManager.getInstance().sign(MainActivity.this, getSignData(), new ETListener() {
                    @Override
                    public void onSuccess(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /**
     * 按照协议构建json 字符串
     */
    private String getTransferData() {
        return "{" +
                "\"protocol\": \"SimpleWallet\"," +
                "\"version\": \"1.0\"," +
                "\"dappName\": \"Newdex\"," +
                "\"dappIcon\": \"https://ndi.340wan.com/i.png\"," +
                "\"action\": \"transfer\"," +
                "\"from\": \"eostokenapp1\"," +
                "\"to\": \"eostokenapp2\"," +
                "\"amount\": 0.0001," +
                "\"contract\": \"eosio.token\"," +
                "\"symbol\": \"EOS\"," +
                "\"precision\": 4," +
                "\"dappData\": \"{\\\"type\\\":\\\"buy-limit\\\",\\\"symbol\\\":\\\"betdicetoken-dice-eos\\\",\\\"price\\\":\\\"0.00220\\\",\\\"count\\\":50,\\\"amount\\\":0.11,\\\"channel\\\":\\\"web\\\",\\\"ref\\\":\\\"eostoken\\\"}\"," +
                "\"desc\": \"\"," +
                "\"expired\": 1535944144181" +
//                "\"callback\": \"https://newdex.io/api/account/transferCallback?uuid=1-46e023fc-015b-4b76-3809-1cab3fd76d2c\"" +
                "}";
//        return "{" +
//                "\"protocol\": \"SimpleWallet\"," +
//                "\"version\": \"1.0\"," +
//                "\"dappName\": \"Newdex\"," +
//                "\"dappIcon\": \"https://ndi.340wan.com/i.png\"," +
//                "\"action\": \"transfer\"," +
//                "\"from\": \"eostokenapp1\"," +
//                "\"to\": \"newdexpocket\"," +
//                "\"amount\": 0.1," +
//                "\"contract\": \"eosio.token\"," +
//                "\"symbol\": \"EOS\"," +
//                "\"precision\": 4," +
//                "\"dappData\": \"{\\\"type\\\":\\\"buy-limit\\\",\\\"symbol\\\":\\\"betdicetoken-dice-eos\\\",\\\"price\\\":\\\"0.00220\\\",\\\"count\\\":50,\\\"amount\\\":0.11,\\\"channel\\\":\\\"web\\\",\\\"ref\\\":\\\"eostoken\\\"}\"," +
//                "\"desc\": \"\"," +
//                "\"expired\": 1535944144181," +
//                "\"callback\": \"https://newdex.io/api/account/transferCallback?uuid=1-46e023fc-015b-4b76-3809-1cab3fd76d2c\"" +
//                "}";
    }

    private String getPushTransactionData() {
        return "{\n" +
                "\"protocol\": \"SimpleWallet\",\n" +
                "\"dappName\": \"test\",\n" +
                "\"dappIcon\": \"https://newdex.io/static/logoicon.png\",\n" +
                "\"action\": \"pushTransaction\",\n" +
                "\"actions\": [{\n" +
                "\"account\": \"eosio.token\",\n" +
                "\"name\": \"transfer\",\n" +
                "\"authorization\": [{\n" +
                "\"actor\": \"eostokenapp1\",\n" +
                "\"permission\": \"active\"\n" +
                "}],\n" +
                "\"data\": {\n" +
                "\"from\": \"eostokenapp1\",\n" +
                "\"to\": \"eostokenapp2\",\n" +
                "\"quantity\": \"0.0001 EOS\",\n" +
                "\"memo\": \"sdk test\"\n" +
                "}\n" +
                "}," +
                "{\n" +
                "\"account\": \"eosio.token\",\n" +
                "\"name\": \"transfer\",\n" +
                "\"authorization\": [{\n" +
                "\"actor\": \"eostokenapp1\",\n" +
                "\"permission\": \"active\"\n" +
                "}],\n" +
                "\"data\": {\n" +
                "\"from\": \"eostokenapp1\",\n" +
                "\"to\": \"eostokenapp3\",\n" +
                "\"quantity\": \"0.0001 EOS\",\n" +
                "\"memo\": \"sdk test\"\n" +
                "}\n" +
                "},\n" +
                "{\n" +
                "\"account\": \"eosio.token\",\n" +
                "\"name\": \"transfer\",\n" +
                "\"authorization\": [{\n" +
                "\"actor\": \"eostokenapp1\",\n" +
                "\"permission\": \"active\"\n" +
                "}],\n" +
                "\"data\": {\n" +
                "\"from\": \"eostokenapp1\",\n" +
                "\"to\": \"eostokenapp3\",\n" +
                "\"quantity\": \"0.0001 EOS\",\n" +
                "\"memo\": \"sdk test\"\n" +
                "}\n" +
                "}],\n" +
                "\"expired\": \"10000000000000\"\n" +
                "}";
    }

    private String getAuthLoginData() {
        return "{" +
                "\"protocol\": \"SimpleWallet\"," +
                "\"version\": \"1.0\"," +
                "\"dappName\": \"Newdex\"," +
                "\"dappIcon\": \"https://newdex.io/static/logoicon.png\"," +
                "\"action\": \"login\"," +
                "\"uuID\": \"web-Dlb3d5qy\"," +
                "\"loginUrl\": \"https://newdex.io/api/wv\"," +
//                " \"actionId\": \"web-99784c28-70f0-49ff-3654-f27b137b3502\",\n" +
//                " \"callbackUrl\": \"https://newdex.io/api/account/walletVerify\",\n" +
                "\"expired\": 8050186," +
                "\"loginmemo\": \"The first gobal decentralized exchange built on EOS\"" +
                "}";
    }

    private String getSignData() {
        return "{\n" +
                "   \"protocol\": \"SimpleWallet\",\n" +
                "    \"version\": \"1.0\",\n" +
                "    \"dappName\": \"Newdex\",\n" +
                "    \"dappIcon\": \"https://newdex.io/static/logoicon.png\",\n" +
                "    \"action\": \"sign\",\n" +
                "    \"actionId\": \"web-99784c28-70f0-49ff-3654-f27b137b3502\",\n" +
                "    \"callbackUrl\": \"https://newdex.io/api/account/walletVerify\",\n" +
                "    \"expired\": 1537157808,\n" +
                "    \"memo\": \"The first gobal decentralized exchange built on EOS\",\n" +
                "    \"message\":\"hello\"\n" +
                "}";
    }

}

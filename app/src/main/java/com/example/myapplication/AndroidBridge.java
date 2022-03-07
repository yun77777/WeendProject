package com.example.myapplication;

import android.app.Activity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import java.util.HashMap;

import kr.co.bootpay.Bootpay;


public class AndroidBridge {
    WebView webview;
    Activity activity;

    public AndroidBridge(WebView webview, Activity activity) {
        this.webview = webview;
        this.activity = activity;
    }

    @JavascriptInterface
    public void getAccessToken( final String msg ){
        Log.d("getAccessToken: ", msg);
//        BootpayApi api = new BootpayApi(
//                "[ REST용 Application ID ]",
//                "[ Project의 Private Key ( 보안 문제상 예제에 표기하지 않습니다. 부트페이 관리자에서 확인해주세요. ) ]"
//        );

//        BootpayExample be = new BootpayExample();
//        Bootpay bootpay = new Bootpay();
//        BootpayTest bootpay = new BootpayTest("5b8f6a4d396fa665fdc2b5ea", "rm6EYECr6aroQVG2ntW0A6LpWnkTgP4uQ3H18sDDUYw=");

        BootpayTest bootpay = new BootpayTest("6210d6f52701800021f66a29", "Q3ZLL5kAYzURPEmm0qIeY2NqRSaCnlRGIyB0kTmTiAQ=");
//        bootpay.getAccessToken();
//        bootpay.goGetToken();

        try {
            ResDefault<HashMap<String, Object>> res = bootpay.getAccessToken();
            System.out.println("@@@ getAccessToken: "+res.toJson());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        webview.post(new Runnable() {
//            @Override
//            public void run() {
//                webview.loadUrl("javascript:alert('"+msg+"')");
//            }
//        });



    }


    @JavascriptInterface
    public void refundTest( final String msg ){
//        webview.post(new Runnable() {
//            @Override
//            public void run() {
//                webview.loadUrl("javascript:alert('"+msg+"')");
//            }
//        });



    }


}

package com.example.myapplication;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;


public class AndroidBridge {
    WebView webview;
    Activity activity;

    public AndroidBridge(WebView webview, Activity activity) {
        this.webview = webview;
        this.activity = activity;
    }

    @JavascriptInterface
    public void getAccessToken( final String msg ){
//        BootpayApi api = new BootpayApi(
//                "[ REST용 Application ID ]",
//                "[ Project의 Private Key ( 보안 문제상 예제에 표기하지 않습니다. 부트페이 관리자에서 확인해주세요. ) ]"
//        );

        BootpayExample be = new BootpayExample();
        BootpayExample.goGetToken();
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

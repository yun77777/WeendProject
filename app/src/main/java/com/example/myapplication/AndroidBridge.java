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
    BootpayTest bootpay;

    public AndroidBridge(WebView webview, Activity activity) {
        this.webview = webview;
        this.activity = activity;
    }

    @JavascriptInterface
    public void getAccessToken( final String msg ){
        Log.d("getAccessToken: ", msg);

        bootpay = new BootpayTest("6210d6f52701800021f66a29", "Q3ZLL5kAYzURPEmm0qIeY2NqRSaCnlRGIyB0kTmTiAQ=");

        try {
            ResDefault<HashMap<String, Object>> res = bootpay.getAccessToken();
            System.out.println("@@@ getAccessToken: "+res.toJson());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @JavascriptInterface
    public void cancelTest( final String msg ){
        Log.d("cancelTest: ", msg);

//        BootpayTest bootpay = new BootpayTest("6210d6f52701800021f66a29", "Q3ZLL5kAYzURPEmm0qIeY2NqRSaCnlRGIyB0kTmTiAQ=");

        try {
            ResDefault<HashMap<String, Object>> res = bootpay.getAccessToken();
            System.out.println("@@@ getAccessToken: "+res.toJson());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Cancel cancel = new Cancel();
        cancel.receiptId = "622349b7d3d0570040b53086";
        cancel.name = "관리자";
        cancel.reason = "테스트 결제";
//        cancel.price = 1000.0; //부분취소 요청시 지정
//        cancel.

//        String receipt_id = "";
        try {
            ResDefault<HashMap<String, Object>> res = bootpay.receiptCancel(cancel);
//            String str = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
            System.out.println(res.toJson());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

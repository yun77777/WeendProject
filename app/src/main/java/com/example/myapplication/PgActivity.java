package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import kr.co.bootpay.BootpayWebView;
import kr.co.bootpay.listener.EventListener;

public class PgActivity extends AppCompatActivity {
    private BootpayWebView webview;
//    private String url = "https://www.naver.com";
//private String url = "http://10.0.2.2:3000"; // instead of localhost
    private String url = "file:///android_asset/index/index.html"; // instead of localhost
//    private String url = "http://3.37.87.71:3000/"; // instead of localhost


    void doJavascript(String script) {
        final String str = script;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webview.loadUrl("javascript:(function(){" + str + "})()");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg);


        webview = (BootpayWebView)findViewById(R.id.wv_main);
        AndroidBridge bridge = new AndroidBridge(webview, PgActivity.this);
        webview.addJavascriptInterface(bridge, "bridge");

//        webview.addJavascriptInterface(new WebAppInterface(this), "Android");

//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.setWebChromeClient(new WebChromeClient());
//        webview.setWebViewClient(new WebViewClientClass());

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("urlurlurl", url);
                Log.d("view", String.valueOf(view));
                try { /** * 201229 * ??????????????? ?????? ????????? ?????? ?????? if?????? ?????????. */
                if (url != null && url.startsWith("intent://kakaopay/")) {
                    try {
                        Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                        Intent existPackage = getPackageManager().getLaunchIntentForPackage(intent.getPackage());
                        if (existPackage != null) { startActivity(intent); }
                        else { Intent marketIntent = new Intent(Intent.ACTION_VIEW);
                        marketIntent.setData(Uri.parse("pg?url=" + intent.getPackage()));
                        startActivity(marketIntent); } return true; } catch (Exception e) { e.printStackTrace(); } } }
                catch (Exception e) { e.printStackTrace(); return false; } return false; }

//            public boolean shouldOverrideUrlLoading(WebView view, String url){
//                Log.d("pg url@@@@@ : ", url);
//                Log.d("url.contains@@@@@ : ", String.valueOf(url.contains("kakaopay")));
//                if(url.contains("kakaopay")) return false;
//                view.loadUrl(url);
//                return false;
//            }
        });

        webview.setOnResponseListener(new EventListener() {
            @Override
            public void onError(String data) {
                System.out.println("bootpay error");
                System.out.println(data);
            }

            @Override
            public void onCancel(String data) {
                System.out.println("bootpay cancel");
                System.out.println(data);
            }

            @Override
            public void onClose(String data) {
                System.out.println("bootpay close");
                System.out.println(data);
            }

            @Override
            public void onReady(String data) {
                System.out.println("bootpay ready");
                System.out.println(data);
            }

            @Override
            public void onConfirm(String data) {
                boolean iWantPay = true;
                if(iWantPay == true) { // ????????? ?????? ??????
                    doJavascript("BootPay.transactionConfirm( " + data + ");");
                } else {
                    doJavascript("BootPay.removePaymentWindow();");
                }
            }

            @Override
            public void onDone(String data) {
                System.out.println("bootpay done");
                System.out.println(data);
            }
        });
        webview.loadUrl(url);

        // FCM gets an device token for push notification
//        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(new OnSuccessListener<String>() {
//            @Override
//            public void onSuccess(String token) {
//                Log.d("token:", token);
//            }
//        });

        // setting for push notification on/off
//        swc_push = (Switch) findViewById(R.id.swc_push);
//
//        SharedPreferences sharedPreferences = getSharedPreferences("shared", 0);
//
//        String push = sharedPreferences.getString("push", "");
//        boolean bool = false;
//        if (push.equals("true")) {
//            bool = true;
//        } else {
//        }
//
//        swc_push.setChecked(bool);
//
//        swc_push.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("push", String.valueOf(b));
//                editor.commit();
//            }
//        });



    }



//    private class WebViewClientClass extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//            Log.d("view:",view.getUrl());
//            view.loadUrl(url);
//            return true;
//        }
//    }

    @Override
    public void onBackPressed() {
        // ????????? history??? ????????? ??????
        WebBackForwardList list = webview.copyBackForwardList();
        Log.d("WebBackForwardList:", String.valueOf(list));
        Log.d("list.getCurrentIndex():", String.valueOf(list.getCurrentIndex()));
        if (list.getCurrentIndex() == 0 ||  !webview.canGoBack()) {
            // ?????? ????????? ??????????????????, history??? ????????????
            super.onBackPressed();
        } else if (list.getCurrentIndex() == 1 || webview.canGoBack()) {
            webview.loadUrl("file:///android_asset/index/index.html");
        } else {
            // history??? ?????? ??????
            // ?????? ???????????? ?????? history ??? ?????? ??? ???????????? ??????
            webview.goBackOrForward(-(list.getCurrentIndex()));
//            // history ??????
            webview.clearHistory();
        }
    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == 4) {
//            webview.loadUrl("file:///android_asset/index.html");
//        }
//        if((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
//
//            Log.d("keyCode:", String.valueOf(keyCode));
//            webview.goBack();
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }


}
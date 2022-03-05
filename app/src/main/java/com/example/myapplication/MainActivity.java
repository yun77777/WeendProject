package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webview;
//    private String url = "file:///android_asset/main.html";
    private String url = "file:///android_asset/frontend/public/index.html";
//    private String url = "file:///android_asset/index.html";
    private Button btn_move;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.wv_main);

        btn_move = (Button)findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PgActivity.class);
                intent.putExtra("data","test");
                startActivity(intent);
            }
        });

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setAllowFileAccessFromFileURLs(true);
        webview.getSettings().setAllowUniversalAccessFromFileURLs(true);
//        webview.setWebChromeClient(new WebChromeClient());
//        webview.setWebViewClient(new WebViewClientClass());


//        webview.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url){
//                Log.d("url@@@@@ : ", url);
//                view.loadUrl(url);
//                return false;
//            }
//        });
        webview.loadUrl(url);
        Log.d("webview:",webview.getUrl());

    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Log.d("view:",view.getUrl());
            view.loadUrl(url);
            return true;
        }
    }

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
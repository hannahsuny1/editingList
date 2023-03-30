package com.example.mytest;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondPage extends AppCompatActivity {

    static ListView listView2;
    static ListViewAdapter2 adapter2;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        listView2 = findViewById(R.id.listview2);

        ArrayList<String> ar1 = getIntent().getExtras().getStringArrayList("list");
        adapter2 = new ListViewAdapter2(getApplicationContext(), ar1);
        listView2.setAdapter(adapter2);

        webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/search?q="+ar1+"+recipe");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}

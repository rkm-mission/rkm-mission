package com.example.ramkrishnamathandmission;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class RamkrishnaMathandMission extends Activity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rkmnm);

        webView = (WebView) findViewById(R.id.rkmnm_web);
        //Load emblem.html from local storage.
        webView.loadUrl("file:///android_asset/RamkrishnaMathandMission.html");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rkmnm, menu);
        return true;
    }
}

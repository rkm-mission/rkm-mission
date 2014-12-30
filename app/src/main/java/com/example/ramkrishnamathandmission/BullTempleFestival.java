package com.example.ramkrishnamathandmission;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;


public class BullTempleFestival extends Activity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_festival);

        webView = (WebView) findViewById(R.id.festival_bull_web);
        webView.loadUrl("file:///android_asset/RKM_Bull_temple_festival_calender.html");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
package com.example.ramkrishnamathandmission;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;


public class ContactUs extends Activity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_contact_us);

        webView = (WebView) findViewById(R.id.contact_web);
        //Load emblem.html from local storage.
        webView.loadUrl("file:///android_asset/contactUs.html");
    }

}

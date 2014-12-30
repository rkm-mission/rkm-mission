package com.example.ramkrishnamathandmission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;

public class DonationPage extends Activity {
    WebView webView;
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_donation_page);

        webView = (WebView) findViewById(R.id.donation_web);
        //Load emblem.html from local storage.
        webView.loadUrl("file:///android_asset/donate.html");

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_branch_donate_option);
        final Button button, button2;

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_emblem);
                webView = (WebView) findViewById(R.id.emblem_web);
                //Load emblem.html from local storage.
                webView.loadUrl("file:///android_asset/donate.html");
            }

        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_emblem);
                webView = (WebView) findViewById(R.id.emblem_web);
                //Load emblem.html from local storage.
                webView.loadUrl("file:///android_asset/donate_bull.html");
            }

        });
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

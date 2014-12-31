package com.example.ramkrishnamathandmission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapActivity extends Activity {
    // initialize map data here
    static final LatLng RKMATH_BLR = new LatLng(12.980518, 77.629882);
    static final LatLng RKMATH_BLR_BULL_TEMPLE = new LatLng(12.948766, 77.566807);
    private GoogleMap map;
    private boolean direction_opened = false;
    private int map_options = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        Intent myIntent = getIntent();
        int val = myIntent.getIntExtra("branch", 0);

        final Button button;

        try {
            switch (val) {
                case 0:
                    // ulsoor map
                    setContentView(R.layout.activity_map);

                    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                            .getMap();

                    if (map != null)
                        map.setMyLocationEnabled(true);

                    Marker rmk_bkr_ulsoor = map.addMarker(new MarkerOptions().position(RKMATH_BLR)
                            .title("Ramkrishna Math Ulsoor"));

                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(RKMATH_BLR, 15));
                    map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

                    button = (Button) findViewById(R.id.button_direction);
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            // open a new webview after button click

                            setContentView(R.layout.map_direction);
                            WebView myWebView = (WebView) findViewById(R.id.dir1);

                            // enable javascript in webview
                            myWebView.getSettings().setJavaScriptEnabled(true);
                            myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                            // any src to specific destination
                            direction_opened = true;
                            map_options = 1;
                            myWebView.loadUrl("http://maps.google.com/maps?f=d&hl=en&saddr=&daddr=Ramakrishna+Mutt,+Ulsoor,+Bengaluru,+Karnataka,+India&ie=UTF8&0&om=0&output=kml");
                        }
                    });
                    break;

                case 1:
                    // Bull temple map
                    setContentView(R.layout.activity_map);

                    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                            .getMap();

                    if (map != null)
                        map.setMyLocationEnabled(true);

                    Marker rkm_blr_bull_temple = map.addMarker(new MarkerOptions().position(RKMATH_BLR_BULL_TEMPLE)
                            .title("Ramkrishna Math Bull Temple Road"));

                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(RKMATH_BLR_BULL_TEMPLE, 15));
                    map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

                    button = (Button) findViewById(R.id.button_direction);
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            // open a new webview after button click

                            setContentView(R.layout.map_direction);
                            WebView myWebView = (WebView) findViewById(R.id.dir1);

                            // enable javascript in webview
                            myWebView.getSettings().setJavaScriptEnabled(true);
                            myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                            // any src to specific destination
                            direction_opened = true;
                            map_options = 2;
                            myWebView.loadUrl("http://maps.google.com/maps?f=d&hl=en&saddr=&daddr=12.948766,77.566807&ie=UTF8&0&om=0&output=kml");
                        }
                    });
                    break;
            }
        }
        catch (Exception e) {
        }

    }

    @Override
    protected void onRestart()
    {
        finish();
        super.onRestart();
    }

}
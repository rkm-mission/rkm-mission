package com.example.ramkrishnamathandmission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

public class DonationPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_donation_page);

        RadioButton rb = (RadioButton) findViewById(R.id.radioButton1);
        rb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                onlineDonation(v);
                finish();
            }
        });

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton2);
        rb1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                offlineDonation(v);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.donation_page, menu);
        return true;
    }

    /** Called when the user clicks the Online Donation Radio button */
    public void onlineDonation(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, OnlineDonation.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Offline Donation Radio button */
    public void offlineDonation(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, OfflineDonation.class);
        startActivity(intent);
    }
}

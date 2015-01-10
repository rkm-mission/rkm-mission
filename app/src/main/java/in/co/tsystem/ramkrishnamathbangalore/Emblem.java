package in.co.tsystem.ramkrishnamathbangalore;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class Emblem extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_emblem);

        webView = (WebView) findViewById(R.id.emblem_web);
        //Load emblem.html from local storage.
        webView.loadUrl("file:///android_asset/emblem.html");

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

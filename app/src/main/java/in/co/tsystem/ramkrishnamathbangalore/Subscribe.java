package in.co.tsystem.ramkrishnamathbangalore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;

public class Subscribe extends Activity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_emblem);

        webView = (WebView) findViewById(R.id.emblem_web);

        //Check for internet connection
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if ((activeNetworkInfo != null) && activeNetworkInfo.isConnected()) {
            // enable javascript in webview
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

            webView.loadUrl("http://www.rkm.org.in/?p=subscribe&id=1");

        } else {

            AlertDialog.Builder build = new AlertDialog.Builder(Subscribe.this);
            build.setTitle("");
            build.setPositiveButton("OK", null);
            build.setMessage("Need Internet Connection");
            AlertDialog errorD = build.create();
            errorD.show();
        }

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

package org.kitchen_info.kitcheninfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private String url = "http://pi02:8888/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.web_view);

        mWebView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.loadUrl(this.url);


        // Set up the user interaction to manually show or hide the system UI.
        mWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return handleTouch(v, event);
            }
        });

    }

    protected boolean handleTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        if ((v instanceof WebView) && (event.getAction() == MotionEvent.ACTION_DOWN)) {
            if (x < 50.0) {
                WebView vw = (WebView) v;
                vw.goBack();
                Log.i("MY", "handleTouch: go back");
                return true;
            }
        } else {
            Log.i("MY", String.format("x=%f", x));
        }
        return false;

    }

}
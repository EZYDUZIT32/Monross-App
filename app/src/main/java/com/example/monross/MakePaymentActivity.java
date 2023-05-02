package com.example.monross;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MakePaymentActivity extends AppCompatActivity {
    private WebView mWebView;
    private ProgressBar mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);

        mWebView = (WebView) findViewById(R.id.mWebView);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mWebView.setVisibility(View.GONE);
                mProgress.setVisibility(View.VISIBLE);
                if(url.equals("https://help.checkout-x.com/en/articles/3998622-how-to-cancel-your-subscriptionee "))
                {
                    Toast.makeText(MakePaymentActivity.this, "Payment is cancelled", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if(url.equals("https://help.checkout-x.com/en/articles/3998622-how-to-cartff"))
                {
                    Toast.makeText(MakePaymentActivity.this, "Payment is successfull", Toast.LENGTH_SHORT).show();
                    youCanDoWhateveryouwanttodo();

                }
            }
            @Override
            public void onPageFinished(WebView view, String url){
                super.onPageFinished(view, url);
                mWebView.setVisibility(View.VISIBLE);
                mProgress.setVisibility(View.GONE);

        }

        });

        mWebView.loadUrl("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MUM8LC2RPJ5JA");

    }

    private void youCanDoWhateveryouwanttodo() {
    }
}
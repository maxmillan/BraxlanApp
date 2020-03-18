package com.example.braxlan;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    BottomNavigationView bottomNavigationView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()){
                    case R.id.nav_cart:
                    webView.loadUrl("https://braxlan.com/cart/");
                    doalog();
                    break;
                    case R.id.nav_account:
                        webView.loadUrl("https://braxlan.com/myAccount/");
                        doalog();
                        break;
                    case R.id.nav_home:
                        webView.loadUrl("https://braxlan.com/");
                        doalog();
                        break;

                }
                return true;
            }
        });
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webView.loadUrl("https://braxlan.com/");
        doalog();
    }

    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
        if (webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed();

        }
    }
    public void doalog(){
        progressDialog= new ProgressDialog(MainActivity.this);
        progressDialog.show();
        progressDialog.setMax(200);
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
    }



}

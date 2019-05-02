package com.harsh.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class Website extends AppCompatActivity {

    EditText e_enter_web;
    WebView w_web;
    String s_enter_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        e_enter_web = (EditText)findViewById(R.id.enter_web);
        w_web = (WebView)findViewById(R.id.custom_web);

    }

    public void goclick (View view) {

        //declaring string and getting edittext data
        s_enter_web = e_enter_web.getText().toString().trim();

        if(s_enter_web.equals("")) {
            Toast.makeText(this, "Please enter the website", Toast.LENGTH_SHORT).show();
        }
        else{
            w_web.getSettings().setJavaScriptEnabled(true);
            w_web.loadUrl("http://www."+s_enter_web+".com");
            w_web.setWebViewClient(new WebViewClient());
            Toast.makeText(this, "You entered "+s_enter_web, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if(w_web.canGoBack()) {
            w_web.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

}

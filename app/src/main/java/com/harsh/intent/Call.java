package com.harsh.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Call extends AppCompatActivity {

    EditText e_call;
    Button b_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        e_call = (EditText)findViewById(R.id.call_number);
        b_call = (Button)findViewById(R.id.call_button);

        //setting action on the click of button
    }

    public void callClick(View view) {

        //getting the number
        String s_number = e_call.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+s_number));
        startActivity(intent);
    }

}

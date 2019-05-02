package com.harsh.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Message extends AppCompatActivity {

    EditText e_number, e_message;
    Button b_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        e_number = (EditText)findViewById(R.id.enter_number);
        e_message = (EditText)findViewById(R.id.enter_message);
        b_send = (Button)findViewById(R.id.message_button);

    }

    public void messageClick(View view) {

        //getting the number
        String s_number = e_number.getText().toString().trim();
        String s_message = e_message.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("sms:"+s_number));
        intent.putExtra("sms_body:",s_message);
        startActivity(intent);
    }

}

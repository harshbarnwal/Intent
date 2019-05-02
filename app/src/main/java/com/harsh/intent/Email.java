package com.harsh.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Email extends AppCompatActivity {

    EditText e_email, e_subject, e_mail_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        e_email = (EditText)findViewById(R.id.enter_email);
        e_subject = (EditText)findViewById(R.id.enter_subject);
        e_mail_message = (EditText)findViewById(R.id.enter_mail_message);

    }

    public void emailClick(View view) {

        String s_email = e_email.getText().toString().trim();
        String s_subject = e_subject.getText().toString().trim();
        String s_mail_message = e_mail_message.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, s_email);
        intent.putExtra(Intent.EXTRA_SUBJECT, s_subject);
        intent.putExtra(Intent.EXTRA_TEXT, s_mail_message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Select the mailing app:"));

    }

}

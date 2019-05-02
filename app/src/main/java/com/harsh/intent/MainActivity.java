package com.harsh.intent;

import android.content.Intent;
import android.graphics.Camera;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView l_lists;
    String col[] = {"Calling","Message(SMS)","Gmail","Website","Camera", "Send Image", "Location"};
    Integer img[] = {R.drawable.call, R.drawable.message, R.drawable.email, R.drawable.website, R.drawable.camera, R.drawable.db, R.drawable.loc};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l_lists = (ListView)findViewById(R.id.lists);
        CustomAdapter adapter = new CustomAdapter(this,col,img);
        l_lists.setAdapter(adapter);

        //setting on click listener
        l_lists.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //using switch
        switch(position) {
            case 0:
               startActivity(new Intent(this,Call.class));
               Toast.makeText(this,"Enter the number to call",Toast.LENGTH_SHORT).show();
               break;

            case 1:
                startActivity(new Intent(this,Message.class));
                Toast.makeText(this,"Enter the Message",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                startActivity(new Intent(this,Email.class));
                Toast.makeText(this,"Enter the Email details",Toast.LENGTH_SHORT).show();
                break;

            case 3:
                startActivity(new Intent(this,Website.class));
                Toast.makeText(this,"Enter the Website name",Toast.LENGTH_SHORT).show();
                break;

            case 4:
                Intent camera = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(camera);
                Toast.makeText(this,"Opened Camera",Toast.LENGTH_SHORT).show();
                break;

            case 5:
                //selecting the image to be sent
                Uri imageUri = Uri.parse("android.resource://com.harsh.intent/drawable/"+R.drawable.db);
                Intent image = new Intent(Intent.ACTION_SEND);

                //setting the type of data to be sent
                image.setType("image/*");

                //sending the image
                image.putExtra(Intent.EXTRA_STREAM, imageUri);
                startActivity(Intent.createChooser(image, "Select the Image receiver:"));
                Toast.makeText(this,"Select the app to receive image",Toast.LENGTH_SHORT).show();
                break;

            case 6:
                //Setting the location in the Uri
                Uri locationUri = Uri.parse("geo:26.8574753,80.8731622");
                Intent location = new Intent(Intent.ACTION_VIEW, locationUri);
                startActivity(Intent.createChooser(location, "Select the Map app:"));
                Toast.makeText(this,"Harsh Barnwal's Home",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

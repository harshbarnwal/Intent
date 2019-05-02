package com.harsh.intent;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private final Activity mcontext;
    private final String[] col;
    private final Integer[] img;

    public CustomAdapter(Activity mcontext, String col[], Integer img[]) {
        super(mcontext,R.layout.custom_adapter,col);
        this.mcontext = mcontext;
        this.col = col;
        this.img = img;
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = mcontext.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_adapter,null,true);
        ImageView iv=(ImageView)rowView.findViewById(R.id.childicon);
        TextView tv=(TextView)rowView.findViewById(R.id.childtext);
        iv.setImageResource(img[position]);
        tv.setText(col[position]);
        return rowView;
    }
}

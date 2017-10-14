package com.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by nidhi on 6/10/2017.
 */

public class OneActivity extends AppCompatActivity {

    private Context context = OneActivity.this;

    private TextView tvname, tvemail, tvmobile;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        sharedPreferences = getSharedPreferences("nidhish",0);

        tvname = (TextView)findViewById(R.id.textView_name);
        tvname.setText(sharedPreferences.getString("name","none"));

        tvemail = (TextView)findViewById(R.id.textView_email);
        tvemail.setText(sharedPreferences.getString("email","none"));

        tvmobile = (TextView)findViewById(R.id.textView_mobile);
        tvmobile.setText(String.valueOf(sharedPreferences.getLong("mobile",0)));


    }
}

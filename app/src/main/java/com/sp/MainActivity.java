package com.sp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context = MainActivity.this;

    private EditText etname, etemail, etmobile;

    private Button btsave,btnext;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("nidhish",0);

        etname = (EditText)findViewById(R.id.editText_name);
        etemail = (EditText)findViewById(R.id.editText_email);
        etmobile = (EditText)findViewById(R.id.editText_mobile);

        btsave = (Button)findViewById(R.id.button_save);
        btsave.setOnClickListener(this);

        btnext = (Button)findViewById(R.id.button_next);
        btnext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_save:

                if(etname.length()>0 && etemail.length()>0 && etmobile.length()>=10) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", etname.getText().toString());
                    editor.putString("email", etemail.getText().toString());
                    editor.putLong("mobile", Long.parseLong(etmobile.getText().toString()));
                    editor.commit();
                }else{
                    Toast.makeText(context,"Enter data",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.button_next:
                startActivity(new Intent(context,OneActivity.class));
                break;
        }
    }
}

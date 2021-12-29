package com.example.lab04_activitiesomelko;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {//created by Igor Omelko
    Intent x;
    String s;
    EditText etsa;
    Switch swup,swdown;
    boolean[] updown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//created by Igor Omelko
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        updown = new boolean[2];
        x=getIntent();
        swup=findViewById(R.id.sw_up_sa);
        swdown=findViewById(R.id.sw_down_sa);
        etsa = findViewById(R.id.et_sa);
        if (x!=null){
            s=x.getStringExtra("textfieldma").toString();
            updown=x.getBooleanArrayExtra("updownma");
            swup.setChecked(updown[0]);
            swdown.setChecked(updown[1]);
        }
        etsa.setText(s.toString());
    }
    public void onClickCancel(View v){//created by Igor Omelko
        setResult(RESULT_CANCELED);
        finish();
    }
    public void onClickOk(View v){//created by Igor Omelko
        Intent i = new Intent();
        if (s!=null){
            s = etsa.getText().toString();
        }
        if (swup.isChecked()){
            updown[0]=true;
        }
        else{
            updown[0]=false;
        }
        if (swdown.isChecked()){
            updown[1]=true;
        }
        else{
            updown[1]=false;
        }
        i.putExtra("textfieldsa",s);
        i.putExtra("updownsa",updown);
        setResult(RESULT_OK,i);
        finish();
    }
}

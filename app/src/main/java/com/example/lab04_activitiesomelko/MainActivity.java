package com.example.lab04_activitiesomelko;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {//created by Igor Omelko
//Context ct_this;
EditText etma;
String s;
Intent i;
CheckBox cbup,cbdown;
boolean[] updown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//created by Igor Omelko
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ct_this=this;
        etma=findViewById(R.id.et_ma);
        s = etma.getText().toString();
        cbup=findViewById(R.id.cb_up_ma);
        cbdown=findViewById(R.id.cb_down_ma);
        updown = new boolean[2];
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){//created by Igor Omelko
        if (requestCode==888){
            if (data!=null){
                s = data.getStringExtra("textfieldsa");
                etma.setText(s.toString());
                updown=data.getBooleanArrayExtra("updownsa");
                    cbup.setChecked(updown[0]);
                    cbdown.setChecked(updown[1]);
                //Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
    public void onClickOpen(View v){//created by Igor Omelko
        s=etma.getText().toString();
        if (cbup.isChecked()){
            updown[0]=true;
        }
        else{
            updown[0]=false;
        }
        if (cbdown.isChecked()){
            updown[1]=true;
        }
        else{
            updown[1]=false;
        }
        i=new Intent(this,SecondActivity.class);
        i.putExtra("textfieldma",s);
        i.putExtra("updownma",updown);
        startActivityForResult(i,888);
    }
    public void onClickExit(View v)
    {
        DialogWindow();
    }
    public void DialogWindow(){ //created by Igor Omelko
        LayoutInflater myLayout = LayoutInflater.from(this);
        View dialogView = myLayout.inflate(R.layout.alertdialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        AlertDialog dlg = builder.create();
        dlg.setIcon(R.drawable.image2);
        dlg.show();
        Button btncancelald =dlg.findViewById(R.id.btn_cancel_ald);
        Button btnexitald =dlg.findViewById(R.id.btn_exit_ald);
        btnexitald.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
                System.exit (0);
            }
        }
        );
        btncancelald.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
                dlg.dismiss ();
            }
        }
        );
    }
}
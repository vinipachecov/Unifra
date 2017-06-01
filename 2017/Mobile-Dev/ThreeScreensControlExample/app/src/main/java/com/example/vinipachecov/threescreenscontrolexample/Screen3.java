package com.example.vinipachecov.threescreenscontrolexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Screen3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
    }

    public void Finish(View v){
        Intent it = new Intent();
        setResult(2,it);
        finish();
    }
}

package com.example.vinipachecov.threescreenscontrolexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startSecondActivity(View view){
        //start second screen
         Intent intent = new Intent(this, Screen2.class);
        startActivityForResult(intent, 2);
    }

    public void startThirdActivity(View view){
        //start second screen
        Intent intent = new Intent(this, Screen3.class);
        startActivityForResult(intent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch(requestCode){
            case 2:
                Toast.makeText(this, "Tela 2 finalizou " , Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Tela 3 finalizou " , Toast.LENGTH_SHORT).show();
                break;
        }




    }
}

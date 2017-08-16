package com.example.vinipachecov.secondscreenwithspinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//1 - Faça uma aplicação em que o usuário, na tela principal, acessa a tela secundária através de um botão.
//    A tela secundária possui um Spinner e um botão, e ao clicar no botão,
//    a tela secundária é fechada e é retornado para a tela principal a informação de qual elemento
//    do Spinner foi selecionado.

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    TextView textView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
    }

    public void startSecondActivity(View view){
        //start second screen
        intent = new Intent(this, SecondScreen.class);
        startActivityForResult(intent, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1234){
            textView.setText(data.getStringExtra("planeta"));
            Log.i("Information sent back" , data.getStringExtra("planeta"));
        }
        //Retrieve data in the intent


    }
}

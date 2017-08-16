package com.example.vinipachecov.loginwithsecondscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        TextView MessageTextView  = (TextView)findViewById(R.id.MessageTextView);

        String login = getIntent().getStringExtra("login");
        String password = getIntent().getStringExtra("password");

        if(login.equals("admin") && password.equals("12345")){
            MessageTextView.setText("Bem vindo Usuário!");
        }else
            MessageTextView.setText("Dados não conferem!");

    }
}

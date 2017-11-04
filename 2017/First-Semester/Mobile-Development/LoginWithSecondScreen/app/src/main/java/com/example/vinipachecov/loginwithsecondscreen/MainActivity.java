package com.example.vinipachecov.loginwithsecondscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//1 – Crie uma tela para solicitar ao usuário os dados de login (nome e senha).
//Quando o usuário informar os dados, ele deverá clicar em um botão e ser direcionado para uma outra tela,
//a qual irá testar se os dados digitados são: nome = "admin" e senha = "12345". Caso, o usuário seja válido,
//exiba uma mensagem de boas vindas, e caso contrario, informe ao usuário que os dados não conferem.




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void signIn(View v){
        EditText login = (EditText)findViewById(R.id.logineditText);
        EditText password= (EditText)findViewById(R.id.passwordeditText2);

        Intent intent = new Intent(this, SecondScreen.class);

        intent.putExtra("login",login.getText().toString());
        intent.putExtra("password",password.getText().toString());
        startActivity(intent);
    }

}

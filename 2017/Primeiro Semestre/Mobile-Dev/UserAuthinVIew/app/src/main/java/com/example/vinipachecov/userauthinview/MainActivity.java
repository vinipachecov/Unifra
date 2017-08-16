package com.example.vinipachecov.userauthinview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

//Crie uma aplicação para Android em que o usuário informa o nome (em uma entrada de texto autocomplementar)
// e a senha (em uma entrada de texto do tipo password).
//O sistema verifica se o usuário é "admin", "adm", "administrador" ou "root" e a senha é "12345".
//Caso afirmativo, então o sistema apresenta uma frase de "Bem-vindo usuário x".
//As informações de usuário e senha deverão estar em uma outra classe chamada Usuario.

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView textView;

    ArrayList<Usuario> users;

    EditText passwordeditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUsers();
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(this,
                android.R.layout.simple_dropdown_item_1line,users);
        textView = (AutoCompleteTextView)findViewById(R.id.usernameAutoCompleteTextView);
        textView.setAdapter(adapter);
        passwordeditText = (EditText)findViewById(R.id.passwordeditText);
    }

    public void signIn(View v){

        findUser();
    }

    public Boolean findUser(){
        String username = textView.getText().toString();

        for (Usuario aux : users){
            if(aux.toString().equals(username)){
                if(passwordeditText.getText().toString().equals(aux.getPassword())){
                    Toast.makeText(this, "Bem-vindo usuário " + aux.getUsername(), Toast.LENGTH_SHORT).show();
                    return true;
                }else
                    Toast.makeText(this, "Senha Incorreta, tente novamente" , Toast.LENGTH_SHORT).show();
                    return false;
            }
        }
        Toast.makeText(this, "Usuário Incorreto, tente novamente" , Toast.LENGTH_SHORT).show();
        return false;
    }

    public void initUsers(){
        users = new ArrayList<>();
        users.add(new Usuario("Administrador", "12345"));
        users.add(new Usuario("adm", "12345"));
        users.add(new Usuario("admin", "12345"));
        users.add(new Usuario("root", "12345"));

    }
}

package com.viniciuspv.aula1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editPassword, editemail,editrepeatPasword,editNome;
    TextView TextResultado;
    Button botaoLimpar, botaoCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //A chamada ao metodo set ContentView definie qual xml será
        //exibido por este arquivo .java
        setContentView(R.layout.activity_main);

        editPassword = (EditText)findViewById(R.id.Editpassword);
        editemail = (EditText)findViewById(R.id.Editemail);
        editrepeatPasword = (EditText)findViewById(R.id.editrepeatPasword);
        editNome = (EditText)findViewById(R.id.editNome);
        TextResultado = (TextView)findViewById(R.id.textView9);
        botaoLimpar = (Button)findViewById(R.id.BotaoLimpar);
        botaoCadastrar= (Button)findViewById(R.id.BotãoCadastrar);
    }

    public void cadastrarClick(android.view.View v){
        //buscando o conteúdo dos edit texts da interface gráfica

        String strnome = editNome.getText().toString();
        String strEmail = editemail.getText().toString();
        String strSenha = editPassword.getText().toString();
        String repeatSenha = editrepeatPasword.getText().toString();

        //definindo o conteúdo de um textview através do Java

        TextResultado.setText(
                "O nome digitado foi "+ strnome +"\n" +
                        "O email digitado foi :" + strEmail+ "\n"
        );

        if(v==botaoLimpar){
            TextResultado.setText("FOI CLICADO O BOTAO DE LIMPAR");

        }else{
            TextResultado.setText("FOI CLICADO O BOTAO  DE CADASTRAR");
        }





    }
}

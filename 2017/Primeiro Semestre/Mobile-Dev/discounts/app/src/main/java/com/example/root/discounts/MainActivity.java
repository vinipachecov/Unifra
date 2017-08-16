package com.example.root.discounts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/*1) Escreva uma aplicação em Android para divulgar as ofertas de uma loja de eletrônicos situada em um shopping center da cidade. Solicitar o nome, a idade e o estado civil do usuário.

    Caso a idade seja maior que 25 anos e o estado civil for solteiro, exibir a mensagem de 10% de desconto em videogames.
    Caso a idade seja maior que 40 anos e o estado civil for casado, exibir a mensagem de 25% de desconto na linha de computadores.
    Para todos os outros casos, exibir a mensagem de desconto padrão, que é de 5% em toda a linha de produtos.
    Dica: Utilize componentes EditText, RadioButton e Toast.
*/


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void publicaToast(View view){
        EditText idade = (EditText) findViewById(R.id.idadeeditText);
        RadioButton solteiro = (RadioButton) findViewById(R.id.solteiroradioButton);
        RadioButton casado = (RadioButton) findViewById(R.id.casadoradioButton);
        int age = Integer.parseInt(idade.getText().toString());
        if(age > 25 && solteiro.isChecked()){
            Toast.makeText(MainActivity.this, "10% de desconto em videogames",
                    Toast.LENGTH_SHORT).show();
        }
        if(age >  40 && casado.isChecked()){
            Toast.makeText(MainActivity.this, "25% de desconto na linha de computadores",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "5% de desconto em toda linha de produtos",
                    Toast.LENGTH_SHORT).show();
        }

    }
}


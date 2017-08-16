package com.example.vinipachecov.iesimagens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


//Escreva um programa em Android para solicitar ao usuário a digitação do nome de uma instituição de ensino superior.
//O usuário irá iniciar a digitação e o sistema irá complementar. Ao todo, deverão estar cadastradas 3 instituições.
//Após o autopreenchimento do nome, o usuário irá clicar em um botão e será exibido o logo dessa instituição escolhida
//, bem como uma mensagem rápida informando em qual(is) cidade(s) ela está localizada.

public class Principal extends AppCompatActivity {

    ArrayList<IES> ies;

    AutoCompleteTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        init();


        ArrayAdapter<IES> adapter = new ArrayAdapter<IES>(this,
                android.R.layout.simple_dropdown_item_1line,ies);
        textView = (AutoCompleteTextView)findViewById(R.id.iesautoCompleteTextView);
        textView.setAdapter(adapter);
    }


    public void showLogo(View v){
        String nome = textView.getText().toString();
        ImageView imageView = (ImageView)findViewById(R.id.logoIESimageView);

        for (IES uni : ies){
            if(nome.equals(uni.toString())){
                Toast.makeText(this, "A Instituição fica na cidade de " + uni.getCidade(), Toast.LENGTH_SHORT).show();
                imageView.setBackgroundResource(uni.getImagem());
            }
        }
    }

    public void init(){
        ies = new ArrayList<>();
        ies.add(new IES("Universidade Federal do Rio Grande do Sul", "Porto Alegre", R.drawable.logoufrfgs));
        ies.add(new IES("Centro Universitário Franciscano" , "Santa Maria", R.drawable.logounifra));
        ies.add(new IES("Universidade Luterana do Brasil", "Santa Maria", R.drawable.ulbralogo));


    }
}

package com.example.vinipachecov.aula24abril;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spiner2;
    static AutoCompleteTextView autoCompletePais;

    public String[] paises = new String[] {"Argentina","Brasil","Costa Rica", "Canadá",
            "Equador", "EUA"};


    //Criação com lista pré-definida no java

    static Spinner spinner3;
    public String[] itens = new String[] {"item 1","item 2","item 3","item 4","item 5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spiner2 = (Spinner) findViewById(R.id.spinner);

//        ArrayAdapter<CharSequence> adaptador =  ArrayAdapter.createFromResource(this, R.array.lista1, android.R.layout.simple_spinner_item);
//        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spiner2.setAdapter(adaptador);


        //spinner 3

        spinner3 = (Spinner) findViewById(R.id.spinner3);


        // spinner 4

        Spinner spinner4;
        EditText editText1;

//        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
//                (this, android.R.layout.simple_spinner_item, itens);
//        adaptador.setDropDownViewResource(android.R.layout. simple_spinner_item);
//        spinner3.setAdapter(adaptador);

        //spinner dinamico

//        spinner4 = (Spinner) findViewById(R.id.spinner4);
//        editText1 = (EditText) findViewById(R.id.editText1);
//        adaptador = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item);
//        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spinner4.setAdapter(adaptador);

        autoCompletePais = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, paises);
        autoCompletePais.setAdapter(adaptador);
//
    }
//
//    public void adicionarClick(View v) {
//        adaptador.add(editText1.getText().toString());
//    }




}

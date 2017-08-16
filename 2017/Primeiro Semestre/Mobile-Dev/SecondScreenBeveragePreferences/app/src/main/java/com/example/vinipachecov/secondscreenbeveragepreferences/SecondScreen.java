package com.example.vinipachecov.secondscreenbeveragepreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        ArrayList<String> lbebidas = new ArrayList<String>();

        lbebidas = getIntent().getStringArrayListExtra("Bebidas");

        TextView nome = (TextView) findViewById(R.id.NometextView);
        TextView telefone= (TextView) findViewById(R.id.telefoneTextView);
        TextView sexo = (TextView) findViewById(R.id.sexotextView);
        ListView bebidas = (ListView)findViewById(R.id.bebidas);

        nome.setText(getIntent().getStringExtra("Nome").toString());
        telefone.setText(getIntent().getStringExtra("Telefone").toString());
        sexo.setText(getIntent().getStringExtra("Sexo").toString());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,lbebidas);
        bebidas.setAdapter(adapter);


    }



}

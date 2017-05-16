package com.example.vinipachecov.recursosdeumaaplicacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> spinnerArray =  new ArrayList<String>();


        Spinner spinnerCountShoes = (Spinner)findViewById(R.id.nacionalidadeSpinner);
        ArrayAdapter<String> spinnerCountShoesArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.spinner));
        spinnerCountShoes.setAdapter(spinnerCountShoesArrayAdapter);
    }
}

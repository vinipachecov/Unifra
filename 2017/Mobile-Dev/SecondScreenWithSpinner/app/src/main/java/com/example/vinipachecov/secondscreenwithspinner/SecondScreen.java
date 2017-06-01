package com.example.vinipachecov.secondscreenwithspinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import static android.R.attr.value;

public class SecondScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner planetasspinner;
    private ImageView planeta;
    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        intent = getIntent();

        planetasspinner = (Spinner)findViewById(R.id.planetaspinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.solarsystem, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetasspinner.setAdapter(adapter);

        planetasspinner.setOnItemSelectedListener(this);
    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        if(!parent.getSelectedItem().toString().equals("Selecione um Planeta")){
            switch(parent.getSelectedItem().toString()){
                case "Mercúrio":
                    intent.putExtra("planeta", "Mercúrio");
                    break;
                case "Venus":
                    intent.putExtra("planeta", "Venus");
                    break;
                case "Terra":
                    intent.putExtra("planeta", "Terra");
                    break;
                case "Marte":
                    intent.putExtra("planeta", "Marte");
                    break;
                case "Júpiter":
                    intent.putExtra("planeta", "Júpiter");
                    break;
                case "Saturno":
                    intent.putExtra("planeta", "Saturno");
                    break;
                case "Urano":
                    intent.putExtra("planeta", "Urano");
                    break;
                case "Netuno":
                    intent.putExtra("planeta", "Netuno");
                    break;
            }
            setResult(1,intent);
            finish();
        }


    }




    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}

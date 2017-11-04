package com.example.vinipachecov.planetsinaspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner planetasspinner;
    private ImageView planeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planeta = (ImageView)findViewById(R.id.planetaimageView);

        planetasspinner = (Spinner)findViewById(R.id.planteasSpinner);

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
        switch(parent.getSelectedItem().toString()){
            case "Mercúrio":
                planeta.setBackgroundResource(R.drawable.mercurio);
                break;
            case "Venus":
                planeta.setBackgroundResource(R.drawable.venus);
                break;
            case "Terra":
                planeta.setBackgroundResource(R.drawable.terra);
                break;
            case "Marte":
                planeta.setBackgroundResource(R.drawable.marte);
                break;
            case "Júpiter":
                planeta.setBackgroundResource(R.drawable.jupiter);
                break;
            case "Saturno":
                planeta.setBackgroundResource(R.drawable.saturno);
                break;
            case "Urano":
                planeta.setBackgroundResource(R.drawable.urano);
                break;
            case "Netuno":
                planeta.setBackgroundResource(R.drawable.netuno);
                break;

        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}

package com.viniciuspv.fontapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    EditText NameTextField,FontSizeTextField,ColorTextField;
    TextView NomeResLabel,FontResLabel,ColorResLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        NameTextField = (EditText)findViewById(R.id.NameTextField);
        FontSizeTextField = (EditText)findViewById(R.id.FontSizeTextField);
        NomeResLabel = (TextView)findViewById(R.id.NomeResLabel);
        FontResLabel = (TextView)findViewById(R.id.FontResLabel);
        ColorResLabel = (TextView)findViewById(R.id.ColorResLabel);
        ColorTextField = (EditText)findViewById(R.id.ColorTextFIeld);
    }

    public void Update(android.view.View v){
        String name = NameTextField.getText().toString();
        String font = FontSizeTextField.getText().toString();
        String color = ColorTextField.getText().toString();
        try {
            ColorResLabel.setTextColor(Color.parseColor("#" + color));
            System.out.println("Valor de " + "#" + color);
        }catch (Exception e){
            ColorResLabel.setText("Valor de Cor Invalido");
            ColorResLabel.setTextColor(Color.BLACK);
        }
        if(Integer.parseInt(font) <= 40  ){
            NomeResLabel.setText(name);
            NomeResLabel.setTextSize(Integer.parseInt(font));
            FontResLabel.setText(font);
        }else
        {
            NomeResLabel.setText(name);
            NomeResLabel.setTextSize(40);
            FontResLabel.setText("40(Max)");
        }


    }
}

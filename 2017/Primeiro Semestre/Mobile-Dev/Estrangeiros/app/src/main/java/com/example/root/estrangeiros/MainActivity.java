package com.example.root.estrangeiros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton brasileiro, estrangeiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brasileiro = (RadioButton) findViewById(R.id.brasileiroradioButton);
        estrangeiro = (RadioButton) findViewById(R.id.estrangeiroradioButton);

    }

    public void tipoNacionalidade(View view){
        Nacionalidade nacio;
        if(brasileiro.isChecked() && view.getId() == R.id.brasileiroradioButton ){
            nacio = new Nacionalidade("brasileiro");
            Toast.makeText(MainActivity.this, nacio.mensagem(),
                    Toast.LENGTH_SHORT).show();
            estrangeiro.setChecked(false);
        }
        if(estrangeiro.isChecked() && view.getId() == R.id.estrangeiroradioButton){
            nacio = new Nacionalidade("estrangeiro");
            Toast.makeText(MainActivity.this, nacio.mensagem(),
                    Toast.LENGTH_SHORT).show();
            brasileiro.setChecked(false);
        }
    }

}

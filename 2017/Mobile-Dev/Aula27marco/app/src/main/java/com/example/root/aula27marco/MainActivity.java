package com.example.root.aula27marco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    public void showImg(View view){
        EditText texto = (EditText) findViewById(R.id.editText);
        ImageView show = (ImageView) findViewById(R.id.imageView);

        switch (texto.getText().toString()){
            case "casa":
                show.setImageResource(R.drawable.casa);
                break;
            case "coqueiro":
                show.setImageResource(R.drawable.coqueiro);
                break;
            case "leao":
                show.setImageResource(R.drawable.leao);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

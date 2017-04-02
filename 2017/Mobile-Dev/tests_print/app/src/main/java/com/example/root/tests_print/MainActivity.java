package com.example.root.tests_print;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
    }

    public void clicou(android.view.View view){
        switch (view.getId()){
            case R.id.button:
                android.util.Log.i("Info", "utton ressed");
        }

    }
}

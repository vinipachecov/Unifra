package com.viniciuspv.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Log.i("TESTES","On create foi executado");
    }

    protected void onStart(){
        super.onStart();
        Log.i("TESTES","onStart foi executado");
    }

    protected void onResume(){
        super.onResume();
        Log.i("TESTES","onResume foi executado");

    }

    protected void onPause(){
        super.onPause();
        Log.i("TESTES","onPause foi executado");

    }

    protected void onStop(){
        super.onStop();
        Log.i("TESTES","onStop foi executado");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i("TESTES","onDestroy foi executado");
    }

    protected void onRestart(){
        super.onRestart();
        Log.i("TESTES","onRestart foi executado");
    }
}

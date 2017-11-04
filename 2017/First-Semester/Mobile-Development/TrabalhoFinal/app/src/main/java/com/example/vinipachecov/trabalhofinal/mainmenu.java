package com.example.vinipachecov.trabalhofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class mainmenu extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://wwww.unifra.br");
    }

    public void openMoodle(View v){
        intent = new Intent(this, MoodleList.class);
        startActivity(intent);
    }

    public void abrirNotas(View v){
        intent = new Intent(this, Notas.class);
        startActivity(intent);
    }

    public void abrirBoleto(View v){
        intent = new Intent(this, Boletos.class);
        startActivity(intent);
    }
}

package com.example.guilherme.aula_animations;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;


public class Principal extends ActionBarActivity {

    ImageView imagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imagem = (ImageView)findViewById(R.id.imageView);
    }

    public void girarClick(View view){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.girar);
        imagem.startAnimation(animation);
    }
    public void zoomClick(View view){
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        imagem.startAnimation(animation1);
    }

    public void fadeClick(View view){
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imagem.startAnimation(animation1);
    }

    public void piscarClick(View view){
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.piscar);
        imagem.startAnimation(animation1);
    }

    public void moverClick(View view){
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mover);
        imagem.startAnimation(animation1);
    }

    public void slideClick(View view){
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        imagem.startAnimation(animation1);
    }

    public void java1Click(View v){
        //cria um conjunto de animações
        AnimationSet animationSet = new AnimationSet(true);//parâmetro tue para usar interpolação
        //cria uma animação de translação
        TranslateAnimation ta = new TranslateAnimation(
                Animation.ABSOLUTE,200, Animation.ABSOLUTE,200,
                Animation.ABSOLUTE,200, Animation.ABSOLUTE,200);
        ta.setDuration(1000); //duração da animação
        animationSet.addAnimation(ta);
        //cria uma animação de rotação
        RotateAnimation tr = new RotateAnimation(0f, -90f,200,200);//do angulo 0 para -90, com ponto pivô (200,200);
        tr.setStartOffset(1000);//delay até a animação começar
        tr.setDuration(1000); //duração da animação
        animationSet.addAnimation(tr);

        //adiciona a animação ao ImageView
        imagem.startAnimation(animationSet);//ambas as animações começam instantaneamente

    }

    public void java2Click(View v){
        final float aumentarPara = 1.2f;
        ScaleAnimation aumentar = new ScaleAnimation(1, aumentarPara, 1, aumentarPara,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        aumentar.setDuration(600);

        ScaleAnimation encolher = new ScaleAnimation(aumentarPara, 1, aumentarPara, 1,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        encolher.setDuration(600);
        encolher.setStartOffset(600);//já essa animação começa 600milisegundos depois do "startAnimation", enquanto que a anterior começa instantaneamente

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.addAnimation(aumentar);
        animationSet.addAnimation(encolher);
        //animationSet.setFillAfter(true); para manter o estado após a animação terminar
        imagem.startAnimation(animationSet);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

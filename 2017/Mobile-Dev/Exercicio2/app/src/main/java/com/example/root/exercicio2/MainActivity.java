package com.example.root.exercicio2;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/*2) Insira uma imagem na tela de uma aplicação Android, e então pesquise como identificar, ao clicar sobre a imagem, as seguintes informações:

    Posição (x, y) onde o clique foi feito.
    Dica: você precisara implementar o evento onTouch
    Cor dos níveis RGB do píxel da posição (x,y) onde foi feito o click.
    Dica: você precisará extrair o Bitmap do ImageView.
    Apresente estas informações na tela.
*/



public class MainActivity extends AppCompatActivity {

    ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView);
    }
    public void clicked(View view ){
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float X = event.getX();
                float Y = event.getY();
                Log.i("Tocou", "onTouch: X=" +X + "  Y= " + Y);
                Bitmap btm =  ((BitmapDrawable)img.getDrawable()).getBitmap();
                int pixel = btm.getPixel((int)X,(int)Y);
                int redValue = Color.red(pixel);
                int blueValue = Color.blue(pixel);
                int greenValue = Color.green(pixel);
                Log.i("Color", "onTouch: R = "+ redValue + " G =" + greenValue + " B = " + blueValue );
                return false;
            }
        });


        //Log.i("Bitmap", "");
    }
}

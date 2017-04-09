package com.example.root.tictactoeimageviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView player;
    ImageView top1ImageView, top2ImageView, top3ImageView, mid1ImageView, mid2ImageView, mid3ImageView, bot1ImageView,
            bot2ImageView, bot3ImageView;
    Jogo jogo;


    public void initializewidgets(){
        jogo = new Jogo();
        top1ImageView = (ImageView) findViewById(R.id.top1ImageView);
        top2ImageView = (ImageView) findViewById(R.id.top2ImageView);
        top3ImageView = (ImageView) findViewById(R.id.top3ImageView);
        mid1ImageView = (ImageView) findViewById(R.id.mid1ImageView);
        mid2ImageView = (ImageView) findViewById(R.id.mid2ImageView);
        mid3ImageView = (ImageView) findViewById(R.id.mid3ImageView);
        bot1ImageView = (ImageView) findViewById(R.id.bot1ImageView);
        bot2ImageView = (ImageView) findViewById(R.id.bot2ImageView);
        bot3ImageView = (ImageView) findViewById(R.id.bot3ImageView);
        player = (TextView) findViewById(R.id.Player);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializewidgets();
    }



    public void playerturn(android.view.View v){
        switch (player.getText().toString()){
            case "Jogador 1":
                findbutton(v, true);
                break;
            case "Jogador 2":
                findbutton(v, false);
                break;
        }
    }

    public void findbutton(android.view.View v, boolean player1){
        String vitoria;
        switch (v.getId()){
            case R.id.top1ImageView:
                addMarker(top1ImageView,player1);
                jogo.addMove(player1,0,0);
                break;
            case R.id.top2ImageView:
                addMarker(top2ImageView,player1);
                jogo.addMove(player1,0,1);
                break;
            case R.id.top3ImageView:
                addMarker(top3ImageView,player1);

                jogo.addMove(player1,0,2);
                break;
            case R.id.mid1ImageView:
                addMarker(mid1ImageView,player1);
                jogo.addMove(player1,1,0);
                break;
            case R.id.mid2ImageView:
                addMarker(mid2ImageView,player1);
                jogo.addMove(player1,1,1);
                break;
            case R.id.mid3ImageView:
                addMarker(mid3ImageView,player1);
                jogo.addMove(player1,1,2);
                break;
            case R.id.bot1ImageView:
                addMarker(bot1ImageView,player1);
                jogo.addMove(player1,2,0);
                break;
            case R.id.bot2ImageView:
                addMarker(bot2ImageView,player1);
                jogo.addMove(player1,2,1);
                break;
            case R.id.bot3ImageView:
                addMarker(bot3ImageView,player1);
                jogo.addMove(player1,2,2);
                break;
        }
        vitoria = jogo.checkWin();
        if(vitoria != null &&  vitoria == "p1 Ganhou"){
            player.setText("Jogador 1 Ganhou");
        }
        else if(vitoria != null &&  vitoria == "p2 Ganhou")
            player.setText("Jogador 2 Ganhou");

    }

    public void addMarker(ImageView imgview, boolean player1){
        if(player1){
            imgview.setImageResource(R.drawable.xmark);
            player.setText("Jogador 2");
        }else{
            imgview.setImageResource(R.drawable.circlemark);
            player.setText("Jogador 1");
        }
    }


}

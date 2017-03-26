package com.example.root.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView player;
    Button upbutton1, upbutton2, upbutton3, midbutton1,midbutton2,midbutton3, bottombutton1,
    bottombutton2, bottombutton3;
    Jogo jogo;
    int jogadas = 0;

    public void initializewidgets(){
        jogo = new Jogo();
        upbutton1 = (Button) findViewById(R.id.upbutton1);
        upbutton2 = (Button) findViewById(R.id.upbutton2);
        upbutton3 = (Button) findViewById(R.id.upbutton3);
        midbutton1 = (Button) findViewById(R.id.midbutton1);
        midbutton2 = (Button) findViewById(R.id.midbutton2);
        midbutton3 = (Button) findViewById(R.id.midbutton3);
        bottombutton1 = (Button) findViewById(R.id.bottombutton1);
        bottombutton2 = (Button) findViewById(R.id.bottombutton2);
        bottombutton3 = (Button) findViewById(R.id.bottombutton3);
        player = (TextView) findViewById(R.id.Player);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
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
            case R.id.upbutton1:
                addMarker(upbutton1,player1);
                jogo.addMove(player1,0,0);
                break;
            case R.id.upbutton2:
                addMarker(upbutton2,player1);
                jogo.addMove(player1,0,1);
                break;
            case R.id.upbutton3:
                addMarker(upbutton3,player1);
                jogo.addMove(player1,0,2);
                break;
            case R.id.midbutton1:
                addMarker(midbutton1,player1);
                jogo.addMove(player1,1,0);
                break;
            case R.id.midbutton2:
                addMarker(midbutton2,player1);
                jogo.addMove(player1,1,1);
                break;
            case R.id.midbutton3:
                addMarker(midbutton3,player1);
                jogo.addMove(player1,1,2);
                break;
            case R.id.bottombutton1:
                addMarker(bottombutton1,player1);
                jogo.addMove(player1,2,0);
                break;
            case R.id.bottombutton2:
                addMarker(bottombutton2,player1);
                jogo.addMove(player1,2,1);
                break;
            case R.id.bottombutton3:
                addMarker(bottombutton3,player1);
                jogo.addMove(player1,2,2);
                break;
        }
        vitoria = jogo.checkWin();
        if(vitoria != null &&  vitoria == "p1 Ganhou"){
            player.setText("p1 Ganhou");
        }
        else if(vitoria != null &&  vitoria == "p2 Ganhou")
            player.setText("p2 Ganhou");

    }

    public void addMarker(Button btn, boolean player1){
        if(player1){
            btn.setText("X");
            player.setText("Jogador 2");
        }else{
            btn.setText("O");
            player.setText("Jogador 1");
        }
    }

}

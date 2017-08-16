package com.example.root.tictactoeimageviews;

/**
 * Created by root on 3/23/17.
 */

public class Jogo {
    int [][]mat;

    public Jogo(){
        mat = new int[3][];
        for (int i = 0; i < 3; i++) {
            mat[i] = new int[3];
            for (int j = 0; j < 3; j++){
                mat[i][j] = 0;
            }
        }
    }

    public void addMove(boolean player1,int i, int j){
        if(player1){
            mat[i][j] = 1;
        }else{
            mat[i][j] = 2;
        }
    }

    public String checkWin(){
        //horizontal
        int contp1h = 0;
        int contp2h = 0;
        int contp1v = 0;
        int contp2v = 0;
        int contp1d = 0;
        int contp2d = 0;
        for (int i = 0; i < 3; i++) {
            contp1h = 0;
            contp2h = 0;
            for (int j = 0; j < 3; j++) {
                //verifica horizontal
                if(mat[i][j] == 1){
                    contp1h +=1;
                    contp2h = 0;
                }
                if(mat[i][j] == 2){
                    contp2h +=1;
                    contp1h = 0;
                }
                if(contp1h == 3){
                    //ganhou p1
                    return "p1 Ganhou";
                }
                if(contp2h == 3){
                    //ganhou p2
                    return "p2 Ganhou";
                }
                
            }
        }


//        // verifica vertical
        for (int j = 0; j < 3; j++) {
            contp1v = 0;
            contp2v = 0;
            for (int i = 0; i < 3; i++) {
                if(mat[i][j] == 1){
                    contp1v +=1;
                    contp2v = 0;
                }
                if(mat[i][j] == 2){
                    contp2v +=1;
                    contp1v = 0;
                }
                if(contp1v == 3){
                    //ganhou p1
                    return "p1 Ganhou";
                }
                if(contp2v == 3){
                    //ganhou p2
                    return "p2 Ganhou";
                }
            }
        }
        //verificar diagonal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j){
                    if(mat[i][j] == 1){
                        contp1d +=1;
                        contp2d = 0;
                    }
                    if(mat[i][j] == 2){
                        contp2d +=1;
                        contp1d = 0;
                    }
                    if(contp1d == 3){
                        //ganhou p1
                        return "p1 Ganhou";
                    }
                    if(contp2d == 3){
                        //ganhou p2
                        return "p2 Ganhou";
                    }
                }
            }
        }
        contp1d = 0;
        contp2d = 0;
        int i , j;
        //diagonal inversa
        for (i = 2, j = 0; i>=0 && j<3 ; i--,j++ ){
            if(mat[i][j] == 1){
                contp1d +=1;
                contp2d = 0;
            }
            if(mat[i][j] == 2){
                contp2d +=1;
                contp1d = 0;
            }
            if(contp1d == 3){
                //ganhou p1
                return "p1 Ganhou";
            }
            if(contp2d == 3){
                //ganhou p2
                return "p2 Ganhou";
            }
        }
        return null;
    }
}

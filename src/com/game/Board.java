package com.game;


/**
 * Created by marco on 25.07.17.
 */
public class Board {

    public Board() {
        Property[] board= new com.game.Property[20];
        for (int i1=0;i1<board.length;i1++){
            board[i1].setName("Square "+i1);
        }

            }

}

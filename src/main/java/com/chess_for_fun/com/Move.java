package com.chess_for_fun.com;

import com.chess_for_fun.com.Pieces.Piece;

public class Move {
    private int startX, startY, endX, endY;
    private Piece pieceMoved;


    public Move(int startX, int startY, int endX, int endY, Piece pieceMoved){
       this.startX = startX;
       this.startY = startY;
       this.endX = endX;
       this.endY = endY;
       this.pieceMoved = pieceMoved;
    }


    public Piece getPiecedMoved(){
        return pieceMoved;
    }

    public int getStartX(){
        return startX;
    }

    public int getStartY(){
        return startY;
    }

    public int getEndX(){
        return endX;
    }

    public int getEndY(){
        return endY;
    }

    
}

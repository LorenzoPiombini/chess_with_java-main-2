package com.chess_for_fun.com.Pieces;

import com.chess_for_fun.com.ChessBoard;

public class Bishop extends Piece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        return  false;
    }

   
    
}

package com.chess_for_fun.com.Pieces;

import com.chess_for_fun.com.ChessBoard;

public class Knight extends Piece {

    public Knight(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        return  false;
    }

    
    
}

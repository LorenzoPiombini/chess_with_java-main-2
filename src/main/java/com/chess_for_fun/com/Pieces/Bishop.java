package com.chess_for_fun.com.Pieces;

import com.chess_for_fun.com.ChessBoard;

public class Bishop extends Piece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {

        if (canMoveTo(startX, startY, endX, endY, board) && (Math.abs(startX - endX) == Math.abs(endY - startY))) {
            return true;
        }

        return false;
    }

}

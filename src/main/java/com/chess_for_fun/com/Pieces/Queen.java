package com.chess_for_fun.com.Pieces;

import com.chess_for_fun.com.ChessBoard;

public class Queen extends Piece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        if (canMoveTo(startX, startY, endX, endY, board) &&
                !knightMove(startX, startY, endX, endY)) {
            return true;
        }

        return false;
    }

}

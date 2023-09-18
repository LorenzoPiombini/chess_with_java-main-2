package com.chess_for_fun.com.Pieces;

import com.chess_for_fun.com.ChessBoard;

public class Rook extends Piece {

    private boolean hasMoved = false;

    public Rook(String color) {
        super(color);

    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard chessBoard) {
        if (!canMoveTo(startX, startY, endX, endY, chessBoard))
            return false;

        Piece[][] board = chessBoard.getBoard();

        // horizontal move
        if (startY == endY) {
            int step = (startX < endX) ? 1 : -1;
            for (int x = startX + step; x != endX; x += step) {
                if (board[x][startY] != null)
                    return false;
            }

            return true;
        }

        // vertical move
        if (startX == endX) {
            int step = (startY < endY) ? 1 : -1;

            for (int y = startY + step; y != endY; y += step) {
                if (board[startX][y] != null)
                    return false;
            }
            return true;
        }

        return false;

    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean condition) {
        this.hasMoved = condition;
    }

}

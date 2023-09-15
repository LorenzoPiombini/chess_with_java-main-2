package com.chess_for_fun.com.Pieces;

import com.chess_for_fun.com.ChessBoard;
import com.chess_for_fun.com.Move;
import com.chess_for_fun.com.Constants.Constant;

public class Pawn extends Piece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard chessBoard) {
        if (!canMoveTo(startX, startY, endX, endY, chessBoard)) {
            return false;
        }

        int direction = (super.getColor().equals(Constant.W)) ? -1 : 1;
        Piece[][] board = chessBoard.getBoard();
        Move lastMove = chessBoard.getLastMove();

        // move forward by one square
        if (startX + direction == endX && startY == endY) {
            return (board[endX][endY] == null);
        }

        // initial two square move
        if (this.getColor().equals(Constant.W) && startX == 6 && startX + 2 * direction == endX && startY == endY) {
            return (board[endX][endY] == null && board[startX + direction][startY] == null);
        }

        if (this.getColor().equals(Constant.B) && startX == 1 && startY + 2 * direction == endX && startY == endY) {
            return (board[endX][endY] == null && board[endX][startY + direction] == null);
        }

        // diagonal capture
        if ((Math.abs(startY - endY) == 1) && startX + direction == endX) {
            Piece target = board[endX][endY];
            if (target != null && !target.getColor().equals(this.getColor())) {
                return true;
            }
        }

        // en passant move
        if (lastMove != null
                && lastMove.getPiecedMoved() instanceof Pawn
                && Math.abs(lastMove.getStartX() - lastMove.getEndX()) == 2
                && ((lastMove.getEndX() == startX + 1) || (lastMove.getEndX() == startX - 1))
                && Math.abs(lastMove.getEndY() - startY) == 1) {

            return true;
        }

        // promotion logic
        if (((this.color.equals(Constant.W) && endY == 0) || this.color.equals(Constant.B) && endY == 7)) {
            return true;
        }

        return false;
    }

}

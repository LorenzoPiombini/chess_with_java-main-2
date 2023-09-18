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
        if (startY + direction == endY && startX == endX) {
            return (board[endX][endY] == null);
        }

        // initial two square move
        if (this.getColor().equals(Constant.W) && startY == 6 && startY + 2 * direction == endY && startX == endX) {
            return (board[endX][endY] == null && board[startX][startY + direction] == null);
        }

        if (this.getColor().equals(Constant.B) && startY == 1 && startY + 2 * direction == endY && startX == endX) {
            return (board[endX][endY] == null && board[endX][startY + direction] == null);
        }

        // diagonal capture
        if ((Math.abs(startX - endX) == 1) && startY + direction == endY) {
            Piece target = board[endX][endY];
            if (target != null && !target.getColor().equals(this.getColor())) {
                return true;
            }
        }

        // en passant move
        if (lastMove != null
                && lastMove.getPiecedMoved() instanceof Pawn
                && Math.abs(lastMove.getStartY() - lastMove.getEndY()) == 2
                && ((lastMove.getEndX() == startX + 1) || (lastMove.getEndX() == startX - 1))
                && Math.abs(lastMove.getEndY() - startY) == 0) {

            return true;
        }

        // promotion logic
        if (((this.color.equals(Constant.W) && endY == 0) || this.color.equals(Constant.B) && endY == 7)) {
            return true;
        }

        return false;
    }

}

package com.chess_for_fun.com.Pieces;

import com.chess_for_fun.com.ChessBoard;

public abstract class Piece {
    protected String color;
    protected int currentX;
    protected int currentY;

    public Piece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board);

    protected boolean canMoveTo(int startX, int startY, int endX, int endY, ChessBoard chessBoard) {

        if (outOfBoard(startX, startY, endX, endY)) {
            return false;
        }

        Piece destinationPiece = chessBoard.getPiece(endX, endY);
        if (destinationPiece != null && destinationPiece.getColor().equals(this.getColor())) {
            return false;
        }

        if (!(this instanceof Knight) || !((this instanceof Queen) && knightMove(startX, startY, endX, endY))) {// this
                                                                                                                // code
                                                                                                                // will
                                                                                                                // execute
                                                                                                                // for
                                                                                                                // all
                                                                                                                // pieces
                                                                                                                // but
                                                                                                                // knights
            int xDirection = (endX > startX) ? 1 : endX < startX ? -1 : 0;
            int yDirection = (endY > startY) ? 1 : endY < startY ? -1 : 0;

            int x = startX + xDirection;
            int y = startY + yDirection;

            while (x != endX || y != endY) {
                if (chessBoard.getPiece(x, y) != null) {
                    return false; // There`s a piece in the way
                }

                // if statemnts to avoid to go outOfBoard
                if (!(x == endX))
                    x += xDirection;

                if (!(y == endY))
                    y += yDirection;
            }
        }

        return true;
    }

    public boolean knightMove(int startX, int startY, int endX, int endY) {
        return (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 2) ||
                (Math.abs(startX - endX) == 2 && Math.abs(startY - endY) == 1);
    }

    public boolean outOfBoard(int startX, int startY, int endX, int endY) {
        return (startX >= 8 || startX < 0) || (startY >= 8 || startY < 0)
                || (endX >= 8 || endX < 0) || (endY >= 8 || endY < 0);
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentPosition(int x, int y) {
        this.currentX = x;
        this.currentY = y;
    }

    @Override
    public String toString() {
        return "the piece is a " + this.getColor() + " " + this.getClass().getSimpleName();
    }

}

package com.chess_for_fun.com.Pieces;

import com.chess_for_fun.com.ChessBoard;

public class King extends Piece {

    private boolean hasMoved = false;

    public King(String color) {
        super(color);

    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        return (canMoveTo(startX, startY, endX, endY, board) || canCastle(startX, startY, endY, board));
    }

    public boolean canCastle(int startX, int startY, int endY, ChessBoard chessBoard) {
        if (hasMoved || isCheck(chessBoard))
            return false;

        return (endY == startY + 2 && canCastlingKingSide(startX, startY, chessBoard)) ||
                (endY == startY - 2 && canCastlingQueenSide(startX, startY, chessBoard));

    }

    private boolean canCastlingQueenSide(int startX, int startY, ChessBoard chessBoard) {
        Piece rook = chessBoard.getPiece(startX, startY - 4);

        if (rook instanceof Rook && rook.getColor().equals(this.getColor()) && !((Rook) rook).getHasMoved()) {
            for (int i = startY - 1; i >= startY - 3; i--) {
                if (chessBoard.getPiece(startX, i) != null)
                    return false;

                // check if the square is under attack
                if (chessBoard.isTheSquareUnderAttack(startX, i, this.color))
                    return false;

            }
        }
        return true;
    }

    private boolean canCastlingKingSide(int startX, int startY, ChessBoard chessBoard) {
        Piece rook = chessBoard.getPiece(startX, startY + 3);

        if (rook instanceof Rook && rook.getColor().equals(this.color) && !((Rook) rook).getHasMoved()) {

            for (int i = currentY + 1; i <= currentY + 2; i++) {

                // check if there are pieces on the way
                if (chessBoard.getPiece(startX, i) != null)
                    return false;

                // check if the square is under attack
                if (chessBoard.isTheSquareUnderAttack(startX, i, this.color))
                    return false;

            }
        }
        return true;
    }

    // check if the king is under check
    private boolean isCheck(ChessBoard board) {
        int[] kingPos = new int[] { getCurrentX(), getCurrentY() };
        return board.isTheSquareUnderAttack(kingPos[0], kingPos[1], getColor());
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean condition) {
        this.hasMoved = condition;
    }

}

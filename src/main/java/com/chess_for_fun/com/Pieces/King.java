package com.chess_for_fun.com.Pieces;

import com.chess_for_fun.com.ChessBoard;

public class King extends Piece {

    private boolean hasMoved = false;

    public King(String color) {
        super(color);

    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, ChessBoard board) {
        return (!board.isTheSquareUnderAttack(endX, endY, color) && canMoveTo(startX, startY, endX, endY, board)
                || canCastle(startX, startY, endY, board));
    }

    public boolean canCastle(int startX, int startY, int endX, ChessBoard chessBoard) {
        if (hasMoved || isCheck(chessBoard))
            return false;

        return (endX == startX + 2 && canCastlingKingSide(startX, startY, chessBoard)) ||
                (endX == startX - 2 && canCastlingQueenSide(startX, startY, chessBoard));

    }

    private boolean canCastlingQueenSide(int startX, int startY, ChessBoard chessBoard) {
        Piece rook = chessBoard.getPiece(startX - 4, startY);

        if (rook instanceof Rook && rook.getColor().equals(this.getColor()) && !((Rook) rook).getHasMoved()) {
            for (int i = startX - 1; i >= startX - 3; i--) {
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

            for (int i = currentX + 1; i <= currentX + 2; i++) {

                // check if there are pieces on the way
                if (chessBoard.getPiece(i, startY) != null)
                    return false;

                // check if the square is under attack
                if (chessBoard.isTheSquareUnderAttack(i, startY, this.color))
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

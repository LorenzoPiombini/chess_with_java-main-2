package com.chess_for_fun.com;

import java.util.ArrayList;
import java.util.List;

import com.chess_for_fun.com.Constants.Constant;
import com.chess_for_fun.com.Pieces.Bishop;
import com.chess_for_fun.com.Pieces.King;
import com.chess_for_fun.com.Pieces.Knight;
import com.chess_for_fun.com.Pieces.Pawn;
import com.chess_for_fun.com.Pieces.Piece;
import com.chess_for_fun.com.Pieces.Queen;
import com.chess_for_fun.com.Pieces.Rook;

public class ChessBoard {
    private Piece[][] board;
    private Move lastMove;
    private List<Piece> caputrePieces = new ArrayList<>();

    public ChessBoard() {
        board = new Piece[8][8];
        setUpBoard();
    }

    private void setUpBoard() {
        for (int x = 0; x < 8; x++) {
            board[x][1] = new Pawn(Constant.B);
            board[x][6] = new Pawn(Constant.W);
        }

        board[0][0] = new Rook(Constant.B);
        board[7][0] = new Rook(Constant.B);
        board[0][7] = new Rook(Constant.W);
        board[7][7] = new Rook(Constant.W);

        board[1][0] = new Knight(Constant.B);
        board[6][0] = new Knight(Constant.B);
        board[1][7] = new Knight(Constant.W);
        board[6][7] = new Knight(Constant.W);

        board[2][0] = new Bishop(Constant.B);
        board[5][0] = new Bishop(Constant.B);
        board[2][7] = new Bishop(Constant.W);
        board[5][7] = new Bishop(Constant.W);

        board[4][0] = new Queen(Constant.B);
        board[3][0] = new King(Constant.B);
        King kingB = (King) getPiece(3, 0);
        kingB.setCurrentPosition(3, 0);

        board[4][7] = new Queen(Constant.W);
        board[3][7] = new King(Constant.W);
        King kingW = (King) getPiece(3, 7);
        kingW.setCurrentPosition(3, 7);
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public Move getLastMove() {
        return lastMove;
    }

    public List<Piece> getCaputeredPieces() {
        return caputrePieces;
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = getPiece(startX, startY);

        if (piece == null) {
            return false;
        }

        System.out.println(piece.toString());

        if (piece.isValidMove(startX, startY, endX, endY, this)) {

            Piece targetPiece = getPiece(endX, endY);

            if (targetPiece != null) {
                caputrePieces.add(targetPiece);
            }

            if (piece instanceof King && Math.abs(endY - startY) == 2) {
                King king = (King) piece;
                if (king.canCastle(startX, startY, endY, this)) {
                    Rook rook;
                    if (endY > startY) {
                        // King side castling
                        rook = (Rook) getPiece(startX, startY + 3);
                        board[startX][startY + 1] = rook;
                        board[startX][startY + 3] = null;
                        rook.setCurrentPosition(startX, startY + 1);
                    } else {
                        // Queen side castling
                        rook = (Rook) getPiece(startX, startY - 4);
                        board[startX][startY - 1] = rook;
                        board[startX][startY - 4] = null;
                        rook.setCurrentPosition(startX, startY - 1);
                    }
                    // Adjust King position for castling
                    board[endX][endY] = king;
                    board[startX][startY] = null;
                    king.setCurrentPosition(endX, endY);

                    rook.setHasMoved(true);
                    king.setHasMoved(true);
                } else {
                    return false; // invalid castling move
                }
            } else {

                board[endX][endY] = piece;
                board[startX][startY] = null;
                piece.setCurrentPosition(endX, endY);

                if (piece instanceof Rook) {
                    ((Rook) piece).setHasMoved(true);
                }

                if (piece instanceof King) {
                    ((King) piece).setHasMoved(true);
                }

            }

            setLastMove(new Move(startX, startY, endX, endY, piece));
            return true;
        }

        return false;
    }

    public boolean isTheSquareUnderAttack(int targetX, int targetY, String defendinColor) {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = getPiece(x, y);

                if (piece != null && !piece.getColor().equals(defendinColor)) {
                    if (piece instanceof King) {
                        if (Math.abs(targetX - x) <= 1 && Math.abs(targetY - y) <= 1) {
                            return true;
                        }
                    } else {
                        if (piece.isValidMove(x, y, targetX, targetY, this))
                            return true;
                    }

                }
            }
        }
        return false;
    }

    public void capture(int endX, int endY) {
        board[endX][endY] = null;
    }

    // only for test and debug
    public void placeApieceInThisSquare(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    public void setLastMove(Move move) {
        this.lastMove = move;
    }

    // only for testing
    public void clearBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                board[x][y] = null;
            }

        }
    }

}

package com.chess_for_fun.com;

import com.chess_for_fun.com.Constants.Constant;
import com.chess_for_fun.com.Pieces.King;
import com.chess_for_fun.com.Pieces.Rook;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KingTest {

    @Test
    public void testValidKingMove() {
        ChessBoard board = new ChessBoard();

        King whiteKing = (King) board.getPiece(3, 7);

        assertFalse(whiteKing.isValidMove(3, 7, 3, 6, board)); // should return false becasue there's a pawn in 6,3
        assertFalse(whiteKing.isValidMove(3, 7, 2, 7, board)); // should return false
        // because there's a bishop in 2,7
        assertFalse(whiteKing.canCastle(3, 7, 6, board)); // should return false
        // becasue you can`t castle at the beginning of the game, since the pieces are
        // all in place.

    }

    @Test
    public void kingBasicMove() {
        ChessBoard board = new ChessBoard();
        board.clearBoard();

        King whiteKing = new King(Constant.W);
        board.placeApieceInThisSquare(3, 3, whiteKing);

        // moves in all directions
        assertTrue(whiteKing.isValidMove(3, 3, 4, 3, board));
        assertTrue(whiteKing.isValidMove(3, 3, 3, 4, board));
        assertTrue(whiteKing.isValidMove(3, 3, 4, 4, board));
        assertTrue(whiteKing.isValidMove(3, 3, 3, 2, board));
        assertTrue(whiteKing.isValidMove(3, 3, 2, 2, board));
        assertTrue(whiteKing.isValidMove(3, 3, 2, 4, board));
        assertTrue(whiteKing.isValidMove(3, 3, 2, 4, board));

    }

    @Test
    public void kingCannotMoveIntoCheck() {
        ChessBoard board = new ChessBoard();
        board.clearBoard();

        King whiteKing = new King(Constant.W);
        Rook blackRook = new Rook(Constant.B);

        board.placeApieceInThisSquare(0, 3, blackRook);
        board.placeApieceInThisSquare(2, 4, whiteKing);

        assertFalse(whiteKing.isValidMove(2, 4, 2, 3, board));
    }

    @Test
    public void kingastling() {
        ChessBoard board = new ChessBoard();

        board.clearBoard();

        King whiteKing = new King(Constant.W);
        Rook whiteRookRight = new Rook(Constant.W);
        Rook whiteRookLeft = new Rook(Constant.W);

        board.placeApieceInThisSquare(7, 7, whiteRookRight);
        board.placeApieceInThisSquare(3, 7, whiteKing);
        board.placeApieceInThisSquare(0, 7, whiteRookLeft);

        assertTrue(whiteKing.isValidMove(3, 7, 6, 7, board)); // castling on the right
        assertTrue(whiteKing.isValidMove(3, 7, 2, 7, board)); // castling on the left

    }
}

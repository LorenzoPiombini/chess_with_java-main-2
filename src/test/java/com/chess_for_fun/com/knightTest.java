package com.chess_for_fun.com;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.chess_for_fun.com.Constants.Constant;
import com.chess_for_fun.com.Pieces.Knight;

public class knightTest {

    @Test
    public void knightValidMove() {
        ChessBoard board = new ChessBoard();
        board.clearBoard();

        Knight leftWhiteKnight = new Knight(Constant.W);
        Knight leftBlackKnight = new Knight(Constant.B);

        board.placeApieceInThisSquare(1, 7, leftWhiteKnight);
        board.placeApieceInThisSquare(1, 0, leftBlackKnight);

        assertTrue(leftWhiteKnight.isValidMove(1, 7, 0, 5, board));
        assertTrue(leftWhiteKnight.isValidMove(1, 7, 2, 5, board));

        board.capture(1, 7);// we delete the leftWhiteKnight in the board as per line 20
        board.placeApieceInThisSquare(0, 5, leftWhiteKnight);

        assertTrue(leftWhiteKnight.isValidMove(0, 5, 1, 7, board));
        assertTrue(leftWhiteKnight.isValidMove(0, 5, 2, 4, board));
        assertTrue(leftWhiteKnight.isValidMove(0, 5, 1, 3, board));
        assertFalse(leftWhiteKnight.isValidMove(0, 5, -1, 3, board));// out of board

    }
}

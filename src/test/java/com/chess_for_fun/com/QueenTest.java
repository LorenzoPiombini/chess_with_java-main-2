package com.chess_for_fun.com;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.chess_for_fun.com.Constants.Constant;
import com.chess_for_fun.com.Pieces.Queen;

public class QueenTest {

    @Test
    public void queenValidMoves() {
        ChessBoard board = new ChessBoard();
        board.clearBoard();

        Queen blackQueen = new Queen(Constant.B);

        board.placeApieceInThisSquare(4, 0, blackQueen);

        assertTrue(blackQueen.isValidMove(4, 0, 4, 3, board));
        assertTrue(blackQueen.isValidMove(4, 0, 7, 3, board));
        assertTrue(blackQueen.isValidMove(4, 0, 0, 4, board));

        // knight move, so it should return false
        assertFalse(blackQueen.isValidMove(4, 0, 3, 2, board));
    }
}

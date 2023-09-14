package com.chess_for_fun.com;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.chess_for_fun.com.Constants.Constant;
import com.chess_for_fun.com.Pieces.Pawn;
import com.chess_for_fun.com.Pieces.Queen;

public class PawnTest {

    @Test
    public void testInitialWhitePawnMove() {
        ChessBoard board = new ChessBoard();

        Pawn whitePawn = (Pawn) board.getPiece(6, 1);

        assertNotNull(whitePawn);
        assertTrue(whitePawn.isValidMove(6, 1, 4, 1, board)); // 2 step valid move
        assertFalse(whitePawn.isValidMove(6, 1, 3, 1, board));// 3 step invalid move
        assertTrue(whitePawn.isValidMove(6, 1, 5, 1, board)); // 1 step valid move
    }

    @Test
    public void testInitialBlackPawnMove() {
        ChessBoard board = new ChessBoard();

        Pawn blackPawn = (Pawn) board.getPiece(1, 1);

        assertNotNull(blackPawn);

        assertFalse(blackPawn.isValidMove(1, 1, 4, 1, board));// 3 step invalid move
        assertTrue(blackPawn.isValidMove(1, 1, 3, 1, board));// 2 step valid move
        assertTrue(blackPawn.isValidMove(1, 1, 2, 1, board));// 1 step valid move
    }

    @Test
    public void testBlackPawnBlockedByOwnPiece() {
        ChessBoard board = new ChessBoard();
        Pawn blackPawn = (Pawn) board.getPiece(1, 1);
        Pawn whitePawn = (Pawn) board.getPiece(6, 1);

        Queen blackQueen = (Queen) board.getPiece(0, 3);
        Queen whiteQueen = (Queen) board.getPiece(7, 3);

        // putting the queens in the way
        board.placeApieceInThisSquare(2, 1, blackQueen);
        board.placeApieceInThisSquare(5, 1, whiteQueen);

        // 1 step valid move, however should return false because we put the queens in
        // square 2,1 and square 5,1, which is exatly in front of the
        assertFalse(blackPawn.isValidMove(1, 1, 2, 1, board));
        assertFalse(whitePawn.isValidMove(6, 1, 5, 1, board));

    }

}

package com.chess_for_fun.com;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.chess_for_fun.com.Pieces.Pawn;
import com.chess_for_fun.com.Pieces.Queen;

public class PawnTest {

    @Test
    public void testInitialWhitePawnMove() {
        ChessBoard board = new ChessBoard();

        Pawn whitePawn = (Pawn) board.getPiece(1, 6);

        assertNotNull(whitePawn);
        assertTrue(whitePawn.isValidMove(1, 6, 1, 4, board)); // 2 step valid move
        assertFalse(whitePawn.isValidMove(1, 6, 3, 1, board));// 3 step invalid move
        assertTrue(whitePawn.isValidMove(1, 6, 1, 5, board)); // 1 step valid move
    }

    @Test
    public void testInitialBlackPawnMove() {
        ChessBoard board = new ChessBoard();

        Pawn blackPawn = (Pawn) board.getPiece(1, 1);

        assertNotNull(blackPawn);

        assertFalse(blackPawn.isValidMove(1, 1, 4, 1, board));// 3 step invalid move
        assertTrue(blackPawn.isValidMove(1, 1, 1, 3, board));// 2 step valid move
        assertTrue(blackPawn.isValidMove(1, 1, 1, 2, board));// 1 step valid move
    }

    @Test
    public void testBlackPawnBlockedByOwnPiece() {
        ChessBoard board = new ChessBoard();
        Pawn blackPawn = (Pawn) board.getPiece(1, 1);
        Pawn whitePawn = (Pawn) board.getPiece(1, 6);

        Queen blackQueen = (Queen) board.getPiece(4, 0);
        Queen whiteQueen = (Queen) board.getPiece(4, 7);

        // putting the queens in the way
        board.placeApieceInThisSquare(1, 2, blackQueen);
        board.placeApieceInThisSquare(1, 5, whiteQueen);

        // 1 step valid move, however should return false because we put the queens in
        // square 2,1 and square 5,1, which is exatly in front of the
        assertFalse(blackPawn.isValidMove(1, 1, 1, 2, board));
        assertFalse(whitePawn.isValidMove(1, 6, 1, 5, board));

    }

    @Test
    public void testWhitePawnCapture() {
        ChessBoard board = new ChessBoard();

        Pawn whitePawn = (Pawn) board.getPiece(0, 6);
        Pawn blackPawn = (Pawn) board.getPiece(1, 1);

        board.placeApieceInThisSquare(1, 5, blackPawn);// placing the black pawn in 5,0 ready to be capture

        assertTrue(whitePawn.isValidMove(0, 6, 1, 5, board));// capturing the black pawn

    }

    @Test
    public void testBlackPawnCapture() {
        ChessBoard board = new ChessBoard();

        Pawn blackPawn = (Pawn) board.getPiece(0, 1);
        Pawn blackPawn2 = (Pawn) board.getPiece(2, 1);
        Pawn whitePawn = (Pawn) board.getPiece(1, 6);

        board.placeApieceInThisSquare(1, 2, whitePawn);// placing the white pawn in 2,0 ready to be capture

        assertTrue(blackPawn.isValidMove(0, 1, 1, 2, board));// capturing the white pawn
        assertTrue(blackPawn2.isValidMove(2, 1, 1, 2, board));// capturing withe pawn with the other black pawn, return
                                                              // true as expected

    }

    @Test
    public void testBlackPawnEnPassant() {
        ChessBoard board = new ChessBoard();

        Pawn blackPawn = (Pawn) board.getPiece(1, 1);

        board.placeApieceInThisSquare(1, 4, blackPawn);

        board.movePiece(2, 6, 2, 4); // moving a white pawn in square 2,4

        assertTrue(blackPawn.isValidMove(1, 4, 2, 5, board));
    }

    @Test
    public void testWhitePawnEnpassant() {
        ChessBoard board = new ChessBoard();

        Pawn whitePawn = (Pawn) board.getPiece(1, 6);

        board.placeApieceInThisSquare(1, 3, whitePawn); // place the white pawn in 3,2

        board.movePiece(0, 1, 0, 3);// first move two square a black Pawn

        assertTrue(whitePawn.isValidMove(1, 3, 0, 2, board));
    }

}

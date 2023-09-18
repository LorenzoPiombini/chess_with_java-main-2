package com.chess_for_fun.com;

import com.chess_for_fun.com.Pieces.Pawn;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ChessBoard board = new ChessBoard();

        Pawn blackPawn = (Pawn) board.getPiece(1, 1);

        board.placeApieceInThisSquare(1, 4, blackPawn);

        board.movePiece(2, 6, 2, 4); // moving a white pawn in square 6,1

        System.out.println(blackPawn.isValidMove(1, 4, 2, 5, board));

    }
}

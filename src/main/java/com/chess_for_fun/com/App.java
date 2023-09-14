package com.chess_for_fun.com;

import com.chess_for_fun.com.Pieces.Pawn;
import com.chess_for_fun.com.Pieces.Queen;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();

        Pawn pawn = (Pawn) board.getPiece(6, 1);
        Queen queen = (Queen) board.getPiece(0, 3);

        queen.setCurrentPosition(2, 1);

        System.out.println("The queen is: " + board.getPiece(2, 1));

        System.out.println(pawn.isValidMove(1, 1, 2, 1, board));

    }
}

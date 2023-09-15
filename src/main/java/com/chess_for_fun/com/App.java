package com.chess_for_fun.com;

import com.chess_for_fun.com.Constants.Constant;
import com.chess_for_fun.com.Pieces.Pawn;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ChessBoard board = new ChessBoard();

        Pawn whitePawn = new Pawn(Constant.W);
        Pawn blackPawn = (Pawn) board.getPiece(1, 3);

        board.placeApieceInThisSquare(4, 0, blackPawn);

        board.movePiece(6, 2, 4, 2);

        System.out.println(blackPawn.isValidMove(4, 0, 5, 1, board));

    }
}

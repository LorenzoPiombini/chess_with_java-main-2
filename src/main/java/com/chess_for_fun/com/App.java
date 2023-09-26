package com.chess_for_fun.com;

import com.chess_for_fun.com.Constants.Constant;

import com.chess_for_fun.com.Pieces.Queen;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.clearBoard();

        Queen blackQueen = new Queen(Constant.B);

        board.placeApieceInThisSquare(4, 0, blackQueen);

        System.out.println(blackQueen.isValidMove(4, 0, 3, 2, board));
    }
}

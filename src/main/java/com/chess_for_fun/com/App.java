package com.chess_for_fun.com;

import com.chess_for_fun.com.Constants.Constant;
import com.chess_for_fun.com.Pieces.Knight;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.clearBoard();

        Knight leftWhiteKnight = new Knight(Constant.W);
        Knight leftBlackKnight = new Knight(Constant.B);

        board.placeApieceInThisSquare(1, 7, leftWhiteKnight);
        board.placeApieceInThisSquare(1, 0, leftBlackKnight);

        System.out.println(leftWhiteKnight.isValidMove(1, 7, 0, 5, board));
        System.out.println(leftWhiteKnight.isValidMove(0, 5, -1, 3, board));
    }
}

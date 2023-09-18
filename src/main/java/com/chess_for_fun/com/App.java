package com.chess_for_fun.com;

import com.chess_for_fun.com.Constants.Constant;
import com.chess_for_fun.com.Pieces.King;
import com.chess_for_fun.com.Pieces.Pawn;
import com.chess_for_fun.com.Pieces.Rook;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ChessBoard board = new ChessBoard();
        board.clearBoard();

        King whiteKing = new King(Constant.W);
        Rook blackRook = new Rook(Constant.B);

        board.placeApieceInThisSquare(0, 3, blackRook);
        board.placeApieceInThisSquare(2, 4, whiteKing);

        System.out.println(whiteKing.isValidMove(2, 4, 2, 3, board));

    }
}

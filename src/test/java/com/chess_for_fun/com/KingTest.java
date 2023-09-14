package com.chess_for_fun.com;

import com.chess_for_fun.com.Pieces.King;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KingTest {

    /**
     * this method test the logic of the king class,
     * in this test we are testing the logic of isValidMove
     * and canCastle methods
     */
    @Test
    public void testValidKingMove() {
        ChessBoard board = new ChessBoard();

        King whiteKing = (King) board.getPiece(7, 4);

        assertFalse(whiteKing.isValidMove(7, 4, 6, 4, board)); // should return false becasue there's a pawn in 6,4
        assertFalse(whiteKing.isValidMove(7, 4, 7, 5, board)); // should return false because there's a bishop in 7,5
        assertFalse(whiteKing.canCastle(7, 4, 6, board)); // should return false becasue you can`t castle at the
                                                          // beginning of the game, since the pieces are all in place.

    }
}

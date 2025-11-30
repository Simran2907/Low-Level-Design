package com.tictactoe.objects;

import com.tictactoe.Constants.Piece;

public abstract class PlayingPiece {
    private Piece pieceType;

    public PlayingPiece(Piece pieceType){
        this.pieceType = pieceType;
    }

    public Piece getPieceType() {
        return pieceType;
    }
}

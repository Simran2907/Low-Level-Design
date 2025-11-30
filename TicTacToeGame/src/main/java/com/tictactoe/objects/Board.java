package com.tictactoe.objects;

public class Board {
    private int size;
    private PlayingPiece[][] playingPieces;

    public Board(int size){
        this.size = size;
        playingPieces =  new PlayingPiece[size][size];
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PlayingPiece[][] getPlayingPieces() {
        return playingPieces;
    }

    public void setPlayingPieces(PlayingPiece[][] playingPieces) {
        this.playingPieces = playingPieces;
    }


    public void printBoard() {
        for(int i=0;i<size;i++){
            for(int j =0;j<size;j++){
                System.out.print((playingPieces[i][j] == null ? " ":playingPieces[i][j].getPieceType())+"|");
            }
            System.out.println();
        }
    }

    public boolean checkValidValue(int[] place) {
        if(place[0] < 0 || place[0] >= size || place[1] < 0 || place[1] >= size) return false;
        return playingPieces[place[0]][place[1]] == null;        
    }

    public void placePiece(PlayingPiece playingPiece, int[] place) {
        playingPieces[place[0]][place[1]] = playingPiece;
    }

    public boolean checkWinner(PlayingPiece playingPiece, int[] place) {

        boolean rowMatch = true;
        //check row
        for(int row = 0;row < size;row++){
            if(playingPieces[row][place[1]] == null || playingPieces[row][place[1]] != playingPiece){
                rowMatch = false;
                break;
            }
        }
        if(rowMatch) return true;

        //check col
        boolean colMatch = true;
        for(int col =0;col<size;col++) {
            if(playingPieces[place[0]][col] == null || playingPieces[place[0]][col] != playingPiece){
                colMatch = false;
                break;
            }
        }
        if(colMatch) return true;



        //check diagonally
        boolean diagonalMatch = true;
        for(int row =0 ;row <size;row++) {
            if(playingPieces[row][row] == null || playingPieces[row][row] != playingPiece){
                diagonalMatch = false;
                break;
            }
        }
        if(diagonalMatch) return true;

        boolean antidiagnoalMatch = true;

        for(int row =0,col=size-1 ; row < size && col>=0;row++,col--) {
            if(playingPieces[row][row] == null || playingPieces[row][row] != playingPiece){
                antidiagnoalMatch = false;
                break;
            }
        }
        return antidiagnoalMatch;
    }

    public boolean checkFreeSpace() {

        for(int i=0;i<size;i++){
            for(int j =0;j<size;j++){
                if(playingPieces[i][j] == null) return true;
            }
        }

        return false;
    }
}

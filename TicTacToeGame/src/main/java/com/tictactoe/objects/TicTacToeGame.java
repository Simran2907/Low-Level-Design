package com.tictactoe.objects;

import com.tictactoe.Constants.Piece;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {

    private Deque<Player> players;
    private Board gameBoard;


    public void initializeGame(){
        players = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter player 1 name with piece X : ");
        String player1Name = sc.next();
        Player player1 = new Player(player1Name,new PlayingPieceX());
        players.addFirst(player1);
        System.out.print("Enter player 2 name with piece O : ");
        String player2Name = sc.next();
        Player player2 = new Player(player2Name,new PlayingPieceO());
        players.addLast(player2);
        gameBoard = new Board(3);
    }

    public String startGame(){
        System.out.println("Game has started");
        boolean noWinner = true;

        while(noWinner){
            Player player = players.removeFirst();

            //check free Spaces
            boolean isSpaceLeft = gameBoard.checkFreeSpace();
            if(!isSpaceLeft){
                noWinner = false;
                continue;
            }

            //printBoard
            gameBoard.printBoard();
            int[] place = enterValues(player);

            //check if value is valid
            boolean isValid = gameBoard.checkValidValue(place);
            while(!isValid){
                System.out.print("Invalid place! Please neter place again : ");
                place = enterValues(player);
                isValid = gameBoard.checkValidValue(place);
            }
            gameBoard.placePiece(player.getPlayingPiece(),place);

            //check if winner
            boolean isWinner = gameBoard.checkWinner(player.getPlayingPiece(),place);
            if(isWinner){
                gameBoard.printBoard();
                return player.getName() + " is Winner";
            }

            players.addLast(player);
        }

        return "Tie";
    }

    private int[] enterValues(Player player) {
        Piece piece = player.getPlayingPiece().getPieceType();
        System.out.print("Enter value to place "+ piece +" : ");
        Scanner sc = new Scanner(System.in);
        int [] place = new int[2];
        place[0] = sc.nextInt();
        place[1] = sc.nextInt();

        return place;
    }
}

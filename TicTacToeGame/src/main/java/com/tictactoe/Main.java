package com.tictactoe;

import com.tictactoe.objects.TicTacToeGame;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TicTacToeGame ticTacToeGame = new TicTacToeGame();
       String val = "Y";
        while(val.equalsIgnoreCase("y")) {
            System.out.print("Want to Start Game (Y/N) : ");
            Scanner sc = new Scanner(System.in);
            val = sc.next();
            ticTacToeGame.initializeGame();
            String winner = ticTacToeGame.startGame();
            System.out.println(winner);
        }
        System.out.println("Game Ended");

    }
}
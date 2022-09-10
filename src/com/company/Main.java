package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        printBoard(board);
        while (true) {
            if (!isGameFinished(board)||determineWinner(board)) {
                break;
            }
            playerMove(board, userInput);
            computerMove(board);
            printBoard(board);


            //break;
        }
        //   userInput.close();
    }

    private static boolean isGameFinished(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    return true;

                }
            }
        }
        System.out.println("game over");
        return false;
    }

    private static void playerMove(char[][] board, Scanner userInput) {
        while (true) {
            System.out.println("Make your move: 1-9");
            String move = userInput.nextLine();
            if (isTaken(board, Integer.parseInt(move))) {
                makeMove(move, board, 'X');
                break;
            } else {
                System.out.println("Not a valid move, try again");
                printBoard(board);
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);

    }

    private static void makeMove(String position, char[][] board, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
        }
        //   printBoard(board);
    }

    private static boolean isTaken(char[][] board, int position) {
        switch (position) {
            case 1:
                return board[0][0] == ' ';
            case 2:
                return board[0][1] == ' ';
            case 3:
                return board[0][2] == ' ';
            case 4:
                return board[1][0] == ' ';
            case 5:
                return board[1][1] == ' ';
            case 6:
                return board[1][2] == ' ';
            case 7:
                return board[2][0] == ' ';
            case 8:
                return board[2][1] == ' ';
            case 9:
                return board[2][2] == ' ';
            default:
                return false;

        }
    }

    private static void computerMove(char[][] board) {
        if(determineWinner(board)||isGameFinished(board)) {
            while (true) {
                Random randy = new Random();
                int move = randy.nextInt(9) + 1;
                if (isTaken(board, move)) {
                    makeMove(String.valueOf(move), board, 'O');
                    //breaker = false;
                     break;
                }
                // break;
            }
        }

    }

    private static boolean determineWinner(char[][] board) {
        char symbol = 'X';
        for(int i = 0; i<2; i++) {
            if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                    (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                    (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
                    (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                    (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                    (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
                    (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                    (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
                System.out.println("the winner is " + symbol);
                return true;

            }
            else{
                symbol = 'O';
            }

        }
        return false;
    }
}
//currently just want to make the board print out if the game ends on the last move, other than that is working right
package edu.neumont.csc150.c.main;

public class LearningArrays {
    public static void main(String[] args) {
//        char[][] ticTacToeBoard = new char[3][3];
//        ticTacToeBoard[0][0] = 'X';
//        ticTacToeBoard[0][1] = 'O';
//        ticTacToeBoard[0][2] = 'O';
//        ticTacToeBoard[1][0] = '_';
//        ticTacToeBoard[1][1] = 'X';
//        ticTacToeBoard[1][2] = 'O';
//        ticTacToeBoard[2][0] = 'O';
//        ticTacToeBoard[2][1] = 'O';
//        ticTacToeBoard[2][2] = 'X';

        char [][] ticTacToeBoard = new char [][] {
            {'X', 'O', 'O'},
            {'_', 'X', 'O'},
            {'O', 'O', 'X'}
        };

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                System.out.print(ticTacToeBoard[row][column] + " ");
            }
            System.out.println();
        }
    }
}

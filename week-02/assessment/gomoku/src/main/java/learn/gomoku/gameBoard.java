package learn.gomoku;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Stone;

import java.util.List;

public class gameBoard {
    private char[][] board;


    public gameBoard(List<Stone> list) {

        char[][] newBoard = new char[15][15];

        for (Stone stone : list) {
            newBoard[stone.getRow()][stone.getColumn()] = stone.isBlack() ? 'B' : 'W';

        }
        board = newBoard;
    }

    public static void displayBoard(Gomoku game) {
        gameBoard board = new gameBoard(game.getStones());
        String cellsSpaces = "%3s";
        System.out.println("");
        for (int row = 0; row <= Gomoku.WIDTH; row++) {
            for (int column = 0; column <= Gomoku.WIDTH; column++) {
                if (row == 0) {
                    System.out.printf(cellsSpaces, column);
                } else if (column == 0) {
                    System.out.print("");
                    System.out.printf("%n%s", String.format(cellsSpaces, row));
                } else {
                    char symbol = board.getCell(row - 1, column - 1);
                    System.out.printf(cellsSpaces, symbol == 0 ? '_' : symbol);
                }
            }
        }
        System.out.println();
    }




    public char getCell(int row, int column) {
        return board[row][column];
    }
}
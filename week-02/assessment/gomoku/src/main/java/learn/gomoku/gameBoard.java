package learn.gomoku;

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

    public char getCell(int row, int column) {
        return board[row][column];
    }
}
package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens
{

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(char[][] board, int col, List<List<String>> result) {
        if (col == board.length) {
            result.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q';
                backtrack(board, col + 1, result);
                board[i][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        // This loop checks the diagonal going up and to the left from the current cell.
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // This loop checks the diagonal going down and to the left from the current cell.
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            result.add(row);
        }
        return result;
    }
}

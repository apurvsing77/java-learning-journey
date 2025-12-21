package JavaBasicProgram.interview;

import java.util.HashSet;
import java.util.Set;

/*
 36. Valid Sudoku
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

* */
public class ValidSudoku {
    public static void main(String[] args) {

        char[][] newSudoku = {
                {'.','.','.','9','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','3','.','.','.','.','.','1'},
                {'.','.','.','.','.','.','.','.','.'},
                {'1','.','.','.','.','.','3','.','.'},
                {'.','.','.','.','2','.','6','.','.'},
                {'.','9','.','.','.','.','.','7','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'8','.','.','8','.','.','.','.','.'}
        };
        char[][] sudoku = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'8','.','.','.','.','.','.','7','9'}
        };
        System.out.println(isValidSudoku(sudoku));


    }
    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for (int i = 0; i <n ; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rows[i].contains(board[i][j])) {
                    return false;
                }else {
                    rows[i].add(board[i][j]);
                }
                if(cols[j].contains(board[i][j])){
                    return false;
                }else {

                    cols[j].add(board[i][j]);
                }
                int boxNum = j/3 + 3*(i/3);
                if (boxes[boxNum].contains(board[i][j])) {
                   return false;
                }else {
                    boxes[boxNum].add(board[i][j]);
                }

            }
        }

        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                if (!seen.add("row" + i + num) ||
                        !seen.add("col" + j + num) ||
                        !seen.add("box" + (i / 3) + (j / 3) + num)) {
                    return false;
                }
            }
        }
        return true;
    }
}

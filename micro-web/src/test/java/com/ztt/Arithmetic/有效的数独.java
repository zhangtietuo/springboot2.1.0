package com.ztt.Arithmetic;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/7/4 11:15
 */
public class 有效的数独 {

    public static boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9], cols = new int[9], squares = new int[9];
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                if(board[r][c] != '.'){
                    int value = (1 << (board[r][c] - '1'));
                    if((value & rows[r]) > 0 || (value & cols[c]) > 0 || (value & squares[3*(r/3)+c/3]) > 0) {
                        return false;
                    }
                    rows[r] |= value;
                    cols[c] |= value;
                    squares[3*(r/3)+c/3] |= value;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        isValidSudoku(board);
    }
}

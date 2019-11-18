package com.ztt.Arithmetic;

/**
 * @Auther: zhangtietuo
 * @Description: [1,2,3]     [7,4,1]        1,1->1,3   1,2->2,3   1,3->3,3
 *               [4,5,6]     [8,5,2]        2,1->1,2   2,2->2,2   2,3->3,2
 *               [7,8,9]     [9,6,3]        3,1->1,1   3,2->2,1   3,3->3,1
 * @Date: 2019/11/18 10:57
 */
public class 旋转图像 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        /*
            [1,2,3]
            [4,5,6]
            [7,8,9]
        */
        // transpose matrix 转置
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        /*
            [1,4,7]
            [2,5,8]
            [3,6,9]
        */
        // reverse each row 翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    /*
        [7,4,1]
        [8,5,2]
        [9,6,3]
    */
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(array);
    }
}

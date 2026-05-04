package leetcode.leetcode48;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
    }
     static void rotate(int[][] matrix) {
        int n = matrix.length;
        int SIZE = n * n;
        int[] tmpArr = new int[SIZE];

        int cnt = 0;
        for(int i = 0; i < n; i ++){
            for(int j = n-1; j >= 0; j--) {
                tmpArr[cnt++] = matrix[j][i];
            }
        }

        for(int i = 0; i < SIZE; i++) {
            matrix[i / n][i % n] = tmpArr[i];
            cnt++;
        }
    }
}

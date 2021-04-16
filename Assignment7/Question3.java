package Assignment7;

import java.util.Arrays;

/*
Set Matrix Zeroes
 */
public class Question3 {
    public void setZeroes(int[][] matrix) {
        boolean[] zeroRow = new boolean[matrix.length];
        boolean[] zeroColumn = new boolean[matrix[0].length];
        for (int i = 0 ; i < matrix.length ;i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    zeroRow[i] = true;
                    zeroColumn[j] = true;
                }
            }
        }
        for (int i = 0 ; i < matrix.length ;i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(zeroRow[i] || zeroColumn[j]){
                    matrix[i][j] =0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Question3 a = new Question3();
        int [][] matrix = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};

        System.out.println("Before setZeroes");
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));

        a.setZeroes(matrix);
        System.out.println("after setZeroes");
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
    }
}

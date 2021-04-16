package Assignment7;

import java.util.Arrays;

/*
Rotate Image
 */
public class Question1 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        for(int i = 0; i < length; i++){
            for(int j= i; j < length; j++){
                int temp = matrix [i][j];
                matrix [i][j] = matrix [j][i];
                matrix [j][i] = temp;

            }
        }
        for(int i = 0; i < length; i++){
            for(int j= 0; j < length/2; j++){
                int temp = matrix [i][j];
                matrix [i][j] = matrix [i][length - 1 - j];
                matrix [i][length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Question1 a = new Question1();
        int [][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Before rotation");
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));

        a.rotate(matrix);
        System.out.println("after rotation");
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));

    }
}

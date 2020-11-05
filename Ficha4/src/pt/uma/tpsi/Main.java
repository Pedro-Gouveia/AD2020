package pt.uma.tpsi;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] matrix = {
                {1, 18, 17},
                {18, 10, 11},
                {11, 13, 18},
                {10, 19, 26}
        };

        int[][] matrix3 = matrix;


        int[][] matrix2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        char plus = '+';

        /*
        System.out.println(MatrixUtilities.show(matrix));
        System.out.println(MatrixUtilities.isMatrix(matrix));
        System.out.println(MatrixUtilities.isIdentity(matrix2));
        System.out.println(MatrixUtilities.multiplyBy(matrix, 2));
        System.out.println(MatrixUtilities.areCompatibleForSum(matrix, matrix3));
        System.out.println(MatrixUtilities.sumOf(matrix, matrix3));
        */

        //System.out.println(CharacterDrawingUtilities.drawElement('+'));
        //System.out.println(CharacterDrawingUtilities.drawHorizontalSegmentWith('+', 10));
        //System.out.println(CharacterDrawingUtilities.drawFilledRectangleWith('+', 5, 10));
        System.out.println(CharacterDrawingUtilities.drawEmptyRectangleWith('+', 5, 10));
    }
}

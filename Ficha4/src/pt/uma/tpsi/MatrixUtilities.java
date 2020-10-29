package pt.uma.tpsi;

public class MatrixUtilities {
    public static String show(int[][] matrix) {
        String newMatrix = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == matrix[i].length-1){
                    newMatrix += matrix[i][j] + "\n";
                }
                else {
                    newMatrix += matrix[i][j] + ", ";
                }
            }
        }
        return newMatrix;
    }

    public static boolean isMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int index = 1;
                if (matrix[i].length != matrix[index].length) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }

    public static boolean isIdentity(int[][] matrix) {
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] != 0 || matrix[i][j] != 1 ) {
                    return false;
                }
                else if (matrix[index][index] != 1) {
                    return false;
                }
                //System.out.println(matrix[i][j]);

            }
            index++;
        }
        return true;
    }

    public static String multiplyBy(int[][] matrix, int constant) {
        String multiplied = "";
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                multiplied+=matrix[i][j]*constant + "\n";
            }
        }
        return multiplied;
    }

    public static boolean areCompatibleForSum(int[][] matrix, int[][] matrix2) {
        if (matrix.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                if (matrix[i].length != matrix2[i].length) {

                    return false;
                }
            }
        }
        return true;
    }

    public static String sumOf(int[][] matrix, int[][] matrix2) {

        if (areCompatibleForSum(matrix, matrix2) == true) {

            String sumArray = "";
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix2[i].length; j++) {
                    if (j == matrix[i].length - 1) {
                        sumArray += matrix[i][j] + matrix2[i][j] + "\n";
                    } else {
                        sumArray += matrix[i][j] + matrix2[i][j] + ", ";
                    }
                }
            }
            return sumArray;
        }
        else {

            return "Matrix's not compatible for sum.";
            }
    }


}

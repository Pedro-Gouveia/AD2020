package pt.uma.tpsi;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final int[] studentNumbers = {20032, 30312, 25342, 31432};
        final String[] courseAcronyms = {"AD", "WEB-FE", "WEB-BE"};
        final int[][] studentGrades = {
                {15, 18, 17},
                {18, 10, 11},
                {11, 13, 15},
                {10, 19, 16}
        };

        float max = 0;
        int index = -1; //pode ser qualquer valor
        for (int i = 0; i < studentNumbers.length; i++) {
            float media = 0;
                System.out.println("Student: " + studentNumbers[i]);
            for (int j = 0; j < courseAcronyms.length; j++) {
                System.out.println(courseAcronyms[j] + " - Grade: " + studentGrades[i][j]);
                media += studentGrades[i][j];
            }
            media /= courseAcronyms.length;
            System.out.println("Media: " + media);
            System.out.println();
            if (media > max) {
                max = media;
                index = i;
            }
            }
        System.out.println(studentNumbers[index] + " - Media mais alta: " + max);

        }
    }


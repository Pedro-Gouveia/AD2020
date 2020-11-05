package pt.uma.tpsi;

public class Main {

    public static void main(String[] args) {
        int number = 3;
        increment(number);

        int[] numbers = {1, 2, 3};
        System.out.println(numbers[0]);
        incrementFirstOf(numbers);

        String message = "abc";
        String message2 = cipher(message, 2);
        /*System.out.println( cipher(message, 2));
        System.out.println( decipher(message2,2));

        System.out.println(NumericalUtiities.powerOf(2, 3));
        System.out.println(NumericalUtiities.sumOfNaturalNumbersUpTo(10));
        System.out.println(NumericalUtiities.sumOfNaturalNumbersBetween(5, 10));
        System.out.println(NumericalUtiities.sumOfEvenNumbersBetween(5, 10));
        System.out.println(NumericalUtiities.numberOfDivisorsOf(2));
        System.out.println(NumericalUtiities.isPrime(8));*/


        int[] numbersArray = {1, 2, 3, 4, 5, 2};
        System.out.println(ArrayUtilities.toString(numbersArray));
        System.out.println(ArrayUtilities.maximumOf(numbersArray));
        System.out.println(ArrayUtilities.minimumOf(numbersArray));
        System.out.println(ArrayUtilities.copyOf(numbersArray));
        System.out.println(ArrayUtilities.contains(numbersArray, 3));
        //System.out.println(ArrayUtilities.containsDuplicates(numbersArray));
        System.out.println(ArrayUtilities.indexOf(numbersArray, 3));
        System.out.println(ArrayUtilities.add(numbersArray, 3));
        System.out.println(ArrayUtilities.toString(ArrayUtilities.add(numbersArray, 5)));
        System.out.println(ArrayUtilities.toString(ArrayUtilities.remove(numbersArray, 5)));



    }

    public static String cipher(String msg, int offset){
        String cipher = "";
        for (int i = 0; i < msg.length(); i++ ){
            char c = msg.charAt(i);
            int code = (int)c;
            code+=offset;
            char cx = (char)code;
            cipher+= cx;
        }
        return cipher;
    }

    public static String decipher(String msg, int offset){
        String decipher = "";
        for (int i = 0; i < msg.length(); i++ ){
            char c = msg.charAt(i);
            int code = (int)c;
            code-=offset;
            char cx = (char)code;
            decipher+= cx;
        }
        return decipher;
    }

    public static void increment(int value) {
        System.out.println(value);
        value++;
        System.out.println(value);
    }

    public static void incrementFirstOf(final int[] values) {
        values[0] = 100;
        System.out.println(values[0]);
    }

}

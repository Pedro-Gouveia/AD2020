package pt.uma.tpsi;

public class ArrayUtilities {
    public static String toString(int[] numbersArray) {
        String stringedArray = "[";
        String comma = ",";
        String end = "]";
        for (int i = 0; i < numbersArray.length; i++) {
            stringedArray += numbersArray[i] + comma;
        }
        stringedArray = stringedArray.substring(0, stringedArray.length() - 1);
        stringedArray+=end;

        return stringedArray;
    }

    public static int maximumOf(int[] numbersArray) {
        int res = 0;
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] > res){
                res = numbersArray[i];
            }
        }
        return res;
    }

    public static int minimumOf(int[] numbersArray) {
        int res = numbersArray[0];
        for(int i = 1; i < numbersArray.length;i++){
            if(numbersArray[i] < res){
                res = numbersArray[i];
            }
        }
        return res;
    }

    public static int[] copyOf(int[] numbersArray) {
        int[] copy = new int[numbersArray.length];
        for(int i = 0; i < numbersArray.length;i++){
            copy[i] = numbersArray[i];
        }
        return copy;
    }

    public static boolean contains(int[] numbersArray, int n) {
        for(int i = 0; i < numbersArray.length; i++){
            if ( numbersArray[i] == n){
                return true;
            }
        }
        return false;
    }

    /*public static boolean containsDuplicates(int[] numbersArray) {
        for(int i = 0; i < numbersArray.length; i++){
            for(int j = 1; j < numbersArray.length; j++){
                if (numbersArray[i] == numbersArray[j]){
                    return true;
                }
            }
        }
        return false;
    }*/

    /*public static boolean containsDuplicates(int[] numbersArray) {
        int[] aux = new int[numbersArray.length];
        for(int i = 0; i < numbersArray.length; i++) {
            int value = numbersArray[i];
            if (contains(aux, value)) {
                return true;
            }
        }
        return false;
    }*/

    public static int indexOf(int[] numbersArray, int n) {
        for(int i = 0; i < numbersArray.length; i++){
            if(numbersArray[i] == n){
                return i;
            }
        }
        return -1;
    }

    public static int[] add(int[] numbersArray, int n) {
        int[] newArray = new int[numbersArray.length +1];
        for(int i = 0; i < numbersArray.length; i++){
            newArray[i] = numbersArray[i];
        }
        newArray[numbersArray.length] = n;
        return newArray;
    }

    public static int[] remove(int[] numbersArray, int n) {
        int index = indexOf(numbersArray, n);
        if(index == -1){
            return numbersArray;
        } else {
            int newArray[] = new int[numbersArray.length -1];
            for(int i = 0; i < numbersArray.length; i++){
                if (i < index) {
                    newArray[i] = numbersArray[i];
                }
                else if (i > index){
                    newArray [i - 1] = numbersArray[i];
                }
            }
            return newArray;
        }
    }


}

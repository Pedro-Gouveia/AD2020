package pt.uma.tpsi;

public class CharacterUtilities {
    public static char lowerLetterSuccessorOf(char character) {
        char ch2 = Character.toLowerCase(character);
        if (ch2 == 'z'){
            return 'a';
        }
        int code = (int) ch2;
        code++;
        char recovered = (char) code;
        return recovered;
    }

    public static char lowerLetterPredecessorOf(char character) {
        char ch2 = Character.toLowerCase(character);
        if (ch2 == 'a'){
            return 'z';
        }
        int code = (int) ch2;
        code++;
        char recovered = (char) code;
        return recovered;
    }

    public static char lowerLetterSuccessorStepsOf(char character, int n) {
        int code = (int) character;
        int newCode = code + n;
        char recovered = (char) newCode;
        return recovered;
    }

    public static char lowerLetterPredecessorStepsOf(char character, int n) {
        int code = (int) character;
        int newCode = code - n;
        char recovered = (char) newCode;
        return recovered;
    }

    public static int occurrencesOfCharacterIn(char[] charArray, char letter) {
        int count = 0;
        for(int i = 0; i < charArray.length; i++){
            if (charArray[i] == letter) {
                count++;
            }
        }
        return count;
    }

    public static char[] replaceCharacterIn(char[] charArray, char letter, char replacement) {
        char[] newArray = new char[charArray.length];
        for(int i = 0; i < charArray.length; i++){
            if (charArray[i] == letter) {
                newArray[i] = replacement;

            } else {
                newArray[i] = charArray[i];
            }
        }
        return newArray;
    }

    public static char[] concatenationOf(char[] charArray, char[] charArray2) {
        int totalLength = charArray.length + charArray2.length;
        System.out.println(totalLength);
        char[] newArray = new char[totalLength];
        int index = 0;
        for(int i = 0; i < charArray.length; i++){
            newArray[i] = charArray[i];
            index++;
        }
        for(int i = 0; i < charArray2.length; i++){
            newArray[index] = charArray2[i];
            index++;
        }
        return newArray;
    }

    public static char[] copyOfPartOf(char[] charArray, int initialIndex, int finalIndex ) {
        char[] newArray = new char[charArray.length];
        for(int i = initialIndex; i < finalIndex; i++) {
            newArray[i] = charArray[i];
        }
        return newArray;
    }
}

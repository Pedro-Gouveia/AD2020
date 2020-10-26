package pt.uma.tpsi;

public class Main {

    public static void main(String[] args) {

        System.out.println(CharacterUtilities.lowerLetterSuccessorOf('Z'));
        System.out.println(CharacterUtilities.lowerLetterPredecessorOf('A'));
        System.out.println(CharacterUtilities.lowerLetterSuccessorStepsOf('a', 3));
        System.out.println(CharacterUtilities.lowerLetterPredecessorStepsOf('d', 3));
        char[] charArray = {'a', 'b', 'c', 'a'};
        char[] charArray2 = {'d', 'e', 'f', 'g'};
        System.out.println(CharacterUtilities.occurrencesOfCharacterIn(charArray, 'a'));
        System.out.println(CharacterUtilities.replaceCharacterIn(charArray, 'a', 'z'));
        System.out.println(CharacterUtilities.concatenationOf(charArray, charArray2));
        //System.out.println(CharacterUtilities.copyOfPartOf(charArray, 1, 2));

        /*
        String message = "abc";
        System.out.println(ChiperDecipher.cipher(message, 2));
        String message2 = ChiperDecipher.cipher(message, 2);
        System.out.println(ChiperDecipher.decipher(message2, 2));
        */
    }
}

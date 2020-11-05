package pt.uma.tpsi;

public class CharacterDrawingUtilities {

    public static char drawElement(char character) {
        return character;
    }

    public static String drawNewLine() {
        return "\n";
    }

    public static String drawHorizontalSegmentWith(char character, int lineLength) {
        String line = "";
        for (int i = 0; i < lineLength; i++){
            line += drawElement(character);
        }
        return line;
    }

    public static String drawFilledRectangleWith(char character, int height, int width) {
        String res = "";
        for (int i = 0; i < height; i++){
            res += drawHorizontalSegmentWith(character, width);
            res += drawNewLine();
        }
        return res;
    }

    public static String drawEmptyRectangleWith(char character, int height, int width) {
        String res = "";
        for (int i = 0; i < height; i++){
            if (i == 0 || i == height-1) {
                res += drawHorizontalSegmentWith(character, width);
            } else {
                res += character;
                res += drawHorizontalSegmentWith(' ', width-2);
                res += character;
            }
            res += drawNewLine();
        }
        return res;
    }



}

package pt.uma.tpsi;

public class ChiperDecipher {
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
}

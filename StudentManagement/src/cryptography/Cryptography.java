package cryptography;

public class Cryptography {

    private static final Long KEY = 2312312313L;

    public static String encrypt(CharSequence chars, long key) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < chars.length(); i++)
            sb.append((char) ((chars.charAt(i) ^ key) + KEY));
        return sb.toString();
    }

    public static String decrypt(CharSequence chars, long key) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < chars.length(); i++)
            sb.append((char) ((chars.charAt(i) - KEY) ^ key));
        return sb.toString();
    }
}
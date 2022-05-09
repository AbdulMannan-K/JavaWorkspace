package utilities;

import SMExceptions.naming_exceptions.IllegalUseOfPunctuation;
import SMExceptions.naming_exceptions.WrongInputException;

import java.time.LocalDateTime;

abstract public class StringUtilities {

    private static char punctuations[] = ",.'-".toCharArray();
    private static char numbers[] = "1234567890".toCharArray();
    private static char symbols[] = "!@#$%^&*()_=+[]{}:;\"\\|<>?/".toCharArray();
    private static char alphabets[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * The work of this function is to Check if the NameBuilder entered by user contains numbers or not.
     *
     * @param chars contains the name entered by user.
     * @return true if the name contains number and vice versa.
     */
    protected boolean isNumerical(CharSequence chars) {

        for (char c : chars.toString().toCharArray())
            for (char cc : numbers)
                if (c == cc)
                    return true;
        return false;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The work of this function is to check if the NameBuilder entered by user contains symbols or not.
     *
     * @param chars contains the name entered by user.
     * @return true if the name contains symbol and vice versa.
     */
    protected boolean isSymbolical(CharSequence chars) {

        for (char c : chars.toString().toCharArray())
            for (char cc : symbols)
                if (c == cc)
                    return true;
        return false;
    }

    /**
     * The work of this method is to Validate the NameBuilder entered by user.
     *
     * @param chars contains the value to be validated.
     * @return true, only if the @param chars is completely validated.
     * @throws WrongInputException if the entered data.info.Name is not correct.
     */
    abstract protected boolean validate(CharSequence chars) throws WrongInputException;

    protected static boolean checkPunctuations(CharSequence chars) throws IllegalUseOfPunctuation {
        for (String s : chars.toString().split("\\s+")) {
            for (char c : punctuations) {
                if (s.startsWith("" + c)) throw new IllegalUseOfPunctuation("Invalid NameBuilder");
                if (c != '.' && c != ',')
                    if (s.endsWith("" + c)) throw new IllegalUseOfPunctuation("Invalid NameBuilder");
            }
        }

        if (chars.length() > 0)
            if (chars.charAt(chars.length() - 1) == ',') throw new IllegalUseOfPunctuation();
        return true;
    }

    protected static boolean isPunctuational(CharSequence chars) {
        for (char c : chars.toString().toCharArray())
            for (char cc : punctuations)
                if (c == cc)
                    return true;
        return false;
    }

    protected static boolean isAlphabetical(CharSequence chars) {
        for (char c : chars.toString().toCharArray())
            for (char cc : alphabets)
                if (c == cc)
                    return true;
        return false;
    }

    public static String getCreationDate(LocalDateTime date) {
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear() + ", " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond();
    }
}

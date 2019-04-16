package rocks.zipcode.io.fundamentals;

import rocks.zipcode.io.arrays.ArrayUtils;

public class BasicStringUtils {
    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(char[] chars) {
        return new String(chars);
    }

    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(Character[] chars) {
        return new String(ArrayUtils.unbox(chars));
    }

    /**
     * @param string - string to be manipulated
     * @return identical string with lowercase and uppercase vowels removed
     */
    public static String removeAllVowels(String string) {
        return string.replaceAll("[a,e,i,o,u]|[A,E<I<O<U]", "");

    }

    /**
     * @param string             - string to be manipulated
     * @param charactersToRemove - characters to be removed from string
     * @return
     */
    public static String removeSpecifiedCharacters(String string, String charactersToRemove) {
        String regEx = "[" + String.join( ",", charactersToRemove.split("")) + "]";
        return string.replaceAll(regEx, "");
    }
}

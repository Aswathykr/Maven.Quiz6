package rocks.zipcode.io.fundamentals;


import rocks.zipcode.io.arrays.ArrayUtils;
import rocks.zipcode.io.collections.PowerSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * @author leon on 10/01/2019.
 */
public class StringUtils {
    /**
     * @param string - string to be evaluated
     * @return collection containing all permutations of casing of this string
     */
    public static Collection<String> getAllCasings(String string) {
        ArrayList<String> output = new ArrayList<>();
        // get length of string
        // get range of length
        Integer[] range = ArrayUtils.getRange(0, string.length() - 1);
        // get power-set of range
        Set<Set<Integer>> powerSet = new PowerSet<Integer>(range).permute();
        // for every set in power-set
        for(Set<Integer> indexSet : powerSet) {
            // uppercase indices of string using set
            output.add(upperCaseIndices(string, indexSet.toArray(new Integer[indexSet.size()])));
        }
        return output;
    }

    /**
     * @param string  - string to be evaluated
     * @param indices - indices to be evaluated
     * @return near-identical string whose characters at specified indices are capitalized
     */
    public static String upperCaseIndices(String string, Integer... indices) {
        String output = string;
        for(Integer index : indices){
            output = replaceAtIndex(output, Character.toUpperCase(output.charAt(index)), index );
        }
        return output;
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param valueToBeInserted     - value to insert into string
     * @param index                 - string-index at which to insert value into string
     * @return near-identical string with `valueToBeInserted` inserted at `index`
     */
    public static String insertAtIndex(String stringToBeManipulated, String valueToBeInserted, Integer index) {
        return stringToBeManipulated.substring(0, index)
                + valueToBeInserted
                + stringToBeManipulated.substring(index);
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param replacementValue      - value to insert at `index`
     * @param index                 - position of string to be manipulated
     * @return near-identical string with character at `index` replaced with `replacementValue`
     */
    public static String replaceAtIndex(String stringToBeManipulated, Character replacementValue, Integer index) {
        return stringToBeManipulated.substring(0, index)
                + replacementValue
                + stringToBeManipulated.substring(index + 1);
    }
}
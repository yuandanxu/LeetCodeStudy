package LeetCode;

import java.util.*;

/**
 * Created by yuand on 3/2/2017.
 * Print all palindrome permutations of a string
 * Given a string, we need to print all possible palindromes that can be generated using letters of that string.
 * Examples:
 * Input:  str = "aabcb"
 * Output: abcba bacab
 * <p>
 * nput:  str = "aabbcadad"
 * Output: aabdcdbaa aadbcbdaa abadcdaba
 * abdacadba adabcbada adbacabda
 * baadcdaab badacadab bdaacaadb
 * daabcbaad dabacabad dbaacaabd
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.print(palindrome.getAllPalindrome("aabbcadad"));
    }
    public List<String> getAllPalindrome(String input) {
        Map<String, Integer> tmpMap = new HashMap<String, Integer>();
        String evenTimesNumberChars = "";
        Set<String> singleChars = new HashSet<String>();

        for (int i = 0; i < input.length(); i++) {
            String tmpString = input.charAt(i) + "";
            Integer tmpSum = 0;
            if (!tmpMap.containsKey(tmpString)) {
                tmpSum = 1;
            } else {
                tmpSum = tmpMap.get(tmpString) + 1;
            }
            tmpMap.put(tmpString, tmpSum);

            if (tmpSum % 2 == 0) {
                evenTimesNumberChars = evenTimesNumberChars + tmpString;
                singleChars.remove(tmpString);
            } else {
                singleChars.add(tmpString);
            }
        }

        List<String> result = new ArrayList<String>();
        if (singleChars.size() > 1) return result;

        String singleChar = singleChars.size() == 0? "" : singleChars.iterator().next();

        Set<String> permString = perm(evenTimesNumberChars);
        for (String string : permString) {
            result.add(string + singleChar + new StringBuilder(string).reverse().toString());
        }

        return result;
    }

    public Set<String> perm(String input) {
        Set<String> result = new HashSet<String>();
        if (input == "") return result;

        char currentChar = input.charAt(0);

        if (input.length() > 1) {
            Set<String> tmpSet = perm(input.substring(1));

            for (String tmp: tmpSet) {
                for(int i=0; i<tmp.length() + 1; i++) {
                    result.add(tmp.substring(0,i) + currentChar + tmp.substring(i));
                }
            }
        } else {
            result.add(currentChar + "");
        }

        return result;
    }
}

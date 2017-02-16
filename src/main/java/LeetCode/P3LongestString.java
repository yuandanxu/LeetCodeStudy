package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yuand on 2/13/2017.
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Subscribe to see which companies asked this question.
 * <p>
 * Show Tags
 * Show Similar Problems
 */
public class P3LongestString {
    public static void main(String[] args) {
        String test = "abcabcbb";
        P3LongestString longestString = new P3LongestString();
        System.out.print(longestString.lengthOfLongestSubstring3(test));
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = 0;
        HashMap<String, Integer> charLocation = new HashMap<String, Integer>();
        char cur;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if (charLocation.containsKey(String.valueOf(cur))) {
                Integer lastCharLocation = charLocation.get(String.valueOf(cur));
                charLocation.put(String.valueOf(cur), i);
                if (lastCharLocation < start) {
                    tmp = i - start + 1;
                    continue;
                } else {
                    start = lastCharLocation + 1;
                }

                result = result > tmp ? result : tmp;
            } else {
                charLocation.put(String.valueOf(cur), i);
                tmp = i - start + 1;
            }
        }
        return result > tmp ? result : tmp;
    }

    public int lengthOfLongestSubstring3(String s) {
        int result = 0;
        int start = 0;
        HashMap<String, Integer> charLocation = new HashMap<String, Integer>();
        char cur;

        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if (charLocation.containsKey(String.valueOf(cur))) {
                Integer lastCharLocation = charLocation.get(String.valueOf(cur));
                if (start <= lastCharLocation) {
                    start = lastCharLocation + 1;
                }
            }
            charLocation.put(String.valueOf(cur), i);
            result = Math.max(result, i - start + 1);

        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        HashMap<String, ArrayList<Integer>> charMap = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < s.length(); i++) {

        }


        return result;
    }
}

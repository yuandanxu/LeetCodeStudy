package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yuand on 2/15/2017.
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class P5LongestPalindromicSubstring {
    int lo=0, max=0;
    public String findLongestPalindromicSubstring(String s) {
        if (s.length() == 0) return "";

        for (int i=0; i<s.length(); i++) {
            extendPalindromic(s, i, i);
            extendPalindromic(s, i, i+1);
        }

        return s.substring(lo, lo + max);
    }

    private void extendPalindromic(String s, int start, int end) {

        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }

        if (max<(end - start - 1)) {
            lo = start + 1;
            max = end - start - 1;
        }
    }
}

package LeetCode;

/**
 * Created by yuand on 2/16/2017.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class P14LongestCommonPrefix {

    public static void main(String[] args) {
        P14LongestCommonPrefix p14LongestCommonPrefix = new P14LongestCommonPrefix();
        String[] source = {"abcded", "abcfd", "abcffff"};
        System.out.println(p14LongestCommonPrefix.longestCommonPrefix2(source));

    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int index = 0;
        for (; index<strs[0].length(); index++) {
            for (int j=0; j<strs.length; j++) {
                if(strs[j].length() == index || strs[j].charAt(index) != strs[0].charAt(index)) {
                    return strs[0].substring(0, index);
                };
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i=1; i<strs.length; i++){
            while (strs[i].indexOf(prefix) != 0) {
                prefix = strs[0].substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}

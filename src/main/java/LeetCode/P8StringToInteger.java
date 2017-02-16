package LeetCode;

/**
 * Created by yuand on 2/15/2017.
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 */
public class P8StringToInteger {
    public int myAtoi(String str) {

        if (str.length() == 0) return 0;

        if ((str.charAt(0) != '-' && str.charAt(0) != '+' && !(str.charAt(0) - '0'>= 0 && str.charAt(0) - '0' <=9)) && str.charAt(0) != ' ') return 0;

        int result = 0;
        int positive = 1;
        int start = 0;


        while (str.charAt(start) == ' ' && start < str.length()) {
            start++;
        }
        if (str.charAt(start) == '-') {
            positive = -1;
            start++;
        } else if (str.charAt(start) == '+') {
            start++;
        }

        for (;start<str.length(); start++) {
            int tmp = str.charAt(start) - '0';
            if ( tmp <0 || tmp>9 ) {
                break;
            }

            if ( Integer.MAX_VALUE/10 < result || (Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE%10<tmp))
                return positive ==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = result * 10 + tmp;

        }
        return result*positive;
    }
}

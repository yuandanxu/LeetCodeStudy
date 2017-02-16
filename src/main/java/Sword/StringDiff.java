package Sword;

/**
 * Created by yuand on 2/14/2017.
 */
public class StringDiff {
    public static void main(String[] args) {
        String s = "abc";
        String b = new String("abc").intern();
        System.out.println(s == b);
    }
}

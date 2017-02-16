import LeetCode.P5LongestPalindromicSubstring;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by yuand on 2/15/2017.
 */
public class P5Test {
    @Test(dataProvider = "p5DataSet")
    public void testP5(String expected, String source) {
        P5LongestPalindromicSubstring p5 = new P5LongestPalindromicSubstring();

        String result = p5.findLongestPalindromicSubstring(source);
        Assert.assertEquals(result, expected, "Result is not the same");
    }

    @DataProvider
    public Object[][] p5DataSet() {
        return new Object[][] {
            {"aba", "abadd"},
            {"a", "a"},
            {"", ""}
        };
    }
}

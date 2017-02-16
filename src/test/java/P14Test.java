import LeetCode.P14LongestCommonPrefix;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by yuand on 2/16/2017.
 */
public class P14Test {

    @Test(dataProvider = "testData")
    public void testP14(String expected, String[] source) {
        P14LongestCommonPrefix p14LongestCommonPrefix = new P14LongestCommonPrefix();
        Assert.assertEquals(p14LongestCommonPrefix.longestCommonPrefix(source), expected);
        Assert.assertEquals(p14LongestCommonPrefix.longestCommonPrefix2(source), expected);
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
            {"abc", new String[]{"abcde", "abcfg", "abceeee"}},
            {"", new String[]{""}},
            {"", null},
            {"abdeeee", new String[]{"abdeeee"}}
        };
    }

}

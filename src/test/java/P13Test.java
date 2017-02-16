import LeetCode.P13ThreeSum;
import org.testng.annotations.Test;

/**
 * Created by yuand on 2/16/2017.
 */
public class P13Test {
    @Test
    public void testP13(String index, int[] source) {
        P13ThreeSum p13ThreeSum = new P13ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, 4};
        p13ThreeSum.threeSum(nums);
    }
}

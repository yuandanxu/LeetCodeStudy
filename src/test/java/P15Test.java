import LeetCode.P15ThreeSum;
import org.testng.annotations.Test;

/**
 * Created by yuand on 2/16/2017.
 */
public class P15Test {
    @Test
    public void testP15() {
        P15ThreeSum p15ThreeSum = new P15ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, 4};
        p15ThreeSum.threeSum(nums);
    }
}

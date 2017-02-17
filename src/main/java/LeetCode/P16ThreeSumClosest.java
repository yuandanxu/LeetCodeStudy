package LeetCode;

import java.util.Arrays;

/**
 * Created by danyuan on 2/17/17.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class P16ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        P16ThreeSumClosest p16ThreeSumClosest = new P16ThreeSumClosest();
        System.out.print(p16ThreeSumClosest.threeSumClosest(nums, 1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;

        int result = 0;
        for(int i=0; i<nums.length-2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int tmp = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - tmp) == 0) return tmp;

                if (Math.abs(target - tmp) < diff) {
                    result = tmp;
                    diff = Math.abs(target - tmp);

                }
                if (target - tmp > 0) {
                    start++;

                } else {
                    end--;
                }
            }
        }
        return result;

    }
}

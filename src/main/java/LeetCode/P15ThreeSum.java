package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuand on 2/16/2017.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
   -2 -1 -1 0 1 2 -4

 * ]
 */
public class P15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;;
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end ) {
                int expected = 0 - nums[i];
                if (nums[start] + nums[end] == expected) {
                    List<Integer> tmpList = new ArrayList<Integer>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[start]);
                    tmpList.add(nums[end]);
                    result.add(tmpList);
                    end--;
                    while (start < end && nums[end] == nums[end+1]) end--;
                } else if (nums[start] + nums[end] < expected) {
                    start++;
                    while (start < end && nums[start] == nums[start-1]) start++;
                } else {
                    end--;
                    while (start < end && nums[end] == nums[end+1]) end--;
                }
            }
        }
        return result;
    }
}

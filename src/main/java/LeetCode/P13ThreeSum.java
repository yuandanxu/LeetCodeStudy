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
 * ]
 */
public class P13ThreeSum {
    public static void main(String[] args) {
        P13ThreeSum p13ThreeSum = new P13ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, 4};
        System.out.println(p13ThreeSum.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            int start = i;
            int end = nums.length - 1;
            while (start < end) {
                int min_number = nums[start + 1];
                if (nums[start] + nums[min_number] + nums[end] == 0) {
                    List<Integer> tmpList = new ArrayList<Integer>();
                    tmpList.add(start);
                    tmpList.add(min_number);
                    tmpList.add(end);
                    result.add(tmpList);
                    end = end - 1;
                } else if (nums[start] + nums[min_number] + nums[end] < 0) {
                    start = start + 1;
                } else {
                    end = end - 1;
                }
            }
        }
        return result;
    }
}

package LeetCode;

import java.util.*;

/**
 * Created by yuand on 3/3/2017.
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class P18FourSum {
    public static void main(String[] args) {
        int[] input = {-1,-5,-5,-3,2,5,0,4};
        P18FourSum p18FourSum = new P18FourSum();
        List<List<Integer>> result = p18FourSum.fourSum(input, 0);
        for (List list : result) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.print("\n");
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (end - start >= 3) {
            int end_next = end;
            while (end_next - start >= 3) {
                twoSum(nums, start, end_next, result, target);
                end_next--;
                while (nums[end_next] == nums[end_next + 1] && end_next - start>=3) end_next--;
            }
            start++;
            while (nums[start] == nums[start-1] && end - start>=3) start++;
        }

        return result;
    }

    public static void twoSum(int[] nums, int start, int end, List<List<Integer>> result, int target) {

        int in_start = start + 1;
        int in_end = end - 1;
        while (in_start < in_end) {
            if (nums[start] + nums[end] + nums[in_start] + nums[in_end] == target) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                tmp.add(nums[in_start]);
                tmp.add(nums[in_end]);
                result.add(tmp);
                in_start++;
                in_end--;
                while (nums[in_start] == nums[in_start - 1] && in_start < in_end) in_start++;
                while (nums[in_end] == nums[in_end + 1] && in_end > in_start) in_end--;
            } else if (nums[start] + nums[end] + nums[in_start] + nums[in_end] > target) {
                in_end--;
                while (nums[in_end] == nums[in_end + 1] && in_end > in_start) in_end--;
            } else {
                in_start++;
                while (nums[in_start] == nums[in_start - 1] && in_start < in_end) in_start++;
            }
        }
    }

}

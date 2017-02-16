package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuand on 2/10/2017.
 */
/*
    2. Add Two Numbers
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8*/
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.add(2);
        l1.add(4);
        l1.add(3);
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l2.add(9);
        l2.add(6);
        l2.add(9);

        int length = l1.size() > l2.size() ? l1.size() : l2.size();
        LinkedList<Integer> result = new LinkedList<Integer>();
        Integer carrybit = 0;
        Integer plus = 0;
        Integer n2 = 0;
        for (int i = 0; i < length; i++) {
            n2 = i < length ? l2.get(l2.size()- 1 - i) : 0;
            plus = l1.get(l1.size() - i - 1) + n2 + carrybit;

            result.add(plus % 10);
            carrybit = plus / 10;
        }

        if (carrybit != 0) {
            result.add(carrybit);
        }
        System.out.print(l1);
        System.out.print(l2);
        System.out.print(result);

    }



    private List<Integer> addNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int length = l1.size() > l2.size() ? l1.size() : l2.size();
        LinkedList<Integer> result = new LinkedList<Integer>();
        Integer carrybit = 0;
        Integer plus = 0;
        Integer n2 = 0;
        for (int i = 0; i < length; i++) {
            n2 = i < length ? l2.get(l2.size() - i) : 0;
            plus = l1.get(l1.size() - i) + n2 + carrybit;

            result.add(plus % 10);
            carrybit = plus / 10;
        }

        if (carrybit != 0) {
            result.add(carrybit);
        }
        return result;
    }



    public class Solution {
        public P2ListNode addTwoNumbers(P2ListNode l1, P2ListNode l2) {
            int carry_bit = 0;
            int n1, n2;
            int intermediate_sum;
            P2ListNode result = null;
            while (l1 != null || l2 != null) {
                n1 = l1 != null ? l1.val : 0;
                n2 = l2 != null ? l2.val : 0;
                intermediate_sum = n1 + n2 + carry_bit;
                carry_bit = intermediate_sum / 10;
                P2ListNode node = new P2ListNode(intermediate_sum%10);
                if (result == null) {
                    result = node;
                } else {
                    result.next = node;
                }
                l1 = l1.next;
                l2 = l2.next;
            }

            if (carry_bit != 0) {
                P2ListNode node = new P2ListNode(carry_bit);
                result.next = node;
            }

            return  result;
        }
    }
}

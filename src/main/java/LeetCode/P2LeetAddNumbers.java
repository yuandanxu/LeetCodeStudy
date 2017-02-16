package LeetCode;

/**
 * Created by yuand on 2/10/2017.
 */
/*
    2. Add Two Numbers
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8*/
public class P2LeetAddNumbers {
    public static void main(String[] args) {
        P2ListNode n1 = new P2ListNode(1);
//        P2ListNode n1_2 = new P2ListNode(9);
//        P2ListNode n1_3 = new P2ListNode(3);
//        n1.next = n1_2;
//        n1_2.next = n1_3;
        P2ListNode n2 = new P2ListNode(9);
        P2ListNode n2_2 = new P2ListNode(9);
//        P2ListNode n2_3 = new P2ListNode(4);
        n2.next = n2_2;
//        n2_2.next = n2_3;

        P2ListNode result = new P2LeetAddNumbers().addTwoNumbersV2(n1, n2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


    private P2ListNode addTwoNumbers(P2ListNode l1, P2ListNode l2) {
        int carry_bit = 0;
        int n1, n2;
        int intermediate_sum;
        P2ListNode result = null;
        P2ListNode result_tmp = null;
        while (l1 != null || l2 != null) {
            n1 = l1 != null ? l1.val : 0;
            n2 = l2 != null ? l2.val : 0;
            intermediate_sum = n1 + n2 + carry_bit;
            carry_bit = intermediate_sum / 10;
            P2ListNode node = new P2ListNode(intermediate_sum % 10);
            if (result == null) {
                result = node;
                result_tmp = result;
            } else {
                result_tmp.next = node;
                result_tmp = node;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry_bit != 0) {
            P2ListNode node = new P2ListNode(carry_bit);
            result_tmp.next = node;
        }

        return result;
    }

    private P2ListNode addTwoNumbersV2(P2ListNode l1, P2ListNode l2) {
        P2ListNode pre = new P2ListNode(0);
        P2ListNode head = pre;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null || carry != 0) {
            P2ListNode cur = new P2ListNode(0);
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            sum = n1 + n2 + carry;
            carry = sum / 10;
            cur.val = sum % 10;

            pre.next = cur;
            pre = cur;


            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return head.next;
    }
}

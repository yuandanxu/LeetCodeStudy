package LeetCode;

import org.w3c.dom.NodeList;

/**
 * Created by yuand on 3/3/2017.
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class P19RemoveNthFromList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        P19RemoveNthFromList p19RemoveNthFromList = new P19RemoveNthFromList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode head = p19RemoveNthFromList.removeNthFromEnd(listNode1, 2);

        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int listSize = 0;
        ListNode cNode = head;
        while (cNode != null) {
            listSize++;
            cNode = cNode.next;
        }

        int index = 0;
        ListNode currentNode = head;
        ListNode previousNode = head;
        while (currentNode != null) {
            if (index == 0 && index == listSize - n) {
                return head.next;
            }

            if (index == listSize - n) {
                previousNode.next = currentNode.next;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            index++;
        }
        return head;
    }
}

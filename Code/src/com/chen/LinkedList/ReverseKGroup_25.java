package com.chen.LinkedList;

public class ReverseKGroup_25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        ListNode end = head;
        int count = 0;
        while (end != null) {
            count++;
            // group
            if (count % k == 0) {
                // reverse linked list (start, end]
                start = reverse(start, end.next);
                end = start.next;
            } else {
                end = end.next;
            }
        }
        return dummy.next;
    }

    /**
     * reverse linked list from range (start, end), return last node.
     * for example:
     * 0->1->2->3->4->5->6->7->8
     * |           |
     * start       end
     *
     * After call start = reverse(start, end)
     *
     * 0->3->2->1->4->5->6->7->8
     *          |  |
     *       start end
     *       first
     *
     */
    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start.next;
        ListNode prev = start;
        ListNode first = curr;
        while (curr != end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        start.next = prev;
        first.next = curr;
        return first;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;


        ListNode ans = ReverseKGroup_25.reverseKGroup(a1,2);

        while(ans != null) {
            System.out.print(ans + " -> ");
            ans = ans.next;
        }
        System.out.print("null\n ");
    }
}

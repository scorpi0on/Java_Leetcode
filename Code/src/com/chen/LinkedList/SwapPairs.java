package com.chen.LinkedList;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode prev = dummyhead;
        while ( head != null && head.next != null){
            ListNode temp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = temp;
        }
        return dummyhead.next;
    }

    public static void main(String[] args) {
        System.out.println("Plz input nodes'vals");

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode ans = new SwapPairs().swapPairs(l1);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}

package com.chen.LinkedList;

public class ReverseList_206 {
    public static ListNode reverseList1(ListNode head) {
        if ( head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head; //将head设置为下一个元素的下一个
        head.next = null;
        return newHead;
    }

    public static ListNode reverseList2(ListNode head) {
        if ( head == null || head.next == null){
            return head;
        }
        ListNode newhead = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next = newhead;
            newhead = head;
            //Around1
            // 1   ->   2   ->   3     null
            //head     nextnode     head.next

            //1     ->    null
            //newhead

            //  2        ->   3     1    ->  null
            // nextnode             newhead
            //
            //Around2
            //2   ->  3             1    ->  null
            //head   head.next    newhead
            //
            //2   ->   1    ->  null     3
            //head   head.next          nextndoe
            //2    ->   1    ->  null    3
            //newhead                  nextnode
            //
            //update nextnode to head
            head = nextNode;
        }
        return newhead;
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


//        ListNode ans = reverseList_206.reverseList1(a1);
        ListNode ans = ReverseList_206.reverseList2(a1);

        while(ans != null) {
            System.out.print(ans + " -> ");
            ans = ans.next;
        }
        System.out.print("null\n ");
    }
}

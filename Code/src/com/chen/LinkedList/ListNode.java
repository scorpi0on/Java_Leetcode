package com.chen.LinkedList;

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     @Override
     public String toString() {
          return Integer.toString(this.val);
     }
}

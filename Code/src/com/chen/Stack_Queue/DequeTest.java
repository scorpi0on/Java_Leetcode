package com.chen.Stack_Queue;

import java.util.*;

public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
//        deque.push("a");
//        deque.push("b");
//        deque.push("c");
        deque.offerFirst("a");
        deque.offerFirst("b");
        deque.offerFirst("c");

        System.out.println(deque);

//        String str = deque.peek();
        String str = deque.peekFirst();

        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
//            System.out.println(deque.pop());
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }
}

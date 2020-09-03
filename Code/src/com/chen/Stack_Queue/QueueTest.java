package com.chen.Stack_Queue;

import java.util.*;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        System.out.println(queue);
        String polledElement = queue.poll();
        System.out.println("polledElement: "+polledElement);
        System.out.println(queue);
        String peekedElement = queue.peek();
        System.out.println("peekedElement: "+peekedElement);
        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.println("queue.poll(): "+queue.poll());
        }
    }
}

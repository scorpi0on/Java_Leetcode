package com.chen.Stack_Queue;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("stack: "+stack);
        System.out.println("stack.search(4): "+stack.search(4));
        System.out.println("Pop top 2 elements---");
        stack.pop();
        stack.pop();
        Integer topElement = stack.peek();
        System.out.println("topElement: "+topElement);
        System.out.println("3的位置 " + stack.search(3));
    }
}

package com.chen.Stack_Queue;



import java.util.Stack;

public class Min_Stack_155 {

    class MinStack{
        private Stack<Integer> stack ;
        private Stack<Integer> min_Stack ;

        public MinStack() {
            stack = new Stack<>();
            min_Stack = new Stack<>();
        }
        public void push(int x) {
            stack.push(x);
            if (min_Stack.isEmpty() == true || x <= min_Stack.peek()){
                min_Stack.push(x);
            }
        }
        public void pop() {
            if (stack.pop().equals(min_Stack.peek())){
                min_Stack.pop();
            }
        }
        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return min_Stack.peek();
        }
    }



    public void minStackTest(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min1 = minStack.getMin();
        minStack.pop();
        int top = minStack.top();
        int min2 = minStack.getMin();
        System.out.println("getMin=" + min1 + " ,top=" + top +" ,getMin=" + min2);
    }
}

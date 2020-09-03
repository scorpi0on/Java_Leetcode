package com.chen.Stack_Queue;

public class MyCircularDeque_641 {
        private int[] ring;

        private int capacity;

        private int head;

        private int tail;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque_641(int k) {
            capacity = k + 1; // 因为环形队列需要一个空位判断队列为空
            ring = new int[capacity];
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            head = (head + capacity - 1) % capacity; // 移动到前一位
            ring[head] = value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            ring[tail] = value;
            tail = (tail + 1) % capacity;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            head = (head + 1) % capacity;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            tail = (tail + capacity - 1) % capacity; // 移动到前一位
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }

            return ring[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }

            return ring[(tail + capacity - 1) % capacity];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return head == tail;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (tail + 1) % capacity == head;
        }



    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */


    public static void main(String[] args) {
        MyCircularDeque_641 circularDeque = new MyCircularDeque_641(3); // 设置容量大小为3
        boolean ans1 = circularDeque.insertFront(8);
        // 返回 true
        boolean ans2 = circularDeque.insertLast(8);
        // 返回 true
        boolean ans3 = circularDeque.insertLast(2);
        // 返回 true
        int ans5 = circularDeque.getFront();
        // 返回 2

        boolean ans7 = circularDeque.deleteLast();
        // 返回 true
        int ans6 = circularDeque.getRear();

        boolean ans4 = circularDeque.insertFront(9);
        // 已经满了，返回 false
        boolean ans11 = circularDeque.deleteFront();

        int ans9 = circularDeque.getRear();

        boolean ans8 = circularDeque.insertLast(2);
        // 返回 true
        boolean ans10 = circularDeque.isFull();
        // 返回 true
    }



}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
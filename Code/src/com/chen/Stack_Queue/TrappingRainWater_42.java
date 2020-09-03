package com.chen.Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater_42 {
//    输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//    输出: 6
    public static int trapBruteForce(int[] height) {
        int len = height.length;
        if (len<=2){
            return 0;
        }
        int curr_sum = 0;
        for (int i = 0; i < len - 1; i++){
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j>=0; j--){
                maxLeft = height[j] >= maxLeft ? height[j] : maxLeft;
            }
            for (int j = i; j<len; j++){
                maxRight = height[j] >= maxRight ? height[j] : maxRight;
            }
            curr_sum += Math.min(maxLeft,maxRight) - height[i];
        }
        return curr_sum;
    }

    public static int trapDeque(int[] height){
        int len = height.length;
        if (len<=2){
            return 0;
        }
        int curr_sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int curr = 0;
        while (curr < len){
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!deque.isEmpty() && height[curr] > height[deque.getFirst()]) {
                int h = height[deque.removeFirst()]; //取出要出栈的元素
                if (deque.isEmpty()) { // 栈空就出去
                    break;
                }
                int distance = curr - deque.getFirst() - 1; //两堵墙之前的距离。
                int min = Math.min(height[deque.getFirst()], height[curr]);
                curr_sum = curr_sum + distance * (min - h);
            }
            deque.addFirst(curr); //当前指向的墙入栈
            curr++; //指针后移
        }
        return curr_sum;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans1 = TrappingRainWater_42.trapBruteForce(a);
        int ans2 = TrappingRainWater_42.trapDeque(a);
        System.out.println(ans2);
    }
}

package com.chen.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleArea_84 {

    public static Integer LargestRABruteForce1(int[] heights){
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++){
                int minHeight = heights[i];
                for (int k = i; k <= j; k++){
                    minHeight = Math.min(minHeight, heights[k]);
                }
                maxArea = Math.max(maxArea, minHeight*(j-i+1));
            }
        }
        return maxArea;
    }

    public static Integer LargestRABruteForce2(int[] heights){
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int minHeight = heights[i];
            for (int j = i; j < len; j++){
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight*(j-i+1));
            }
        }
        return maxArea;
    }

    public static Integer LargestRAStack(int[] heights) {
        int len = heights.length;
        if (len < 0){
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i=0; i<len; i++){
            while (stack.peek()!=-1 && heights[stack.peek()] >= heights[i]){
                int curr_index = stack.pop(), curr_len = i - stack.peek() - 1 ;
                int curr_hight = heights[curr_index];
                maxArea = Math.max( curr_hight * curr_len, maxArea);
            }
            stack.push(i);

        }

        while (stack.peek()!=-1){
            int curr_index_f = stack.pop(), curr_len_f = len-stack.peek()-1;
            int curr_hight_f = heights[curr_index_f];
            maxArea = Math.max(maxArea, curr_hight_f * curr_len_f);
        }
        return maxArea;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int[] heights = new int[str.length];
            int i = 0;
            for (String s : str){
                heights[i] = Integer.parseInt(s);
                ++i;
            }
            int ans1 = LargestRectangleArea_84.LargestRABruteForce1(heights);
            int ans2 = LargestRectangleArea_84.LargestRABruteForce2(heights);
            int ans3 = LargestRectangleArea_84.LargestRAStack(heights);

            System.out.println("BruteForce1 "+ ans1 + " "+"BruteForce2 "+ ans2 + " "+"Stack "+ ans3 + " ");
        }
//            int[] a = {2,1,5,6,2,3};
//            int ans1 = LargestRectangleArea.LargestRAHardCode1(a);
//            int ans2 = LargestRectangleArea.LargestRAHardCode2(a);
//            int ans3 = LargestRectangleArea.LargestRAStack(a);
//
//            System.out.println("HardCode1 "+ ans1 + " "+"HardCode2 "+ ans2 + " "+"Stack "+ ans3 + " ");
    }

}

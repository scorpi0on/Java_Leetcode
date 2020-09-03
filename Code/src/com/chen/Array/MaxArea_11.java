package com.chen.Array;


import java.util.Arrays;
import java.util.Scanner;

public class MaxArea_11 {
    public int maxArea(int[] height) {
        if ( height == null || height.length < 2){
            return -1;
        }
        int size = height.length;
        int max = Integer.MIN_VALUE;
        int left = 0, right = size-1;
        while (left < right){
            int minHeight = height[left] < height[right]? height[left]:height[right];
            max = minHeight*(right-left) < max? max:minHeight*(right-left);
            if (height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Input heights:");
            String input = sc.next();
            if (input.equals("-1")){
                break;
            }
            String[] arr = input.split(",");
            int[] heights = new int[arr.length];
            int i = 0;
            for (String s:arr){
                heights[i] = Integer.parseInt(s);
                i++;
            }
            System.out.println(Arrays.toString(heights));

            int ans = new MaxArea_11().maxArea(heights);
            System.out.println(ans);
        }
    }
}

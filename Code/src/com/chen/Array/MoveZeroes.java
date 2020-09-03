package com.chen.Array;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {
    public void moveZeroes(int[] nums){
        //必须在原数组上操作，不能拷贝额外的数组。
        //尽量减少操作次数。
        int j = 0;
        for (int i = 0; i<nums.length; ++i){
            if (nums[i] != 0){
                nums[j] = nums[i];
                if (i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        //输入: [0,1,0,3,12]
        //输出: [1,3,12,0,0]

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Input array:");
            String str = in.next();
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                nums[j] = Integer.parseInt(arr[j]);
            }
            new MoveZeroes().moveZeroes(nums);
        }
    }
}

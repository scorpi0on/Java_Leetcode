package com.chen.Array;

import java.util.Arrays;
import java.util.Scanner;

public class RotateTest {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; ++i) {
            int prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; ++j) {
                int temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Input array:");
            String str = in.next();
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                nums[j] = Integer.parseInt(arr[j]);
            }
            System.out.println("Input k:");
            int k = in.nextInt();
            RotateTest rotateTest = new RotateTest();
            rotateTest.rotate(nums, k);
        }

    }
}

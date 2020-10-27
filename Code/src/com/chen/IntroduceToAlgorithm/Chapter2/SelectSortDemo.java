package com.chen.IntroduceToAlgorithm.Chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SelectSortDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SelectSortDemo selectSortDemo = new SelectSortDemo();
        System.out.println("Input nums array:");
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            int[] nums = new int[strs.length];
            for (int i = 0; i < strs.length; ++i) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int[] ans = selectSortDemo.selectSort(nums);
            System.out.println(Arrays.toString(ans));
            System.out.println("Input nums array:");
        }
    }

    public int[] selectSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < length; ++j) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }
}

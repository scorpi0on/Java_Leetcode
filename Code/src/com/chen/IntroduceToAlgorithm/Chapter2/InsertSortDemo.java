package com.chen.IntroduceToAlgorithm.Chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSortDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InsertSortDemo insertSortDemo = new InsertSortDemo();
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            int[] nums = new int[strs.length];
            for (int i = 0; i < strs.length; ++i) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int[] ouput = insertSortDemo.inserSort(nums);
            System.out.println(Arrays.toString(ouput));
        }
    }

    public int[] inserSort(int[] nums) {
        int len = nums.length;
        for (int j = 1; j < len; ++j) {
            int key = nums[j];
            for (int i = j-1; i >=0; --i) {
                if (key < nums[j]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i + 1] = key;
                }
            }
        }
        return nums;
    }
}

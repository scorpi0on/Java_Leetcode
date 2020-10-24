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
            int[] ouput0 = insertSortDemo.inserSortASC(nums);
            System.out.println(Arrays.toString(ouput0));

            int[] ouput1 = insertSortDemo.inserSortDESC(nums);
            System.out.println(Arrays.toString(ouput1));
        }
    }

    public int[] inserSortASC(int[] nums) {
        int len = nums.length;
        for (int j = 1; j < len; ++j) {
            int key = nums[j];
            int i = j - 1;
            while (i >= 0 && nums[i] > key) {
                nums[i + 1] = nums[i];
                i -= 1;
            }
            nums[i + 1] = key;
        }
        return nums;
    }

    public int[] inserSortDESC(int[] nums) {
        int len = nums.length;
        for (int j = 1; j < len; ++j) {
            int key = nums[j];
            int i = j - 1;
            while( i >= 0 && nums[i] < key) {
                nums[i + 1] = nums[i];
                i -= 1;
            }
            nums[i + 1] = key;
        }
        return nums;
    }
}

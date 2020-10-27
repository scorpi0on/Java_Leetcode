package com.chen.IntroduceToAlgorithm.Chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class AddBinaryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddBinaryDemo addBinaryDemo = new AddBinaryDemo();
        System.out.println("Please input the length n:");
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println("Please input the nums1:");
            int[] nums1 = new int[n];
            for (int i = 0; i<n; ++i){
                nums1[i] = sc.nextInt();
            }
            nums1 = addBinaryDemo.reverseNums(nums1);
            System.out.println("Please input the nums2:");
            int[] nums2 = new int[n];
            for (int i = 0; i<n; ++i){
                nums2[i] = sc.nextInt();
            }
            nums2 = addBinaryDemo.reverseNums(nums2);
            int[] ans = addBinaryDemo.addBinary(nums1, nums2, n);
            ans = addBinaryDemo.reverseNums(ans);
            System.out.print(Arrays.toString(ans));
            System.out.println("Please input the length n:");
        }
    }

    public int[] reverseNums(int[] nums) {
        int mid = (nums.length + 0) / 2;
        for (int i = 0; i < mid; ++i) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        return nums;
    }

    public int[] addBinary(int[] num1, int[] nums2, int length) {
        int[] result = new int[length + 1];
        int carry = 0;

        for (int i=0; i < length; ++i){
            result[i] = (num1[i] + nums2[i] + carry) % 2;
            carry = (num1[i] + nums2[i] + carry) / 2;
        }

        result[length ] = carry;
        return result;
    }
}

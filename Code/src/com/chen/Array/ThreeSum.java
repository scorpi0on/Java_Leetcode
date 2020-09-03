package com.chen.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; ++i){
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int nums1 = nums[i];
            int target = -nums1;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                }else if (nums[left] + nums[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Input array:");
            String str = in.next();
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                nums[j] = Integer.parseInt(arr[j]);
            }
            List<List<Integer>> res = new ThreeSum().threeSum(nums);
            System.out.println(res.toString());
        }
    }
}

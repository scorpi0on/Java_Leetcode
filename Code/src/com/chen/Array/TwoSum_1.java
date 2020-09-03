package com.chen.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//给定 nums = [2, 7, 11, 15], target = 9
//
//        因为 nums[0] + nums[1] = 2 + 7 = 9
//        所以返回 [0, 1]

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length-1; ++i){
            for (int j = i+1; j<nums.length; ++j){
                if (nums[i]+nums[j] == target){
                    int[] ans = {i, j};
                    return ans;
                }
            }
        }
        return null;
    }

    public int[] twoSumHash(int[] nums, int target){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int compl = target - nums[i];
            if (!hashMap.isEmpty() && hashMap.containsKey(nums[i])){
                int[] ans = {hashMap.get(nums[i]),i};
                return ans;
            }
            hashMap.put(compl,i);
        }
        return null;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Input array:");
            String str = in.next();
            String[] arr = str.split(",");
            int[] nums = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                nums[j] = Integer.parseInt(arr[j]);
            }
            System.out.println("Input target:");
            int t = in.nextInt();
            int[] res = new TwoSum_1().twoSumHash(nums, t);
            System.out.println(Arrays.toString(res));
        }
    }
}

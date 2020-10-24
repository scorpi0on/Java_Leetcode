package com.chen.DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//O(nlgn)
public class IntroduceToAlgorithms237 {
    public static void main(String[] args) {
        IntroduceToAlgorithms237 introduceToAlgorithms237 = new IntroduceToAlgorithms237();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input nums array:");
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            int[] i_nums = new int[strs.length];
            for (int i = 0; i < strs.length; ++i) {
                i_nums[i] = Integer.parseInt(strs[i]);
            }
            System.out.println("Input target num:");
            int target = sc.nextInt();
            sc.nextLine();
            //do something
//            Arrays.sort(nums);
            int[] nums = mergeSort(i_nums);
            List<Integer> list = introduceToAlgorithms237.twoSum(nums, target);
            System.out.println(list.toString());
            System.out.println("Input nums array:");
        }
    }
    private static int[] mergeSort(int[] array) {
        // 如果数组的长度大于1，继续分解数组
        if (array.length > 1) {
            int leftLength = array.length / 2;
            int rightLength = array.length - leftLength;
            // 创建两个新的数组
            int[] left = new int[leftLength];
            int[] right = new int[rightLength];
            // 将array中的值分别对应复制到两个子数组中
            for (int i = 0; i < leftLength; i++) {
                left[i] = array[i];
            }
            for (int i = 0; i < rightLength; i++) {
                right[i] = array[leftLength + i];
            }
            // 递归利用合并排序，排序子数组
            left = mergeSort(left);
            right = mergeSort(right);
            // 设置初始索引
            int i = 0;
            int j = 0;
            for (int k = 0; k < array.length; k++) {
                // 如果左边数据索引到达边界则取右边的值
                if (i == leftLength && j < rightLength) {
                    array[k] = right[j];
                    j++;
                    // 如果右边数组索引到达边界，取左数组的值
                } else if (i < leftLength && j == rightLength) {
                    array[k] = left[i];
                    i++;
                    // 如果均为到达则取，较小的值
                } else if (i < leftLength && j < rightLength) {
                    if (left[i] > right[j]) {
                        array[k] = right[j];
                        j++;
                    } else {
                        array[k] = left[i];
                        i++;
                    }
                }
            }
        }
        return array;
    }
    public List<Integer> twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return list;

        for (int i = 0; i < len; ++i) {
            int another = target - nums[i];
            //binarysearch
            Integer ans = binarySearch(nums, another, 0, len-1);
            if (ans != null) {
                list.add(nums[i]);
                list.add(ans);
                break;
            }
        }
        return list;
    }

    public Integer binarySearch(int[] nums, int v, int p, int r) {
        int range = r - p;
        if (range > 0) {
            int q = (r + p) / 2;
            if (nums[q] == v) return v;
            if (nums[q] > v) {
                return binarySearch(nums, v, p, q - 1);
            } else {
                return binarySearch(nums, v, q + 1, r);
            }
        } else {
            if (nums[p] == v) {
                return nums[p];
            } else {
                return null;
            }
        }
    }
}

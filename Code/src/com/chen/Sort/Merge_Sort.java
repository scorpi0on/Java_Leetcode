package com.chen.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Merge_Sort {
    public static void merger_sort(int[] nums, int len){
        merger_sort_c(nums, 0, len-1);
    }

    public static void merger_sort_c(int[] nums, int left, int right){
              if (left >= right){
            return ;
        }

        int middle = (right + left) / 2;

        merger_sort_c(nums, left, middle);
        merger_sort_c(nums, middle+1, right);

        merge_array(nums, right, middle, left);
    }

    public static void merge_array(int[] nums, int right, int middle, int left){
        int i = left, j = middle+1, k = 0;
        int[] tmp = new int[right - left + 1];
        while (i<=middle && j<=right){
            if (nums[i] <= nums[j]){
                tmp[k++] = nums[i++];
            }else {
                tmp[k++]=nums[j++];
            }
        }

        int start = i, end = middle;
        if (j<=right){
            start = j;
            end = right;
        }

        while (start <= end){
            tmp[k++]=nums[start++];
        }

        for (int n = 0; n<=right-left; n++){
            nums[left+n] = tmp[n];
        }
    }

    public static void main(String[] args) {
//        int[] a = {1,5,6,2,3,4};

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the array:");
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(" ");
            int[] a = new int[str.length];
            int i = 0;
            for (String ch:str){
                a[i] = Integer.parseInt(ch);
                ++i;
            }

            Merge_Sort.merger_sort(a, a.length);
            System.out.println(Arrays.toString(a));
            System.out.println("Input the array:");
        }
    }
}

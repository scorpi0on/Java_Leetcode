package com.chen.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Quick_Sort {
    public static void quick_sort(int[] nums){
        int len = nums.length;
        quick_sort_c(nums, 0, len-1);
    }

    public static void quick_sort_c(int[] nums, int left, int right){

        if (left >= right){
            return;
        }

        int pt = partition(nums, left, right);

        quick_sort_c(nums, left, pt-1);
        quick_sort_c(nums, pt+1, right);
    }

    public static int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int i = left;
        for (int j=0; j<right-left; j++){
            if (nums[left+j] < pivot){
                int temp = nums[left+j];
                nums[left+j]=nums[i];
                nums[i]=temp;
                i++;
            }
        }
        int temp = nums[right];
        nums[right]=nums[i];
        nums[i]=temp;
        return i;
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

            Quick_Sort.quick_sort(a);
            System.out.println(Arrays.toString(a));
            System.out.println("Input the array:");
        }
    }

}

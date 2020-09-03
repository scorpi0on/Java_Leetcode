package com.chen.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Insertion_Sort {
    public void insertSort(int[] a, int n){
        if (n < 1) return;

        for (int i = 0 ; i < n ; ++i){
            int value = a[i];
            int j = i -1;
            for ( ; j >= 0 ; --j){
                if (a[j] > value){
                    a[j + 1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public void insertionSort(int[] nums, String... reversed){
        if (reversed[0] == "Reversed"){
            for (int j=1; j<nums.length; ++j){
                int key = nums[j];
                int i = j - 1;
                while (i>=0 && key>nums[i]){
                    nums[i+1] = nums[i];
                    i = i - 1;
                }
                nums[i+1] = key;
            }
        }else {
            for (int j=1; j<nums.length; ++j){
                int key = nums[j];
                int i = j - 1;
                while (i>=0 && key<nums[i]){
                    nums[i+1] = nums[i];
                    i = i - 1;
                }
                nums[i+1] = key;
            }
        }

    }


    public static void main(String[] args) {
        Insertion_Sort insertion_sort = new Insertion_Sort();
//        int[] a = {4,5,6,1,3,2};
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the array:");
        while (sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i<str.length; i++){
                a[i] = Integer.parseInt(str[i]);
            }
//            insertion_sort.insertSort(a, 6);
            insertion_sort.insertionSort(a, "Reversed");
            System.out.println(Arrays.toString(a));
            System.out.println("Input the array:");
        }
        System.out.println("Input the size of array:");
    }
}

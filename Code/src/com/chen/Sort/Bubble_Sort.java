package com.chen.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Bubble_Sort {
    public static void bubble_sort(int[] a){
        int n = a.length;
        if (n <= 1) return;
        for (int i = 0; i < n; ++i){
            boolean flag = false;
            for (int j = 0; j< n - i - 1; ++j){
                if ( a[j+1] < a[j]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the array:");
        while (sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i<str.length; i++){
                a[i] = Integer.parseInt(str[i]);
            }
//            insertion_sort.insertSort(a, 6);
            Bubble_Sort.bubble_sort(a);
            System.out.println(Arrays.toString(a));
            System.out.println("Input the array:");
        }
    }
}

package com.chen.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Selection_Sort {
    public void selectionSort(int[] a){
        int n = a.length;
        if (n < 2){
            return;
        }

        for (int i = 0; i < n; ++i){
            int maxVal = Integer.MAX_VALUE;
            int index = 0;
            int j = i;
            for (; j < n; ++j){
                if (a[j] < maxVal){
                    maxVal = a[j];
                    index = j;
                }
            }
            a[index] = a[i];
            a[i] = maxVal;
        }
    }

    public static void main(String[] args) {
        Selection_Sort selection_sort = new Selection_Sort();
//        int[] a = {4,5,6,3,2,1};
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the array:");
        while (sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i<str.length; i++){
                a[i] = Integer.parseInt(str[i]);
            }
            selection_sort.selectionSort(a);
            System.out.println(Arrays.toString(a));
            System.out.println("Input the array:");
        }
    }
}

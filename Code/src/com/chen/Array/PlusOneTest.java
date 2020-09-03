package com.chen.Array;

import java.util.Arrays;
import java.util.Scanner;

public class PlusOneTest {
    public int[] pulsOne(int[] digits){
        if(digits == null){
            return null;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

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
            PlusOneTest plusOneTest = new PlusOneTest();
            int[] ans = plusOneTest.pulsOne(nums);
            System.out.println(Arrays.toString(ans));
        }
    }
}

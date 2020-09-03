package com.chen.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClimbStairs {
    public int climbStairs(int n){
        if (n <= 0){
            return 0;
        }
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        for (int j = 2; j<n; ++j){
            l.add(l.get(j - 1) + l.get(j - 2));
        }
        return l.get(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("input the number n");
            int n = sc.nextInt();
            if (n == -1){
                break;
            }
            int ans = new ClimbStairs().climbStairs(n);
            System.out.println(ans);
        }
    }
}

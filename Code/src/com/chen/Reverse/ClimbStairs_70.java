package com.chen.Reverse;

/*
* 每次上楼梯可以上 1 层，或者 2 层
* 当 n=1 时候，有 1 种方法
* 当 n=2 时候，有 2 种方法
* 当 n=3时候， 有 1+2 = 3种
* 例如 1->1->1 = 3, 1->2 = 3, 2 -> 1 = 3.
* */

import java.util.Scanner;

public class ClimbStairs_70 {
    public static int climbStarReverse(int n){
        if (n < 0) return 0;
        if (n == 1 || n== 2){
            return n;
        }
        int sum = climbStarReverse(n-1) + climbStarReverse(n-2);
        return sum;
    }

    public static int climbStarIteration(int n){
        if (n < 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int f1 = 1, f2 = 2;
        for (int i = 2; i < n; i++){
            int temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int input = sc.nextInt();
            System.out.println("Recurrent: "+ClimbStairs_70.climbStarReverse(input));
            System.out.println("Iteration: "+ClimbStairs_70.climbStarIteration(input));
        }
    }
}

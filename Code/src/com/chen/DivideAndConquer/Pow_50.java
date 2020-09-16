package com.chen.DivideAndConquer;

public class Pow_50 {
    public double pow(double x, int n){
        long N = n;
        if( N < 0){
            N = -N;
            x = 1 /x;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if( n == 0){
            return 1.0;
        }

        double half = fastPow(x, n/2);

        if( n % 2 == 0){
            return half*half;
        }else{
            return half*half*x;
        }
    }

    public static void main(String[] args) {
        Pow_50 pow = new Pow_50();
        System.out.println(pow.pow(2.0, -10));
    }
}

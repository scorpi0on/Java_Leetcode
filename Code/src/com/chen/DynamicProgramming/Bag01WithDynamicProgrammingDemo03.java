package com.chen.DynamicProgramming;

public class Bag01WithDynamicProgrammingDemo02 {
    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
    private int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 10; // 背包承受的最大重量
    private boolean[][] mem = new boolean[5][10] ;
    public void f(int i, int cw) { // 调用 f(0, 0)
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
        if (cw > maxW) maxW = cw;
        System.out.println(i + " " +maxW);
        return;
        }
        if (mem[i][cw]) return;
        mem[i][cw] = true;
        f(i+1, cw); // 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
        f(i+1,cw + weight[i]); // 选择装第 i 个物品
        }
    }
    public static void main(String[] args) {
      Bag01WithDynamicProgrammingDemo02 bag01WithDynamicProgrammingDemo02 = new Bag01WithDynamicProgrammingDemo02();
      bag01WithDynamicProgrammingDemo02.f(0,0);
    }
}

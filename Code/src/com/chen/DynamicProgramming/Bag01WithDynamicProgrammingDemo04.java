package com.chen.DynamicProgramming;

import java.util.Arrays;

public class Bag01WithDynamicProgrammingDemo04 {

    private int maxV = Integer.MIN_VALUE; // 结果放到 maxV 中
    private int[] items = {2, 2, 4, 6, 3};  // 物品的重量
    private int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    public void f(int i, int cw, int cv) { // 调用 f(0, 0, 0)
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
        if (cv > maxV) maxV = cv;
        return;
        }
        f(i+1, cw, cv); // 选择不装第 i 个物品
        if (cw + items[i] <= w) {
        f(i+1,cw+items[i], cv+value[i]); // 选择装第 i 个物品
        }
    }

    public int knapsack3(int[] weight, int[] value, int n, int w) {
        //初始化状态矩阵，坐标为【物品编号】【背包重量】，值为总价值
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                states[i][j] = -1;
            }
        }
        //遍历所有items
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i = 1; i < n; i++) {
            //不选取第i个物品，[i][j]的值继承[i - 1][j]
            for (int j = 0; j < w; j++) {
                if (states[i - 1][j] >= 0) states[i][j] = states[i-1][j];
            }
            //选取第i个物品，寻找最合适的state，满足j < w-weight[i]，更新其value
            for (int j = 0; j <= w-weight[i]; ++j) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            //在最后的状态里寻找最大值
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }

    public static int knapsack2(int[] items, int[] value, int n, int w) {
        int[] states = new int[w+1]; // 默认值 false
        Arrays.fill(states, -1);
        states[0] = 0;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[items[0]] = value[0];
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w-items[i]; j >= 0; --j) {// 把第 i 个物品放入背包
                if (states[j]>=0) states[j+items[i]] = states[j] + value[i];
            }
        }
        int maxvalue = -1;
        for (int i =0 ; i <= w; ++i) { // 输出结果
            if (states[i] > maxvalue) maxvalue = states[i];
        }
        return maxvalue;
    }

    public static void main(String[] args) {
      Bag01WithDynamicProgrammingDemo04 bag01WithDynamicProgrammingDemo03 = new Bag01WithDynamicProgrammingDemo04();
      bag01WithDynamicProgrammingDemo03.f(0, 0, 0);
      int[] value = bag01WithDynamicProgrammingDemo03.value;
      int[] items = bag01WithDynamicProgrammingDemo03.items;
//      int ans1 = bag01WithDynamicProgrammingDemo03.knapsack3(items, value, 5, 9);
//      System.out.println(ans1);
      int ans2 = bag01WithDynamicProgrammingDemo03.knapsack2(items, value, 5, 9);
      System.out.println(ans2);
    }
}

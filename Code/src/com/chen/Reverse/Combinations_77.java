package com.chen.Reverse;

import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {
    //n = 4, k = 2
    public List<List<Integer>> combine(int n, int k) {
        //递归方式遍历
        if (n == 0 || n < k){
            return null;
        }
        LinkedList<List<Integer>> paths = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        //因为至少有2个数字的组合，所以遍历1，2，3时候可以停止了。单独的元素 4 是无法组成组合的。
        //所以遍历区间长度就是  n - k + 1。
        findCombination(paths, path,1,n - k + 1, k);// 1, 3, 2
        return paths;
    }
    private void findCombination(LinkedList<List<Integer>> paths, LinkedList<Integer> path,int start, int end, int k){
        //终止条件
        if (path.size() == k){
            paths.add(new LinkedList<>(path));
            return;
        }
        else{
            for (int i = start; i <= end ; i++){
                path.add(i);
                //区间右移动
                findCombination(paths, path, i + 1, end + 1 ,k);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations_77 combinations_77 = new Combinations_77();
        List<List<Integer>> result = combinations_77.combine(4,2);
        for (List<Integer> e : result){
            System.out.print("[ ");
            for (Integer k : e){
                System.out.print( k + " ");
            }
            System.out.print("]\n");
        }
    }
}

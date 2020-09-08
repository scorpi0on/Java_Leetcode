package com.chen.Reverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> paths = new LinkedList<>();
        if (len == 0){
            return paths;
        }

        boolean[] used = new boolean[len];
        LinkedList<Integer> path = new LinkedList<>();

//        dfs(nums, len, 0, path, used, paths);

        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer e : nums){
            temp.add(e);
        }
        dfs2(len, temp, paths, 0);

        return paths;
    }

    private void dfs(int[] nums, int len, int depth, LinkedList<Integer> path, boolean[] used, List<List<Integer>> paths) {
        if (depth == len){
            paths.add(new LinkedList<>(path));
            return;
        }else{
            for (int i=0; i < len; i++){
                if (used[i]){
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, paths);
                used[i] = false;
                path.removeLast();
            }
        }
    }

    private void dfs2(int n,
                          ArrayList<Integer> output,
                          List<List<Integer>> res,
                          int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            dfs2(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        Permutations_46 permutations_46 = new Permutations_46();
        List<List<Integer>> ans = permutations_46.permute(new int[]{1,2,3,4});
        for (List<Integer> e : ans){
            System.out.print("[ ");
            for (Integer m : e){
                System.out.print(m+ " ");
            }
            System.out.print("]\n");
        }

    }


}

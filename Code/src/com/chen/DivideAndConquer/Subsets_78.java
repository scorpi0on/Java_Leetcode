package com.chen.DivideAndConquer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;

        dfs(new ArrayList<Integer>(), ans, nums, 0);
        return ans;
    }

    private void dfs(ArrayList<Integer> temp, List<List<Integer>> ans, int[] nums, int index) {
        //terminator
        if (index == nums.length){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        dfs(temp, ans, nums, index+1);

        temp.add(nums[index]);
        dfs(temp, ans, nums, index+1);

        temp.remove(temp.size()-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets_78 subsets_78 = new Subsets_78();
        List<List<Integer>> ans = subsets_78.subsets(nums);
        Iterator iterator = ans.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}

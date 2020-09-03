package com.chen.Stack_Queue;

import java.util.*;

public class SlidingWindowMaximum_239 {
//    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//    输出: [3,3,5,5,6,7]
//    解释:
//
//    滑动窗口的位置                最大值
//---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7

    //暴力 O(n*k)
    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int len = nums.length;
        if (len < k){
            return null;
        }
        int[] maxNums = new int[len-k + 1];
        for (int i = 0; i < len - k + 1; i++){
            int tMax= Integer.MIN_VALUE;
            for (int j = i; j< i + k; j++){
                if (nums[j] > tMax){
                    tMax = nums[j];
                }
            }
            maxNums[i] = tMax;
        }
        return maxNums;
    }

    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        int len = nums.length;
        if (len < k) {
            return null;
        }
        int[] ans = new int[len - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            //如果队列中队头元素和当前元素位置相差i-k，相当于队头元素要
            //出窗口了，就把队头元素给移除，注意队列中存储
            //的是元素的下标（函数peekFirst()表示的是获取队头的下标，函数
            //pollFirst()表示的是移除队头元素的下标）
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //在添加一个值之前，前面比他小的都要被移除掉，并且还要保证窗口
            //中队列头部元素永远是队列中最大的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                //队头元素是队列中最大的，把队列头部的元素加入到数组中
                ans[index++] = nums[deque.peekFirst()];
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input nums:");
        while (sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            int[] nums = new int[str.length];
            int i = 0;
            for (String s : str){
                nums[i] = Integer.parseInt(s);
                ++i;
            }
            System.out.println("Window Length:");
            int k = sc.nextInt();
            int[] ans1 = SlidingWindowMaximum_239.maxSlidingWindowBruteForce(nums, k);
            int[] ans2 = SlidingWindowMaximum_239.maxSlidingWindowDeque(nums,k);

            System.out.println("BruteForce: "+ Arrays.toString(ans1));
            System.out.println("Deque: " + Arrays.toString(ans2));


            System.out.println("Input nums:");
            str = sc.nextLine().split(" ");
        }

//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
//        int[] ans1 = SlidingWindowMaximum_239.maxSlidingWindowBruteForce(nums,k);
//        int[] ans2 = SlidingWindowMaximum_239.maxSlidingWindowDeque(nums,k);
//        System.out.println(Arrays.toString(ans1));
//        System.out.println(Arrays.toString(ans2));
    }
}

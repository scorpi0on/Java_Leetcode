package com.chen.Reverse;

import java.util.*;

//组合问题
//合法性
// 左括号 不能超标
// 右括号个数 小于 左括号才可以添加
public class GenerateParenthesis_22 {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        _generate(0, 0, n, "", result);
        return result;
    }

    public static void _generate(int left, int right, int n, String s, List<String> result){
        //terminate
        if ( left == n && right ==n){
//            System.out.println(s);
            result.add(s);
            return;
        }

        //process
        //drill down
        if (left < n){
            String s1 = s + "(";
            _generate(left+1, right, n, s1, result);
        }
        if (right < left){
            String s2 = s + ")";
            _generate(left,right + 1,n, s2, result);
        }
        //reverse status
    }



    public static void main(String[] args) {
        List<String> ans = GenerateParenthesis_22.generateParenthesis(3);
        Iterator iterator = ans.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}

package com.chen.HashTable;

import java.util.Arrays;

public class IsAnagram_242 {
    //全为小写字母
//    输入: s = "anagram", t = "nagaram"
//    输出: true
//    输入: s = "rat", t = "car"
//    输出: false
    public static boolean isAnagramArrays(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] str1 = s.toLowerCase().toCharArray();
        char[] str2 = t.toLowerCase().toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        int ans = Arrays.compare(str1,str2);
        return ans == 0 ? true: false;
    }

    public static boolean isAnagramHash(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a'] += 1;
        }
        for (int i=0; i<s.length(); i++){
            count[t.charAt(i) - 'a'] -= 1;
            if (count[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean ans = IsAnagram_242.isAnagramHash(s,t);
        if (ans){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}

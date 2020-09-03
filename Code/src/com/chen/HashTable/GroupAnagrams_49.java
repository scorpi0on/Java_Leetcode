package com.chen.HashTable;

import java.util.*;

public class GroupAnagrams_49 {

//    输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//    输出:
//            [
//            ["ate","eat","tea"],
//            ["nat","tan"],
//            ["bat"]
//            ]
//排序比较
    public static List<List<String>> groupAnagramsSort(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

    }
//字典比较
public static List<List<String>> groupAnagramsDict(String[] strs) {
    if (strs.length == 0) return new ArrayList();
    Map<String, List> ans = new HashMap<String, List>();
    int[] count = new int[26];
    for (String s : strs) {
        Arrays.fill(count, 0);
        for (int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a'] ++;
        }

        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<26; i++){
            sb.append("#");
            sb.append(count[i]);
        }
        String key = sb.toString();
        if (!ans.containsKey(key)) ans.put(key, new ArrayList());
        ans.get(key).add(s);
    }
    return new ArrayList(ans.values());

}

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = GroupAnagrams_49.groupAnagramsDict(strs);
        for (List<String> e : ans){
            for (String n : e){
                System.out.print(n+" ");
            }
            System.out.print("\n");
        }
    }
}

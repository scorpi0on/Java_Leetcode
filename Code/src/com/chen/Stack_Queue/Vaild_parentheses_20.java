package com.chen.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Vaild_parentheses_20 {
    public static boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        for (Character character : s.toCharArray()){
            if (character == '('){
                characters.push(')');
            }else if (character == '['){
                characters.push(']');
            }else if (character == '{'){
                characters.push('}');
            }else if (characters.isEmpty() || characters.pop() != character){
                return false;
            }
        }
        return characters.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input:");
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            boolean ans = Vaild_parentheses_20.isValid(str);
            System.out.println("result is:");
            System.out.println(ans);
            System.out.println("Please input:");
        }
    }
}

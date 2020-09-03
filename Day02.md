# Day02 栈、队列、双端队列、优先队列
- 特点：添加删除O(1);查询O(n)

## Stack
LIFO

- 双栈 括号匹配、游览器前进后退

## Queue
FIFO

### Priority Queue
- insert O(n)
- pop O(logN)
- 底层实现 Heap\Bst\Trep....

## Deque
- Stack + Queue

## Leetcode
- 最近相关性 Stack
- 先来后到 Queue
- 栈 -> 队列
- 队列 -> 栈

20.有效的括号
```Java
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
```
155.最小栈
```java
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }
    public void pop() {
        if(stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min_stack.peek();
    }
}
```

## 实战题目
84.柱状图中最大的矩形
```java
``` 
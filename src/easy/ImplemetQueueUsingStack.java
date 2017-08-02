package easy;

import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), 
as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

用栈实现队列的如下操作
push(x) --将元素x压入队列的尾部
pop() -- 从队列头部移除元素
peek() -- 获得第一个元素.
empty() -- 返回队列是否为空

提示：
你必须使用栈的标准操作，这意味着你只能将元素压到顶端，查看和弹出元素从顶端中，查看栈中元素的数目，和判空操作是有效的
取决于语言，栈可能不被支持直接生成，你必须使用一个列表或者双向队列假装成一个栈(双尾部队列)
只要你只使用栈的标准操作
你必须假设所有的操作均为有效的(例如，在一个空队列中不能弹出或者查看栈顶元素)

 */

public class ImplemetQueueUsingStack 
{
	Stack<Integer> s=new Stack<Integer>();
	 Stack<Integer> temp=new Stack<Integer>();
	/** Initialize your data structure here. */
    public ImplemetQueueUsingStack() 
    {
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) 
    {
        while(!s.isEmpty())
        	temp.push(s.pop());
        s.push(x);
        while(!temp.isEmpty())
        	s.push(temp.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() 
    {
        return s.pop();
    }
    
    /** Get the front element. */
    public int peek() 
    {
        return s.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() 
    {
    	return s.isEmpty();
    }
    
    /**
     * leetcode上运行时间最短的代码
     * 推荐阅读的代码，体会其实现的思路
     * 
     */
    
    /*
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    *//** Initialize your data structure here. *//*
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    *//** Push element x to the back of queue. *//*
    public void push(int x) {
        s1.push(x);
    }
    
    *//** Removes the element from in front of queue and returns that element. *//*
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    *//** Get the front element. *//*
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    *//** Returns whether the queue is empty. *//*
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    */
}

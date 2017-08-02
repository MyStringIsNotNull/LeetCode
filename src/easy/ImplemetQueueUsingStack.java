package easy;

import java.util.Stack;

/**
 * 
 * @author ѧͽ
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

��ջʵ�ֶ��е����²���
push(x) --��Ԫ��xѹ����е�β��
pop() -- �Ӷ���ͷ���Ƴ�Ԫ��
peek() -- ��õ�һ��Ԫ��.
empty() -- ���ض����Ƿ�Ϊ��

��ʾ��
�����ʹ��ջ�ı�׼����������ζ����ֻ�ܽ�Ԫ��ѹ�����ˣ��鿴�͵���Ԫ�شӶ����У��鿴ջ��Ԫ�ص���Ŀ�����пղ�������Ч��
ȡ�������ԣ�ջ���ܲ���֧��ֱ�����ɣ������ʹ��һ���б����˫����м�װ��һ��ջ(˫β������)
ֻҪ��ֻʹ��ջ�ı�׼����
�����������еĲ�����Ϊ��Ч��(���磬��һ���ն����в��ܵ������߲鿴ջ��Ԫ��)

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
     * leetcode������ʱ����̵Ĵ���
     * �Ƽ��Ķ��Ĵ��룬�����ʵ�ֵ�˼·
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

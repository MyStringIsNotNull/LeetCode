package easy;

import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

设计一个栈，这个栈支持push,pop,top和在常量时间内返回最小的元素的

push(x)--将元素x压入栈中
pop()--删除栈顶元素
top()--获取栈顶元素
getMin()--返回栈中最小的元素

 */
public class MiniStack 
{
	public static void main(String[] args)
	{
		MiniStack s=new MiniStack();
		s.push(512);
		s.push(-1024);
		s.push(-1024);
		s.push(512);
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		
	}
	/** 
	 * initialize your data structure here. 
	 * 在此初始化你的数据结构
	 */
	/**
	 * 维护两个栈，第一个栈用于存放元素
	 * 
	 * 第二个栈用于存放当前栈中最小的元素
	 */
	Stack<Integer> s;
	Stack<Integer> min;
    public MiniStack() 
    {
    	s=new Stack<Integer>();
    	min=new Stack<Integer>();
    }
    
    public void push(int x)
    {
    	if(min.isEmpty()||min.peek()>=x)
    		min.push(x);
        s.push(x);
    }
    
    public void pop() 
    {
    	if(!min.isEmpty()&&!s.isEmpty()&&min.peek().equals(s.peek()))//注意此处的min.peek().equals(s.peek())不能写为min.peek()==s.peek();
    		min.pop();
    	if(!s.isEmpty())
    		s.pop();
    }
    
    public int top() 
    {
       return s.peek();
    }
    
    public int getMin() 
    {
    	return min.peek();
    }
    
    /**
     * leetcode上运行时间最短的代码，其代码思路并不特别清晰
     *不推荐阅读，
     */
    /*
    long min;
	Stack<Long> stack;
	
    public MinStack() 
    {
        stack=new Stack<>();
    }
    
    public void push(int x) 
    {
        if(stack.isEmpty())
        {
        	stack.push(0L);
        	min=x;
        }
        else
        {
        	stack.push(x-min);//Could be negative if min value to change
        	if(x<min)
        		min=x;
        }
    }
    
    public void pop() 
    {
        if(stack.isEmpty()) 
        	return;
        
        long pop=stack.pop();
        
        if(pop<0) 
        	min=min-pop;
    }
    
    public int top() 
    {
        long top =stack.peek();
        if(top>0) 
        	return (int)(top+min);
        else 
        	return (int)min;
    }
    
    public int getMin() 
    {
        return (int)min;
    }
    
    */
    /**
     * leetcode上另一种较为简单的理解的代码
     * 但是对于这样的代码，其只使用于该份API的实现，当需要实现size()方法和isEmpty()方法的时候
     * 其并不容易
     * 
     */
    /*
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) 
    {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min)
        {          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() 
    {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) 
        	min=stack.pop();
    }

    public int top() 
    {
        return stack.peek();
    }

    public int getMin() 
    {
        return min;
    }*/
}

package easy;

import java.util.Stack;

/**
 * 
 * @author ѧͽ
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

���һ��ջ�����ջ֧��push,pop,top���ڳ���ʱ���ڷ�����С��Ԫ�ص�

push(x)--��Ԫ��xѹ��ջ��
pop()--ɾ��ջ��Ԫ��
top()--��ȡջ��Ԫ��
getMin()--����ջ����С��Ԫ��

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
	 * �ڴ˳�ʼ��������ݽṹ
	 */
	/**
	 * ά������ջ����һ��ջ���ڴ��Ԫ��
	 * 
	 * �ڶ���ջ���ڴ�ŵ�ǰջ����С��Ԫ��
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
    	if(!min.isEmpty()&&!s.isEmpty()&&min.peek().equals(s.peek()))//ע��˴���min.peek().equals(s.peek())����дΪmin.peek()==s.peek();
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
     * leetcode������ʱ����̵Ĵ��룬�����˼·�����ر�����
     *���Ƽ��Ķ���
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
     * leetcode����һ�ֽ�Ϊ�򵥵����Ĵ���
     * ���Ƕ��������Ĵ��룬��ֻʹ���ڸ÷�API��ʵ�֣�����Ҫʵ��size()������isEmpty()������ʱ��
     * �䲢������
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

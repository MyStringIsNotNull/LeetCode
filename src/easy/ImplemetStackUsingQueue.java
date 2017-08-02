package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), 
as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

ʹ�ö���ʵ�����еĲ���

push(x) -- ��Ԫ��xѹ��ջ��.
pop() -- ��ջ��Ԫ���Ƴ�.
top() -- ���ջ��Ԫ��.
empty() -- ����ջ�Ƿ�Ϊ��.

��ʾ��

�����ֻʹ�ö��еı�׼����--����ζ��ֻ����β��ѹ��Ԫ�أ����ײ��鿴�͵���Ԫ�أ���С�ͿյĲ���ͬ������Ч��
���������ԣ����п��ܲ�֧��ֱ�����ɣ��������Ҫʹ��һ��˫����л����б��װ��һ������(˫β������)
ֻҪ��ֻʹ�ö��еı�׼����
�������Ҫ�������еĲ�������Ч��(���磬�ڿ�ջ�в��ܲ鿴���ߵ���ջ���ڵ�Ĳ���)

 */
/**
 * 
 * ��ʵ�ֵ�˼·ΪҪѹ��һ��Ԫ��ʱ���������е�ԭ�е�Ԫ���ȷ�������һ�������У����Ž�Ҫѹ��ջ��Ԫ�ط��������
 * Ȼ������Ԫ�ش�����һ�������з���ԭ�еĶ����У�ʹ���Ϊһ������
 * 
 */
public class ImplemetStackUsingQueue
{
	Queue<Integer> q;
	/** Initialize your data structure here. */
    public ImplemetStackUsingQueue() 
    {
    	q=new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x)
    {
    	Queue<Integer> temp=new LinkedList<Integer>();
        while(!q.isEmpty())
        {
        	temp.add(q.poll());
        }
        q.add(x);
        while(!temp.isEmpty())
        {
        	q.add(temp.poll());
        }
        	
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() 
    {
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() 
    {
    	return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() 
    {
        return q.isEmpty();
    }
    
    /**
     * leetcode������ʱ����̵Ĵ���
     * �Ƽ��Ķ��Ĵ��롣�����push��˼��
     */
    
    /*
    Queue<Integer> stack = new LinkedList<Integer>();

	*//** Initialize your data structure here. *//*
	public MyStack() {
	}

	*//** Push element x onto stack. *//*
	public void push(int x) {
		stack.add(x);
		int s=stack.size();
		for(int i=1;i<s;i++)       //���ö����Է����Լ�����˳��
			stack.add(stack.poll());
	}

	*//** Removes the element on top of the stack and returns that element. *//*
	public int pop() {
		return stack.poll();
	}

	*//** Get the top element. *//*
	public int top() {
		return stack.peek();
	}

	*//** Returns whether the stack is empty. *//*
	public boolean empty() {
		return stack.isEmpty();
	}
    */
    
}

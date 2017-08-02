package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author 学徒
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

使用队列实现下列的操作

push(x) -- 将元素x压入栈中.
pop() -- 将栈顶元素移除.
top() -- 获得栈顶元素.
empty() -- 返回栈是否为空.

提示：

你必须只使用队列的标准操作--这意味着只能在尾部压入元素，从首部查看和弹出元素，大小和空的操作同样是有效的
依赖于语言，队列可能不支持直接生成，你可能需要使用一个双向队列或者列表假装成一个队列(双尾部队列)
只要你只使用队列的标准操作
你可能需要假设所有的操作是有效的(例如，在空栈中不能查看或者弹出栈顶节点的操作)

 */
/**
 * 
 * 其实现的思路为要压入一个元素时，将队列中的原有的元素先放在另外一个队列中，接着将要压入栈的元素放入队列中
 * 然后将其它元素从另外一个队列中返回原有的队列中，使其成为一个队列
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
     * leetcode上运行时间最短的代码
     * 推荐阅读的代码。体会其push的思想
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
		for(int i=1;i<s;i++)       //利用队列自反性自己调整顺序
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

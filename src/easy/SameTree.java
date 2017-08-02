package easy;

import java.util.Stack;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
 Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 

����������������дһ���������ڼ�������Ƿ���һ����

������������ȱ�����Ϊ���ǵĽṹ��ȫ��ͬ������ڵ�����ͬ��ֵ

 */

public class SameTree 
{
	
	/*
	 * ���õ�˼·Ϊ�������ö������ֱ���������ǰ�����������������ı����������ȵ��������֤����������һ���Ķ�����
	 * ���ڴ���������Ҫ����ÿ���ڵ��ֵ�ǲ�ͬ�ģ�����ڵ��ֵΪ��ͬ������£����õ�һ����Ľ��
	 * ���磺
	 * [1,1]
	 * [1,null,1]
	 * �����ö���������������ͬ��
	 * 
	 * ����ķ����ǣ�Ϊÿһ��Ҷ�ڵ�Ŀսڵ������һ������ڵ㣬��ֵΪInteger.MAX_VALUE
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) 
	{
		boolean result=true;
		if(!getStringByMid(p).equals(getStringByMid(q)))
			result=false;
		if(result&&!getStringByPre(p).equals(getStringByPre(q)))
			result=false;
		return result;
    }
	
	/*
	//��һ�ö����������������
	private String getStringByMid(TreeNode p)
	{
		String result="";
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(p);
		while(!stack.isEmpty())
		{
			while(stack.peek()!=null)
			{
				stack.push(stack.peek().left);
			}
			//���սڵ���е�������
			stack.pop();
			if(!stack.isEmpty())
			{
				TreeNode node=stack.pop();
				result+=node.val;
				stack.push(node.right);
			}
		}
		return result;
	}
	
	//��һ�ö���������ǰ�����
	private String getStringByPre(TreeNode p)
	{
		String result="";
		Stack<TreeNode> stack=new Stack<TreeNode>();
		if(p!=null)
			stack.push(p);
		while(!stack.isEmpty())
		{
			TreeNode node=stack.pop();
			result+=node.val;
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
		return result;
	}
	*/
	
	//��һ�ö����������������
	private String getStringByMid(TreeNode p)
	{
		String result="";
		Stack<TreeNode> stack=new Stack<TreeNode>();
		if(p!=null)
			stack.push(p);
		else
			stack.push(new TreeNode(Integer.MAX_VALUE));
		while(!stack.isEmpty())
		{
			while(stack.peek()!=null&&stack.peek().val!=Integer.MAX_VALUE)
			{
				if(stack.peek().left!=null)
					stack.push(stack.peek().left);
				else
					stack.push(new TreeNode(Integer.MAX_VALUE));
					
			}
			//ȥ����Ϊnull�Ľڵ�
			if(stack.peek()==null)
			{
				stack.pop();
			}
			if(!stack.isEmpty())
			{
				TreeNode node=stack.pop();
				result+=node.val;
				if(node.right!=null&&node.val!=Integer.MAX_VALUE)
					stack.push(node.right);
				else if(node.right==null&&node.val!=Integer.MAX_VALUE)
					stack.push(new TreeNode(Integer.MAX_VALUE));
				else if(node.right==null&&node.val==Integer.MAX_VALUE)
					stack.push(null);
			}
		}
		return result;
	}
	
	//��һ�ö���������ǰ�����
	private String getStringByPre(TreeNode p)
	{
		String result="";
		Stack<TreeNode> stack=new Stack<TreeNode>();
		if(p!=null)
			stack.push(p);
		else
			stack.push(new TreeNode(Integer.MAX_VALUE));
		while(!stack.isEmpty())
		{
			TreeNode node=stack.pop();
			result+=node.val;
			if(node.right!=null&&node.right.val!=Integer.MAX_VALUE)
				stack.push(node.right);
			else if(node.right==null&&node.val!=Integer.MAX_VALUE)
				stack.push(new TreeNode(Integer.MAX_VALUE));
			if(node.left!=null&&node.left.val!=Integer.MAX_VALUE)
				stack.push(node.left);
			else if(node.left==null&&node.val!=Integer.MAX_VALUE)
				stack.push(new TreeNode(Integer.MAX_VALUE));
		}
		return result;
	}
	
	
	
	/**
	 * leetcode������ʱ�����ٵĴ���
	 * 
	 * �ݹ��һ��˼·�� ����ܺõ�˵���˵ݹ��㷨�ĺô����Ƽ��Ķ�
	 */
	/*
	 public boolean isSameTree(TreeNode p, TreeNode q) 
	{
        if (p == null && q == null)
        	return true;
        if (p != null && q != null && p.val == q.val) 
        {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
    */
	
}

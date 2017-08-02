package easy;

import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 

给定两个二叉树，写一个函数用于检查它们是否是一样的

两个二叉树相等被定义为它们的结构完全相同并且其节点有相同的值

 */

public class SameTree 
{
	
	/*
	 * 采用的思路为，对两棵二叉树分别进行中序和前序遍历，如果两棵树的遍历结果都相等的情况，则证明其是两棵一样的二叉树
	 * 对于此种做法，要求其每个节点的值是不同的，当其节点的值为相同的情况下，其会得到一错误的结果
	 * 例如：
	 * [1,1]
	 * [1,null,1]
	 * 这两棵二叉树，其结果是相同的
	 * 
	 * 解决的方法是，为每一个叶节点的空节点出增加一个虚拟节点，其值为Integer.MAX_VALUE
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
	//对一棵二叉树进行中序遍历
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
			//将空节点进行弹出处理
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
	
	//对一棵二叉树进行前序遍历
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
	
	//对一棵二叉树进行中序遍历
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
			//去除掉为null的节点
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
	
	//对一棵二叉树进行前序遍历
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
	 * leetcode上运行时间最少的代码
	 * 
	 * 递归的一个思路。 该题很好的说明了递归算法的好处，推荐阅读
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

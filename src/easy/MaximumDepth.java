package easy;

import java.util.Stack;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

给定一棵二叉树，寻找其树的深度

树的深度是节点沿着最长的路径从根节点到最远的叶子节点的长度


 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepth 
{
	public int maxDepth(TreeNode root) 
	{
		//用于记录下深度遍历二叉树的过程中的各个子节点
        Stack<TreeNode> stack=new Stack<TreeNode>();
        //用于记录下深度遍历二叉树的过程中节点的方向，true为右边，false为左边
        Stack<Boolean> direction=new Stack<Boolean>();
        //用于保存最大的深度的结果
        int result=0;
        //用于记录下临时的叶节点的深度
        int temp=0;
        if(root!=null)
        {
        	stack.push(root);
        	temp++;
        }
        while(!stack.isEmpty())
        {
        	TreeNode node=stack.peek();
        	//证明其为叶子节点
        	if(node.left==null&&node.right==null)
        	{
        		if(temp>result)
        		{
        			result=temp;
        			
        		}
        		//弹出该叶节点
        		stack.pop();
        		//重置当前节点的深度
        		temp--;
        		if(!direction.isEmpty())
        		{
        			boolean directions=direction.pop();
        			if(directions)
        			{
        				stack.peek().right=null;
        			}
        			else
        			{
        				stack.peek().left=null;
        			}
        		}
        	}
        	else
        	{
        		if(node.left!=null)
        		{
        			direction.push(false);
        			stack.push(node.left);
        			temp++;
        		}
        		else
        		{
        			direction.push(true);
        			stack.push(node.right);
        			temp++;
        		}
        	}
        	
        }
        return result;
    }
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读，其很好的运用了递归的思路解决了问题
	 * 
	 */
	/*public int maxDepth(TreeNode root) 
	{
        if(root==null)
        {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }*/
}

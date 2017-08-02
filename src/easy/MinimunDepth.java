package easy;

import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

给定一个二叉树，寻找其最短的深度

最短的省队为其从根节点沿着其最短的路径(离根节点最靠近的叶子节点)的过程中所经过的节点的数目

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
public class MinimunDepth 
{
	public int minDepth(TreeNode root) 
    {
		//当其节点本身为null时，返回0
	     if(root==null) 
	        return 0;
	     //当左子树和右子树均不为null时，返回1+左右子树中年最小深度的那个
	     if(root.left!=null&&root.right!=null)
	         return 1+Math.min(minDepth(root.left),minDepth(root.right));
	     //当左右子树均为空的时候，其值为该节点本身
	    else if(root.left==null&&root.right==null)
	        return 1;
	     //当左子树为空，右子树不为空时，其深度为1+右子树的深度
    	else if(root.left==null)
	            return 1+minDepth(root.right);
	   //当右子树为空，左子树不为空时，其深度为1+左子树的深度
        else
	            return 1+minDepth(root.left);
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其思路不如上面的代码清晰(其上的代码，运行时间在leetcode上也是最短的)
	 *故不推荐阅读以下代码
	 */
	/*
	 * 
	public int minDepth(TreeNode root)
	{
        if (root == null) 
        	return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null) 
        	return right+1;
        if (root.right == null) 
        	return left+1;
        return Math.min(left, right) + 1;
    }
	 */
	
}

package easy;

import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

给定一个二叉树以及一个和，判断是否存在一条从根到页的路径，使得其沿着路径的各个节点的值的和等于给定的那个值

例如:

给定下列的一个二叉树和值sum=22
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        
其存在从根到叶的路径5->4->11->2使得其和为22，故返回true

 */

public class PathSum 
{
	public boolean hasPathSum(TreeNode root, int sum) 
	{
        if(root==null)
        	return false;
        if(root.val==sum&&root.left==null&&root.right==null)
        	return true;
        else if(root.left!=null&&root.right!=null)
        	return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
        else if(root.left==null&&root.right!=null)
        	return hasPathSum(root.right,sum-root.val);
        else if(root.left!=null&&root.right==null)
        	return hasPathSum(root.left,sum-root.val);
        else
        	return false;
        //对其进行简化之后的代码,其思路和以上的一致
        /*
	        if(root==null)
	        	return false;
	        if(root.left==null&&root.right==null)
	        	return sum==root.val;
	        else
	        	return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
         */
        
        /**
         * leetcode上运行时间最短的代码
         */
        /*public boolean hasPathSum(TreeNode root, int sum) 
        {
            if(root == null) 
            	return false;
            if(root.left == null && root.right == null) 
            	return sum == root.val;
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }*/
        
        
    }
}

package easy;

import java.util.Stack;

/**
 * 
 * @author ѧͽ
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

����һ���������Լ�һ���ͣ��ж��Ƿ����һ���Ӹ���ҳ��·����ʹ��������·���ĸ����ڵ��ֵ�ĺ͵��ڸ������Ǹ�ֵ

����:

�������е�һ����������ֵsum=22
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        
����ڴӸ���Ҷ��·��5->4->11->2ʹ�����Ϊ22���ʷ���true

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
        //������м�֮��Ĵ���,��˼·�����ϵ�һ��
        /*
	        if(root==null)
	        	return false;
	        if(root.left==null&&root.right==null)
	        	return sum==root.val;
	        else
	        	return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
         */
        
        /**
         * leetcode������ʱ����̵Ĵ���
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

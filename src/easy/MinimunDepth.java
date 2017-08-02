package easy;

import java.util.Stack;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

����һ����������Ѱ������̵����

��̵�ʡ��Ϊ��Ӹ��ڵ���������̵�·��(����ڵ������Ҷ�ӽڵ�)�Ĺ������������Ľڵ����Ŀ

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
		//����ڵ㱾��Ϊnullʱ������0
	     if(root==null) 
	        return 0;
	     //��������������������Ϊnullʱ������1+��������������С��ȵ��Ǹ�
	     if(root.left!=null&&root.right!=null)
	         return 1+Math.min(minDepth(root.left),minDepth(root.right));
	     //������������Ϊ�յ�ʱ����ֵΪ�ýڵ㱾��
	    else if(root.left==null&&root.right==null)
	        return 1;
	     //��������Ϊ�գ���������Ϊ��ʱ�������Ϊ1+�����������
    	else if(root.left==null)
	            return 1+minDepth(root.right);
	   //��������Ϊ�գ���������Ϊ��ʱ�������Ϊ1+�����������
        else
	            return 1+minDepth(root.left);
    }
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼·��������Ĵ�������(���ϵĴ��룬����ʱ����leetcode��Ҳ����̵�)
	 *�ʲ��Ƽ��Ķ����´���
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

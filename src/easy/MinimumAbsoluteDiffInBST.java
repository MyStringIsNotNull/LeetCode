package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).

Note: There are at least two nodes in this BST. 

����һ���������������������ڵ��ֵ��Ϊ�Ǹ��ģ��ҵ��������е����������ڵ��ֵ����Сֵ

���磺
����:
   1
    \
     3
    /
   2
���1

����:
��С�ľ���ֵ֮��Ϊ1���������ڵ�Ϊ2��1(����2��3)

ע��:
�����ڶ���������������������ڵ�

 */
public class MinimumAbsoluteDiffInBST
{
	public int getMinimumDifference(TreeNode root)
	{
        int min=Integer.MAX_VALUE;
        if(root==null)
        	return min;
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        if(root.left!=null)
        	left=getSmall(root.left);
        if(root.right!=null)
        	right=getBig(root.right);
        min=Math.min(getMinimumDifference(root.right),Math.min(getMinimumDifference(root.left),Math.min(Math.abs(root.val-left), Math.abs(root.val-right))));
        return min;
	}
	//���ڻ�ȡ�ýڵ�node�������µĽڵ��ֵ������û��������������������ʱ�򣬷���������
	private int getBig(TreeNode node)
	{
		if(node.left==null)
			return node.val;
		return getBig(node.left);
	}
	//���ڻ�ȡ�ýڵ�node�������µĽڵ��ֵ������û��������������������ʱ�򣬷���������
	private int getSmall(TreeNode node)
	{
		if(node.right==null)
			return node.val;
		return getSmall(node.right);
	}
	
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * ��˼·Ϊ:
	 * �Զ�������������������(�Զ�����������������������õ��Ľ��Ϊ���ڵ��ֵ���յ�����˳�����)
	 *ps:�������Ϊ�����
	 *
	 */
	/*
	//���ڼ�¼���������е���Сֵ
	int min = Integer.MAX_VALUE;
	//���ڼ�¼�¿�����ǰ�ڵ��ǰһ���ڵ��ֵ
	Integer prev = null;
	public int getMinimumDifference(TreeNode root)
	{
		if (root == null)
			return min;
		getMinimumDifference(root.left);
		if (prev != null)
		{
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;
		getMinimumDifference(root.right);
		return min;
	}
	 */
}

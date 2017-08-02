package easy;
/**
 * 
 * @author 学徒
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

给定一个二叉查找树，其中任意节点的值均为非负的，找到二叉树中的任意两个节点的值的最小值

例如：
输入:
   1
    \
     3
    /
   2
输出1

解释:
最小的绝对值之差为1，其两个节点为2和1(或者2和3)

注意:
其中在二叉查找树中最少有两个节点

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
	//用于获取该节点node的最左下的节点的值，当其没有左子树而有右子树的时候，返回其自身
	private int getBig(TreeNode node)
	{
		if(node.left==null)
			return node.val;
		return getBig(node.left);
	}
	//用于获取该节点node的最右下的节点的值，当其没有左子树而有右子树的时候，返回其自身
	private int getSmall(TreeNode node)
	{
		if(node.right==null)
			return node.val;
		return getSmall(node.right);
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其思路为:
	 * 对二叉查找数进行中序遍历(对二叉查找数进行中序遍历，其得到的结果为将节点的值按照递增的顺序输出)
	 *ps:中序遍历为左根右
	 *
	 */
	/*
	//用于记录整个过程中的最小值
	int min = Integer.MAX_VALUE;
	//用于记录下靠近当前节点的前一个节点的值
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

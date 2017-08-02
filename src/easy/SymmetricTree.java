package easy;


/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively. 

给定一棵二叉树，检查其是否是镜像对称的(中心旋转对称)
例如，二叉树[1,2,2,3,4,4,3]是匀称的

    1
   / \
  2   2
 / \ / \
3  4 4  3

但二叉树[1,2,2,null,3,null,3]并不是对称的

    1
   / \
  2   2
   \   \
   3    3

提示:
加分点是，你能够使用递归和迭代的方式解决这个问题


ps解题的关键在于需要知道:是否对称就是要求每一层从左到右刚好等于从右到左

 */

public class SymmetricTree 
{
	/**
	 * 解题的思路为：
	 * 对二叉树的左子树进行先序遍历(即按照左右根的方式进行遍历)
	 * 对二叉树的右子树进行右左根的方式进行遍历
	 * 若遍历得到的结果为相同的，则表示其为关于根节点呈镜像对称的
	 * 
	 */
	public boolean isSymmetric(TreeNode root)
	{
		StringBuffer pre=new StringBuffer("");
		StringBuffer unnormal=new StringBuffer("");
		if(root==null)
			return true;
		UnnormalVisit(root.right,unnormal);
		preVisit(root.left,pre);
		if(pre.toString().equals(unnormal.toString()))
			return true;
		else
			return false;
    }
	
	/*
	 * 进行右左根的方式进行遍历
	 */
	private void UnnormalVisit(TreeNode node,StringBuffer result)
	{
		if(node==null)
		{
			result.append("n");
			return;
		}
		UnnormalVisit(node.right,result);
		UnnormalVisit(node.left,result);
		result.append(node.val);
	}
	/*
	 * 进行先序遍历
	 * 即左右根的方式
	 */
	private void preVisit(TreeNode node,StringBuffer result)
	{
		if(node==null)
		{
			result.append("n");
			return;
		}
		preVisit(node.left,result);
		preVisit(node.right,result);
		result.append(node.val);
	}
	
	
	/**
	 * leetcode上运行时间最少的代码
	 * 推荐阅读的代码，其递归算法的思路尽显无疑
	 * 虽然自己也想过用递归的方式来实现，并且其大致的思路知道，但是就是无法写好递归的如下的这份代码
	 * 所以要多加努力。 date:2017-7-4
	 */
/*
	public boolean isSymmetric(TreeNode root) 
	{
        if(root == null) 
        	return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) 
    {
        if(left == null && right == null) 
        {
            return true;
        } 
        //此处的left==null||right==null不能省略，并且其要求放在left.val!=right.val的左边，否则会出现报错的情况
        //此处为其写得精妙的地方
        else if(left == null || right == null || left.val != right.val) 
        {
            return false;
        }
        else 
        {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
    }
    */
	
}

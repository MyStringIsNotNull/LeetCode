package easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
给定一棵二叉查找树，找到其二叉查找树中给定的两个节点的最小的公共祖先
According to the definition of LCA on Wikipedia: 
按照在Wikipedia中对最小公共祖先的定义:
"The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
最小的公共祖先定义在两个节点v和w之间。其在树中最小的节点都将v和w作为其后代
(where we allow a node to be a descendant of itself).”
(此处，我们允许节点为其本身的后代)

 _______6______
       /              \
___2__       ___8__
  /      \        /      \
 0      _4       7       9
         /  \
         3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
例如，2和8最小公共祖先是6，另一个例子，2和4的最小公共祖先为2
since a node can be a descendant of itself according to the LCA definition.
因为，按照最小公共祖先的定义，一个节点可以成为其后代本身


 */
public class LowestCommonAncestor
{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
	{
		TreeNode result=null;
        Queue<TreeNode> qp=new LinkedList<TreeNode>();
        findPaths(root,p,qp);
        Queue<TreeNode> qq=new LinkedList<TreeNode>();
        findPaths(root,q,qq);
        while(!qp.isEmpty())
        {
        	TreeNode node=qp.poll();
        	if(qq.contains(node))
        	{
        		result=node;
        		break;
        	}
        }
        return result;
    }
	//用于查找一个从根节点到需要查找的节点的路径，并将其填入队列q中
	private void findPaths(TreeNode root,TreeNode toFind,Queue<TreeNode> q)
	{
		Set<TreeNode> set=new HashSet<TreeNode>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		set.add(root);
		while(!stack.isEmpty())
		{
			TreeNode node=stack.peek();
			if(node==toFind)
				break;
			if(node.left!=null&&!set.contains(node.left))
			{
				stack.push(node.left);
				set.add(node.left);
			}
			else if(node.right!=null&&!set.contains(node.right))
			{
				stack.push(node.right);
				set.add(node.right);
			}
			else
			{
				stack.pop();
			}
		}
		while(!stack.isEmpty())
		{
			q.add(stack.pop());
		}
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 此处利用了二叉查找树的性质(即左子树节点小于根节点小于右子树节点，根节点小于右子树节点)
	 * 利用了这个性质在该二叉查找树中进行递归的查询
	 * 当两个节点的值均大于根节点的值时，其表明其两个节点均存在根节点的右子树中，故最小的祖先为其右子树的节点
	 * 当两个节点的值均小于根节点的值时，其表明其两个节点均存在根节点的左子树中，故最小的祖先为其左子树的节点
	 * 当两个节点的值一个大于根节点的值，一个小于根节点的值时，其最小的祖先为其当前根节点
	 * 而以上自己所写的代码，并没有利用二叉查找树的性质。其适用于所有的二叉树
	 * 
	 * 
	 */
	/*
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
	{
        if (root == null || p == null || q == null) 
        	return root;
        if (p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        } 
        else if (p.val > root.val && q.val > root.val) 
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        else 
        {
            return root;
        }
    }
	*/
}

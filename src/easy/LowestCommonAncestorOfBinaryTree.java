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
 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
给定一棵二叉树，找到其二叉查找树中给定的两个节点的最小的公共祖先
According to the definition of LCA on Wikipedia: 
按照在Wikipedia中对最小公共祖先的定义:
“The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
最小的公共祖先定义在两个节点v和w之间。其在树中最小的节点都将v和w作为其后代
(where we allow a node to be a descendant of itself).”
(此处，我们允许节点为其本身的后代)
        _______3______
       		/              \
    ___5__          ___1__
   	/        \   		   /      \
   6     	 _2          0       8
         	/  \
         	7   4

For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
例如，5和1最小公共祖先是3.
Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
另一个例子，5和4的最小公共祖先为5,因为，按照最小公共祖先的定义，一个节点可以成为其后代本身

 */
public class LowestCommonAncestorOfBinaryTree 
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
	 * 推荐阅读的代码
	 * 其思路为:当节点p和q在当前节点的同一边时，进行迭代查询
	 * 当节点p和q在当前节点两边的时候，当前节点为其节点p和q的最小公共祖先
	 * 
	 */
	/*
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(isChild(p,q))
            return p;
        if(isChild(q,p))
            return q;
        while(true)
        {
        	//if和elseif部分用于判断q和p其是否为当前节点的同一边
            if(isChild(root.left,p) && isChild(root.left,q))
            {
                root = root.left;
            }
            else if(isChild(root.right,p) && isChild(root.right,q))
            {
                root = root.right;
            }
            else
            {
                break;
            }
        }
        return root;
    }
    //用于判断节点child是否为parent的后代节点
    public boolean isChild(TreeNode parent, TreeNode child)
    {
        if(parent==null)
            return false;
        if(parent.left==child || parent.right==child)
            return true;
        return isChild(parent.left,child) || isChild(parent.right,child);
    }
	*/
	
}

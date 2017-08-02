package easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]

给定一个二叉树，返回所有从根到叶的路径
例如，给定如下的二叉树:
   1
 /   \
2     3
 \
  5
所有从根到叶的路径为:
["1->2->5", "1->3"]

 */
public class BinaryTreePath 
{
	//用于存储入过栈的节点
	private Set<TreeNode> set=new HashSet<TreeNode>();
	//用于存储节点
	private Stack<TreeNode> stack=new Stack<TreeNode>();
	//用于记录下当前路径的字符串
	private StringBuffer now=new StringBuffer();
	public List<String> binaryTreePaths(TreeNode root) 
	{
	   List<String> result=new LinkedList<String>();
	   if(root==null)
		   return result;
	   stack.push(root);
	   set.add(root);
	   now.append(root.val+" ");
	   while(!stack.isEmpty())
	   {
		   TreeNode node=stack.peek();
		   if(node.left!=null&&!set.contains(node.left))
		   {
			   stack.push(node.left);
			   set.add(node.left);
			   now.append(node.left.val+" ");
		   }
		   else if(node.right!=null&&!set.contains(node.right))
		   {
			   stack.push(node.right);
			   set.add(node.right);
			   now.append(node.right.val+" ");
		   }
		   else if(node.right==null&&node.left==null)
		   {
			   stack.pop();
			   result.add(now.toString().trim().replaceAll(" ", "->"));
			   int length=now.length();
			   now.delete(now.lastIndexOf(String.valueOf(node.val)),length);
		   }
		   else
		   {
			   stack.pop();
			   int length=now.length();
			   now.delete(now.lastIndexOf(String.valueOf(node.val)),length);
		   }
	   }
	   return result;
	}
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其采用递归的思想，很好的解决了这个问题
	 * 推荐阅读
	 */
	/*
	public List<String> binaryTreePaths(TreeNode root) 
	{
		 List<String> list = new LinkedList<String>();
        if(root == null) 
        {
            return list;
        }
        helper(root,list,"");
        return list;
    }
    public void helper(TreeNode node, List<String> list, String s)
    {
        if(node.left == null && node.right == null) 
        {
            list.add(s+node.val);
        }
        else
        {
	        if(node.left != null) 
	        {
	            helper(node.left,list,s+node.val+"->");
	        }
	        if(node.right != null)
	        {
	            helper(node.right,list,s+node.val+"->");
	        }
        }
    }
	*/
}

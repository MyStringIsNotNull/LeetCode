package easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author ѧͽ
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

����һ�����������������дӸ���Ҷ��·��
���磬�������µĶ�����:
   1
 /   \
2     3
 \
  5
���дӸ���Ҷ��·��Ϊ:
["1->2->5", "1->3"]

 */
public class BinaryTreePath 
{
	//���ڴ洢���ջ�Ľڵ�
	private Set<TreeNode> set=new HashSet<TreeNode>();
	//���ڴ洢�ڵ�
	private Stack<TreeNode> stack=new Stack<TreeNode>();
	//���ڼ�¼�µ�ǰ·�����ַ���
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
	 * leetcode������ʱ����̵Ĵ���
	 * ����õݹ��˼�룬�ܺõĽ�����������
	 * �Ƽ��Ķ�
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

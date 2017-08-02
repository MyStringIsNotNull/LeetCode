package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author 学徒
 *
 */
/*
 *question:
 
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

给定一个二叉树，返回其从自底向上的顺序读取的节点的值
(提示:同一层从左到右的顺序，不同层是从叶到根(此处应该是想说从最低层到最高层)的顺序)
例如:
给定一个二叉树[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
   
返回从底到顶的阅读顺序为:
[
  [15,7],
  [9,20],
  [3]
]

 */


public class LevelOrderTraversal 
{
	//该内部类用于封装节点
	class Node
	{
		TreeNode node;
		int level;
		public Node(TreeNode node,int level)
		{
			this.level=level;
			this.node=node;
		}
	}
	/**
	 * 用到的思路是记录下各个节点所对应的层次，并对二叉树进行层次遍历以得到结果
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		//用于存放层次遍历过程中的节点
        Queue<Node> q=new LinkedList<Node>();
        //用来存放遍历的结果
        LinkedList<Node> out=new LinkedList<Node>();
        if(root!=null)	
        	q.add(new Node(root,1));
        while(!q.isEmpty())
        {
        	Node n=q.poll();
        	out.add(n);
        	if(n.node.left!=null)
        		q.add(new Node(n.node.left,n.level+1));
        	if(n.node.right!=null)
        		q.add(new Node(n.node.right,n.level+1));
        }
        int level=0;
        List<Integer> l=new LinkedList<Integer>();
        Stack<List<Integer>> result=new Stack<List<Integer>>();
        if(!out.isEmpty())
        {
        	level=out.peek().level;
        }
        while(!out.isEmpty())
        {
        	Node node=out.poll();
        	if(node.level!=level)
        	{
        		result.push(l);
        		l=new LinkedList<Integer>();
        		level=node.level;
        	}
        	l.add(node.node.val);
        }
        //用于将最后一个层的节点加入
        if(!l.isEmpty())
        	result.push(l);
        List<List<Integer>> results=new LinkedList<List<Integer>>();
        while(!result.isEmpty())
        {
        	results.add(result.pop());
        }
        return results;  
    }
	
	
	/**
	 * leetcode上运行时间最短的代码
	 * 递归的思路，推荐阅读的代码
	 * 
	 */
	/*
	public List<List<Integer>> levelOrderBottom(TreeNode root) 
	{
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        addLevel(list, 0, root);
        return list;
    }
	private void addLevel(LinkedList<List<Integer>> list, int level, TreeNode node) 
	{
		if (node == null)
			return;
		if (list.size()-1 < level)//表示有该层的节点但是没有该层的List<Integer>对象的时候，创建一个新的层的List<Integer>对象
			list.addFirst(new LinkedList<Integer>());
		list.get(list.size()-1-level).add(node.val);//当有该层的List<Integer>对象的时候，将节点加入相应的层的List<Integer>对象中
		addLevel(list, level+1, node.left);//加入该节点所在层的节点的左节点，其下一节点的层为level+1层
		addLevel(list, level+1, node.right);//加入该节点所在层的节点的右节点，其下一节点的层为level+1层
	}
	 */
	
}

package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author ѧͽ
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

����һ������������������Ե����ϵ�˳���ȡ�Ľڵ��ֵ
(��ʾ:ͬһ������ҵ�˳�򣬲�ͬ���Ǵ�Ҷ����(�˴�Ӧ������˵����Ͳ㵽��߲�)��˳��)
����:
����һ��������[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
   
���شӵ׵������Ķ�˳��Ϊ:
[
  [15,7],
  [9,20],
  [3]
]

 */


public class LevelOrderTraversal 
{
	//���ڲ������ڷ�װ�ڵ�
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
	 * �õ���˼·�Ǽ�¼�¸����ڵ�����Ӧ�Ĳ�Σ����Զ��������в�α����Եõ����
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		//���ڴ�Ų�α��������еĽڵ�
        Queue<Node> q=new LinkedList<Node>();
        //������ű����Ľ��
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
        //���ڽ����һ����Ľڵ����
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
	 * leetcode������ʱ����̵Ĵ���
	 * �ݹ��˼·���Ƽ��Ķ��Ĵ���
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
		if (list.size()-1 < level)//��ʾ�иò�Ľڵ㵫��û�иò��List<Integer>�����ʱ�򣬴���һ���µĲ��List<Integer>����
			list.addFirst(new LinkedList<Integer>());
		list.get(list.size()-1-level).add(node.val);//���иò��List<Integer>�����ʱ�򣬽��ڵ������Ӧ�Ĳ��List<Integer>������
		addLevel(list, level+1, node.left);//����ýڵ����ڲ�Ľڵ����ڵ㣬����һ�ڵ�Ĳ�Ϊlevel+1��
		addLevel(list, level+1, node.right);//����ýڵ����ڲ�Ľڵ���ҽڵ㣬����һ�ڵ�Ĳ�Ϊlevel+1��
	}
	 */
	
}

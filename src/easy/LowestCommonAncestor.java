package easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
����һ�ö�����������ҵ������������и����������ڵ����С�Ĺ�������
According to the definition of LCA on Wikipedia: 
������Wikipedia�ж���С�������ȵĶ���:
"The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
��С�Ĺ������ȶ����������ڵ�v��w֮�䡣����������С�Ľڵ㶼��v��w��Ϊ����
(where we allow a node to be a descendant of itself).��
(�˴�����������ڵ�Ϊ�䱾��ĺ��)

 _______6______
       /              \
___2__       ___8__
  /      \        /      \
 0      _4       7       9
         /  \
         3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
���磬2��8��С����������6����һ�����ӣ�2��4����С��������Ϊ2
since a node can be a descendant of itself according to the LCA definition.
��Ϊ��������С�������ȵĶ��壬һ���ڵ���Գ�Ϊ��������


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
	//���ڲ���һ���Ӹ��ڵ㵽��Ҫ���ҵĽڵ��·�����������������q��
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
	 * leetcode������ʱ����̵Ĵ���
	 * �˴������˶��������������(���������ڵ�С�ڸ��ڵ�С���������ڵ㣬���ڵ�С���������ڵ�)
	 * ��������������ڸö���������н��еݹ�Ĳ�ѯ
	 * �������ڵ��ֵ�����ڸ��ڵ��ֵʱ��������������ڵ�����ڸ��ڵ���������У�����С������Ϊ���������Ľڵ�
	 * �������ڵ��ֵ��С�ڸ��ڵ��ֵʱ��������������ڵ�����ڸ��ڵ���������У�����С������Ϊ���������Ľڵ�
	 * �������ڵ��ֵһ�����ڸ��ڵ��ֵ��һ��С�ڸ��ڵ��ֵʱ������С������Ϊ�䵱ǰ���ڵ�
	 * �������Լ���д�Ĵ��룬��û�����ö�������������ʡ������������еĶ�����
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

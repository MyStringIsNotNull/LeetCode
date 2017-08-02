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
 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
����һ�ö��������ҵ������������и����������ڵ����С�Ĺ�������
According to the definition of LCA on Wikipedia: 
������Wikipedia�ж���С�������ȵĶ���:
��The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
��С�Ĺ������ȶ����������ڵ�v��w֮�䡣����������С�Ľڵ㶼��v��w��Ϊ����
(where we allow a node to be a descendant of itself).��
(�˴�����������ڵ�Ϊ�䱾��ĺ��)
        _______3______
       		/              \
    ___5__          ___1__
   	/        \   		   /      \
   6     	 _2          0       8
         	/  \
         	7   4

For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
���磬5��1��С����������3.
Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
��һ�����ӣ�5��4����С��������Ϊ5,��Ϊ��������С�������ȵĶ��壬һ���ڵ���Գ�Ϊ��������

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
	 * �Ƽ��Ķ��Ĵ���
	 * ��˼·Ϊ:���ڵ�p��q�ڵ�ǰ�ڵ��ͬһ��ʱ�����е�����ѯ
	 * ���ڵ�p��q�ڵ�ǰ�ڵ����ߵ�ʱ�򣬵�ǰ�ڵ�Ϊ��ڵ�p��q����С��������
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
        	//if��elseif���������ж�q��p���Ƿ�Ϊ��ǰ�ڵ��ͬһ��
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
    //�����жϽڵ�child�Ƿ�Ϊparent�ĺ���ڵ�
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

package easy;

import java.util.Stack;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

����һ�ö�������Ѱ�����������

��������ǽڵ��������·���Ӹ��ڵ㵽��Զ��Ҷ�ӽڵ�ĳ���


 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepth 
{
	public int maxDepth(TreeNode root) 
	{
		//���ڼ�¼����ȱ����������Ĺ����еĸ����ӽڵ�
        Stack<TreeNode> stack=new Stack<TreeNode>();
        //���ڼ�¼����ȱ����������Ĺ����нڵ�ķ���trueΪ�ұߣ�falseΪ���
        Stack<Boolean> direction=new Stack<Boolean>();
        //���ڱ���������ȵĽ��
        int result=0;
        //���ڼ�¼����ʱ��Ҷ�ڵ�����
        int temp=0;
        if(root!=null)
        {
        	stack.push(root);
        	temp++;
        }
        while(!stack.isEmpty())
        {
        	TreeNode node=stack.peek();
        	//֤����ΪҶ�ӽڵ�
        	if(node.left==null&&node.right==null)
        	{
        		if(temp>result)
        		{
        			result=temp;
        			
        		}
        		//������Ҷ�ڵ�
        		stack.pop();
        		//���õ�ǰ�ڵ�����
        		temp--;
        		if(!direction.isEmpty())
        		{
        			boolean directions=direction.pop();
        			if(directions)
        			{
        				stack.peek().right=null;
        			}
        			else
        			{
        				stack.peek().left=null;
        			}
        		}
        	}
        	else
        	{
        		if(node.left!=null)
        		{
        			direction.push(false);
        			stack.push(node.left);
        			temp++;
        		}
        		else
        		{
        			direction.push(true);
        			stack.push(node.right);
        			temp++;
        		}
        	}
        	
        }
        return result;
    }
	/**
	 * leetcode������ʱ����̵Ĵ���
	 * �Ƽ��Ķ�����ܺõ������˵ݹ��˼·���������
	 * 
	 */
	/*public int maxDepth(TreeNode root) 
	{
        if(root==null)
        {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }*/
}

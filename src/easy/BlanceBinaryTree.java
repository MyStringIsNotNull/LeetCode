package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a binary tree, determine if it is height-balanced.

For this problem

a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 

����һ�����������ж��Ƿ�Ϊ����ƽ���

�����������

һ������ƽ��Ķ�����������Ϊ����������ÿһ���ڵ�ĸ߶Ȳ�ܳ���1�Ķ�����

ps:ƽ�����������������:
����һ�ÿ����������������������ĸ߶Ȳ�ľ���ֵ������1����������������������һ��ƽ�������
 */
public class BlanceBinaryTree 
{
    public boolean isBalanced(TreeNode root) 
    {
        if (root == null) 
        {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left - right > 1 || left - right < -1) //�ô�дΪMath.abs(left-right)>1,�����������ĸ߶Ȳ��1;
        {
            return false;
        } 
        else
        {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * �����ĸ߶�
     * @param n ���ĸ����
     * @return ���ĸ߶�
     */
    private int depth(TreeNode n) 
    {
        if (n == null) 
        {
            return 0;
        } 
        if (n.left == null && n.right == null) 
        {
            return 1;
        } 
        else 
        {
            int left = depth(n.left);
            int right = depth(n.right);
            return 1 + (left > right ? left : right);
        }
    }
    
    /**
     * leetcode������ʱ�����ٵĴ���
     * 
     */
    /*
     public boolean isBalanced(TreeNode root) 
    {
        return depth(root) != -1;
    }
    
    private int depth(TreeNode node) 
    {
        if(node == null) 
        {
            return 0;
        }
        int left = depth(node.left);
        if(left == -1) 
        {
            return -1;
        }
        int right = depth(node.right);
        if(right == -1)
        {
            return -1;
        }
        int sub = Math.abs(left - right);
        if(sub > 1) 
        {
            return -1;
        }
        return 1 + Math.max(left, right);
    }*/
    
}

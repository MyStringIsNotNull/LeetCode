package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a binary tree, determine if it is height-balanced.

For this problem

a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 

给定一个二叉树，判断是否为树高平衡的

对于这个问题

一个树高平衡的二叉树被定义为两个子树的每一个节点的高度差不能超过1的二叉树

ps:平衡二叉树的性质如下:
它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
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
        if (left - right > 1 || left - right < -1) //该处写为Math.abs(left-right)>1,即左右子树的高度差超过1;
        {
            return false;
        } 
        else
        {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 求树的高度
     * @param n 树的根结点
     * @return 树的高度
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
     * leetcode上运行时间最少的代码
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

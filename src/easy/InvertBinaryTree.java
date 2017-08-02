package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1

左右颠倒一棵二叉树
例如:
从
 	 4
   /   \
  2     7
 / \   / \
1   3 6   9

颠倒为

     4
   /   \
  7     2
 / \   / \
9   6 3   1



 */
public class InvertBinaryTree 
{
	/**
	 * 其思路为，当当前节点不为空的时候，将该节点左右节点翻转，之后翻转该节点的左右子树
	 * 其为自顶向下的考虑和写法
	 * 
	 */
	public TreeNode invertTree(TreeNode root) 
    {
        if(root==null)
        	return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
	
	/**
	 * 
	 * leetcode上运行时间最短的代码
	 * 其代码思路同上，只不过，其为自顶向上的考虑方法
	 * 
	 */
	
	/*
	public TreeNode invertTree(TreeNode root) 
	{
    
        if(root==null)
        {
            return null;
        }
        if(root.left==null&&root.right!=null){
            root.left=root.right;
            root.right=null;
            return root;
        }else if(root.left!=null&&root.right==null){
            root.right=root.left;
            root.left=null;
            return root;
        }else{
            
        
        
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right=temp;
        
        return root;
        
    //}
	}
	*/
	
}

package easy;
/**
 * 
 * @author ѧͽ
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

���ҵߵ�һ�ö�����
����:
��
 	 4
   /   \
  2     7
 / \   / \
1   3 6   9

�ߵ�Ϊ

     4
   /   \
  7     2
 / \   / \
9   6 3   1



 */
public class InvertBinaryTree 
{
	/**
	 * ��˼·Ϊ������ǰ�ڵ㲻Ϊ�յ�ʱ�򣬽��ýڵ����ҽڵ㷭ת��֮��ת�ýڵ����������
	 * ��Ϊ�Զ����µĿ��Ǻ�д��
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
	 * leetcode������ʱ����̵Ĵ���
	 * �����˼·ͬ�ϣ�ֻ��������Ϊ�Զ����ϵĿ��Ƿ���
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

package easy;


/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively. 

����һ�ö�������������Ƿ��Ǿ���ԳƵ�(������ת�Գ�)
���磬������[1,2,2,3,4,4,3]���ȳƵ�

    1
   / \
  2   2
 / \ / \
3  4 4  3

��������[1,2,2,null,3,null,3]�����ǶԳƵ�

    1
   / \
  2   2
   \   \
   3    3

��ʾ:
�ӷֵ��ǣ����ܹ�ʹ�õݹ�͵����ķ�ʽ����������


ps����Ĺؼ�������Ҫ֪��:�Ƿ�Գƾ���Ҫ��ÿһ������Ҹպõ��ڴ��ҵ���

 */

public class SymmetricTree 
{
	/**
	 * �����˼·Ϊ��
	 * �Զ������������������������(���������Ҹ��ķ�ʽ���б���)
	 * �Զ�����������������������ķ�ʽ���б���
	 * �������õ��Ľ��Ϊ��ͬ�ģ����ʾ��Ϊ���ڸ��ڵ�ʾ���ԳƵ�
	 * 
	 */
	public boolean isSymmetric(TreeNode root)
	{
		StringBuffer pre=new StringBuffer("");
		StringBuffer unnormal=new StringBuffer("");
		if(root==null)
			return true;
		UnnormalVisit(root.right,unnormal);
		preVisit(root.left,pre);
		if(pre.toString().equals(unnormal.toString()))
			return true;
		else
			return false;
    }
	
	/*
	 * ����������ķ�ʽ���б���
	 */
	private void UnnormalVisit(TreeNode node,StringBuffer result)
	{
		if(node==null)
		{
			result.append("n");
			return;
		}
		UnnormalVisit(node.right,result);
		UnnormalVisit(node.left,result);
		result.append(node.val);
	}
	/*
	 * �����������
	 * �����Ҹ��ķ�ʽ
	 */
	private void preVisit(TreeNode node,StringBuffer result)
	{
		if(node==null)
		{
			result.append("n");
			return;
		}
		preVisit(node.left,result);
		preVisit(node.right,result);
		result.append(node.val);
	}
	
	
	/**
	 * leetcode������ʱ�����ٵĴ���
	 * �Ƽ��Ķ��Ĵ��룬��ݹ��㷨��˼·��������
	 * ��Ȼ�Լ�Ҳ����õݹ�ķ�ʽ��ʵ�֣���������µ�˼·֪�������Ǿ����޷�д�õݹ�����µ���ݴ���
	 * ����Ҫ���Ŭ���� date:2017-7-4
	 */
/*
	public boolean isSymmetric(TreeNode root) 
	{
        if(root == null) 
        	return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) 
    {
        if(left == null && right == null) 
        {
            return true;
        } 
        //�˴���left==null||right==null����ʡ�ԣ�������Ҫ�����left.val!=right.val����ߣ��������ֱ�������
        //�˴�Ϊ��д�þ���ĵط�
        else if(left == null || right == null || left.val != right.val) 
        {
            return false;
        }
        else 
        {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
    }
    */
	
}

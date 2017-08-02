package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
The thief has found himself a new place for his thievery again. 
 �����Լ������˸��µĵط����е���
There is only one entrance to this area, called the "root." 
 ��Ƭ����ֻ��һ����֮Ϊ"root"�����
Besides the root, each house has one and only one parent house.
 ����"root"֮�⣬ÿ����������ֻ��һ��������
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
�ڹ۹�������֮�󣬴����ĵ����˽⵽������������еķ��ӵ���ʽΪһ��������
It will automatically contact the police if two directly-linked houses were broken into on the same night.
��ֱ�����ӵ�����������ͬһ���ϱ���������֮������Զ�����ϵ������
Determine the maximum amount of money the thief can rob tonight without alerting the police.
�ж�����û�о������������£�����͵�Ե��Ľ��
Example 1:
����1:
     3(��)
    / \
   2   3
    \   \ 
(��)3   1(��)

Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
������͵�Ե���������Ľ��Ϊ 3 + 3 + 1 = 7
Example 2:

     	 3
    	/ \
(��)4   5(��)
  	 / \   \ 
 	1   3   1

Maximum amount of money the thief can rob = 4 + 5 = 9. 
��͵�Ե������Ϊ4 + 5 = 9

 */
public class HouseRobberIII 
{
	public int rob(TreeNode root) 
	{
		if(root==null)
			return 0;
		int robParent=root.val;
		int robChildren=rob(root.left)+rob(root.right);
		if(root.left!=null)
			robParent+=rob(root.left.left)+rob(root.left.right);
		if(root.right!=null)
			robParent+=rob(root.right.left)+rob(root.right.right);
		return Math.max(robParent, robChildren);
    }
	
	/**
	 * 
	 * leetcode������ʱ����̵Ĵ���
	 * ������˼·Ϊ:
	 * DFS����ÿ���������һ����Ԫ�ص����飬��0��Ԫ�ش��������˱��ڵ㼰�������²�ڵ�����õĽ�
	 * ��1��Ԫ�ش����˲����ٱ��ڵ�������ѡ�����ٻ��߲������²�ڵ�����ֵ֮�����ܻ�õĽ�
	 * ��ô���� res[1] ��˵����ֵ�����ӽ������Ԫ�صĽϴ�ֵ����Ϊ��ʱ���Լ����ӽ�㣬Ҳ���Բ������ӽ�㣬ѡ���нϴ�ֵ��
	 * ���Ƕ��� res[0] ��˵���Ͳ����ˣ���Ϊ���ϵ�ǰ���ֵ��ʱ�򣬱��벻�ܼ����ӽ���ֵ�����򾯱����죬
	 * ��ˣ�ֻ�������ӽ��� res[1]��
	 * 
	 */
	
	/*
	public int rob(TreeNode root) 
	{
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    public int[] dfs(TreeNode root) 
    {
    	int[] res=new int[2];
        if(root == null) 
            return res;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        //left[0]��right[0]���������ٱ��ڵ������£��������²�ڵ����ܻ�ȡ�Ľ��
        //left[1]��right[1]�����˲����ٱ��ڵ������������߲������²�ڵ����ܻ�õĽ���е����ֵ�����
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
	*/
}

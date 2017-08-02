package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
The thief has found himself a new place for his thievery again. 
 盗贼自己又找了个新的地方进行盗窃
There is only one entrance to this area, called the "root." 
 这片区域只有一个称之为"root"的入口
Besides the root, each house has one and only one parent house.
 除了"root"之外，每座房子有且只有一个父房子
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
在观关了这里之后，聪明的盗贼了解到，在这里的所有的房子的形式为一个二叉树
It will automatically contact the police if two directly-linked houses were broken into on the same night.
当直接连接的两座房子在同一晚上被盗贼闯进之后，其会自动的联系到警察
Determine the maximum amount of money the thief can rob tonight without alerting the police.
判断其在没有惊动警察的情况下，其能偷窃到的金额
Example 1:
例子1:
     3(红)
    / \
   2   3
    \   \ 
(红)3   1(红)

Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
其所能偷窃的最大数量的金额为 3 + 3 + 1 = 7
Example 2:

     	 3
    	/ \
(红)4   5(红)
  	 / \   \ 
 	1   3   1

Maximum amount of money the thief can rob = 4 + 5 = 9. 
其偷窃的最大金额为4 + 5 = 9

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
	 * leetcode上运行时间最短的代码
	 * 其代码的思路为:
	 * DFS，给每个结点增加一个两元素的数组，第0个元素代表抢劫了本节点及不抢劫下层节点所获得的金额，
	 * 第1个元素代表了不抢劫本节点的情况下选择抢劫或者不抢劫下层节点的最大值之和所能获得的金额。
	 * 那么对于 res[1] 来说，其值等于子结点数组元素的较大值，因为此时可以加上子结点，也可以不加上子结点，选其中较大值。
	 * 但是对于 res[0] 来说，就不行了，因为加上当前结点值的时候，必须不能加上子结点的值，否则警报会响，
	 * 因此，只能算上子结点的 res[1]。
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
        //left[0]和right[0]代表了抢劫本节点的情况下，不抢劫下层节点所能获取的金额
        //left[1]和right[1]代表了不抢劫本节点的情况，抢或者不抢劫下层节点所能获得的金额中的最大值的情况
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
	*/
}

package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

给定一个按照升序序列排序的数组，将其转化为一个高度平衡的二叉排序树(BST=Binary Sort Tree)

二叉排序树又叫二叉查找树，英文名称是：Binary Sort Tree.  

BST的定义就不详细说了，我用一句话概括：左节点 < 中根节点 < 右节点。 
 
根据这个原理，我们可以推断：BST的中序遍历必定是严格递增的

对于二叉树的四种遍历:
先序遍历；中序遍历；后序遍历；层次遍历。事实上，知道任意两种方式，并不能唯一地确定树的结构，
但是，只要知道中序遍历和另外任意一种遍历方式，就一定可以唯一地确定一棵树
 
 */
public class ArraryToTree 
{
	/*
	 * 该题的解题思路，关键在于BST树的中序遍历，其遍历的结果是按照节点的值的大小严格递增的，对于排好序的，严格按照从小
	 * 到大的顺序进行递增的数组，可以采用二分查找的思路，将中间的那个节点作为根节点的存在，将其左边的作为其左子树部分，
	 * 将其右边的作为其右子树部分进行递归的建立平痕二叉查找树
	 * 
	 * 
	 */
	public TreeNode sortedArrayToBST(int[] nums) 
    {
        if(nums==null||nums.length==0)
        	return null;
        else
        	return toBST(nums,0,nums.length-1);
    }
	//用于实现二叉排序数的递归建立过程
	private TreeNode toBST(int[] nums,int low,int high)
	{
		if(low>high)
			return null;
		int mid=(low+high)/2;
		TreeNode node=new TreeNode(nums[mid]);
		node.left=toBST(nums,low,mid-1);
		node.right=toBST(nums,mid+1,high);
		return node;
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其实现的思路同上，但是其代码不如自己写的清晰，且其易读性不如上面的自己写的高
	 */
	/*
	 public TreeNode sortedArrayToBST(int[] nums) 
	{
		if (nums == null || nums.length == 0)
			return null;
        return convert(nums, 0, nums.length);
    }
    
    public TreeNode convert(int[] nums, int start, int end) 
    {
        if (start == end) 
        	return null;
        if (start + 1 == end) 
        	return new TreeNode(nums[start]);
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(nums, start, mid);
        root.right = convert(nums, mid + 1, end);
        return root;
    }
    */
}

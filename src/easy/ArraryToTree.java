package easy;
/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

����һ����������������������飬����ת��Ϊһ���߶�ƽ��Ķ���������(BST=Binary Sort Tree)

�����������ֽж����������Ӣ�������ǣ�Binary Sort Tree.  

BST�Ķ���Ͳ���ϸ˵�ˣ�����һ�仰��������ڵ� < �и��ڵ� < �ҽڵ㡣 
 
�������ԭ�����ǿ����ƶϣ�BST����������ض����ϸ������

���ڶ����������ֱ���:
�����������������������������α�������ʵ�ϣ�֪���������ַ�ʽ��������Ψһ��ȷ�����Ľṹ��
���ǣ�ֻҪ֪�������������������һ�ֱ�����ʽ����һ������Ψһ��ȷ��һ����
 
 */
public class ArraryToTree 
{
	/*
	 * ����Ľ���˼·���ؼ�����BST�������������������Ľ���ǰ��սڵ��ֵ�Ĵ�С�ϸ�����ģ������ź���ģ��ϸ��մ�С
	 * �����˳����е��������飬���Բ��ö��ֲ��ҵ�˼·�����м���Ǹ��ڵ���Ϊ���ڵ�Ĵ��ڣ�������ߵ���Ϊ�����������֣�
	 * �����ұߵ���Ϊ�����������ֽ��еݹ�Ľ���ƽ�۶��������
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
	//����ʵ�ֶ����������ĵݹ齨������
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
	 * leetcode������ʱ����̵Ĵ���
	 * ��ʵ�ֵ�˼·ͬ�ϣ���������벻���Լ�д�������������׶��Բ���������Լ�д�ĸ�
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

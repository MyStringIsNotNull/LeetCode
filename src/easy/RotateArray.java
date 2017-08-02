package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Hint:
Could you do it in-place with O(1) extra space? 

旋转一个具有n个数组元素的数组到右边，通过k步

例如，n=7，k=3，数组[1,2,3,4,5,6,7]旋转为[5,6,7,1,2,3,4].

注意:
尝试多种解决的方案，它至少有3中不同的解决方法

提示:
你能在O(1)的空间复杂度内完成吗？


 */
public class RotateArray
{
	//将数组元素整体向右移动k次，每次步长为1
	public void rotate(int[] nums, int k) 
	{
		if(nums.length<=1||k<=0)
			return;
		int length=nums.length;
		k%=length;
		while(k!=0)
		{
			int temp=nums[length-1];
			for(int i=length-2;i>=0;i--)
			{
				nums[i+1]=nums[i];
			}
			nums[0]=temp;
			k--;
		}
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读的代码，其解决的是向右移动k个元素的这一类问题
	 * 对于要向右移动k个元素的这一类问题，均可以使用这个算法
	 * 其思路为，先翻转前n-k(0~n-k-1)个元素
	 * 后翻转后k(n-k,n-1)个元素
	 * 最后将n个元素进行翻转
	 * ps:所谓的翻转，即为将数组元素从头元素和尾元素进行交换
	 * 之后，将头元素的下标加一，尾元素的下标减一处理
	 */
	
	/*
	public void rotate(int[] nums,int k)
	{
		if(k<=0)
			return;
		int length=nums.length;
		k=k%length;
		swap(nums,0,length-k-1);
		swap(nums,length-k,length-1);
		swap(nums,0,length-1);
	}
	private void swap(int[] nums,int low,int high)
	{
		for(int i=low,j=high;i<j;i++,j--)
		{
			int temp=nums[i];
			nums[i]=nums[j];
			nums[j]=temp;
		}
	}*/
}

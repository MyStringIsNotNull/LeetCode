package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

You must do this in-place without making a copy of the array.

Minimize the total number of operations.

给定一个数组nums，写一个函数去移动所有的0到数组的末尾，同时保持非0元素间的相对关系

例如，给定nums=[0,1,0,3,12],调用了你的函数之后，nums必须变成[1,3,12,0,0]

提示:
你必须在原数组上进行操作
最下化其操作的次数


 */
public class MoveZeroes 
{
	public void moveZeroes(int[] nums) 
	{
		int zeroNumber=0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==0)
				zeroNumber++;
		}
		for(int i=0;i<zeroNumber;i++)
		{
			for(int index=0;index<nums.length-i;index++)
			{
				if(nums[index]==0)
				{
					for(int k=index;k<nums.length-1-i;k++)
					{
						int temp=nums[k];
						nums[k]=nums[k+1];
						nums[k+1]=temp;
					}
				}
			}
		}
    }
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读的代码
	 * 其采用的思路为:
	 * 从左往右遍历数组元素，当其为0时，用后面不为0的元素进行覆盖
	 * 直到遍历完数组，之后将后面的元素全部置为0
	 * 
	 */
	
	/*
	public void moveZeroes(int[] nums) 
	{
        if (nums == null || nums.length == 0)
            return;
        int insPos = 0;
        for (int num : nums)
        {
            if (num!=0) 
                nums[insPos++] = num;
        }
        while(insPos < nums.length)
            nums[insPos++] = 0;
    }
	*/
	
}

package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 
给定一个排好序的数组，移除掉重复的元素，以使每个数组元素只出现一次，并返回该数组的长度
不允许分配额外的空间给其它数组，你必须在该连续的内存空间的数组上进行操作

例如
给定一个输入数组nums=[1,1,2]

你的函数必须返回length=2，同时，这个数组的第一和第二个元素变为1，2。
对于这个数组所留空间的长度超过新数组的长度这件事并无所谓

 */
public class RemoveDuplexNumber 
{
	public int removeDuplicates(int[] nums) 
	{
		int low=0;
		int high=1;
		int length=1;
		//用于记录下重复的相邻的元素的个数
		int max=nums.length;
		while(high<max)
		{
			if(nums[low]==nums[high])
			{
				length--;
				//将后面的元素往前面移动，以覆盖掉重复的元素
				for(int i=high+1;i<max;i++)
				{
					nums[i-1]=nums[i];
				}
				max--;
			}
			else
			{
				low=high;
				high++;
			}
			length++;
		}
		if(nums.length==0)
            length=0;
		return length;
    }
	
	/**
	 * leetcode上花费的时间最小的代码
	 * 很不错的代码，荐读
	 */
	/*public int removeDuplicates(int[] nums) 
	{
        if(nums.length <= 1)
        {
            return nums.length;
        }
        int len = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[i-1])
            {
                nums[len++] = nums[i];
            }
        }
        return len;
    }*/
	
}

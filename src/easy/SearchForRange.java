package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 

给定一个按升序序列排序的整型数组，找到一个给定值的开始和结束位置

你的算法，时间复杂度大约为O(logn)

如果给定值不在数组中，返回[-1,-1]

例如:
给定[5,7,7,8,8,10] 给定值为8

返回[3,4]

 */
public class SearchForRange 
{
	/**
	 * 该算法，空间复杂度为O(1)，时间复杂度为O(n)
	 * 不符合题目的要求
	 * 为此采用如下的方法
	 */
	/*
	public int[] searchRange(int[] nums, int target) 
	{
		int lows=-1,highs=-1;
		int low=0;
		int high=nums.length-1;
		while(low<=high)
		{
			if(lows!=-1&&highs!=-1)
				break;
			if(nums[low]==target)
			{
				lows=low;
				low--;
			}
			if(nums[high]==target)
			{
				highs=high;
				high++;
			}
			low++;
			high--;
		}
		return new int[]{lows,highs};
    }
	*/
	/**
	 * 其时间复杂度为O(logn),空间复杂度为O(1)，符合题目的要求
	 * 其思想同二分查找，只不过进行了改进
	 * 
	 */
	public int[] searchRange(int[] nums, int target) 
	{
		int[] result=new int[2];
		int low=0,high=nums.length-1;
		//确定其左边界
		while(low<=high)
		{
			int mid=low+(high-low)/2;
			if(nums[mid]>=target)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		result[0]=low;
		low=0;
		high=nums.length-1;
		//确认其右边界
		while(low<=high)
		{
			int mid=low+(high-low)/2;
			if(nums[mid]>target)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		result[1]=high;
		if(result[0]>result[1])
			result[0]=result[1]=-1;
		return result;
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 */
	/*
	public int[] searchRange(int[] nums, int target) 
	{
        int[] range = {nums.length - 1, -1}; // {6, -1}
        helper(nums, target, 0 , nums.length - 1, range);
        if(range[0] > range[1])
        {
            range[0] = -1;
        }
        return range;
    }
  
    public void helper(int[] nums, int target, int start, int end, int[] range)
    {
        if(start > end)
        {
            return;
        }
        int mid = start + (end - start)/2; 
        if(nums[mid] == target)
        { 
        	//用递归的方式确定其左边界
            if(mid < range[0])
            {
                range[0] = mid; 
                helper(nums, target, start, mid - 1, range);
            }
            //用递归的方式确定其右边界
            if(mid > range[1])
            {
                range[1] = mid; 
                helper(nums, target, mid + 1, end, range); // 5, 5
            }
        } 
        else if(nums[mid] < target)
        {
            helper(nums, target, mid + 1, end, range);
        } 
        else
        {
            helper(nums, target, start, mid - 1, range);
        }
    }
	*/
	
}

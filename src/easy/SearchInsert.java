package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 

给定一个已经排好序的数组和一个目标值，如果这个值存在数组中的话，返回索引。否则，返回它将插入在数组中的位置

你可以假设在数组中并没有重复的值
 */
public class SearchInsert 
{
	 public int searchInsert(int[] nums, int target) 
	{
		boolean search=false;
		int result=0;
		int low=0;
		int high=nums.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(nums[mid]==target)
			{
				result=mid;
				search=true;
				break;
			}
			else if(nums[mid]>target)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		if(!search&&low!=0)
			result=high+1;
		else if(!search)
			result=0;
		return result;
    }
	
	/**
	 * leetcode上运行时间最少的代码,其思路同上，均是采用二分查找的方式
	 */
	/*public int searchInsert(int[] nums, int target) 
	{
        if (nums.length == 0)
            return 0;
        int low = 0;
        int high = nums.length;
        int mid = high / 2;
        while(high - low > 0)
        {
            if (target == nums[mid])
                return mid;
            if (target > nums[mid])
            {
                low = mid + 1;
                mid = low + (high - low) / 2;	//对于mid=low+(high-low)/2与mid=(low+high)/2并没有区别
            }
            else 
            {
                high = mid - 1;
                mid = high - (high - low) / 2;
            }        
        }
        if ( mid < 0 || (mid < nums.length && target > nums[mid]))
            return mid + 1;
        else 
        	return mid;
    }*/
}

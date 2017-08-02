package easy;
/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? 

给定一个取自[0,n]，具有n个不同数字的数组，找到数组中丢失的的那个数

例如:
给定num=[0,1,3]返回2

注意:
你的算法必须具有O(n)的时间复杂度。你能仅仅使用常数的空间复杂度去实现它吗？

 */
public class MissingNumber 
{
	/**
	 * 该算法的时间复杂度为O(n)，空间复杂度为O(n)
	 */
	public int missingNumber(int[] nums) 
	{
		boolean[] number=new boolean[nums.length+1];
		for(int i:nums)
		{
			number[i]=true;
		}
		int i=0;
		for(;i<number.length;i++)
		{
			if(!number[i])
			{
				break;
			}
		}
		return i;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 以下的实现，具有O(n)的时间复杂度。O(1)的空间复杂度
	 */
	
	/*
	public int missingNumber(int[] nums) 
	{
        int sum =0,val =0;
        for(int i=0; i<nums.length; i++)
        {
            sum+= i;
            val += nums[i];
        }
        sum += nums.length;
        return sum-val;
    }
	*/
}

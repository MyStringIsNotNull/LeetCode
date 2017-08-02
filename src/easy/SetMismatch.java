package easy;

import java.util.Arrays;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
The set S originally contains numbers from 1 to n. But unfortunately, 
 
due to the data error, one of the numbers in the set got duplicated to another number in the set, 
 
which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. 

Your task is to firstly find the number occurs twice and then find the number that is missing. 

Return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Note:

The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

集合s中原本包含了1到n这写数字，不幸的是
由于数据发生了错误，一个数字在集合中变成了另外一个在集合中存在的数字
这导致了一个数字重复出现，而另一个数字丢失的情况
给定一个数组nums表示这个集合发生错误之后的状态的情况
你的任务是第一时间找出那个出现了两次的数字和那个丢失了的数字
用一个数组的形式返回他们
例如:
输入 nums=[1,2,2,4]
输出:[2,3]

注意:
对于给定的数组，其将会在[2,10000]之间
对于给定的数组，其将不会是有序的


 */
public class SetMismatch
{
	/**
	 * 该算法，时间复杂度为O(n)
	 * 空间复杂度为O(1)
	 */
	public int[] findErrorNums(int[] nums) 
	{
		int n=nums.length;
		int[] result=new int[2];
		boolean founded=false;
		//用于找到重复了的数
		for(int i=0;i<n&&!founded;i++)
		{
			while(nums[i]!=i+1)
			{
				int needIndex=nums[i]-1;
				if(nums[needIndex]==nums[i])
				{
					//记录下重复的数
					result[0]=nums[i];
					founded=true;
					break;
				}
				nums[i]^=nums[needIndex];
				nums[needIndex]^=nums[i];
				nums[i]^=nums[needIndex];
			}
		}
		//用于找到缺失的数
		long number=((1+n)*n)/2;
		long add=0;
		for(int i=0;i<n;i++)
		{
			add+=nums[i];
		}
		result[1]=(int)(number+result[0]-add);
        return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 该代码的思路为记录下[1,n]之间的数是否有出现
	 * 当其中的一个数出现了2遍的情况下，则该数为重复的那个数
	 * 当遍历完数组一遍之后，当数组中有一个数没有出现的时候，则该数为缺失的数
	 * 其时间和空间复杂度均为O(n)
	 */
	/*
	public int[] findErrorNums(int[] nums)
	{
		int size = nums.length;
		int[] map = new int[size];
		int[] r = new int[2];
		for (int i = 0; i < size; i++)
		{
			int t = nums[i] - 1;
			if (map[t] == 0)
				map[t] = 1;
			else
				r[0] = t + 1;
		}
		for (int i = 0; i < size; i++)
		{
			if (map[i] == 0)
			{
				r[1] = i + 1;
				break;
			}
		}
		return r;
	}
	*/
}

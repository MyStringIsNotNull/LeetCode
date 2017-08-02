package easy;

import java.util.Arrays;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.

给定一个整型数组，找出其数组是否包含了任何重复的元素
当任何值在数组中至少出现两次的时候你的函数必须返回true
当数组中的任何值都是不相同的时候，其函数必须返回false

 */

public class ContainsDuplicate 
{
	public boolean containsDuplicate(int[] nums) 
	{
		boolean result=false;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++)
		{
			if(nums[i]==nums[i+1])
			{
				result=true;
				break;
			}
		}
		return result;
    }
	
	/**
	 * 
	 * leetcode上运行时间最短的代码
	 * 不推荐的一种写法，其实质为计数排序算法的一种应用
	 * 其空间复杂度可能会出现特别高的情况，所以并不推荐使用该写法
	 * 其本质为一种以空间换取时间的操作
	 * 
	 */
	
	/*
	public boolean containsDuplicate(int[] nums)
	{
        if(nums == null || nums.length == 1) 
        	return false;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums)
        {
            if(num > max)
                max = num;
            if(num < min)
                min = num;
        }
        boolean[] bool = new boolean[max - min + 1];
        for(int num : nums)
        {
            if(bool[num - min])
                return true;
            else
                bool[num - min] = true;
        }
        return false;
    }
	*/
	
	/**
	 * 
	 * leetcode上的另外一份代码
	 * 推荐看的是其使用了一个集合的那个算法，其空间和时间复杂度均为O(n)
	 * 这比先排序的那种写法其时间复杂度要低(排序的那种写法的时间复杂度为O(nlogn))，但是其空间复杂度要高
	 * 
	 */
	
	/*
	public boolean containsDuplicate(int[] nums) 
	{
        // // Linear space and time solution
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0; i<nums.length; i++) {
        //     if(set.contains(nums[i]))
        //         return true;
        //     set.add(nums[i]);
        // }
        // return false;
        
        // Sorting method
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++) 
        {
            if(nums[i] == nums[i-1])
                return true;
        }
        return false;
    }
	*/
}

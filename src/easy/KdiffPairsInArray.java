package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
给定一个整型数组和一个整数k，你需要在数组中找到距离为k的唯一的数对
Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
距离为k的数对被定义为元组(i,j),其中i和j均是数组中的元素，并且其绝对值之差为k
Example 1:

Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

例子1:
输入:[3,1,4,1,5]，k=2
输出:2
解释:在数组中这里有两个绝对值之差为2的元组(1,3)和(3,5)

Example 2:

Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

例子2:
输入:[1, 2, 3, 4, 5], k = 1
输出:4
解释:在数组中这里有4个绝对值之差为1的元组(1, 2), (2, 3), (3, 4) 和 (4, 5).

Example 3:

Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

例子3:
输入:[1, 3, 1, 5, 4], k = 0
输出:1
解释:在数组中这里有1个绝对值之差为0的元组(1,1)

Note:

The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].

注意:
元组(i,j)和(j,i)为相同的一对
数组的长度并不会超过10000
数组中元素的值在[-1e7, 1e7]之间

 */
public class KdiffPairsInArray 
{
	/**
	 * 该算法，时间复杂度为O(n^2)
	 */
	public int findPairs(int[] nums, int k)
	{
        int result=0;
        //用于存放元组的元素，当两个元素均在set集合中时，其表示同一个元组
        Set<Integer> set=new HashSet<Integer>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
        	for(int tem=i+1;tem<nums.length;tem++)
        	{
        		int numi=nums[i];
        		int numt=nums[tem];
        		if(numi+k==numt)
        		{
        			if(!(set.contains(numi)&&set.contains(numt)))
        			{
        				result++;
        				set.add(numi);
        				set.add(numt);
        			}
        			else
        			{
        				break;
        			}
        		}
        		else if(numt-numi>k)
        		{
        			break;
        		}
        	}
        }
        return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其算法时间复杂度为O(nlogn)（排序为O(nlogn)，计算对数为O(n)）
	 */
	/*
	public int findPairs(int[] nums, int k) 
	{
		if (k < 0) 
		{
			return 0;
		}
		Arrays.sort(nums);
		int start = 0, end = 0, res = 0;
		while (end < nums.length) 
		{
			if (end == start || nums[end] - nums[start] < k) 
			{
				end++;
			} 
			//ps:(start > 0 && nums[start] == nums[start - 1])的目的在于避免掉重复的数组元素
			else if ((start > 0 && nums[start] == nums[start - 1])|| nums[end] - nums[start] > k) 
			{
				start++;
			} 
			else 
			{
				res++;
				start++;
			}
		}
		return res;
	}
    */
	/**
	 * 该代码的思路为统计出现的各个数字出现的次数
	 * 之后迭代查找每个键(即各个不同的数字)，查找需要查找的键是否包含在其中
	 * k=0的情况下，需要当前键的出现的次数大于等于2，其才有一个元组，否则
	 * 不算入一个新的元组
	 * 
	 */
// ========================================================
// solution 1: using hashmap 33.43 %
//	public int findPairs(int[] nums, int k)
//	{
//		if (k < 0)
//		{
//			return 0;
//		}
//		Map<Integer, Integer> map = new LinkedHashMap<>();
//	//用于统计各个数字出现的次数
//		for (int num : nums)
//		{
//			int count = map.getOrDefault(num, 0);
//			map.put(num, count + 1);
//		}
//		int res = 0;
//		for (Map.Entry<Integer, Integer> entry : map.entrySet())
//		{
//			int key = entry.getKey();
//			int count = entry.getValue();
//			int targetKey = key + k;
//			if (targetKey == key)
//			{
//				if (count >= 2)
//				{
//					res++;
//				}
//			} 
//			else
//			{
//				if (map.containsKey(targetKey))
//				{
//					res++;
//				}
//			}
//		}
//		return res;
//	}
	
}

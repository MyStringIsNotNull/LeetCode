package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author ѧͽ
 *
 */
/*
 * question:
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
����һ�����������һ������k������Ҫ���������ҵ�����Ϊk��Ψһ������
Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
����Ϊk�����Ա�����ΪԪ��(i,j),����i��j���������е�Ԫ�أ����������ֵ֮��Ϊk
Example 1:

Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

����1:
����:[3,1,4,1,5]��k=2
���:2
����:����������������������ֵ֮��Ϊ2��Ԫ��(1,3)��(3,5)

Example 2:

Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

����2:
����:[1, 2, 3, 4, 5], k = 1
���:4
����:��������������4������ֵ֮��Ϊ1��Ԫ��(1, 2), (2, 3), (3, 4) �� (4, 5).

Example 3:

Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

����3:
����:[1, 3, 1, 5, 4], k = 0
���:1
����:��������������1������ֵ֮��Ϊ0��Ԫ��(1,1)

Note:

The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].

ע��:
Ԫ��(i,j)��(j,i)Ϊ��ͬ��һ��
����ĳ��Ȳ����ᳬ��10000
������Ԫ�ص�ֵ��[-1e7, 1e7]֮��

 */
public class KdiffPairsInArray 
{
	/**
	 * ���㷨��ʱ�临�Ӷ�ΪO(n^2)
	 */
	public int findPairs(int[] nums, int k)
	{
        int result=0;
        //���ڴ��Ԫ���Ԫ�أ�������Ԫ�ؾ���set������ʱ�����ʾͬһ��Ԫ��
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
	 * leetcode������ʱ����̵Ĵ���
	 * ���㷨ʱ�临�Ӷ�ΪO(nlogn)������ΪO(nlogn)���������ΪO(n)��
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
			//ps:(start > 0 && nums[start] == nums[start - 1])��Ŀ�����ڱ�����ظ�������Ԫ��
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
	 * �ô����˼·Ϊͳ�Ƴ��ֵĸ������ֳ��ֵĴ���
	 * ֮���������ÿ����(��������ͬ������)��������Ҫ���ҵļ��Ƿ����������
	 * k=0������£���Ҫ��ǰ���ĳ��ֵĴ������ڵ���2�������һ��Ԫ�飬����
	 * ������һ���µ�Ԫ��
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
//	//����ͳ�Ƹ������ֳ��ֵĴ���
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

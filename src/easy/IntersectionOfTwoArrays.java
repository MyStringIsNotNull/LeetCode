package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

Each element in the result must be unique.
The result can be in any order.

给定两个数组，写一个功能去计算其交叉点

例如:
给定nums1=[1,2,2,1] nums2=[2,2] 返回[2]

注意:
在结果中的元素必须唯一
结果可以是任何顺序的

 */
public class IntersectionOfTwoArrays
{
	public int[] intersection(int[] nums1, int[] nums2) 
	{
		int[] result=null;
		Set<Integer> set=new HashSet<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i=0;
		int j=0;
		while(i<nums1.length&&j<nums2.length)
		{
			if(nums1[i]>nums2[j])
				j++;
			else if(nums1[i]<nums2[j])
				i++;
			else
			{
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		result=new int[set.size()];
		int index=0;
		for(int z:set)
		{
			result[index++]=z;		
		}
		return result;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 代码思路同上，只不过其不此采用，为此更为直接点
	 */
	/*
	public int[] intersection(int[] nums1, int[] nums2)
	{
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		int index = 0;
		int[] res = new int[Math.min(nums1.length, nums2.length)];
		while (i <= nums1.length - 1 && j <= nums2.length - 1)
		{
			if (nums1[i] > nums2[j])
			{
				j++;
			}
			else if (nums1[i] < nums2[j])
			{
				i++;
			}
			else
			{
				if (index == 0 || res[index - 1] != nums1[i])
					res[index++] = nums1[i];
				j++;
				i++;
			}
		}
		int[] result = new int[index];
		for (int k = 0; k < index; k++)
		{
			result[k] = res[k];
		}

		return result;
	}
	*/
}

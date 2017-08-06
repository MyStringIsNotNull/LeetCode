package easy;

import java.util.Arrays;

/**
 * 
 * @author 学徒
 *
 */
/*
 * 
question:

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

给定两个数组，编写一个函数去计算他们的交集

例如:
给定nums1=[1,2,2,1],nums2=[2,2] 返回[2,2]

注意:
每个出现在结果中的元素的次数必须同其在两个数组中的一样多
返回的结果可以是任意顺序的

接着:
如果给定的数组是已经有序的呢？你如何去调整你的算法，使你的算法达到最优？
如果nums1的大小小于nums2的大小，什么样的算法是最优的？
如果nums2的元素是存储在硬盘上的，而内存的大小的受限的以至于你不能一次性加载全部的元素到的你内存上呢？


 */
public class IntersesctionOfTwoArrays
{
	public int[] intersect(int[] nums1, int[] nums2) 
	{
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int length=nums1.length>nums2.length?nums2.length:nums1.length;
		int[] result=new int[length];
		int n1=0,n2=0,index=0;
		while(n1<nums1.length&&n2<nums2.length)
		{
			if(nums1[n1]==nums2[n2])
			{
				result[index++]=nums1[n1];
				n1++;
				n2++;
			}
			else if(nums1[n1]>nums2[n2])
				n2++;
			else
				n1++;
		}
		int[] r=new int[index];
		for(int i=0;i<index;i++)
		{
			r[i]=result[i];
		}
		return r;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 推荐阅读的代码
	 * 以上代码在leetcode的测试上运行时间较短
	 * 为此找了一个leetcode上运行时间相对较少的，但是可以提供一种学习思路的代码
	 * 其可以满足在内存不足，并且其硬盘上的数据有较多重复的情况
	 * 
	 */
	/*
	public int[] intersect(int[] nums1, int[] nums2)
	{
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++)
			count.put(nums1[i], count.getOrDefault(nums1[i], 0) + 1);
		for (int i = 0; i < nums2.length; i++)
		{
			if (count.getOrDefault(nums2[i], 0) > 0)
			{
				list.add(nums2[i]);
				count.put(nums2[i], count.get(nums2[i]) - 1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			res[i] = list.get(i);
		return res;
	}
*/
}

package easy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array of integers, 
find out whether there are two distinct indices i and j in the array 
such that the absolute difference between nums[i] and nums[j] is at most t 
and the absolute difference between i and j is at most k. 

给定一个整型数组，
找出其在数组中是否有两个不同的索引i和j
使得nums[i]和nums[j]的值的绝对值之差最多为t
同时使得索引i和j的绝对值之差最多为k

 */
public class ContainsDuplicateIII 
{
	/**
	 * 其运行时间超时
	 * 其为暴力破解的一种方法，为此，考虑另外一种方法
	 * 
	 */
	
	/*
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
    {
		boolean result=false;
       for(int i=1;i<=k&&!result;i++)
       {
    	   for(int tem=0;tem<nums.length-i;tem++)
    	   {
    		   if(Math.abs((double)nums[tem]-nums[tem+i])<=t)
    		   {
    			   result=true;
    			   break;
    		   }
    	   }
       }
       return result;
    }
	*/
	
	/**
	 * 其代码思路为维持一个大小为k的滑动窗口，其窗口中的元素判断是否为在nums[i]+t到nums[i]-t之间
	 * 
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
    {
	     if (nums == null || nums.length == 0 || k <= 0)
	        return false;
	     TreeSet<Long> ts = new TreeSet();
	     for (int i = 0; i < nums.length; ++i) 
	     {
	        Long right = ts.floor((long) nums[i] + t);//获取在TreeSet中小于等于nums[i]+t的元素，没有时返回null
	        Long left = ts.ceiling((long) nums[i] - t);//获取在TreeSet中大于等于nums[i]-t的元素,没有时返回null
	        if (right != null && left != null && right >= left)
	            return true;
	        ts.add((long) nums[i]);
	        if (i >= k)
	            ts.remove((long) nums[i-k]);
	
	     }
	     return false;
    }
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其思路为，每次取连续的k个元素，检验其中是否包含两个元素之间的差不超过k的元素
	 * 
	 */
	/*
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
	{
        int size = nums.length;
        if(size >= 20000)return false;
        if (k >= size) 
        {
            return containsNearbyAlmostDuplicate(nums, t);
        }
        if (k > 0 && size > 1) 
        {
            int i = 0;
            while (i < size - k) 
            {
            	//Arrays.copyOfRange(T[ ] original,int from,int to)	将一个原始的数组original，从下标from开始复制，
            	// 复制到下标to，生成一个新的数组。注意这里包括下标from，不包括下标to。
                if (containsNearbyAlmostDuplicate(Arrays.copyOfRange(nums, i, i + k + 1), t))
                    return true;
                i++;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int t) 
    {
        int size = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < size; i++) 
        {
        	//检验排序之后的数组中相邻的两个数组元素，因为相邻的两个数组元素之间的差为最小的(相比于隔了元素而言)
            int result = nums[i] - nums[i - 1];
            if (result <= t && result >= 0)
            {
                return true;
            }
        }
        return false;
    }
	*/
	
}

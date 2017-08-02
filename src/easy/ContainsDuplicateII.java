package easy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author 学徒
 *
 */
/*
 * question:
Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the absolute difference between i and j is at most k. 

给定一个整型数组和一个整数k
找出其是否存在两个不同的数组元素索引i和j使其nums[i]==nums[j]
并且其索引i和j的差的绝对值最最大为k

 */
public class ContainsDuplicateII 
{
	/**
	 * 其提交到了leetcode上时，其超时
	 * 其时间复杂度为O(kn),空间复杂度为O(0)为此，故采用另外的一种方法
	 * 
	 */
	
	/*
	public boolean containsNearbyDuplicate(int[] nums, int k) 
	{
		boolean result=false;
		for(int i=1;i<=k&&!result;i++)
		{
			for(int tem=0;tem<nums.length-i;tem++)
			{
				if(nums[tem]==nums[tem+i])
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
	 * 对于该算法，其时间复杂度和空间复杂度均为O(n)
	 */
	
	
	public boolean containsNearbyDuplicate(int[] nums, int k) 
	{
		boolean result=false;
		Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(!map.containsKey(nums[i])||Math.abs(map.get(nums[i])-i)>k)
				map.put(nums[i], i);
			else
			{
				result=true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * leetcode上运行时间最短的代码
	 * 其时间复杂度为O(n),空间复杂度为O(1)
	 * 其代码虽然通过了leetcode上代码的提交检验，但是其会出现bug，说明了leetcode上的代码提交成功的不一定是百分百正确的
	 * 故不推荐看这代码
	 * 
	 */
	
	/*
	 public boolean containsNearbyDuplicate(int[] nums, int k) 
	 {
	        if(k==0) 
	        	return false;
	        int l = 0;
	        int r = 1;
	        while(r < nums.length) 
	        {
	            if(l < r && nums[r] == nums[l]) 
	            	return true;
	            if(r - l == k) 
	            {
	                l++;
	            } 
	            else 
	            {
	                r++;
	            }
	        }
	        while(l < r-1) 
	        {
	            if(nums[l++] == nums[r-1]) 
	            	return true;
	        }
	        return false;
	  }
	*/
	/**
	 * leetcode上看到的，认为没有bug的，且运行时间相对较少的一份代码
	 *其思路同下所写的代码，但其代码更为简洁
	 *
	 */
	/*
	 public boolean containsNearbyDuplicate(int[] nums, int k) 
	 {
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i = 0; i < nums.length; i++)
	        {
	            if(i > k) 
	            	set.remove(nums[i-1-k]);
	            if(!set.add(nums[i])) //set.add返回false的情况为，在集合中存在着元素nums[i]的值
	            	return true;
	        }
	        return false;
	    }
	*/
	
	/**
	 * 
	 * 网上看到的另一份代码，其思路比较清晰
	 * 故将其放在此处作为参考
	 * 其代码的思路为，集合Num维护一个最多具有k个元素的数据结构
	 * 在集合Num中的那k个元素，均是不重复的
	 * (
	 * 可将集合Num维护的k个元素的集合看成一个滑动窗口，在集合Num中的，为索引距离在1~k之间的数组元素
	 * 通过不断的移动该滑动窗口，以查看数组中索引距离在1~k之间的元素值相等的数组元素
	 * )
	 */
	/*
	public boolean containsNearbyDuplicate(int[] nums, int k) 
	{
        Set<Integer> Num = new HashSet<Integer>();
        int left=0,right=0;
        if(nums.length==0)return false;
        for(int i=0;i<nums.length;i++){
            if(!Num.contains(nums[i])){
                Num.add(nums[i]);
                right++;
            }else return true;
            if(right - left > k){
                Num.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
	*/
	
	
	
}
